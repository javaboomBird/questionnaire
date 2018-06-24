/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.customer.pt.web;

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
import com.create80.rd.modules.customer.pt.entity.CustomerPollutionTypeEntity;
import com.create80.rd.modules.customer.pt.api.model.CustomerPollutionType;

/**
 * 排污类型管理Controller
 *
 * @author yzx
 * @version 2018-06-22
 */
@Controller
@RequestMapping(value = "${adminPath}/customer/pt")
public class CustomerPollutionTypeViewController extends BaseController {

  @Autowired
  private RestTemplate restTemplate;

  @ModelAttribute
  public CustomerPollutionTypeEntity get(@RequestParam(required = false) String id) {

    CustomerPollutionTypeEntity entity = new CustomerPollutionTypeEntity();
    if (StringUtils.isNotBlank(id)) {
      String apiBaseUrl = moduleLinkConfiguration.getLink("customer");
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("id", id);
      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/pt/customerPollutionType/api/{id}", String.class,
              urlVariables);

      String type = responseEntity.getBody();
      entity = JsonUtils.toSimpleObject(type, CustomerPollutionTypeEntity.class);
    }
    return entity;
  }

  @RequiresPermissions("pt:customerPollutionType:view")
  @RequestMapping(value = {"list", ""})
  public String list(CustomerPollutionTypeEntity customerPollutionType, HttpServletRequest request,
      HttpServletResponse response, Model model) {

    Page<CustomerPollutionTypeEntity> page = new Page<>(request, response);
    CustomerPollutionType type = JsonUtils
        .toSimpleObject(JsonUtils.toJson(customerPollutionType), CustomerPollutionType.class);

    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("pageNum", page.getPageNo());
    urlVariables.put("pageSize", page.getPageSize());

    String apiBaseUrl = moduleLinkConfiguration.getLink("customer");
    ResponseEntity<String> pageResponseEntity = restTemplate
        .postForEntity(
            apiBaseUrl
                + "/pt/customerPollutionType/api/list?pageNum={pageNum}&&pageSize={pageSize}",
            type, String.class, urlVariables);

    PageInfo<CustomerPollutionTypeEntity> customerPollutionTypePageInfo = JsonUtils
        .fromJson(pageResponseEntity.getBody(), PageInfo.class, CustomerPollutionTypeEntity.class);

    page.setCount(customerPollutionTypePageInfo.getTotal());
    page.setPageNo(customerPollutionTypePageInfo.getPageNum());
    page.setList(customerPollutionTypePageInfo.getList());
    model.addAttribute("page", page);
    model.addAttribute("customerPollutionType", customerPollutionType);

    return "modules/customer/pt/customerPollutionTypeList";
  }

  @RequiresPermissions("pt:customerPollutionType:view")
  @RequestMapping(value = "form")
  public String form(CustomerPollutionTypeEntity customerPollutionType, Model model) {
    model.addAttribute("customerPollutionType", customerPollutionType);
    return "modules/customer/pt/customerPollutionTypeForm";
  }

  @RequiresPermissions("pt:customerPollutionType:edit")
  @RequestMapping(value = "save")
  public String save(CustomerPollutionTypeEntity customerPollutionType, Model model,
      RedirectAttributes redirectAttributes) {
    if (!beanValidator(model, customerPollutionType)) {
      return form(customerPollutionType, model);
    }

    CustomerPollutionType type = resolveBeanProperties(
        StringUtils.isEmpty(customerPollutionType.getId()), customerPollutionType);
    String apiBaseUrl = moduleLinkConfiguration.getLink("customer");

    restTemplate
        .postForObject(apiBaseUrl + "/pt/customerPollutionType/api/save", type, String.class);
    addMessage(redirectAttributes, "保存排污类型管理成功");

    return "redirect:" + Global.getAdminPath() + "/customer/pt/?repage";
  }

  @RequiresPermissions("pt:customerPollutionType:edit")
  @RequestMapping(value = "delete")
  public String delete(CustomerPollutionTypeEntity customerPollutionType,
      RedirectAttributes redirectAttributes) {

    String apiBaseUrl = moduleLinkConfiguration.getLink("customer");

    CustomerPollutionType type = new CustomerPollutionType();
    BeanUtils.copyProperties(customerPollutionType, type);
    restTemplate
        .postForEntity(apiBaseUrl + "/pt/customerPollutionType/api/delete", type, String.class);

    addMessage(redirectAttributes, "删除排污类型管理成功");
    return "redirect:" + Global.getAdminPath() + "/customer/pt/?repage";
  }

  /**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private CustomerPollutionType resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    CustomerPollutionType customerPollutionType = JsonUtils
        .toSimpleObject(JsonUtils.toJson(source), CustomerPollutionType.class);
    Date now = new Date();
    if (isNewRecord) {
      customerPollutionType.setInsertTime(now);
      customerPollutionType.setInsertBy(user.getName());
    }
    customerPollutionType.setUpdateBy(user.getName());
    customerPollutionType.setUpdateTime(now);
    return customerPollutionType;
  }

}