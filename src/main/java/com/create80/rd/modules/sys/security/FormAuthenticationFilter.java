/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.sys.security;

import com.create80.rd.common.config.ModuleLinkConfiguration;
import com.create80.rd.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.create80.rd.modules.sys.utils.UserUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;

import com.create80.rd.common.utils.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * 表单验证（包含验证码）过滤类
 *
 * @author ThinkGem
 * @version 2014-5-19
 */
@Service
public class FormAuthenticationFilter extends
    org.apache.shiro.web.filter.authc.FormAuthenticationFilter {

  /**
   * 模块配置链接配置对象
   */
  @Autowired
  protected ModuleLinkConfiguration moduleLinkConfiguration;

  @Autowired
  private RestTemplate restTemplate;
  /**
   * 日志对象
   */
  protected Logger logger = LoggerFactory.getLogger(getClass());

  public static final String DEFAULT_CAPTCHA_PARAM = "validateCode";
  public static final String DEFAULT_MOBILE_PARAM = "mobileLogin";
  public static final String DEFAULT_MESSAGE_PARAM = "message";

  private String captchaParam = DEFAULT_CAPTCHA_PARAM;
  private String mobileLoginParam = DEFAULT_MOBILE_PARAM;
  private String messageParam = DEFAULT_MESSAGE_PARAM;

  @Override
  protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
    String username = getUsername(request);
    String password = getPassword(request);
    if (password == null) {
      password = "";
    }
    boolean rememberMe = isRememberMe(request);
    String host = StringUtils.getRemoteAddr((HttpServletRequest) request);
    String captcha = getCaptcha(request);
    boolean mobile = isMobileLogin(request);
    UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,
        password.toCharArray(), rememberMe, host, captcha, mobile);

    return usernamePasswordToken;
  }

  /**
   * 获取登录用户名
   */
  @Override
  protected String getUsername(ServletRequest request) {
    String username = super.getUsername(request);
    if (StringUtils.isBlank(username)) {
      username = StringUtils.toString(request.getAttribute(getUsernameParam()), StringUtils.EMPTY);
    }
    return username;
  }

  /**
   * 获取登录密码
   */
  @Override
  protected String getPassword(ServletRequest request) {
    String password = super.getPassword(request);
    if (StringUtils.isBlank(password)) {
      password = StringUtils.toString(request.getAttribute(getPasswordParam()), StringUtils.EMPTY);
    }
    return password;
  }

  /**
   * 获取记住我
   */
  @Override
  protected boolean isRememberMe(ServletRequest request) {
    String isRememberMe = WebUtils.getCleanParam(request, getRememberMeParam());
    if (StringUtils.isBlank(isRememberMe)) {
      isRememberMe = StringUtils
          .toString(request.getAttribute(getRememberMeParam()), StringUtils.EMPTY);
    }
    return StringUtils.toBoolean(isRememberMe);
  }

  public String getCaptchaParam() {
    return captchaParam;
  }

  protected String getCaptcha(ServletRequest request) {
    return WebUtils.getCleanParam(request, getCaptchaParam());
  }

  public String getMobileLoginParam() {
    return mobileLoginParam;
  }

  protected boolean isMobileLogin(ServletRequest request) {
    return WebUtils.isTrue(request, getMobileLoginParam());
  }

  public String getMessageParam() {
    return messageParam;
  }

  /**
   * 登录成功之后跳转URL
   */
  @Override
  public String getSuccessUrl() {
    return super.getSuccessUrl();
  }

  @Override
  protected void issueSuccessRedirect(ServletRequest request,
      ServletResponse response) throws Exception {
    Principal p = UserUtils.getPrincipal();
    if (p != null) {
      try {
        //登入成功,根据用户名密码获取token信息
        String authenticationApiUrl = moduleLinkConfiguration.getLink("authentication");
        Map<String, Object> body = new HashMap<>();
        body.put("username", getUsername(request));
        body.put("password", getPassword(request));
        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(body);
        ResponseEntity<String> responseEntity = restTemplate
            .postForEntity(authenticationApiUrl + "/token", httpEntity, String.class);
        logger.debug("<<<get remote token :" + responseEntity.getBody());
        String token = responseEntity.getBody();
        String authorizationKey = "Authorization";
        if (StringUtils.isNotEmpty(token)) {
          restTemplate.getInterceptors().add(0,new ClientHttpRequestInterceptor() {
            @Override
            public ClientHttpResponse intercept(HttpRequest request, byte[] body,
                ClientHttpRequestExecution execution) throws IOException {
              HttpHeaders httpHeaders = request.getHeaders();
              httpHeaders.set(authorizationKey, responseEntity.getBody());
              httpHeaders.set("ContentType", MediaType.APPLICATION_JSON_VALUE);
              return execution.execute(request, body);
            }
          });
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    WebUtils.issueRedirect(request, response, getSuccessUrl(), null, true);
  }

  /**
   * 登录失败调用事件
   */
  @Override
  protected boolean onLoginFailure(AuthenticationToken token,
      AuthenticationException e, ServletRequest request, ServletResponse response) {
    String className = e.getClass().getName(), message = "";
    if (IncorrectCredentialsException.class.getName().equals(className)
        || UnknownAccountException.class.getName().equals(className)) {
      message = "用户或密码错误, 请重试.";
    } else if (e.getMessage() != null && StringUtils.startsWith(e.getMessage(), "msg:")) {
      message = StringUtils.replace(e.getMessage(), "msg:", "");
    } else {
      message = "系统出现点问题，请稍后再试！";
      e.printStackTrace(); // 输出到控制台
    }
    request.setAttribute(getFailureKeyAttribute(), className);
    request.setAttribute(getMessageParam(), message);
    return true;
  }

}