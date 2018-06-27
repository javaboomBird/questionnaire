/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.engineering.web;

import com.create80.rd.modules.group.web.SysGroupViewController;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;

import com.create80.rd.common.utils.JsonUtils;
import com.create80.rd.modules.sys.entity.User;
import com.create80.rd.modules.sys.utils.UserUtils;
import com.create80.rd.common.config.Global;
import com.create80.rd.common.persistence.Page;
import com.create80.rd.common.web.BaseController;
import com.create80.rd.common.utils.StringUtils;
import com.create80.rd.common.utils.page.PageInfo;
import com.create80.rd.modules.engineering.entity.EngineeringSignInEntity;
import com.create80.rd.modules.engineering.api.model.EngineeringSignIn;

/**
 * 工程签到Controller
 *
 * @author yzx
 * @version 2018-06-27
 */
@Controller
@RequestMapping(value = "${adminPath}/engineering/engineeringSignIn")
public class EngineeringSignInViewController extends BaseController {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private EngineeringWorkOrderViewController engineeringWorkOrderViewController;

  @Autowired
  private SysGroupViewController sysGroupViewController;

  @ModelAttribute
  public EngineeringSignInEntity get(@RequestParam(required = false) String id) {

    EngineeringSignInEntity entity = new EngineeringSignInEntity();
    if (StringUtils.isNotBlank(id)) {
      String apiBaseUrl = moduleLinkConfiguration.getLink("engineering");
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("id", id);
      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/engineering/engineeringSignIn/api/{id}", String.class,
              urlVariables);

      String type = responseEntity.getBody();
      entity = JsonUtils.toSimpleObject(type, EngineeringSignInEntity.class);

      setEntity(entity);
    }
    return entity;
  }

  private void setEntity(EngineeringSignInEntity entity) {
    if (entity != null) {
      entity.setEngineeringWorkOrder(
          engineeringWorkOrderViewController.get(entity.getEngineeringId()));
      entity.setSysGroup(sysGroupViewController.get(entity.getTeamId()));
    }
  }


  @RequiresPermissions("engineering:engineeringSignIn:view")
  @RequestMapping(value = {"list", ""})
  public String list(EngineeringSignInEntity engineeringSignIn, HttpServletRequest request,
      HttpServletResponse response, Model model) {

    Page<EngineeringSignInEntity> page = new Page<>(request, response);
    EngineeringSignIn type = JsonUtils
        .toSimpleObject(JsonUtils.toJson(engineeringSignIn), EngineeringSignIn.class);

    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("pageNum", page.getPageNo());
    urlVariables.put("pageSize", page.getPageSize());

    String apiBaseUrl = moduleLinkConfiguration.getLink("engineering");
    ResponseEntity<String> pageResponseEntity = restTemplate
        .postForEntity(
            apiBaseUrl
                + "/engineering/engineeringSignIn/api/list?pageNum={pageNum}&&pageSize={pageSize}",
            type, String.class, urlVariables);

    PageInfo<EngineeringSignInEntity> engineeringSignInPageInfo = JsonUtils
        .fromJson(pageResponseEntity.getBody(), PageInfo.class, EngineeringSignInEntity.class);

    List<EngineeringSignInEntity> engineeringSignInEntityList = engineeringSignInPageInfo.getList();
    if (engineeringSignInEntityList != null) {
      engineeringSignInEntityList.stream().forEach(engineeringSignInEntity -> {
        setEntity(engineeringSignInEntity);
      });
    }
    page.setCount(engineeringSignInPageInfo.getTotal());
    page.setPageNo(engineeringSignInPageInfo.getPageNum());
    page.setList(engineeringSignInEntityList);
    model.addAttribute("page", page);
    model.addAttribute("engineeringSignIn", engineeringSignIn);

    return "modules/engineering/engineeringSignInList";
  }

  @RequiresPermissions("engineering:engineeringSignIn:view")
  @RequestMapping(value = "form")
  public String form(EngineeringSignInEntity engineeringSignIn, Model model) {
    model.addAttribute("engineeringSignIn", engineeringSignIn);
    return "modules/engineering/engineeringSignInForm";
  }

  @RequiresPermissions("engineering:engineeringSignIn:edit")
  @RequestMapping(value = "save")
  public String save(EngineeringSignInEntity engineeringSignIn, Model model,
      RedirectAttributes redirectAttributes) {
    if (!beanValidator(model, engineeringSignIn)) {
      return form(engineeringSignIn, model);
    }

    EngineeringSignIn type = resolveBeanProperties(StringUtils.isEmpty(engineeringSignIn.getId()),
        engineeringSignIn);
    String apiBaseUrl = moduleLinkConfiguration.getLink("engineering");

    restTemplate
        .postForObject(apiBaseUrl + "/engineering/engineeringSignIn/api/save", type, String.class);
    addMessage(redirectAttributes, "保存工程签到成功");

    return "redirect:" + Global.getAdminPath() + "/engineering/engineeringSignIn/?repage";
  }

  @RequiresPermissions("engineering:engineeringSignIn:edit")
  @RequestMapping(value = "delete")
  public String delete(EngineeringSignInEntity engineeringSignIn,
      RedirectAttributes redirectAttributes) {

    String apiBaseUrl = moduleLinkConfiguration.getLink("engineering");

    EngineeringSignIn type = new EngineeringSignIn();
    BeanUtils.copyProperties(engineeringSignIn, type);
    restTemplate.postForEntity(apiBaseUrl + "/engineering/engineeringSignIn/api/delete", type,
        String.class);

    addMessage(redirectAttributes, "删除工程签到成功");
    return "redirect:" + Global.getAdminPath() + "/engineering/engineeringSignIn/?repage";
  }

  /**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private EngineeringSignIn resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    EngineeringSignIn engineeringSignIn = JsonUtils
        .toSimpleObject(JsonUtils.toJson(source), EngineeringSignIn.class);
    Date now = new Date();
    if (isNewRecord) {
      engineeringSignIn.setInsertTime(now);
      engineeringSignIn.setInsertBy(user.getName());
    }
    engineeringSignIn.setUpdateBy(user.getName());
    engineeringSignIn.setUpdateTime(now);
    return engineeringSignIn;
  }

}