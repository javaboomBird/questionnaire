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

import com.create80.rd.modules.projectmanager.entity.ProjectStageEntity;
import com.create80.rd.modules.projectmanager.api.model.ProjectStage;

import com.create80.rd.modules.sys.service.UserService;

/**
 * 项目阶段管理Controller
 *
 * @author yzx
 * @version 2018-05-29
 */
@Controller
@RequestMapping(value = "${adminPath}/projectmanager/projectStage")
public class ProjectStageViewController extends BaseController {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UserService userService;

  @ModelAttribute
  public ProjectStageEntity get(@RequestParam(required = false) String id) {

    ProjectStageEntity entity = new ProjectStageEntity();
    if (StringUtils.isNotBlank(id)) {
      String apiBaseUrl = moduleLinkConfiguration.getLink("projectmanager");
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("id", id);
      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/projectmanager/projectStage/api/{id}", String.class,
              urlVariables);

      entity = JsonUtils.toSimpleObject(responseEntity.getBody(), ProjectStageEntity.class);

      entity.setManager(userService.get(entity.getManagerId()));
    }
    return entity;
  }

  /**
   * 通过项目ID获取项目阶段列表
   *
   * @param projectId 项目ID
   */
  @RequestMapping(value = "getAll", method = RequestMethod.GET)
  @ResponseBody
  public List<ProjectStage> getAllProjectTaskList(String projectId) {

    String apiBaseUrl = moduleLinkConfiguration.getLink("projectmanager");
    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("projectId", projectId);

    ResponseEntity<String> responseEntity = restTemplate
        .getForEntity(apiBaseUrl + "/projectmanager/projectStage/api/getAll?projectId={projectId}",
            String.class, urlVariables);

    return JsonUtils.toListObject(responseEntity.getBody(), ProjectStage.class);
  }

  @RequiresPermissions("projectmanager:projectStage:view")
  @RequestMapping(value = {"list", ""})
  public String list(ProjectStageEntity projectStage, HttpServletRequest request,
      HttpServletResponse response, Model model) {

    if (StringUtils.isEmpty(projectStage.getProjectId())) {
      projectStage.setProjectId(null);
    }
    if (StringUtils.isEmpty(projectStage.getStageName())) {
      projectStage.setStageName(null);
    }

    Page<ProjectStage> page = new Page<>(request, response);
    ProjectStage type = JsonUtils
        .toSimpleObject(JsonUtils.toJson(projectStage), ProjectStage.class);

    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("pageNum", page.getPageNo());
    urlVariables.put("pageSize", page.getPageSize());

    String apiBaseUrl = moduleLinkConfiguration.getLink("projectmanager");
    ResponseEntity<String> pageResponseEntity = restTemplate
        .postForEntity(
            apiBaseUrl
                + "/projectmanager/projectStage/api/list?pageNum={pageNum}&&pageSize={pageSize}",
            type, String.class, urlVariables);

    PageInfo<ProjectStage> projectStagePageInfo = JsonUtils
        .fromJson(pageResponseEntity.getBody(), PageInfo.class, ProjectStage.class);

    page.setCount(projectStagePageInfo.getTotal());
    page.setPageNo(projectStagePageInfo.getPageNum());
    page.setList(projectStagePageInfo.getList());
    model.addAttribute("page", page);
    model.addAttribute("projectStage", projectStage);

    return "modules/projectmanager/projectStageList";
  }

  @RequiresPermissions("projectmanager:projectStage:view")
  @RequestMapping(value = "form")
  public String form(ProjectStageEntity projectStage, Model model) {
    model.addAttribute("projectStage", projectStage);
    return "modules/projectmanager/projectStageForm";
  }

  @RequiresPermissions("projectmanager:projectStage:edit")
  @RequestMapping(value = "save")
  public String save(ProjectStageEntity projectStage, Model model,
      RedirectAttributes redirectAttributes) {
    if (!beanValidator(model, projectStage)) {
      return form(projectStage, model);
    }

    ProjectStage type = resolveBeanProperties(StringUtils.isEmpty(projectStage.getId()),
        projectStage);
    String apiBaseUrl = moduleLinkConfiguration.getLink("projectmanager");

    restTemplate
        .postForObject(apiBaseUrl + "/projectmanager/projectStage/api/save", type, String.class);
    addMessage(redirectAttributes, "保存项目阶段管理成功");

    return "redirect:" + Global.getAdminPath() + "/projectmanager/projectStage/?repage";
  }

  @RequiresPermissions("projectmanager:projectStage:edit")
  @RequestMapping(value = "delete")
  public String delete(ProjectStageEntity projectStage, RedirectAttributes redirectAttributes) {

    String apiBaseUrl = moduleLinkConfiguration.getLink("projectmanager");

    ProjectStage type = new ProjectStage();
    BeanUtils.copyProperties(projectStage, type);
    restTemplate
        .postForEntity(apiBaseUrl + "/projectmanager/projectStage/api/delete", type, String.class);

    addMessage(redirectAttributes, "删除项目阶段管理成功");
    return "redirect:" + Global.getAdminPath() + "/projectmanager/projectStage/?repage";
  }

  /**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private ProjectStage resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    ProjectStage projectStage = JsonUtils
        .toSimpleObject(JsonUtils.toJson(source), ProjectStage.class);
    Date now = DateUtils.getNow();
    if (isNewRecord) {
      projectStage.setCreateDate(now);
      projectStage.setCreateBy(user.getName());
    }
    projectStage.setUpdateBy(user.getName());
    projectStage.setUpdateDate(now);
    return projectStage;
  }

}