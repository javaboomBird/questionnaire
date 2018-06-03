package com.create80.rd.modules.projectmanager.web;

import com.create80.rd.common.utils.JsonUtils;
import com.create80.rd.common.utils.page.PageInfo;
import com.create80.rd.common.web.BaseController;
import com.create80.rd.modules.projectmanager.api.model.Project;
import com.create80.rd.modules.projectmanager.entity.ProjectEntity;
import com.create80.rd.modules.sys.entity.Dict;
import com.create80.rd.modules.sys.utils.DictUtils;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 * 项目管理DashboardController
 *
 * @author yzx
 * @version 2018-05-29
 */
@Controller
@RequestMapping(value = "${adminPath}/projectmanager/dashboard")
public class ProjectDashboardController extends BaseController {

  @Autowired
  private RestTemplate restTemplate;

  @RequestMapping(value = "", method = RequestMethod.GET)
  public String form(Model model) {

    Map<String, Integer> projectStatusMap = getProjectStatusMap();
    //查询项目列表
    List<Project> projectList = getProjects();

    //根据项目状态统计数量
    List<Project> delayProjectList = new ArrayList<>();
    if (projectList != null) {
      delayProjectList = getDelayProjectList(projectStatusMap, projectList);
    }
    //未完成任务列表(工程/运维)
    List<Map<String, Object>> noCompleteTaskList = getManagerNoCompleteTaskInProjectOrOperatorStage();

    model.addAttribute("projectStatus", projectStatusMap);
    model.addAttribute("delayProjectList", delayProjectList);
    model.addAttribute("noCompleteTaskList", noCompleteTaskList);
    return "modules/projectmanager/dashboard";
  }

  /**
   *
   * @return
   */
  private List<Map<String, Object>> getManagerNoCompleteTaskInProjectOrOperatorStage() {

    String apiBaseUrl = moduleLinkConfiguration.getLink("projectmanager");
    ResponseEntity<String> responseEntity = restTemplate.getForEntity(
        apiBaseUrl
            + "/projectmanager/projectTask/api/getManagerNoCompleteTaskInProjectOrOperatorStage",
        String.class);
    return JsonUtils.toSimpleObject(responseEntity.getBody(), List.class);
  }

  /**
   * 返回延项目列表
   */
  private List<Project> getDelayProjectList(Map<String, Integer> projectStatusMap,
      List<Project> projectList) {
    //延期项目状态
    final String delayStatus = "3";
    List<Project> delayProjectList = new ArrayList<>();
    projectList.stream().forEach(project -> {
      String status = project.getProjectStatus();
      if (projectStatusMap.containsKey(status)) {
        projectStatusMap.put(status, projectStatusMap.get(status) + 1);
      }
      //延期状态
      if (delayStatus.equals(status)) {
        delayProjectList.add(project);
      }
    });
    return delayProjectList;
  }

  /**
   * 获取项目列表
   */
  private List<Project> getProjects() {
    String apiBaseUrl = moduleLinkConfiguration.getLink("projectmanager");
    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("pageNum", -1);
    urlVariables.put("pageSize", -1);
    Map<String, Object> paramMap = Maps.newHashMap();
    ResponseEntity<String> responseEntity = restTemplate
        .postForEntity(
            apiBaseUrl + "/projectmanager/project/api/list?pageNum={pageNum}&&pageSize={pageSize}",
            paramMap,
            String.class, urlVariables);
    PageInfo<Project> projectPageInfo = JsonUtils
        .fromJson(responseEntity.getBody(), PageInfo.class, Project.class);

    return projectPageInfo.getList();
  }

  /**
   * 项目状态
   */
  private Map<String, Integer> getProjectStatusMap() {
    Map<String, Integer> projectStatusMap = new HashMap<>();
    List<Dict> projectStatusDictList = DictUtils.getDictList("project_status");
    projectStatusDictList.stream().forEach(dict -> {
      String statusValue = dict.getValue();
      projectStatusMap.put(statusValue, 0);
    });
    return projectStatusMap;
  }
}
