/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.customer.bt.web;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.BeanUtils;

import com.create80.rd.common.utils.JsonUtils;
import com.create80.rd.modules.sys.entity.User;
import com.create80.rd.modules.sys.utils.UserUtils;
import com.create80.rd.common.config.Global;
import com.create80.rd.common.persistence.Page;
import com.create80.rd.common.web.BaseController;
import com.create80.rd.common.utils.StringUtils;
import com.create80.rd.common.utils.page.PageInfo;
import com.create80.rd.modules.customer.bt.entity.CustomerBusinessTypeEntity;
import com.create80.rd.modules.customer.bt.api.model.CustomerBusinessType;

/**
 * 工商行业类型Controller
 *
 * @author yzx
 * @version 2018-06-22
 */
@Controller
@RequestMapping(value = "${adminPath}/customer/bt")
public class CustomerBusinessTypeViewController extends BaseController {

  @Autowired
  private RestTemplate restTemplate;

  @ModelAttribute
  public CustomerBusinessTypeEntity get(@RequestParam(required = false) String id) {

    CustomerBusinessTypeEntity entity = new CustomerBusinessTypeEntity();
    if (StringUtils.isNotBlank(id)) {
      String apiBaseUrl = moduleLinkConfiguration.getLink("customer");
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("id", id);
      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/bt/customerBusinessType/api/{id}", String.class,
              urlVariables);

      String type = responseEntity.getBody();
      entity = JsonUtils.toSimpleObject(type, CustomerBusinessTypeEntity.class);
    }
    return entity;
  }

  @RequiresPermissions("bt:customerBusinessType:view")
  @RequestMapping(value = {"list", ""})
  public String list(CustomerBusinessTypeEntity customerBusinessType, HttpServletRequest request,
      HttpServletResponse response, Model model) {

    Page<CustomerBusinessTypeEntity> page = new Page<>(request, response);
    CustomerBusinessType type = JsonUtils
        .toSimpleObject(JsonUtils.toJson(customerBusinessType), CustomerBusinessType.class);

    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("pageNum", page.getPageNo());
    urlVariables.put("pageSize", page.getPageSize());

    String apiBaseUrl = moduleLinkConfiguration.getLink("customer");
    ResponseEntity<String> pageResponseEntity = restTemplate
        .postForEntity(
            apiBaseUrl + "/bt/customerBusinessType/api/list?pageNum={pageNum}&&pageSize={pageSize}",
            type, String.class, urlVariables);

    PageInfo<CustomerBusinessTypeEntity> customerBusinessTypePageInfo = JsonUtils
        .fromJson(pageResponseEntity.getBody(), PageInfo.class, CustomerBusinessTypeEntity.class);

    page.setCount(customerBusinessTypePageInfo.getTotal());
    page.setPageNo(customerBusinessTypePageInfo.getPageNum());
    page.setList(customerBusinessTypePageInfo.getList());
    model.addAttribute("page", page);
    model.addAttribute("customerBusinessType", customerBusinessType);

    return "modules/customer/bt/customerBusinessTypeList";
  }

  @RequiresPermissions("bt:customerBusinessType:view")
  @RequestMapping(value = "form")
  public String form(CustomerBusinessTypeEntity customerBusinessType, Model model) {
    model.addAttribute("customerBusinessType", customerBusinessType);
    return "modules/customer/bt/customerBusinessTypeForm";
  }

  @RequiresPermissions("bt:customerBusinessType:edit")
  @RequestMapping(value = "save")
  public String save(CustomerBusinessTypeEntity customerBusinessType, Model model,
      RedirectAttributes redirectAttributes) {
    if (!beanValidator(model, customerBusinessType)) {
      return form(customerBusinessType, model);
    }

    CustomerBusinessType type = resolveBeanProperties(
        StringUtils.isEmpty(customerBusinessType.getId()), customerBusinessType);
    String apiBaseUrl = moduleLinkConfiguration.getLink("customer");

    restTemplate
        .postForObject(apiBaseUrl + "/bt/customerBusinessType/api/save", type, String.class);
    addMessage(redirectAttributes, "保存工商行业类型成功");

    return "redirect:" + Global.getAdminPath() + "/customer/bt/?repage";
  }

  @RequiresPermissions("bt:customerBusinessType:edit")
  @RequestMapping(value = "delete")
  public String delete(CustomerBusinessTypeEntity customerBusinessType,
      RedirectAttributes redirectAttributes) {

    String apiBaseUrl = moduleLinkConfiguration.getLink("customer");

    CustomerBusinessType type = new CustomerBusinessType();
    BeanUtils.copyProperties(customerBusinessType, type);
    restTemplate
        .postForEntity(apiBaseUrl + "/bt/customerBusinessType/api/delete", type, String.class);

    addMessage(redirectAttributes, "删除工商行业类型成功");
    return "redirect:" + Global.getAdminPath() + "/customer/bt/?repage";
  }

  /**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private CustomerBusinessType resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    CustomerBusinessType customerBusinessType = JsonUtils
        .toSimpleObject(JsonUtils.toJson(source), CustomerBusinessType.class);
    Date now = new Date();
    if (isNewRecord) {
      customerBusinessType.setInsertTime(now);
      customerBusinessType.setInsertBy(user.getName());
    }
    customerBusinessType.setUpdateBy(user.getName());
    customerBusinessType.setUpdateTime(now);
    return customerBusinessType;
  }

}