/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.customer.it.web;

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
import com.create80.rd.modules.customer.it.entity.CustomerIndustryTypeEntity;
import com.create80.rd.modules.customer.it.api.model.CustomerIndustryType;

/**
 * 污染行业类型Controller
 * @author yzx
 * @version 2018-06-22
 */
@Controller
@RequestMapping(value = "${adminPath}/customer/it")
public class CustomerIndustryTypeViewController extends BaseController {

	@Autowired
  private RestTemplate restTemplate;
	
	@ModelAttribute
	public CustomerIndustryTypeEntity get(@RequestParam(required=false) String id) {

		CustomerIndustryTypeEntity entity = new CustomerIndustryTypeEntity();
		if (StringUtils.isNotBlank(id)){
	  	String apiBaseUrl = moduleLinkConfiguration.getLink("customer");
		   Map<String, Object> urlVariables = new HashMap<>();
		   urlVariables.put("id",id);
		   ResponseEntity<String> responseEntity = restTemplate
		                      .getForEntity(apiBaseUrl + "/it/customerIndustryType/api/{id}", String.class, urlVariables);

        String  type = responseEntity.getBody();
        entity = JsonUtils.toSimpleObject(type, CustomerIndustryTypeEntity.class);
		}
		return entity;
	}
	
	@RequiresPermissions("it:customerIndustryType:view")
	@RequestMapping(value = {"list", ""})
	public String list(CustomerIndustryTypeEntity customerIndustryType, HttpServletRequest request, HttpServletResponse response, Model model) {

    Page<CustomerIndustryTypeEntity> page = new Page<>(request, response);
    CustomerIndustryType type = JsonUtils
        .toSimpleObject(JsonUtils.toJson(customerIndustryType), CustomerIndustryType.class);


    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("pageNum", page.getPageNo());
    urlVariables.put("pageSize", page.getPageSize());

    String apiBaseUrl = moduleLinkConfiguration.getLink("customer");
    ResponseEntity<String> pageResponseEntity = restTemplate
        .postForEntity(
            apiBaseUrl + "/it/customerIndustryType/api/list?pageNum={pageNum}&&pageSize={pageSize}",
            type, String.class, urlVariables);

    PageInfo<CustomerIndustryTypeEntity> customerIndustryTypePageInfo = JsonUtils
        .fromJson(pageResponseEntity.getBody(), PageInfo.class, CustomerIndustryTypeEntity.class);


    page.setCount(customerIndustryTypePageInfo.getTotal());
    page.setPageNo(customerIndustryTypePageInfo.getPageNum());
    page.setList(customerIndustryTypePageInfo.getList());
    model.addAttribute("page", page);
    model.addAttribute("customerIndustryType", customerIndustryType);


		return "modules/customer/it/customerIndustryTypeList";
	}

	@RequiresPermissions("it:customerIndustryType:view")
	@RequestMapping(value = "form")
	public String form(CustomerIndustryTypeEntity customerIndustryType, Model model) {
		model.addAttribute("customerIndustryType", customerIndustryType);
		return "modules/customer/it/customerIndustryTypeForm";
	}

	@RequiresPermissions("it:customerIndustryType:edit")
	@RequestMapping(value = "save")
	public String save(CustomerIndustryTypeEntity customerIndustryType, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, customerIndustryType)){
			return form(customerIndustryType, model);
		}

    CustomerIndustryType type =resolveBeanProperties(StringUtils.isEmpty(customerIndustryType.getId()),customerIndustryType);
    String apiBaseUrl = moduleLinkConfiguration.getLink("customer");

	 	restTemplate.postForObject(apiBaseUrl+"/it/customerIndustryType/api/save",type,String.class);
		addMessage(redirectAttributes, "保存污染行业类型成功");

		return "redirect:"+Global.getAdminPath()+"/customer/it/?repage";
	}
	
	@RequiresPermissions("it:customerIndustryType:edit")
	@RequestMapping(value = "delete")
	public String delete(CustomerIndustryTypeEntity customerIndustryType, RedirectAttributes redirectAttributes) {

    String apiBaseUrl = moduleLinkConfiguration.getLink("customer");

  	CustomerIndustryType type = new CustomerIndustryType();
    BeanUtils.copyProperties(customerIndustryType, type);
		restTemplate.postForEntity(apiBaseUrl+"/it/customerIndustryType/api/delete",type,String.class);

		addMessage(redirectAttributes, "删除污染行业类型成功");
		return "redirect:"+Global.getAdminPath()+"/customer/it/?repage";
	}

	/**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private CustomerIndustryType resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    CustomerIndustryType customerIndustryType = JsonUtils
        .toSimpleObject(JsonUtils.toJson(source),  CustomerIndustryType.class);
    Date now = new Date();
    if (isNewRecord) {
      customerIndustryType.setInsertTime(now);
      customerIndustryType.setInsertBy(user.getName());
    }
    customerIndustryType.setUpdateBy(user.getName());
    customerIndustryType.setUpdateTime(now);
    return customerIndustryType;
  }

}