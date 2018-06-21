/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.assets.web;

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
import com.create80.rd.modules.assets.entity.AssetsRepairEntity;
import com.create80.rd.modules.assets.api.model.AssetsRepair;

/**
 * 资产维修Controller
 *
 * @author yzx
 * @version 2018-06-06
 */
@Controller
@RequestMapping(value = "${adminPath}/assets/assetsRepair")
public class AssetsRepairViewController extends BaseController {

  @Autowired
  private RestTemplate restTemplate;


  @ModelAttribute
  public AssetsRepairEntity get(@RequestParam(required = false) String id) {

    AssetsRepairEntity entity = new AssetsRepairEntity();
    if (StringUtils.isNotBlank(id)) {
      String apiBaseUrl = moduleLinkConfiguration.getLink("assets");
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("id", id);
      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/assets/assetsRepair/api/{id}", String.class, urlVariables);

      String type = responseEntity.getBody();
      entity = JsonUtils.toSimpleObject(type, AssetsRepairEntity.class);
    }
    return entity;
  }

  @RequiresPermissions("assets:assetsRepair:view")
  @RequestMapping(value = {"list", ""})
  public String list(AssetsRepairEntity assetsRepair, HttpServletRequest request,
      HttpServletResponse response, Model model) {

    Page<AssetsRepairEntity> page = new Page<>(request, response);
    AssetsRepair type = JsonUtils
        .toSimpleObject(JsonUtils.toJson(assetsRepair), AssetsRepair.class);

    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("pageNum", page.getPageNo());
    urlVariables.put("pageSize", page.getPageSize());

    String apiBaseUrl = moduleLinkConfiguration.getLink("assets");
    ResponseEntity<String> pageResponseEntity = restTemplate
        .postForEntity(
            apiBaseUrl + "/assets/assetsRepair/api/list?pageNum={pageNum}&&pageSize={pageSize}",
            type, String.class, urlVariables);

    PageInfo<AssetsRepairEntity> assetsRepairPageInfo = JsonUtils
        .fromJson(pageResponseEntity.getBody(), PageInfo.class, AssetsRepairEntity.class);

    List<AssetsRepairEntity> assetsRepairEntityList = assetsRepairPageInfo.getList();
    if (assetsRepairEntityList != null && assetsRepairEntityList.size() > 0) {
      assetsRepairEntityList.stream().forEach(assetsRepairEntity -> {
        assetsRepairEntity.setApplicant(UserUtils.get(assetsRepairEntity.getApplicantId()));
      });
    }
    page.setCount(assetsRepairPageInfo.getTotal());
    page.setPageNo(assetsRepairPageInfo.getPageNum());
    page.setList(assetsRepairEntityList);
    model.addAttribute("page", page);
    model.addAttribute("assetsRepair", assetsRepair);

    return "modules/assets/assetsRepairList";
  }

  @RequiresPermissions("assets:assetsRepair:view")
  @RequestMapping(value = "form")
  public String form(AssetsRepairEntity assetsRepair, Model model) {
    model.addAttribute("assetsRepair", assetsRepair);
    return "modules/assets/assetsRepairForm";
  }

  @RequiresPermissions("assets:assetsRepair:edit")
  @RequestMapping(value = "save")
  public String save(AssetsRepairEntity assetsRepair, Model model,
      RedirectAttributes redirectAttributes) {
    if (!beanValidator(model, assetsRepair)) {
      return form(assetsRepair, model);
    }

    AssetsRepair type = resolveBeanProperties(StringUtils.isEmpty(assetsRepair.getId()),
        assetsRepair);
    String apiBaseUrl = moduleLinkConfiguration.getLink("assets");

    restTemplate.postForObject(apiBaseUrl + "/assets/assetsRepair/api/save", type, String.class);
    addMessage(redirectAttributes, "保存资产维修成功");

    return "redirect:" + Global.getAdminPath() + "/assets/assetsRepair/?repage";
  }

  @RequiresPermissions("assets:assetsRepair:edit")
  @RequestMapping(value = "delete")
  public String delete(AssetsRepairEntity assetsRepair, RedirectAttributes redirectAttributes) {

    String apiBaseUrl = moduleLinkConfiguration.getLink("assets");

    AssetsRepair type = new AssetsRepair();
    BeanUtils.copyProperties(assetsRepair, type);
    restTemplate.postForEntity(apiBaseUrl + "/assets/assetsRepair/api/delete", type, String.class);

    addMessage(redirectAttributes, "删除资产维修成功");
    return "redirect:" + Global.getAdminPath() + "/assets/assetsRepair/?repage";
  }

  /**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private AssetsRepair resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    AssetsRepair assetsRepair = JsonUtils
        .toSimpleObject(JsonUtils.toJson(source), AssetsRepair.class);
    Date now = new Date();
    if (isNewRecord) {
      assetsRepair.setInsertTime(now);
      assetsRepair.setInsertBy(user.getName());
    }
    assetsRepair.setUpdateBy(user.getName());
    assetsRepair.setUpdateTime(now);
    return assetsRepair;
  }

}