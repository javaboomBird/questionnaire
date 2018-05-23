/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.customer.eiareport.web;

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

import com.create80.rd.modules.sys.entity.User;
import com.create80.rd.modules.sys.utils.UserUtils;
import com.create80.rd.common.config.Global;
import com.create80.rd.common.persistence.Page;
import com.create80.rd.common.web.BaseController;
import com.create80.rd.common.utils.StringUtils;
import com.create80.rd.common.utils.JsonUtils;
import com.create80.rd.common.utils.DateUtils;
import com.create80.rd.common.utils.page.PageInfo;

import com.create80.rd.modules.customer.eiareport.entity.EiaReportEntity;
import com.create80.rd.modules.customer.eiareport.api.model.EiaReport;

/**
 * 环评报告信息管理Controller
 * @author yzx
 * @version 2018-05-22
 */
@Controller
@RequestMapping(value = "${adminPath}/eiareport/eiaReport")
public class EiaReportViewController extends BaseController {

	@Autowired
  private RestTemplate restTemplate;

	@ModelAttribute
	public EiaReportEntity get(@RequestParam(required=false) String id) {

		EiaReportEntity entity = new EiaReportEntity();
    if (StringUtils.isNotBlank(id)) {
      String apiBaseUrl = moduleLinkConfiguration.getLink("customer");
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("id", id);
      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/eiareport/eiaReport/api/{id}", String.class,
              urlVariables);

      return JsonUtils.toSimpleObject(responseEntity.getBody(), EiaReportEntity.class);
    }
    return entity;
	}

	@RequiresPermissions("eiareport:eiaReport:view")
	@RequestMapping(value = {"list", ""})
	public String list(EiaReportEntity eiaReport, HttpServletRequest request, HttpServletResponse response, Model model) {

     Page<EiaReport> page = new Page<>(request, response);
    EiaReport type = JsonUtils
        .toSimpleObject(JsonUtils.toJson(eiaReport), EiaReport.class);


    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("pageNum", page.getPageNo());
    urlVariables.put("pageSize", page.getPageSize());

    String apiBaseUrl = moduleLinkConfiguration.getLink("customer");
    ResponseEntity<String> pageResponseEntity = restTemplate
        .postForEntity(
            apiBaseUrl + "/eiareport/eiaReport/api/list?pageNum={pageNum}&&pageSize={pageSize}",
            type, String.class, urlVariables);

    PageInfo<EiaReport> eiaReportPageInfo = JsonUtils
        .fromJson(pageResponseEntity.getBody(), PageInfo.class, EiaReport.class);


    page.setCount(eiaReportPageInfo.getTotal());
    page.setPageNo(eiaReportPageInfo.getPageNum());
    page.setList(eiaReportPageInfo.getList());
    model.addAttribute("page", page);
    model.addAttribute("eiaReport", eiaReport);

		return "customer/eiareport/eiaReportList";
	}

	@RequiresPermissions("eiareport:eiaReport:view")
	@RequestMapping(value = "form")
	public String form(EiaReportEntity eiaReport, Model model) {
		model.addAttribute("eiaReport", eiaReport);
		return "customer/eiareport/eiaReportForm";
	}

	@RequiresPermissions("eiareport:eiaReport:edit")
	@RequestMapping(value = "save")
	public String save(EiaReportEntity eiaReport, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, eiaReport)){
			return form(eiaReport, model);
		}

	  EiaReport type = resolveBeanProperties(StringUtils.isEmpty(eiaReport.getId()), eiaReport);
    String apiBaseUrl = moduleLinkConfiguration.getLink("customer");

	 	restTemplate.postForObject(apiBaseUrl+"/eiareport/eiaReport/api/save",type,String.class);
		addMessage(redirectAttributes, "保存环评报告信息管理成功");

		return "redirect:"+Global.getAdminPath()+"/eiareport/eiaReport/?repage";
	}

	@RequiresPermissions("eiareport:eiaReport:edit")
	@RequestMapping(value = "delete")
	public String delete(EiaReportEntity eiaReport, RedirectAttributes redirectAttributes) {

    String apiBaseUrl = moduleLinkConfiguration.getLink("customer");

  	EiaReport type = new EiaReport();
    BeanUtils.copyProperties(eiaReport, type);
		restTemplate.postForEntity(apiBaseUrl+"/eiareport/eiaReport/api/delete",type,String.class);

		addMessage(redirectAttributes, "删除环评报告信息管理成功");
		return "redirect:"+Global.getAdminPath()+"/eiareport/eiaReport/?repage";
	}

	 /**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private EiaReport resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    EiaReport eiaReport = JsonUtils.toSimpleObject(JsonUtils.toJson(source), EiaReport.class);
    Date now = DateUtils.getNow();
     if (isNewRecord) {
      eiaReport.setCreateDate(now);
      eiaReport.setCreateBy(user.getName());
    }
    eiaReport.setUpdateBy(user.getName());
    eiaReport.setUpdateDate(now);
    return eiaReport;
  }

}