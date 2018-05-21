/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.knt.rd.modules.customer.enterprise.web;

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

import com.knt.rd.modules.sys.entity.User;
import com.knt.rd.modules.sys.utils.UserUtils;
import com.knt.rd.common.config.Global;
import com.knt.rd.common.persistence.Page;
import com.knt.rd.common.web.BaseController;
import com.knt.rd.common.utils.StringUtils;
import com.knt.rd.common.utils.JsonUtils;
import com.knt.rd.common.utils.DateUtils;
import com.knt.rd.common.utils.page.PageInfo;

import com.knt.rd.modules.customer.enterprise.entity.EnterpriseEntity;
import com.knt.rd.modules.customer.enterprise.api.model.Enterprise;

/**
 * 企业信息管理Controller
 *
 * @author yzx
 * @version 2018-05-21
 */
@Controller
@RequestMapping(value = "${adminPath}/enterprise/enterprise")
public class EnterpriseViewController extends BaseController {

  @Autowired
  private RestTemplate restTemplate;

  @ModelAttribute
  public EnterpriseEntity get(@RequestParam(required = false) String id) {

    EnterpriseEntity entity = new EnterpriseEntity();
    if (StringUtils.isNotBlank(id)) {
      String apiBaseUrl = modelLinkConfiguration.getLink("enterprise");
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("id", id);
      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/enterprise/enterprise/api/{id}", String.class,
              urlVariables);

      return JsonUtils.toSimpleObject(responseEntity.getBody(), EnterpriseEntity.class);
    }
    return entity;
  }

  @RequiresPermissions("enterprise:enterprise:view")
  @RequestMapping(value = {"list", ""})
  public String list(EnterpriseEntity enterprise, HttpServletRequest request,
      HttpServletResponse response, Model model) {

    Page<Enterprise> page = new Page<>(request, response);
    Enterprise type = JsonUtils
        .toSimpleObject(JsonUtils.toJson(enterprise), Enterprise.class);

    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("pageNum", page.getPageNo());
    urlVariables.put("pageSize", page.getPageSize());

    String apiBaseUrl = modelLinkConfiguration.getLink("it");
    ResponseEntity<String> pageResponseEntity = restTemplate
        .postForEntity(
            apiBaseUrl + "/enterprise/enterprise/api/list?pageNum={pageNum}&&pageSize={pageSize}",
            type, String.class, urlVariables);

    PageInfo<Enterprise> enterprisePageInfo = JsonUtils
        .fromJson(pageResponseEntity.getBody(), PageInfo.class, Enterprise.class);

    page.setCount(enterprisePageInfo.getTotal());
    page.setPageNo(enterprisePageInfo.getPageNum());
    page.setList(enterprisePageInfo.getList());
    model.addAttribute("page", page);
    model.addAttribute("enterprise", enterprise);

    return "customer/enterprise/enterpriseList";
  }

  @RequiresPermissions("enterprise:enterprise:view")
  @RequestMapping(value = "form")
  public String form(EnterpriseEntity enterprise, Model model) {
    model.addAttribute("enterprise", enterprise);
    return "customer/enterprise/enterpriseForm";
  }

  @RequiresPermissions("enterprise:enterprise:edit")
  @RequestMapping(value = "save")
  public String save(EnterpriseEntity enterprise, Model model,
      RedirectAttributes redirectAttributes) {
    if (!beanValidator(model, enterprise)) {
      return form(enterprise, model);
    }

    Enterprise type = resolveBeanProperties(StringUtils.isEmpty(enterprise.getId()), enterprise);
    String apiBaseUrl = modelLinkConfiguration.getLink("enterprise");

    restTemplate.postForObject(apiBaseUrl + "/enterprise/enterprise/api/save", type, String.class);
    addMessage(redirectAttributes, "保存企业信息管理成功");

    return "redirect:" + Global.getAdminPath() + "/enterprise/enterprise/?repage";
  }

  @RequiresPermissions("enterprise:enterprise:edit")
  @RequestMapping(value = "delete")
  public String delete(EnterpriseEntity enterprise, RedirectAttributes redirectAttributes) {

    String apiBaseUrl = modelLinkConfiguration.getLink("enterprise");

    Enterprise type = new Enterprise();
    BeanUtils.copyProperties(enterprise, type);
    restTemplate
        .postForEntity(apiBaseUrl + "/enterprise/enterprise/api/delete", type, String.class);

    addMessage(redirectAttributes, "删除企业信息管理成功");
    return "redirect:" + Global.getAdminPath() + "/enterprise/enterprise/?repage";
  }

  /**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private Enterprise resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    Enterprise enterprise = JsonUtils.toSimpleObject(JsonUtils.toJson(source), Enterprise.class);
    Date now = DateUtils.getNow();
    if (isNewRecord) {
      enterprise.setCreateDate(now);
      enterprise.setCreateBy(user.getName());
    }
    enterprise.setUpdateBy(user.getName());
    enterprise.setUpdateDate(now);

    return enterprise;
  }

}