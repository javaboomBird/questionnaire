/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.customer.government.web;

import com.create80.rd.modules.customer.government.entity.GovernmentEntity;
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

import com.create80.rd.modules.sys.entity.User;
import com.create80.rd.modules.sys.utils.UserUtils;
import com.create80.rd.common.config.Global;
import com.create80.rd.common.persistence.Page;
import com.create80.rd.common.web.BaseController;
import com.create80.rd.common.utils.StringUtils;
import com.create80.rd.common.utils.JsonUtils;
import com.create80.rd.common.utils.DateUtils;
import com.create80.rd.common.utils.page.PageInfo;

import com.create80.rd.modules.customer.government.api.model.Government;

/**
 * 政府信息管理Controller
 *
 * @author yzx
 * @version 2018-05-21
 */
@Controller
@RequestMapping(value = "${adminPath}/government/government")
public class GovernmentViewController extends BaseController {

  @Autowired
  private RestTemplate restTemplate;

  @ModelAttribute
  public GovernmentEntity get(@RequestParam(required = false) String id) {

    GovernmentEntity entity = new GovernmentEntity();
    if (StringUtils.isNotBlank(id)) {
      String apiBaseUrl = moduleLinkConfiguration.getLink("customer");
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("id", id);
      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/government/government/api/{id}", String.class,
              urlVariables);

      return JsonUtils.toSimpleObject(responseEntity.getBody(), GovernmentEntity.class);
    }
    return entity;
  }

  @RequiresPermissions("government:government:view")
  @RequestMapping(value = {"list", ""})
  public String list(GovernmentEntity government, HttpServletRequest request,
      HttpServletResponse response, Model model) {

    Page<Government> page = new Page<>(request, response);
    Government type = JsonUtils
        .toSimpleObject(JsonUtils.toJson(government), Government.class);

    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("pageNum", page.getPageNo());
    urlVariables.put("pageSize", page.getPageSize());

    String apiBaseUrl = moduleLinkConfiguration.getLink("customer");
    ResponseEntity<String> pageResponseEntity = restTemplate
        .postForEntity(
            apiBaseUrl + "/government/government/api/list?pageNum={pageNum}&&pageSize={pageSize}",
            type, String.class, urlVariables);

    PageInfo<Government> governmentPageInfo = JsonUtils
        .fromJson(pageResponseEntity.getBody(), PageInfo.class, Government.class);

    page.setCount(governmentPageInfo.getTotal());
    page.setPageNo(governmentPageInfo.getPageNum());
    page.setList(governmentPageInfo.getList());
    model.addAttribute("page", page);
    model.addAttribute("government", government);

    return "customer/government/governmentList";
  }

  @RequiresPermissions("government:government:view")
  @RequestMapping(value = "form")
  public String form(GovernmentEntity government, Model model) {
    model.addAttribute("government", government);
    return "customer/government/governmentForm";
  }

  @RequiresPermissions("government:government:edit")
  @RequestMapping(value = "save")
  public String save(GovernmentEntity government, Model model,
      RedirectAttributes redirectAttributes) {
    if (!beanValidator(model, government)) {
      return form(government, model);
    }

    Government type = resolveBeanProperties(StringUtils.isEmpty(government.getId()), government);
    String apiBaseUrl = moduleLinkConfiguration.getLink("customer");

    restTemplate.postForObject(apiBaseUrl + "/government/government/api/save", type, String.class);
    addMessage(redirectAttributes, "保存政府信息管理成功");

    return "redirect:" + Global.getAdminPath() + "/government/government/?repage";
  }

  @RequiresPermissions("government:government:edit")
  @RequestMapping(value = "delete")
  public String delete(GovernmentEntity government, RedirectAttributes redirectAttributes) {

    String apiBaseUrl = moduleLinkConfiguration.getLink("customer");

    Government type = new Government();
    BeanUtils.copyProperties(government, type);
    restTemplate
        .postForEntity(apiBaseUrl + "/government/government/api/delete", type, String.class);

    addMessage(redirectAttributes, "删除政府信息管理成功");
    return "redirect:" + Global.getAdminPath() + "/government/government/?repage";
  }

  /**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private Government resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    Government government = JsonUtils.toSimpleObject(JsonUtils.toJson(source), Government.class);
    Date now = DateUtils.getNow();
    if (isNewRecord) {
      government.setCreateDate(now);
      government.setCreateBy(user.getName());
    }
    government.setUpdateBy(user.getName());
    government.setUpdateDate(now);
    return government;
  }

}