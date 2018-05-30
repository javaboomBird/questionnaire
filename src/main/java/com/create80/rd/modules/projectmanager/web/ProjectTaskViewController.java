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

import com.create80.rd.modules.projectmanager.entity.ProjectTaskEntity;
import com.create80.rd.modules.projectmanager.api.model.ProjectTask;

import com.create80.rd.modules.sys.service.UserService;

/**
 * 项目任务信息管理Controller
 *
 * @author yzx
 * @version 2018-05-29
 */
@Controller
@RequestMapping(value = "${adminPath}/projectmanager/projectTask")
public class ProjectTaskViewController extends BaseController {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UserService userService;

  @ModelAttribute
  public ProjectTaskEntity get(@RequestParam(required = false) String id) {

    ProjectTaskEntity entity = new ProjectTaskEntity();
    if (StringUtils.isNotBlank(id)) {
      String apiBaseUrl = moduleLinkConfiguration.getLink("projectmanager");
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("id", id);
      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/projectmanager/projectTask/api/{id}", String.class,
              urlVariables);

      entity = JsonUtils.toSimpleObject(responseEntity.getBody(), ProjectTaskEntity.class);

      entity.setManager(userService.get(entity.getManagerId()));
    }
    return entity;
  }


  /**
   * 根据阶段ID获取任务列表
   */
  @RequestMapping(value = "/getAll", method = RequestMethod.GET)
  @ResponseBody
  public List<ProjectTask> getAllProjectTaskList(String stageId) {

    String apiBaseUrl = moduleLinkConfiguration.getLink("projectmanager");
    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("stageId", stageId);

    ResponseEntity<String> responseEntity = restTemplate
        .getForEntity(apiBaseUrl + "projectmanager/projectTask/api/getAll?stageId={stageId}",
            String.class, urlVariables);

    return JsonUtils.toListObject(responseEntity.getBody(), ProjectTask.class);
  }


  @RequiresPermissions("projectmanager:projectTask:view")
  @RequestMapping(value = {"list", ""})
  public String list(ProjectTaskEntity projectTask, HttpServletRequest request,
      HttpServletResponse response, Model model) {

    if (StringUtils.isEmpty(projectTask.getProjectId())) {
      projectTask.setProjectId(null);
    }
    if (StringUtils.isEmpty(projectTask.getTaskName())) {
      projectTask.setTaskName(null);
    }
    Page<ProjectTask> page = new Page<>(request, response);
    ProjectTask type = JsonUtils
        .toSimpleObject(JsonUtils.toJson(projectTask), ProjectTask.class);

    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("pageNum", page.getPageNo());
    urlVariables.put("pageSize", page.getPageSize());

    String apiBaseUrl = moduleLinkConfiguration.getLink("projectmanager");
    ResponseEntity<String> pageResponseEntity = restTemplate
        .postForEntity(
            apiBaseUrl
                + "/projectmanager/projectTask/api/list?pageNum={pageNum}&&pageSize={pageSize}",
            type, String.class, urlVariables);

    PageInfo<ProjectTask> projectTaskPageInfo = JsonUtils
        .fromJson(pageResponseEntity.getBody(), PageInfo.class, ProjectTask.class);

    page.setCount(projectTaskPageInfo.getTotal());
    page.setPageNo(projectTaskPageInfo.getPageNum());
    page.setList(projectTaskPageInfo.getList());
    model.addAttribute("page", page);
    model.addAttribute("projectTask", projectTask);

    return "modules/projectmanager/projectTaskList";
  }

  @RequiresPermissions("projectmanager:projectTask:view")
  @RequestMapping(value = "form")
  public String form(ProjectTaskEntity projectTask, Model model) {
    model.addAttribute("projectTask", projectTask);
    return "modules/projectmanager/projectTaskForm";
  }

  @RequiresPermissions("projectmanager:projectTask:edit")
  @RequestMapping(value = "save")
  public String save(ProjectTaskEntity projectTask, Model model,
      RedirectAttributes redirectAttributes) {
    if (!beanValidator(model, projectTask)) {
      return form(projectTask, model);
    }

    ProjectTask type = resolveBeanProperties(StringUtils.isEmpty(projectTask.getId()), projectTask);
    String apiBaseUrl = moduleLinkConfiguration.getLink("projectmanager");

    restTemplate
        .postForObject(apiBaseUrl + "/projectmanager/projectTask/api/save", type, String.class);
    addMessage(redirectAttributes, "保存项目任务信息管理成功");

    return "redirect:" + Global.getAdminPath() + "/projectmanager/projectTask/?repage";
  }

  @RequiresPermissions("projectmanager:projectTask:edit")
  @RequestMapping(value = "delete")
  public String delete(ProjectTaskEntity projectTask, RedirectAttributes redirectAttributes) {

    String apiBaseUrl = moduleLinkConfiguration.getLink("projectmanager");

    ProjectTask type = new ProjectTask();
    BeanUtils.copyProperties(projectTask, type);
    restTemplate
        .postForEntity(apiBaseUrl + "/projectmanager/projectTask/api/delete", type, String.class);

    addMessage(redirectAttributes, "删除项目任务信息管理成功");
    return "redirect:" + Global.getAdminPath() + "/projectmanager/projectTask/?repage";
  }

  /**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private ProjectTask resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    ProjectTask projectTask = JsonUtils.toSimpleObject(JsonUtils.toJson(source), ProjectTask.class);
    Date now = DateUtils.getNow();
    if (isNewRecord) {
      projectTask.setCreateDate(now);
      projectTask.setCreateBy(user.getName());
    }
    projectTask.setUpdateBy(user.getName());
    projectTask.setUpdateDate(now);
    return projectTask;
  }

}