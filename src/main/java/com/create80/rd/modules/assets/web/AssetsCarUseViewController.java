/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.assets.web;

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
import org.springframework.http.ResponseEntity;

import com.create80.rd.common.utils.JsonUtils;
import com.create80.rd.modules.sys.entity.User;
import com.create80.rd.modules.sys.utils.UserUtils;
import com.create80.rd.common.config.Global;
import com.create80.rd.common.persistence.Page;
import com.create80.rd.common.web.BaseController;
import com.create80.rd.common.utils.StringUtils;
import com.create80.rd.common.utils.page.PageInfo;
import com.create80.rd.modules.assets.entity.AssetsCarUseEntity;
import com.create80.rd.modules.assets.api.model.AssetsCarUse;

/**
 * 车辆使用Controller
 *
 * @author yzx
 * @version 2018-06-08
 */
@Controller
@RequestMapping(value = "${adminPath}/assets/assetsCarUse")
public class AssetsCarUseViewController extends BaseController {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private AssetsCarDistributiveViewController assetsCarDistributiveViewController;

  @ModelAttribute
  public AssetsCarUseEntity get(@RequestParam(required = false) String id) {

    AssetsCarUseEntity entity = new AssetsCarUseEntity();
    if (StringUtils.isNotBlank(id)) {
      String apiBaseUrl = moduleLinkConfiguration.getLink("assets");
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("id", id);
      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/assets/assetsCarUse/api/{id}", String.class, urlVariables);

      String type = responseEntity.getBody();
      entity = JsonUtils.toSimpleObject(type, AssetsCarUseEntity.class);
    }
    return entity;
  }




  @RequiresPermissions("assets:assetsCarUse:view")
  @RequestMapping(value = {"list", ""})
  public String list(AssetsCarUseEntity assetsCarUse, HttpServletRequest request,
      HttpServletResponse response, Model model) {

    Page<AssetsCarUseEntity> page = new Page<>(request, response);
    AssetsCarUse type = JsonUtils
        .toSimpleObject(JsonUtils.toJson(assetsCarUse), AssetsCarUse.class);

    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("pageNum", page.getPageNo());
    urlVariables.put("pageSize", page.getPageSize());

    String apiBaseUrl = moduleLinkConfiguration.getLink("assets");
    ResponseEntity<String> pageResponseEntity = restTemplate
        .postForEntity(
            apiBaseUrl + "/assets/assetsCarUse/api/list?pageNum={pageNum}&&pageSize={pageSize}",
            type, String.class, urlVariables);

    PageInfo<AssetsCarUseEntity> assetsCarUsePageInfo = JsonUtils
        .fromJson(pageResponseEntity.getBody(), PageInfo.class, AssetsCarUseEntity.class);

    page.setCount(assetsCarUsePageInfo.getTotal());
    page.setPageNo(assetsCarUsePageInfo.getPageNum());
    page.setList(assetsCarUsePageInfo.getList());
    model.addAttribute("page", page);
    model.addAttribute("assetsCarUse", assetsCarUse);

    return "modules/assets/assetsCarUseList";
  }

  @RequiresPermissions("assets:assetsCarUse:view")
  @RequestMapping(value = "form")
  public String form(AssetsCarUseEntity assetsCarUse, Model model) {
    model.addAttribute("assetsCarUse", assetsCarUse);
    return "modules/assets/assetsCarUseForm";
  }

  @RequiresPermissions("assets:assetsCarUse:edit")
  @RequestMapping(value = "save")
  public String save(AssetsCarUseEntity assetsCarUse, Model model,
      RedirectAttributes redirectAttributes) {
    if (!beanValidator(model, assetsCarUse)) {
      return form(assetsCarUse, model);
    }

    AssetsCarUse type = resolveBeanProperties(StringUtils.isEmpty(assetsCarUse.getId()),
        assetsCarUse);
    String apiBaseUrl = moduleLinkConfiguration.getLink("assets");

    restTemplate.postForObject(apiBaseUrl + "/assets/assetsCarUse/api/save", type, String.class);
    addMessage(redirectAttributes, "保存车辆使用成功");

    return "redirect:" + Global.getAdminPath() + "/assets/assetsCarUse/?repage";
  }

  @RequiresPermissions("assets:assetsCarUse:edit")
  @RequestMapping(value = "delete")
  public String delete(AssetsCarUseEntity assetsCarUse, RedirectAttributes redirectAttributes) {

    String apiBaseUrl = moduleLinkConfiguration.getLink("assets");

    AssetsCarUse type = new AssetsCarUse();
    BeanUtils.copyProperties(assetsCarUse, type);
    restTemplate.postForEntity(apiBaseUrl + "/assets/assetsCarUse/api/delete", type, String.class);

    addMessage(redirectAttributes, "删除车辆使用成功");
    return "redirect:" + Global.getAdminPath() + "/assets/assetsCarUse/?repage";
  }

  /**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private AssetsCarUse resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    AssetsCarUse assetsCarUse = JsonUtils
        .toSimpleObject(JsonUtils.toJson(source), AssetsCarUse.class);
    Date now = new Date();
    if (isNewRecord) {
      assetsCarUse.setInsertTime(now);
      assetsCarUse.setInsertBy(user.getName());
    }
    assetsCarUse.setUpdateBy(user.getName());
    assetsCarUse.setUpdateTime(now);
    return assetsCarUse;
  }

}