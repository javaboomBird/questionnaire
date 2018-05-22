/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.customer.bt.web;

import com.create80.rd.modules.customer.bt.entity.BusinessTypeEntity;
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
import com.create80.rd.modules.customer.bt.entity.BusinessTypeEntity;
import com.create80.rd.modules.customer.bt.api.model.BusinessType;

/**
 * 工商行业类型Controller
 * @author yzx
 * @version 2018-05-21
 */
@Controller
@RequestMapping(value = "${adminPath}/bt/businessType")
public class BusinessTypeViewController extends BaseController {

	@Autowired
  private RestTemplate restTemplate;
	
	@ModelAttribute
	public BusinessTypeEntity get(@RequestParam(required=false) String id) {

		BusinessTypeEntity entity = new BusinessTypeEntity();
		if (StringUtils.isNotBlank(id)){
	  	String apiBaseUrl = modelLinkConfiguration.getLink("bt");
		   Map<String, Object> urlVariables = new HashMap<>();
		   urlVariables.put("id",id);
		   ResponseEntity<String> responseEntity = restTemplate
		                      .getForEntity(apiBaseUrl + "/bt/businessType/api/{id}", String.class, urlVariables);

        String  type = responseEntity.getBody();
        entity = JsonUtils.toSimpleObject(type, BusinessTypeEntity.class);
		}
		return entity;
	}
	
	@RequiresPermissions("bt:businessType:view")
	@RequestMapping(value = {"list", ""})
	public String list(BusinessTypeEntity businessType, HttpServletRequest request, HttpServletResponse response, Model model) {

    Page<BusinessType> page = new Page<>(request, response);
    BusinessType type = JsonUtils
        .toSimpleObject(JsonUtils.toJson(businessType), BusinessType.class);


    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("pageNum", page.getPageNo());
    urlVariables.put("pageSize", page.getPageSize());

    String apiBaseUrl = modelLinkConfiguration.getLink("it");
    ResponseEntity<String> pageResponseEntity = restTemplate
        .postForEntity(
            apiBaseUrl + "/bt/businessType/api/list?pageNum={pageNum}&&pageSize={pageSize}",
            type, String.class, urlVariables);

    PageInfo<BusinessType> businessTypePageInfo = JsonUtils
        .fromJson(pageResponseEntity.getBody(), PageInfo.class, BusinessType.class);


    page.setCount(businessTypePageInfo.getTotal());
    page.setPageNo(businessTypePageInfo.getPageNum());
    page.setList(businessTypePageInfo.getList());
    model.addAttribute("page", page);
    model.addAttribute("businessType", businessType);


		return "customer/bt/businessTypeList";
	}

	@RequiresPermissions("bt:businessType:view")
	@RequestMapping(value = "form")
	public String form(BusinessTypeEntity businessType, Model model) {
		model.addAttribute("businessType", businessType);
		return "customer/bt/businessTypeForm";
	}

	@RequiresPermissions("bt:businessType:edit")
	@RequestMapping(value = "save")
	public String save(BusinessTypeEntity businessType, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, businessType)){
			return form(businessType, model);
		}

    BusinessType type =resolveBeanProperties(StringUtils.isEmpty(businessType.getId()),businessType);
    String apiBaseUrl = modelLinkConfiguration.getLink("bt");

	 	restTemplate.postForObject(apiBaseUrl+"/bt/businessType/api/save",type,String.class);
		addMessage(redirectAttributes, "保存工商行业类型成功");

		return "redirect:"+Global.getAdminPath()+"/bt/businessType/?repage";
	}
	
	@RequiresPermissions("bt:businessType:edit")
	@RequestMapping(value = "delete")
	public String delete(BusinessTypeEntity businessType, RedirectAttributes redirectAttributes) {

    String apiBaseUrl = modelLinkConfiguration.getLink("bt");

  	BusinessType type = new BusinessType();
    BeanUtils.copyProperties(businessType, type);
		restTemplate.postForEntity(apiBaseUrl+"/bt/businessType/api/delete",type,String.class);

		addMessage(redirectAttributes, "删除工商行业类型成功");
		return "redirect:"+Global.getAdminPath()+"/bt/businessType/?repage";
	}

	/**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private BusinessType resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    BusinessType businessType = JsonUtils
        .toSimpleObject(JsonUtils.toJson(source),  BusinessType.class);
    Date now = new Date();
    if (isNewRecord) {
      businessType.setCreateDate(now);
      businessType.setCreateBy(user.getName());
    }
    businessType.setUpdateBy(user.getName());
    businessType.setUpdateDate(now);
    return businessType;
  }

}