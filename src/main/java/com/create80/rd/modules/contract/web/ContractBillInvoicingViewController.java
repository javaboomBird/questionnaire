/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.contract.web;

import com.create80.rd.common.config.Global;
import com.create80.rd.common.persistence.Page;
import com.create80.rd.common.utils.DateUtils;
import com.create80.rd.common.utils.JsonUtils;
import com.create80.rd.common.utils.StringUtils;
import com.create80.rd.common.utils.page.PageInfo;
import com.create80.rd.common.web.BaseController;
import com.create80.rd.modules.contract.api.model.ContractBillInvoicing;
import com.create80.rd.modules.contract.entity.ContractBillInvoicingEntity;
import com.create80.rd.modules.sys.entity.User;
import com.create80.rd.modules.sys.utils.UserUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 合同开票管理Controller
 *
 * @author lzp
 * @version 2018-05-23
 */
@Controller
@RequestMapping(value = "${adminPath}/contract/contractBillInvoicing")
public class ContractBillInvoicingViewController extends BaseController {

  @Autowired
  private RestTemplate restTemplate;

  @ModelAttribute
  public ContractBillInvoicingEntity get(@RequestParam(required = false) String id) {

    ContractBillInvoicingEntity entity = new ContractBillInvoicingEntity();
    if (StringUtils.isNotBlank(id)) {
      String apiBaseUrl = moduleLinkConfiguration.getLink("contract");
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("id", id);
      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/contract/contractBillInvoicing/api/{id}", String.class,
              urlVariables);

      return JsonUtils.toSimpleObject(responseEntity.getBody(), ContractBillInvoicingEntity.class);
    }
    return entity;
  }

  @RequiresPermissions("contract:contractBillInvoicing:view")
  @RequestMapping(value = {"list", ""})
  public String list(ContractBillInvoicingEntity contractBillInvoicing, HttpServletRequest request,
      HttpServletResponse response, Model model) {

    Page<ContractBillInvoicing> page = new Page<>(request, response);
    ContractBillInvoicing type = JsonUtils
        .toSimpleObject(JsonUtils.toJson(contractBillInvoicing), ContractBillInvoicing.class);

    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("pageNum", page.getPageNo());
    urlVariables.put("pageSize", page.getPageSize());

    String apiBaseUrl = moduleLinkConfiguration.getLink("contract");
    ResponseEntity<String> pageResponseEntity = restTemplate
        .postForEntity(
            apiBaseUrl
                + "/contract/contractBillInvoicing/api/list?pageNum={pageNum}&&pageSize={pageSize}",
            type, String.class, urlVariables);

    PageInfo<ContractBillInvoicing> contractBillInvoicingPageInfo = JsonUtils
        .fromJson(pageResponseEntity.getBody(), PageInfo.class, ContractBillInvoicing.class);

    page.setCount(contractBillInvoicingPageInfo.getTotal());
    page.setPageNo(contractBillInvoicingPageInfo.getPageNum());
    page.setList(contractBillInvoicingPageInfo.getList());
    model.addAttribute("page", page);
    model.addAttribute("contractBillInvoicing", contractBillInvoicing);

    return "modules/contract/contractBillInvoicingList";
  }

  @RequiresPermissions("contract:contractBillInvoicing:view")
  @RequestMapping(value = "form")
  public String form(ContractBillInvoicingEntity contractBillInvoicing, Model model) {
    model.addAttribute("contractBillInvoicing", contractBillInvoicing);
    return "modules/contract/contractBillInvoicingForm";
  }

  @RequiresPermissions("contract:contractBillInvoicing:edit")
  @RequestMapping(value = "save")
  public String save(ContractBillInvoicingEntity contractBillInvoicing, Model model,
      RedirectAttributes redirectAttributes) {
    if (!beanValidator(model, contractBillInvoicing)) {
      return form(contractBillInvoicing, model);
    }

    ContractBillInvoicing type = resolveBeanProperties(
        StringUtils.isEmpty(contractBillInvoicing.getId()), contractBillInvoicing);
    String apiBaseUrl = moduleLinkConfiguration.getLink("contract");

    restTemplate
        .postForObject(apiBaseUrl + "/contract/contractBillInvoicing/api/save", type, String.class);
    addMessage(redirectAttributes, "保存合同开票成功");

    return "redirect:" + Global.getAdminPath() + "/contract/contractBillInvoicing/?repage";
  }

  @RequiresPermissions("contract:contractBillInvoicing:edit")
  @RequestMapping(value = "delete")
  public String delete(ContractBillInvoicingEntity contractBillInvoicing,
      RedirectAttributes redirectAttributes) {

    String apiBaseUrl = moduleLinkConfiguration.getLink("contract");

    ContractBillInvoicing type = new ContractBillInvoicing();
    BeanUtils.copyProperties(contractBillInvoicing, type);
    restTemplate.postForEntity(apiBaseUrl + "/contract/contractBillInvoicing/api/delete", type,
        String.class);

    addMessage(redirectAttributes, "删除合同开票成功");
    return "redirect:" + Global.getAdminPath() + "/contract/contractBillInvoicing/?repage";
  }

  /**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private ContractBillInvoicing resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    ContractBillInvoicing contractBillInvoicing = JsonUtils
        .toSimpleObject(JsonUtils.toJson(source), ContractBillInvoicing.class);
    Date now = DateUtils.getNow();
    if (isNewRecord) {
      contractBillInvoicing.setCreateDate(now);
      contractBillInvoicing.setCreateBy(user.getName());
    }
    contractBillInvoicing.setUpdateBy(user.getName());
    contractBillInvoicing.setUpdateDate(now);
    return contractBillInvoicing;
  }

}