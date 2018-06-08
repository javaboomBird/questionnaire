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
import com.create80.rd.modules.assets.entity.AssetsReplaceEntity;
import com.create80.rd.modules.assets.api.model.AssetsReplace;

/**
 * 资产替换Controller
 *
 * @author yzx
 * @version 2018-06-06
 */
@Controller
@RequestMapping(value = "${adminPath}/assets/assetsReplace")
public class AssetsReplaceViewController extends BaseController {

  @Autowired
  private RestTemplate restTemplate;

  @ModelAttribute
  public AssetsReplaceEntity get(@RequestParam(required = false) String id) {

    AssetsReplaceEntity entity = new AssetsReplaceEntity();
    if (StringUtils.isNotBlank(id)) {
      String apiBaseUrl = moduleLinkConfiguration.getLink("assets");
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("id", id);
      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/assets/assetsReplace/api/{id}", String.class, urlVariables);

      String type = responseEntity.getBody();
      entity = JsonUtils.toSimpleObject(type, AssetsReplaceEntity.class);
      entity.setReplaceManager(UserUtils.get(entity.getReplaceManagerId()));
    }
    return entity;
  }

  @RequiresPermissions("assets:assetsReplace:view")
  @RequestMapping(value = {"list", ""})
  public String list(AssetsReplaceEntity assetsReplace, HttpServletRequest request,
      HttpServletResponse response, Model model) {

    Page<AssetsReplaceEntity> page = new Page<>(request, response);
    AssetsReplace type = JsonUtils
        .toSimpleObject(JsonUtils.toJson(assetsReplace), AssetsReplace.class);

    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("pageNum", page.getPageNo());
    urlVariables.put("pageSize", page.getPageSize());

    String apiBaseUrl = moduleLinkConfiguration.getLink("assets");
    ResponseEntity<String> pageResponseEntity = restTemplate
        .postForEntity(
            apiBaseUrl + "/assets/assetsReplace/api/list?pageNum={pageNum}&&pageSize={pageSize}",
            type, String.class, urlVariables);

    PageInfo<AssetsReplaceEntity> assetsReplacePageInfo = JsonUtils
        .fromJson(pageResponseEntity.getBody(), PageInfo.class, AssetsReplaceEntity.class);

    List<AssetsReplaceEntity> assetsReplaceEntityList = assetsReplacePageInfo.getList();
    if (assetsReplaceEntityList != null) {
      assetsReplaceEntityList.stream().forEach(assetsReplaceEntity -> {
        assetsReplaceEntity
            .setReplaceManager(UserUtils.get(assetsReplaceEntity.getReplaceManagerId()));
      });
    }
    page.setCount(assetsReplacePageInfo.getTotal());
    page.setPageNo(assetsReplacePageInfo.getPageNum());
    page.setList(assetsReplaceEntityList);
    model.addAttribute("page", page);
    model.addAttribute("assetsReplace", assetsReplace);

    return "modules/assets/assetsReplaceList";
  }

  @RequiresPermissions("assets:assetsReplace:view")
  @RequestMapping(value = "form")
  public String form(AssetsReplaceEntity assetsReplace, Model model) {
    model.addAttribute("assetsReplace", assetsReplace);
    return "modules/assets/assetsReplaceForm";
  }

  @RequiresPermissions("assets:assetsReplace:edit")
  @RequestMapping(value = "save")
  public String save(AssetsReplaceEntity assetsReplace, Model model,
      RedirectAttributes redirectAttributes) {
    if (!beanValidator(model, assetsReplace)) {
      return form(assetsReplace, model);
    }

    //校验替换和被替换的资产是同一个资产
    if (assetsReplace.getOriginalAssetsId().equals(assetsReplace.getReplaceAssetsId())) {
      addMessage(model, "替换的资产和被替换的资产选项选择的是同一个,保存失败!");
      return form(assetsReplace, model);
    }

    AssetsReplace type = resolveBeanProperties(StringUtils.isEmpty(assetsReplace.getId()),
        assetsReplace);
    String apiBaseUrl = moduleLinkConfiguration.getLink("assets");

    restTemplate.postForObject(apiBaseUrl + "/assets/assetsReplace/api/save", type, String.class);
    addMessage(redirectAttributes, "保存资产替换成功");

    return "redirect:" + Global.getAdminPath() + "/assets/assetsReplace/?repage";
  }

  @RequiresPermissions("assets:assetsReplace:edit")
  @RequestMapping(value = "delete")
  public String delete(AssetsReplaceEntity assetsReplace, RedirectAttributes redirectAttributes) {

    String apiBaseUrl = moduleLinkConfiguration.getLink("assets");

    AssetsReplace type = new AssetsReplace();
    BeanUtils.copyProperties(assetsReplace, type);
    restTemplate.postForEntity(apiBaseUrl + "/assets/assetsReplace/api/delete", type, String.class);

    addMessage(redirectAttributes, "删除资产替换成功");
    return "redirect:" + Global.getAdminPath() + "/assets/assetsReplace/?repage";
  }

  /**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private AssetsReplace resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    AssetsReplace assetsReplace = JsonUtils
        .toSimpleObject(JsonUtils.toJson(source), AssetsReplace.class);
    Date now = new Date();
    if (isNewRecord) {
      assetsReplace.setCreateDate(now);
      assetsReplace.setCreateBy(user.getName());
    }
    assetsReplace.setUpdateBy(user.getName());
    assetsReplace.setUpdateDate(now);
    return assetsReplace;
  }

}