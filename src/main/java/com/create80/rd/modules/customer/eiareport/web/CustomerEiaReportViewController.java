/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.customer.eiareport.web;

import com.create80.rd.modules.customer.customer.web.CustomerEnterpriseViewController;
import com.create80.rd.modules.customer.pt.web.CustomerPollutionTypeViewController;
import java.util.ArrayList;
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

import com.create80.rd.modules.customer.eiareport.entity.CustomerEiaReportEntity;
import com.create80.rd.modules.customer.eiareport.api.model.CustomerEiaReport;


/**
 * 环评报告信息管理Controller
 *
 * @author yzx
 * @version 2018-06-22
 */
@Controller
@RequestMapping(value = "${adminPath}/customer/eiareport")
public class CustomerEiaReportViewController extends BaseController {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private CustomerEnterpriseViewController customerEnterpriseViewController;

  @Autowired
  private CustomerPollutionTypeViewController customerPollutionTypeViewController;


  @ModelAttribute
  public CustomerEiaReportEntity get(@RequestParam(required = false) String id) {

    CustomerEiaReportEntity entity = new CustomerEiaReportEntity();
    if (StringUtils.isNotBlank(id)) {
      String apiBaseUrl = moduleLinkConfiguration.getLink("customer");
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("id", id);
      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/eiareport/customerEiaReport/api/{id}", String.class,
              urlVariables);

      entity = JsonUtils.toSimpleObject(responseEntity.getBody(), CustomerEiaReportEntity.class);


    }
    return entity;
  }

  @RequiresPermissions("eiareport:customerEiaReport:view")
  @RequestMapping(value = {"list", ""})
  public String list(CustomerEiaReportEntity customerEiaReport, HttpServletRequest request,
      HttpServletResponse response, Model model) {

    Page<CustomerEiaReportEntity> page = new Page<>(request, response);
    PageInfo<CustomerEiaReportEntity> customerEiaReportPageInfo = new PageInfo<>();
    try {
      CustomerEiaReport type = JsonUtils
          .toSimpleObject(JsonUtils.toJson(customerEiaReport), CustomerEiaReport.class);

      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("pageNum", page.getPageNo());
      urlVariables.put("pageSize", page.getPageSize());

      String apiBaseUrl = moduleLinkConfiguration.getLink("customer");
      ResponseEntity<String> pageResponseEntity = restTemplate
          .postForEntity(
              apiBaseUrl
                  + "/eiareport/customerEiaReport/api/list?pageNum={pageNum}&&pageSize={pageSize}",
              type, String.class, urlVariables);

      customerEiaReportPageInfo = JsonUtils
          .fromJson(pageResponseEntity.getBody(), PageInfo.class, CustomerEiaReportEntity.class);
    } catch (Exception e) {
      e.printStackTrace();
    }

    List<CustomerEiaReportEntity> customerEiaReportEntityList = customerEiaReportPageInfo.getList();
    if (customerEiaReportEntityList != null) {
      customerEiaReportEntityList.stream().forEach(customerEiaReportEntity -> {
        customerEiaReportEntity.setCustomer(
            customerEnterpriseViewController.get(customerEiaReportEntity.getCustomerId()));

        customerEiaReportEntity.setCustomerPollutionType(
            customerPollutionTypeViewController.get(customerEiaReportEntity.getPollutionTypeId()));
      });
    }
    page.setCount(customerEiaReportPageInfo.getTotal());
    page.setPageNo(customerEiaReportPageInfo.getPageNum());
    page.setList(customerEiaReportEntityList);
    model.addAttribute("page", page);
    model.addAttribute("customerEiaReport", customerEiaReport);

    return "modules/customer/eiareport/customerEiaReportList";
  }

  @RequiresPermissions("eiareport:customerEiaReport:view")
  @RequestMapping(value = "form")
  public String form(CustomerEiaReportEntity customerEiaReport, Model model) {
    model.addAttribute("customerEiaReport", customerEiaReport);
    return "modules/customer/eiareport/customerEiaReportForm";
  }

  @RequiresPermissions("eiareport:customerEiaReport:edit")
  @RequestMapping(value = "save")
  public String save(CustomerEiaReportEntity customerEiaReport, Model model,
      RedirectAttributes redirectAttributes) {
    if (!beanValidator(model, customerEiaReport)) {
      return form(customerEiaReport, model);
    }

    CustomerEiaReport type = resolveBeanProperties(StringUtils.isEmpty(customerEiaReport.getId()),
        customerEiaReport);
    String apiBaseUrl = moduleLinkConfiguration.getLink("customer");

    restTemplate
        .postForObject(apiBaseUrl + "/eiareport/customerEiaReport/api/save", type, String.class);
    addMessage(redirectAttributes, "保存环评报告信息管理成功");

    return "redirect:" + Global.getAdminPath() + "/customer/eiareport?repage";
  }

  @RequiresPermissions("eiareport:customerEiaReport:edit")
  @RequestMapping(value = "delete")
  public String delete(CustomerEiaReportEntity customerEiaReport,
      RedirectAttributes redirectAttributes) {

    String apiBaseUrl = moduleLinkConfiguration.getLink("customer");

    CustomerEiaReport type = new CustomerEiaReport();
    BeanUtils.copyProperties(customerEiaReport, type);
    restTemplate
        .postForEntity(apiBaseUrl + "/eiareport/customerEiaReport/api/delete", type, String.class);

    addMessage(redirectAttributes, "删除环评报告信息管理成功");
    return "redirect:" + Global.getAdminPath() + "/customer/eiareport?repage";
  }

  /**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private CustomerEiaReport resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    CustomerEiaReport customerEiaReport = JsonUtils
        .toSimpleObject(JsonUtils.toJson(source), CustomerEiaReport.class);
    Date now = DateUtils.getNow();
    if (isNewRecord) {
      customerEiaReport.setInsertTime(now);
      customerEiaReport.setInsertBy(user.getName());
    }
    customerEiaReport.setUpdateBy(user.getName());
    customerEiaReport.setUpdateTime(now);
    return customerEiaReport;
  }

}