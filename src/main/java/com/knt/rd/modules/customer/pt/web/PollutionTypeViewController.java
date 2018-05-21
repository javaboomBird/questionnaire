/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.knt.rd.modules.customer.pt.web;

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

import com.knt.rd.common.utils.JsonUtils;
import com.knt.rd.modules.sys.entity.User;
import com.knt.rd.modules.sys.utils.UserUtils;
import com.knt.rd.common.config.Global;
import com.knt.rd.common.persistence.Page;
import com.knt.rd.common.web.BaseController;
import com.knt.rd.common.utils.StringUtils;
import com.knt.rd.common.utils.page.PageInfo;
import com.knt.rd.modules.customer.pt.entity.PollutionTypeEntity;
import com.knt.rd.modules.customer.pt.api.model.PollutionType;

/**
 * 排污类型管理Controller
 *
 * @author yzx
 * @version 2018-05-21
 */
@Controller
@RequestMapping(value = "${adminPath}/pt/pollutionType")
public class PollutionTypeViewController extends BaseController {

  @Autowired
  private RestTemplate restTemplate;

  @ModelAttribute
  public PollutionTypeEntity get(@RequestParam(required = false) String id) {

    PollutionTypeEntity entity = new PollutionTypeEntity();
    if (StringUtils.isNotBlank(id)) {
      String apiBaseUrl = modelLinkConfiguration.getLink("pt");
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("id", id);
      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/pt/pollutionType/api/{id}", String.class, urlVariables);

      String type = responseEntity.getBody();
      entity = JsonUtils.toSimpleObject(type, PollutionTypeEntity.class);
    }
    return entity;
  }

  @RequiresPermissions("pt:pollutionType:view")
  @RequestMapping(value = {"list", ""})
  public String list(PollutionTypeEntity pollutionType, HttpServletRequest request,
      HttpServletResponse response, Model model) {

    Page<PollutionType> page = new Page<>(request, response);
    PollutionType type = JsonUtils
        .toSimpleObject(JsonUtils.toJson(pollutionType), PollutionType.class);

    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("pageNum", page.getPageNo());
    urlVariables.put("pageSize", page.getPageSize());

    String apiBaseUrl = modelLinkConfiguration.getLink("it");
    ResponseEntity<String> pageResponseEntity = restTemplate
        .postForEntity(
            apiBaseUrl + "/pt/pollutionType/api/list?pageNum={pageNum}&&pageSize={pageSize}",
            type, String.class, urlVariables);

    PageInfo<PollutionType> pollutionTypePageInfo = JsonUtils
        .fromJson(pageResponseEntity.getBody(), PageInfo.class, PollutionType.class);

    page.setCount(pollutionTypePageInfo.getTotal());
    page.setPageNo(pollutionTypePageInfo.getPageNum());
    page.setList(pollutionTypePageInfo.getList());
    model.addAttribute("page", page);
    model.addAttribute("pollutionType", pollutionType);

    return "customer/pt/pollutionTypeList";
  }

  @RequiresPermissions("pt:pollutionType:view")
  @RequestMapping(value = "form")
  public String form(PollutionTypeEntity pollutionType, Model model) {
    model.addAttribute("pollutionType", pollutionType);
    return "customer/pt/pollutionTypeForm";
  }

  @RequiresPermissions("pt:pollutionType:edit")
  @RequestMapping(value = "save")
  public String save(PollutionTypeEntity pollutionType, Model model,
      RedirectAttributes redirectAttributes) {
    if (!beanValidator(model, pollutionType)) {
      return form(pollutionType, model);
    }

    PollutionType type = resolveBeanProperties(StringUtils.isEmpty(pollutionType.getId()),
        pollutionType);
    String apiBaseUrl = modelLinkConfiguration.getLink("pt");

    restTemplate.postForObject(apiBaseUrl + "/pt/pollutionType/api/save", type, String.class);
    addMessage(redirectAttributes, "保存排污类型管理成功");

    return "redirect:" + Global.getAdminPath() + "/pt/pollutionType/?repage";
  }

  @RequiresPermissions("pt:pollutionType:edit")
  @RequestMapping(value = "delete")
  public String delete(PollutionTypeEntity pollutionType, RedirectAttributes redirectAttributes) {

    String apiBaseUrl = modelLinkConfiguration.getLink("pt");

    PollutionType type = new PollutionType();
    BeanUtils.copyProperties(pollutionType, type);
    restTemplate.postForEntity(apiBaseUrl + "/pt/pollutionType/api/delete", type, String.class);

    addMessage(redirectAttributes, "删除排污类型管理成功");
    return "redirect:" + Global.getAdminPath() + "/pt/pollutionType/?repage";
  }

  /**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private PollutionType resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    PollutionType pollutionType = JsonUtils
        .toSimpleObject(JsonUtils.toJson(source), PollutionType.class);
    Date now = new Date();
    if (isNewRecord) {
      pollutionType.setCreateDate(now);
      pollutionType.setCreateBy(user.getName());
    }
    pollutionType.setUpdateBy(user.getName());
    pollutionType.setUpdateDate(now);
    return pollutionType;
  }

}