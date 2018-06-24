/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.customer.customer.web;

import com.create80.rd.modules.customer.customer.entity.CustomerTypeEnum;
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
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;

import com.create80.rd.modules.sys.entity.User;
import com.create80.rd.modules.sys.utils.UserUtils;
import com.create80.rd.common.config.Global;
import com.create80.rd.common.persistence.Page;
import com.create80.rd.common.web.BaseController;
import com.create80.rd.common.utils.StringUtils;
import com.create80.rd.common.utils.JsonUtils;
import com.create80.rd.common.utils.DateUtils;
import com.create80.rd.common.utils.page.PageInfo;

import com.create80.rd.modules.customer.customer.entity.CustomerEntity;
import com.create80.rd.modules.customer.customer.api.model.Customer;

import com.create80.rd.modules.sys.service.AreaService;

/**
 * 企业信息管理Controller
 *
 * @author yzx
 * @version 2018-06-22
 */
@Controller
@RequestMapping(value = "${adminPath}/customer/enterprise")
public class CustomerEnterpriseViewController extends BaseController {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private AreaService areaService;

  @ModelAttribute
  public CustomerEntity get(@RequestParam(required = false) String id) {

    CustomerEntity entity = new CustomerEntity();
    if (StringUtils.isNotBlank(id)) {
      String apiBaseUrl = moduleLinkConfiguration.getLink("customer");
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("id", id);
      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/customer/api/{id}", String.class,
              urlVariables);

      entity = JsonUtils.toSimpleObject(responseEntity.getBody(), CustomerEntity.class);

      entity.setArea(areaService.get(entity.getAreaId()));
    }
    return entity;
  }

  @RequiresPermissions("customer:enterprise:view")
  @RequestMapping(value = {"list", ""})
  public String list(CustomerEntity customer, HttpServletRequest request,
      HttpServletResponse response, Model model) {

    if (StringUtils.isEmpty(customer.getType())) {
      customer.setType(CustomerTypeEnum.ENTERPRISE_TYPE.getValue());
    }

    Page<CustomerEntity> page = new Page<>(request, response);
    Customer type = JsonUtils
        .toSimpleObject(JsonUtils.toJson(customer), Customer.class);

    PageInfo<CustomerEntity> customerPageInfo = new PageInfo<>();
    try {
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("pageNum", page.getPageNo());
      urlVariables.put("pageSize", page.getPageSize());

      String apiBaseUrl = moduleLinkConfiguration.getLink("customer");
      ResponseEntity<String> pageResponseEntity = restTemplate
          .postForEntity(
              apiBaseUrl + "/customer/api/list?pageNum={pageNum}&&pageSize={pageSize}",
              type, String.class, urlVariables);

      customerPageInfo = JsonUtils
          .fromJson(pageResponseEntity.getBody(), PageInfo.class, CustomerEntity.class);
    } catch (RestClientException e) {
      e.printStackTrace();
    }

    page.setCount(customerPageInfo.getTotal());
    page.setPageNo(customerPageInfo.getPageNum());
    page.setList(customerPageInfo.getList());
    model.addAttribute("page", page);
    model.addAttribute("customer", customer);

    return "modules/customer/enterprise/enterpriseList";
  }

  @RequiresPermissions("customer:enterprise:view")
  @RequestMapping(value = "form")
  public String form(CustomerEntity customer, Model model) {
    model.addAttribute("customer", customer);
    return "modules/customer/enterprise/enterpriseForm";
  }

  @RequiresPermissions("customer:enterprise:edit")
  @RequestMapping(value = "save")
  public String save(CustomerEntity customer, Model model, RedirectAttributes redirectAttributes) {
    if (!beanValidator(model, customer)) {
      return form(customer, model);
    }

    Customer type = resolveBeanProperties(StringUtils.isEmpty(customer.getId()), customer);

    String apiBaseUrl = moduleLinkConfiguration.getLink("customer");

    restTemplate.postForObject(apiBaseUrl + "/customer/api/save", type, String.class);
    addMessage(redirectAttributes, "保存信息成功");

    return "redirect:" + Global.getAdminPath() + "/customer/enterprise/?repage";
  }

  @RequiresPermissions("customer:enterprise:edit")
  @RequestMapping(value = "delete")
  public String delete(CustomerEntity customer, RedirectAttributes redirectAttributes) {

    String apiBaseUrl = moduleLinkConfiguration.getLink("customer");

    Customer type = new Customer();
    BeanUtils.copyProperties(customer, type);
    restTemplate.postForEntity(apiBaseUrl + "/customer/api/delete", type, String.class);

    addMessage(redirectAttributes, "删除信息成功");
    return "redirect:" + Global.getAdminPath() + "/customer/enterprise/?repage";
  }

  /**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private Customer resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    Customer customer = JsonUtils.toSimpleObject(JsonUtils.toJson(source), Customer.class);
    Date now = DateUtils.getNow();
    if (isNewRecord) {
      customer.setInsertTime(now);
      customer.setInsertBy(user.getName());
    }
    customer.setUpdateBy(user.getName());
    customer.setUpdateTime(now);
    return customer;
  }

}