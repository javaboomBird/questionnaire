/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.projectmanager.web;

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

import com.create80.rd.modules.projectmanager.entity.ProjectEntity;
import com.create80.rd.modules.projectmanager.api.model.Project;

import com.create80.rd.modules.sys.service.UserService;

/**
 * 项目管理Controller
 *
 * @author yzx
 * @version 2018-05-30
 */
@Controller
@RequestMapping(value = "${adminPath}/projectmanager/project")
public class ProjectViewController extends BaseController {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UserService userService;

  @ModelAttribute
  public ProjectEntity get(@RequestParam(required = false) String id) {

    ProjectEntity entity = new ProjectEntity();
    if (StringUtils.isNotBlank(id)) {
      String apiBaseUrl = moduleLinkConfiguration.getLink("projectmanager");
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("id", id);
      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/projectmanager/project/api/{id}", String.class,
              urlVariables);

      entity = JsonUtils.toSimpleObject(responseEntity.getBody(), ProjectEntity.class);

      entity.setManager(userService.get(entity.getManagerId()));
    }
    return entity;
  }

  @RequiresPermissions("projectmanager:project:view")
  @RequestMapping(value = {"list", ""})
  public String list(ProjectEntity project, HttpServletRequest request,
      HttpServletResponse response, Model model) {

    Page<Project> page = new Page<>(request, response);
    Project type = JsonUtils
        .toSimpleObject(JsonUtils.toJson(project), Project.class);

    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("pageNum", page.getPageNo());
    urlVariables.put("pageSize", page.getPageSize());

    String apiBaseUrl = moduleLinkConfiguration.getLink("projectmanager");
    ResponseEntity<String> pageResponseEntity = restTemplate
        .postForEntity(
            apiBaseUrl + "/projectmanager/project/api/list?pageNum={pageNum}&&pageSize={pageSize}",
            type, String.class, urlVariables);

    PageInfo<Project> projectPageInfo = JsonUtils
        .fromJson(pageResponseEntity.getBody(), PageInfo.class, Project.class);

    page.setCount(projectPageInfo.getTotal());
    page.setPageNo(projectPageInfo.getPageNum());
    page.setList(projectPageInfo.getList());
    model.addAttribute("page", page);
    model.addAttribute("project", project);

    return "modules/projectmanager/projectList";
  }

  @RequiresPermissions("projectmanager:project:view")
  @RequestMapping(value = "form")
  public String form(ProjectEntity project, Model model) {
    model.addAttribute("project", project);
    return "modules/projectmanager/projectForm";
  }

  @RequiresPermissions("projectmanager:project:edit")
  @RequestMapping(value = "save")
  public String save(ProjectEntity project, Model model, RedirectAttributes redirectAttributes) {
    if (!beanValidator(model, project)) {
      return form(project, model);
    }

    Project type = resolveBeanProperties(StringUtils.isEmpty(project.getId()), project);
    String apiBaseUrl = moduleLinkConfiguration.getLink("projectmanager");

    restTemplate.postForObject(apiBaseUrl + "/projectmanager/project/api/save", type, String.class);
    addMessage(redirectAttributes, "保存项目管理成功");

    return "redirect:" + Global.getAdminPath() + "/projectmanager/project/?repage";
  }

  @RequiresPermissions("projectmanager:project:edit")
  @RequestMapping(value = "delete")
  public String delete(ProjectEntity project, RedirectAttributes redirectAttributes) {

    String apiBaseUrl = moduleLinkConfiguration.getLink("projectmanager");

    Project type = new Project();
    BeanUtils.copyProperties(project, type);
    restTemplate
        .postForEntity(apiBaseUrl + "/projectmanager/project/api/delete", type, String.class);

    addMessage(redirectAttributes, "删除项目管理成功");
    return "redirect:" + Global.getAdminPath() + "/projectmanager/project/?repage";
  }

  /**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private Project resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    Project project = JsonUtils.toSimpleObject(JsonUtils.toJson(source), Project.class);
    Date now = DateUtils.getNow();
    if (isNewRecord) {
      project.setCreateDate(now);
      project.setCreateBy(user.getName());
    }
    project.setUpdateBy(user.getName());
    project.setUpdateDate(now);
    return project;
  }

}