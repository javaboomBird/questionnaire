/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.customer.customer.web;

import com.create80.rd.common.config.Global;
import com.create80.rd.common.utils.DateUtils;
import com.create80.rd.common.utils.JsonUtils;
import com.create80.rd.common.web.BaseController;
import com.create80.rd.modules.customer.customer.api.model.Customer;
import com.create80.rd.modules.customer.customer.entity.CustomerEntity;
import com.create80.rd.modules.customer.customer.entity.CustomerTypeEnum;
import com.create80.rd.modules.sys.entity.User;
import com.create80.rd.modules.sys.utils.UserUtils;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 政府信息管理Controller
 *
 * @author yzx
 * @version 2018-06-22
 */
@Controller
@RequestMapping(value = "${adminPath}/customer/government")
public class CustomerGovernmentViewController extends BaseController {

  @Autowired
  private CustomerEnterpriseViewController customerEnterpriseViewController;

  @ModelAttribute
  public CustomerEntity get(@RequestParam(required = false) String id) {
    return customerEnterpriseViewController.get(id);
  }

  @RequiresPermissions("customer:government:view")
  @RequestMapping(value = {"list", ""})
  public String list(CustomerEntity customer, HttpServletRequest request,
      HttpServletResponse response, Model model) {
    customer.setType(CustomerTypeEnum.GOVENMENT_TYPE.getValue());
    customerEnterpriseViewController.list(customer, request, response, model);
    return "modules/customer/government/governmentList";
  }

  @RequiresPermissions("customer:government:view")
  @RequestMapping(value = "form")
  public String form(CustomerEntity customer, Model model) {
    model.addAttribute("customer", customer);
    return "modules/customer/government/governmentForm";
  }

  @RequestMapping(value = "formView")
  public String formView(CustomerEntity customer, Model model) {
    model.addAttribute("customer", customer);
    return "modules/customer/government/governmentFormView";
  }

  @RequiresPermissions("customer:government:edit")
  @RequestMapping(value = "save")
  public String save(CustomerEntity customer, Model model, RedirectAttributes redirectAttributes) {
    if (!beanValidator(model, customer)) {
      return form(customer, model);
    }
    customerEnterpriseViewController.save(customer, model, redirectAttributes);

    return "redirect:" + Global.getAdminPath() + "/customer/government/?repage";
  }

  @RequiresPermissions("customer:government:edit")
  @RequestMapping(value = "delete")
  public String delete(CustomerEntity customer, RedirectAttributes redirectAttributes) {
    customerEnterpriseViewController.delete(customer, redirectAttributes);
    return "redirect:" + Global.getAdminPath() + "/customer/government/?repage";
  }



}