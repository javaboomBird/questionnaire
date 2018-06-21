/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.contract.web;

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

import com.create80.rd.modules.contract.entity.ContractAccountsReceivableEntity;
import com.create80.rd.modules.contract.api.model.ContractAccountsReceivable;


/**
 * 合同收款管理Controller
 * @author lzp
 * @version 2018-05-31
 */
@Controller
@RequestMapping(value = "${adminPath}/contract/contractAccountsReceivable")
public class ContractAccountsReceivableViewController extends BaseController {

	@Autowired
  private RestTemplate restTemplate;

	
	@ModelAttribute
	public ContractAccountsReceivableEntity get(@RequestParam(required=false) String id) {

		ContractAccountsReceivableEntity entity = new ContractAccountsReceivableEntity();
    if (StringUtils.isNotBlank(id)) {
      String apiBaseUrl = moduleLinkConfiguration.getLink("contract");
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("id", id);
      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/contract/contractAccountsReceivable/api/{id}", String.class,
              urlVariables);

      entity= JsonUtils.toSimpleObject(responseEntity.getBody(), ContractAccountsReceivableEntity.class);

    }
    return entity;
	}
	
	@RequiresPermissions("contract:contractAccountsReceivable:view")
	@RequestMapping(value = {"list", ""})
	public String list(ContractAccountsReceivableEntity contractAccountsReceivable, HttpServletRequest request, HttpServletResponse response, Model model) {

     Page<ContractAccountsReceivable> page = new Page<>(request, response);
    ContractAccountsReceivable type = JsonUtils
        .toSimpleObject(JsonUtils.toJson(contractAccountsReceivable), ContractAccountsReceivable.class);


    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("pageNum", page.getPageNo());
    urlVariables.put("pageSize", page.getPageSize());

    String apiBaseUrl = moduleLinkConfiguration.getLink("contract");
    ResponseEntity<String> pageResponseEntity = restTemplate
        .postForEntity(
            apiBaseUrl + "/contract/contractAccountsReceivable/api/list?pageNum={pageNum}&&pageSize={pageSize}",
            type, String.class, urlVariables);

    PageInfo<ContractAccountsReceivable> contractAccountsReceivablePageInfo = JsonUtils
        .fromJson(pageResponseEntity.getBody(), PageInfo.class, ContractAccountsReceivable.class);


    page.setCount(contractAccountsReceivablePageInfo.getTotal());
    page.setPageNo(contractAccountsReceivablePageInfo.getPageNum());
    page.setList(contractAccountsReceivablePageInfo.getList());
    model.addAttribute("page", page);
    model.addAttribute("contractAccountsReceivable", contractAccountsReceivable);

		return "modules/contract/contractAccountsReceivableList";
	}

	@RequiresPermissions("contract:contractAccountsReceivable:view")
	@RequestMapping(value = "form")
	public String form(ContractAccountsReceivableEntity contractAccountsReceivable, Model model) {
		model.addAttribute("contractAccountsReceivable", contractAccountsReceivable);
		return "modules/contract/contractAccountsReceivableForm";
	}

	@RequiresPermissions("contract:contractAccountsReceivable:edit")
	@RequestMapping(value = "save")
	public String save(ContractAccountsReceivableEntity contractAccountsReceivable, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, contractAccountsReceivable)){
			return form(contractAccountsReceivable, model);
		}

	  ContractAccountsReceivable type = resolveBeanProperties(StringUtils.isEmpty(contractAccountsReceivable.getId()), contractAccountsReceivable);
    String apiBaseUrl = moduleLinkConfiguration.getLink("contract");

	 	restTemplate.postForObject(apiBaseUrl+"/contract/contractAccountsReceivable/api/save",type,String.class);
		addMessage(redirectAttributes, "保存合同收款成功");

		return "redirect:"+Global.getAdminPath()+"/contract/contractAccountsReceivable/?repage";
	}
	
	@RequiresPermissions("contract:contractAccountsReceivable:edit")
	@RequestMapping(value = "delete")
	public String delete(ContractAccountsReceivableEntity contractAccountsReceivable, RedirectAttributes redirectAttributes) {

    String apiBaseUrl = moduleLinkConfiguration.getLink("contract");

  	ContractAccountsReceivable type = new ContractAccountsReceivable();
    BeanUtils.copyProperties(contractAccountsReceivable, type);
		restTemplate.postForEntity(apiBaseUrl+"/contract/contractAccountsReceivable/api/delete",type,String.class);

		addMessage(redirectAttributes, "删除合同收款成功");
		return "redirect:"+Global.getAdminPath()+"/contract/contractAccountsReceivable/?repage";
	}

	 /**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private ContractAccountsReceivable resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    ContractAccountsReceivable contractAccountsReceivable = JsonUtils.toSimpleObject(JsonUtils.toJson(source), ContractAccountsReceivable.class);
    Date now = DateUtils.getNow();
     if (isNewRecord) {
      contractAccountsReceivable.setInsertTime(now);
      contractAccountsReceivable.setInsertBy(user.getName());
    }
    contractAccountsReceivable.setUpdateBy(user.getName());
    contractAccountsReceivable.setUpdateTime(now);
    return contractAccountsReceivable;
  }

}