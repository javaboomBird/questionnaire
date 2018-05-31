/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.group.web;

import com.create80.rd.modules.group.entity.SysUserGroupEntity;
import com.create80.rd.modules.sys.service.UserService;
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

import com.create80.rd.modules.group.entity.SysGroupEntity;
import com.create80.rd.modules.group.api.model.SysGroup;

import com.create80.rd.modules.sys.service.OfficeService;

/**
 * 分组管理Controller
 *
 * @author yzx
 * @version 2018-05-31
 */
@Controller
@RequestMapping(value = "${adminPath}/group/sysGroup")
public class SysGroupViewController extends BaseController {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private OfficeService officeService;

  @Autowired
  private UserService userService;

  @ModelAttribute
  public SysGroupEntity get(@RequestParam(required = false) String id) {

    SysGroupEntity entity = new SysGroupEntity();
    if (StringUtils.isNotBlank(id)) {
      String apiBaseUrl = moduleLinkConfiguration.getLink("group");
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("id", id);
      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/group/sysGroup/api/{id}", String.class,
              urlVariables);

      entity = JsonUtils.toSimpleObject(responseEntity.getBody(), SysGroupEntity.class);

      entity.setOffice(officeService.get(entity.getOfficeId()));
    }

    List<SysUserGroupEntity> sysUserGroupEntityList = entity.getSysUserGroupList();
    if (sysUserGroupEntityList != null && sysUserGroupEntityList.size() > 0) {
      sysUserGroupEntityList.stream().forEach(sysUserGroupEntity -> {
        sysUserGroupEntity.setUser(userService.get(sysUserGroupEntity.getUserId()));
      });
    }
    return entity;
  }

  @RequiresPermissions("group:sysGroup:view")
  @RequestMapping(value = {"list", ""})
  public String list(SysGroupEntity sysGroup, HttpServletRequest request,
      HttpServletResponse response, Model model) {

    Page<SysGroupEntity> page = new Page<>(request, response);
    SysGroup type = JsonUtils
        .toSimpleObject(JsonUtils.toJson(sysGroup), SysGroup.class);

    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("pageNum", page.getPageNo());
    urlVariables.put("pageSize", page.getPageSize());

    String apiBaseUrl = moduleLinkConfiguration.getLink("group");
    ResponseEntity<String> pageResponseEntity = restTemplate
        .postForEntity(
            apiBaseUrl + "/group/sysGroup/api/list?pageNum={pageNum}&&pageSize={pageSize}",
            type, String.class, urlVariables);

    PageInfo<SysGroupEntity> sysGroupPageInfo = JsonUtils
        .fromJson(pageResponseEntity.getBody(), PageInfo.class, SysGroupEntity.class);

    List<SysGroupEntity> sysGroupEntityList = sysGroupPageInfo.getList();
    if (sysGroupEntityList != null && sysGroupEntityList.size() > 0) {
      sysGroupEntityList.stream().forEach(sysGroupEntity -> {
        sysGroupEntity.setOffice(officeService.get(sysGroupEntity.getOfficeId()));
      });
    }
    page.setCount(sysGroupPageInfo.getTotal());
    page.setPageNo(sysGroupPageInfo.getPageNum());
    page.setList(sysGroupEntityList);
    model.addAttribute("page", page);
    model.addAttribute("sysGroup", sysGroup);

    return "modules/group/sysGroupList";
  }

  @RequiresPermissions("group:sysGroup:view")
  @RequestMapping(value = "form")
  public String form(SysGroupEntity sysGroup, Model model) {
    model.addAttribute("sysGroup", sysGroup);
    return "modules/group/sysGroupForm";
  }

  @RequiresPermissions("group:sysGroup:edit")
  @RequestMapping(value = "save")
  public String save(SysGroupEntity sysGroup, Model model, RedirectAttributes redirectAttributes) {
    if (!beanValidator(model, sysGroup)) {
      return form(sysGroup, model);
    }

    SysGroup type = resolveBeanProperties(StringUtils.isEmpty(sysGroup.getId()), sysGroup);
    String apiBaseUrl = moduleLinkConfiguration.getLink("group");

    restTemplate.postForObject(apiBaseUrl + "/group/sysGroup/api/save", type, String.class);
    addMessage(redirectAttributes, "保存分组管理成功");

    return "redirect:" + Global.getAdminPath() + "/group/sysGroup/?repage";
  }

  @RequiresPermissions("group:sysGroup:edit")
  @RequestMapping(value = "delete")
  public String delete(SysGroupEntity sysGroup, RedirectAttributes redirectAttributes) {

    String apiBaseUrl = moduleLinkConfiguration.getLink("group");

    SysGroup type = new SysGroup();
    BeanUtils.copyProperties(sysGroup, type);
    restTemplate.postForEntity(apiBaseUrl + "/group/sysGroup/api/delete", type, String.class);

    addMessage(redirectAttributes, "删除分组管理成功");
    return "redirect:" + Global.getAdminPath() + "/group/sysGroup/?repage";
  }

  /**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private SysGroup resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    SysGroup sysGroup = JsonUtils.toSimpleObject(JsonUtils.toJson(source), SysGroup.class);
    Date now = DateUtils.getNow();
    if (isNewRecord) {
      sysGroup.setCreateDate(now);
      sysGroup.setCreateBy(user.getName());
    }
    sysGroup.setUpdateBy(user.getName());
    sysGroup.setUpdateDate(now);
    return sysGroup;
  }

}