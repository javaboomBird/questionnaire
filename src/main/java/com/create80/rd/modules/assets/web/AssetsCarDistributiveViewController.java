/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.assets.web;

import com.create80.rd.modules.group.entity.SysGroupEntity;
import com.create80.rd.modules.group.entity.SysUserGroupEntity;
import com.create80.rd.modules.sys.service.OfficeService;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
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
import com.create80.rd.modules.assets.entity.AssetsCarDistributiveEntity;
import com.create80.rd.modules.assets.api.model.AssetsCarDistributive;

/**
 * 车辆分配Controller
 *
 * @author yzx
 * @version 2018-06-08
 */
@Controller
@RequestMapping(value = "${adminPath}/assets/assetsCarDistributive")
public class AssetsCarDistributiveViewController extends BaseController {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private OfficeService officeService;

  @ModelAttribute
  public AssetsCarDistributiveEntity get(@RequestParam(required = false) String id) {

    AssetsCarDistributiveEntity entity = new AssetsCarDistributiveEntity();
    if (StringUtils.isNotBlank(id)) {
      String apiBaseUrl = moduleLinkConfiguration.getLink("assets");
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("id", id);
      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/assets/assetsCarDistributive/api/{id}", String.class,
              urlVariables);

      String type = responseEntity.getBody();
      entity = JsonUtils.toSimpleObject(type, AssetsCarDistributiveEntity.class);
      entity.setSysGroup(getSysGroupEntity(entity.getGroupId()));
    }
    return entity;
  }

  /**
   * 返回车辆分配给组对应的组员列表
   */
  @RequestMapping(value = "/getDistributiveAssetsCarMembers", method = RequestMethod.GET)
  @ResponseBody
  public List<SysUserGroupEntity> getDistributiveAssetsCarMembers(
      @RequestParam(value = "assetsId", required = true) String assetsId) {

    List<SysUserGroupEntity> sysUserGroupEntityList = new ArrayList<>();
    //根据资源ID获取绑定列表
    List<AssetsCarDistributiveEntity> assetsCarDistributiveEntityList = null;
    try {
      String apiBaseUrl = moduleLinkConfiguration.getLink("assets");
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("assetsId", assetsId);
      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/assets/assetsCarDistributive/api/getAll?assetsId={assetsId}",
              String.class,
              urlVariables);
      assetsCarDistributiveEntityList = JsonUtils
          .toListObject(responseEntity.getBody(), AssetsCarDistributiveEntity.class);
    } catch (RestClientException e) {
      e.printStackTrace();
    }

    if (assetsCarDistributiveEntityList != null && assetsCarDistributiveEntityList.size() > 0) {
      assetsCarDistributiveEntityList.stream().forEach(assetsCarDistributiveEntity -> {
        SysGroupEntity sysGroupEntity = get(assetsCarDistributiveEntity.getId()).getSysGroup();
        if (sysGroupEntity != null) {
          List<SysUserGroupEntity> userGroupEntities = sysGroupEntity.getSysUserGroupList();
          if (userGroupEntities != null && userGroupEntities.size() > 0) {
            userGroupEntities.stream().forEach(u -> {
              u.setUser(UserUtils.get(u.getUserId()));
            });
            sysUserGroupEntityList.addAll(userGroupEntities);
          }
        }
      });
    }
    return sysUserGroupEntityList;
  }

  @RequiresPermissions("assets:assetsCarDistributive:view")
  @RequestMapping(value = {"list", ""})
  public String list(AssetsCarDistributiveEntity assetsCarDistributive, HttpServletRequest request,
      HttpServletResponse response, Model model) {

    Page<AssetsCarDistributiveEntity> page = new Page<>(request, response);
    AssetsCarDistributive type = JsonUtils
        .toSimpleObject(JsonUtils.toJson(assetsCarDistributive), AssetsCarDistributive.class);

    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("pageNum", page.getPageNo());
    urlVariables.put("pageSize", page.getPageSize());

    String apiBaseUrl = moduleLinkConfiguration.getLink("assets");
    PageInfo<AssetsCarDistributiveEntity> assetsCarDistributivePageInfo = null;
    List<AssetsCarDistributiveEntity> assetsCarDistributiveEntityList = null;
    try {
      ResponseEntity<String> pageResponseEntity = restTemplate
          .postForEntity(
              apiBaseUrl
                  + "/assets/assetsCarDistributive/api/list?pageNum={pageNum}&&pageSize={pageSize}",
              type, String.class, urlVariables);

      assetsCarDistributivePageInfo = JsonUtils
          .fromJson(pageResponseEntity.getBody(), PageInfo.class,
              AssetsCarDistributiveEntity.class);

      assetsCarDistributiveEntityList = assetsCarDistributivePageInfo
          .getList();
    } catch (RestClientException e) {
      e.printStackTrace();
    }
    //设置分组信息
    if (assetsCarDistributiveEntityList != null && assetsCarDistributiveEntityList.size() > 0) {
      try {
        assetsCarDistributiveEntityList.stream().forEach(assetsCarDistributiveEntity -> {
          SysGroupEntity sysGroupEntity = getSysGroupEntity(
              assetsCarDistributiveEntity.getGroupId());
          if (sysGroupEntity != null) {
            sysGroupEntity.setOffice(officeService.get(sysGroupEntity.getOfficeId()));
          }
          assetsCarDistributiveEntity.setSysGroup(sysGroupEntity);
        });
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    page.setCount(assetsCarDistributivePageInfo.getTotal());
    page.setPageNo(assetsCarDistributivePageInfo.getPageNum());
    page.setList(assetsCarDistributiveEntityList);
    model.addAttribute("page", page);
    model.addAttribute("assetsCarDistributive", assetsCarDistributive);

    return "modules/assets/assetsCarDistributiveList";
  }

  private SysGroupEntity getSysGroupEntity(String groupId) {
    if (StringUtils.isEmpty(groupId)) {
      return null;
    }
    String groupApiBaseUrl = moduleLinkConfiguration.getLink("group");
    Map<String, Object> paramMap = new HashMap<>();
    paramMap.put("id", groupId);
    ResponseEntity<String> responseEntity = restTemplate
        .getForEntity(groupApiBaseUrl + "/group/sysGroup/api/{id}", String.class,
            paramMap);

    String responseEntityBody = responseEntity.getBody();
    return JsonUtils
        .toSimpleObject(responseEntityBody, SysGroupEntity.class);
  }


  @RequiresPermissions("assets:assetsCarDistributive:view")
  @RequestMapping(value = "form")
  public String form(AssetsCarDistributiveEntity assetsCarDistributive, Model model) {
    model.addAttribute("assetsCarDistributive", assetsCarDistributive);
    return "modules/assets/assetsCarDistributiveForm";
  }

  @RequiresPermissions("assets:assetsCarDistributive:edit")
  @RequestMapping(value = "save")
  public String save(AssetsCarDistributiveEntity assetsCarDistributive, Model model,
      RedirectAttributes redirectAttributes) {
    if (!beanValidator(model, assetsCarDistributive)) {
      return form(assetsCarDistributive, model);
    }

    AssetsCarDistributive type = resolveBeanProperties(
        StringUtils.isEmpty(assetsCarDistributive.getId()), assetsCarDistributive);
    String apiBaseUrl = moduleLinkConfiguration.getLink("assets");

    restTemplate
        .postForObject(apiBaseUrl + "/assets/assetsCarDistributive/api/save", type, String.class);
    addMessage(redirectAttributes, "保存车辆分配成功");

    return "redirect:" + Global.getAdminPath() + "/assets/assetsCarDistributive/?repage";
  }

  @RequiresPermissions("assets:assetsCarDistributive:edit")
  @RequestMapping(value = "delete")
  public String delete(AssetsCarDistributiveEntity assetsCarDistributive,
      RedirectAttributes redirectAttributes) {

    String apiBaseUrl = moduleLinkConfiguration.getLink("assets");

    AssetsCarDistributive type = new AssetsCarDistributive();
    BeanUtils.copyProperties(assetsCarDistributive, type);
    restTemplate
        .postForEntity(apiBaseUrl + "/assets/assetsCarDistributive/api/delete", type, String.class);

    addMessage(redirectAttributes, "删除车辆分配成功");
    return "redirect:" + Global.getAdminPath() + "/assets/assetsCarDistributive/?repage";
  }

  /**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private AssetsCarDistributive resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    AssetsCarDistributive assetsCarDistributive = JsonUtils
        .toSimpleObject(JsonUtils.toJson(source), AssetsCarDistributive.class);
    Date now = new Date();
    if (isNewRecord) {
      assetsCarDistributive.setCreateDate(now);
      assetsCarDistributive.setCreateBy(user.getName());
    }
    assetsCarDistributive.setUpdateBy(user.getName());
    assetsCarDistributive.setUpdateDate(now);
    return assetsCarDistributive;
  }

}