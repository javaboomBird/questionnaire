/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.customer.it.web;

import com.create80.rd.modules.customer.it.entity.IndustryTypeEntity;
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
import com.create80.rd.modules.customer.it.entity.IndustryTypeEntity;
import com.create80.rd.modules.customer.it.api.model.IndustryType;

/**
 * 污染行业类型Controller
 * @author yzx
 * @version 2018-05-21
 */
@Controller
@RequestMapping(value = "${adminPath}/it/industryType")
public class IndustryTypeViewController extends BaseController {

	@Autowired
  private RestTemplate restTemplate;
	
	@ModelAttribute
	public IndustryTypeEntity get(@RequestParam(required=false) String id) {

		IndustryTypeEntity entity = new IndustryTypeEntity();
		if (StringUtils.isNotBlank(id)){
	  	String apiBaseUrl = modelLinkConfiguration.getLink("it");
		   Map<String, Object> urlVariables = new HashMap<>();
		   urlVariables.put("id",id);
		   ResponseEntity<String> responseEntity = restTemplate
		                      .getForEntity(apiBaseUrl + "/it/industryType/api/{id}", String.class, urlVariables);

        String  type = responseEntity.getBody();
        entity = JsonUtils.toSimpleObject(type, IndustryTypeEntity.class);
		}
		return entity;
	}
	
	@RequiresPermissions("it:industryType:view")
	@RequestMapping(value = {"list", ""})
	public String list(IndustryTypeEntity industryType, HttpServletRequest request, HttpServletResponse response, Model model) {

    Page<IndustryType> page = new Page<>(request, response);
    IndustryType type = JsonUtils
        .toSimpleObject(JsonUtils.toJson(industryType), IndustryType.class);


    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("pageNum", page.getPageNo());
    urlVariables.put("pageSize", page.getPageSize());

    String apiBaseUrl = modelLinkConfiguration.getLink("it");
    ResponseEntity<String> pageResponseEntity = restTemplate
        .postForEntity(
            apiBaseUrl + "/it/industryType/api/list?pageNum={pageNum}&&pageSize={pageSize}",
            type, String.class, urlVariables);

    PageInfo<IndustryType> industryTypePageInfo = JsonUtils
        .fromJson(pageResponseEntity.getBody(), PageInfo.class, IndustryType.class);


    page.setCount(industryTypePageInfo.getTotal());
    page.setPageNo(industryTypePageInfo.getPageNum());
    page.setList(industryTypePageInfo.getList());
    model.addAttribute("page", page);
    model.addAttribute("industryType", industryType);


		return "customer/it/industryTypeList";
	}

	@RequiresPermissions("it:industryType:view")
	@RequestMapping(value = "form")
	public String form(IndustryTypeEntity industryType, Model model) {
		model.addAttribute("industryType", industryType);
		return "customer/it/industryTypeForm";
	}

	@RequiresPermissions("it:industryType:edit")
	@RequestMapping(value = "save")
	public String save(IndustryTypeEntity industryType, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, industryType)){
			return form(industryType, model);
		}

    IndustryType type =resolveBeanProperties(StringUtils.isEmpty(industryType.getId()),industryType);
    String apiBaseUrl = modelLinkConfiguration.getLink("it");

	 	restTemplate.postForObject(apiBaseUrl+"/it/industryType/api/save",type,String.class);
		addMessage(redirectAttributes, "保存污染行业类型成功");

		return "redirect:"+Global.getAdminPath()+"/it/industryType/?repage";
	}
	
	@RequiresPermissions("it:industryType:edit")
	@RequestMapping(value = "delete")
	public String delete(IndustryTypeEntity industryType, RedirectAttributes redirectAttributes) {

    String apiBaseUrl = modelLinkConfiguration.getLink("it");

  	IndustryType type = new IndustryType();
    BeanUtils.copyProperties(industryType, type);
		restTemplate.postForEntity(apiBaseUrl+"/it/industryType/api/delete",type,String.class);

		addMessage(redirectAttributes, "删除污染行业类型成功");
		return "redirect:"+Global.getAdminPath()+"/it/industryType/?repage";
	}

	/**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private IndustryType resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    IndustryType industryType = JsonUtils
        .toSimpleObject(JsonUtils.toJson(source),  IndustryType.class);
    Date now = new Date();
    if (isNewRecord) {
      industryType.setCreateDate(now);
      industryType.setCreateBy(user.getName());
    }
    industryType.setUpdateBy(user.getName());
    industryType.setUpdateDate(now);
    return industryType;
  }

}