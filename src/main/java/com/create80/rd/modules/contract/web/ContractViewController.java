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

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

import com.create80.rd.modules.contract.entity.ContractEntity;
import com.create80.rd.modules.contract.api.model.Contract;


/**
 * 合同管理Controller
 * @author lzp
 * @version 2018-06-12
 */
@Controller
@RequestMapping(value = "${adminPath}/contract/contract")
public class ContractViewController extends BaseController {

	@Autowired
  private RestTemplate restTemplate;

	
	@ModelAttribute
	public ContractEntity get(@RequestParam(required=false) String id) {

		ContractEntity entity = new ContractEntity();
    if (StringUtils.isNotBlank(id)) {
      String apiBaseUrl = moduleLinkConfiguration.getLink("contract");
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("id", id);
      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/contract/contract/api/{id}", String.class,
              urlVariables);

      entity= JsonUtils.toSimpleObject(responseEntity.getBody(), ContractEntity.class);

    }
    return entity;
	}
	
	@RequiresPermissions("contract:contract:view")
	@RequestMapping(value = {"list", ""})
	public String list(ContractEntity contract, HttpServletRequest request, HttpServletResponse response, Model model) {

     Page<ContractEntity> page = new Page<>(request, response);
    Contract type = JsonUtils
        .toSimpleObject(JsonUtils.toJson(contract), Contract.class);


    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("pageNum", page.getPageNo());
    urlVariables.put("pageSize", page.getPageSize());

    String apiBaseUrl = moduleLinkConfiguration.getLink("contract");
    ResponseEntity<String> pageResponseEntity = restTemplate
        .postForEntity(
            apiBaseUrl + "/contract/contract/api/list?pageNum={pageNum}&&pageSize={pageSize}",
            type, String.class, urlVariables);

    PageInfo<ContractEntity> contractPageInfo = JsonUtils
        .fromJson(pageResponseEntity.getBody(), PageInfo.class, ContractEntity.class);


    page.setCount(contractPageInfo.getTotal());
    page.setPageNo(contractPageInfo.getPageNum());
    page.setList(contractPageInfo.getList());
    model.addAttribute("page", page);
    model.addAttribute("contract", contract);

		return "modules/contract/contractList";
	}

	@RequiresPermissions("contract:contract:view")
	@RequestMapping(value = "form")
	public String form(ContractEntity contract, Model model) {
		model.addAttribute("contract", contract);
		return "modules/contract/contractForm";
	}

    @RequestMapping(value = "formView")
    public String formView(ContractEntity contract, Model model) {
        model.addAttribute("contract", contract);
        return "modules/contract/contractFormView";
    }


    @RequiresPermissions("contract:contract:edit")
	@RequestMapping(value = "save")
	public String save(ContractEntity contract, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, contract)){
			return form(contract, model);
		}

	  Contract type = resolveBeanProperties(StringUtils.isEmpty(contract.getId()), contract);
    String apiBaseUrl = moduleLinkConfiguration.getLink("contract");

	 	restTemplate.postForObject(apiBaseUrl+"/contract/contract/api/save",type,String.class);
		addMessage(redirectAttributes, "保存合同成功");

		return "redirect:"+Global.getAdminPath()+"/contract/contract/?repage";
	}

  /**
   * 通过甲方ID获取合同列表信息
   *
   * @param firstParty 项目ID
   */
  @RequestMapping(value = "getAll", method = RequestMethod.GET)
  @ResponseBody
  public List<Contract> getAllProjectTaskList(@Param(value = "firstParty") String firstParty) {

    String apiBaseUrl = moduleLinkConfiguration.getLink("contract");
    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("firstParty", firstParty);

    ResponseEntity<String> responseEntity = restTemplate
        .getForEntity(apiBaseUrl + "/contract/contract/api/getAll?firstParty={firstParty}",
            String.class, urlVariables);

    return JsonUtils.toListObject(responseEntity.getBody(), Contract.class);
  }
	
	@RequiresPermissions("contract:contract:edit")
	@RequestMapping(value = "delete")
	public String delete(ContractEntity contract, RedirectAttributes redirectAttributes) {

    String apiBaseUrl = moduleLinkConfiguration.getLink("contract");

  	Contract type = new Contract();
    BeanUtils.copyProperties(contract, type);
		restTemplate.postForEntity(apiBaseUrl+"/contract/contract/api/delete",type,String.class);

		addMessage(redirectAttributes, "删除合同成功");
		return "redirect:"+Global.getAdminPath()+"/contract/contract/?repage";
	}

	 /**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private Contract resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    Contract contract = JsonUtils.toSimpleObject(JsonUtils.toJson(source), Contract.class);
    Date now = DateUtils.getNow();
     if (isNewRecord) {
      contract.setInsertTime(now);
      contract.setInsertBy(user.getName());
    }
    contract.setUpdateBy(user.getName());
    contract.setUpdateTime(now);
    return contract;
  }

}