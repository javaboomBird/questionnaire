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

import com.create80.rd.common.utils.JsonUtils;
import com.create80.rd.modules.sys.entity.User;
import com.create80.rd.modules.sys.utils.UserUtils;
import com.create80.rd.common.config.Global;
import com.create80.rd.common.persistence.Page;
import com.create80.rd.common.web.BaseController;
import com.create80.rd.common.utils.StringUtils;
import com.create80.rd.common.utils.page.PageInfo;
import com.create80.rd.modules.projectmanager.entity.ProjectTemplateEntity;
import com.create80.rd.modules.projectmanager.api.model.ProjectTemplate;

/**
 * 项目模板Controller
 *
 * @author yzx
 * @version 2018-05-30
 */
@Controller
@RequestMapping(value = "${adminPath}/projectmanager/projectTemplate")
public class ProjectTemplateViewController extends BaseController {

  @Autowired
  private RestTemplate restTemplate;

  @ModelAttribute
  public ProjectTemplateEntity get(@RequestParam(required = false) String id) {

    ProjectTemplateEntity entity = new ProjectTemplateEntity();
    if (StringUtils.isNotBlank(id)) {
      String apiBaseUrl = moduleLinkConfiguration.getLink("projectmanager");
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("id", id);
      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/projectmanager/projectTemplate/api/{id}", String.class,
              urlVariables);

      String type = responseEntity.getBody();
      entity = JsonUtils.toSimpleObject(type, ProjectTemplateEntity.class);
    }
    return entity;
  }

  @RequiresPermissions("projectmanager:projectTemplate:view")
  @RequestMapping(value = {"list", ""})
  public String list(ProjectTemplateEntity projectTemplate, HttpServletRequest request,
      HttpServletResponse response, Model model) {

    Page<ProjectTemplate> page = new Page<>(request, response);
    ProjectTemplate type = JsonUtils
        .toSimpleObject(JsonUtils.toJson(projectTemplate), ProjectTemplate.class);

    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("pageNum", page.getPageNo());
    urlVariables.put("pageSize", page.getPageSize());

    String apiBaseUrl = moduleLinkConfiguration.getLink("projectmanager");
    ResponseEntity<String> pageResponseEntity = restTemplate
        .postForEntity(
            apiBaseUrl
                + "/projectmanager/projectTemplate/api/list?pageNum={pageNum}&&pageSize={pageSize}",
            type, String.class, urlVariables);

    PageInfo<ProjectTemplate> projectTemplatePageInfo = JsonUtils
        .fromJson(pageResponseEntity.getBody(), PageInfo.class, ProjectTemplate.class);

    page.setCount(projectTemplatePageInfo.getTotal());
    page.setPageNo(projectTemplatePageInfo.getPageNum());
    page.setList(projectTemplatePageInfo.getList());
    model.addAttribute("page", page);
    model.addAttribute("projectTemplate", projectTemplate);

    return "modules/projectmanager/projectTemplateList";
  }

  @RequiresPermissions("projectmanager:projectTemplate:view")
  @RequestMapping(value = "form")
  public String form(ProjectTemplateEntity projectTemplate, Model model) {
    model.addAttribute("projectTemplate", projectTemplate);
    return "modules/projectmanager/projectTemplateForm";
  }

  @RequiresPermissions("projectmanager:projectTemplate:edit")
  @RequestMapping(value = "save")
  public String save(ProjectTemplateEntity projectTemplate, Model model,
      RedirectAttributes redirectAttributes) {
    if (!beanValidator(model, projectTemplate)) {
      return form(projectTemplate, model);
    }

    ProjectTemplate type = resolveBeanProperties(StringUtils.isEmpty(projectTemplate.getId()),
        projectTemplate);
    String apiBaseUrl = moduleLinkConfiguration.getLink("projectmanager");

    restTemplate
        .postForObject(apiBaseUrl + "/projectmanager/projectTemplate/api/save", type, String.class);
    addMessage(redirectAttributes, "保存项目模板成功");

    return "redirect:" + Global.getAdminPath() + "/projectmanager/projectTemplate/?repage";
  }

  @RequiresPermissions("projectmanager:projectTemplate:edit")
  @RequestMapping(value = "delete")
  public String delete(ProjectTemplateEntity projectTemplate,
      RedirectAttributes redirectAttributes) {

    String apiBaseUrl = moduleLinkConfiguration.getLink("projectmanager");

    ProjectTemplate type = new ProjectTemplate();
    BeanUtils.copyProperties(projectTemplate, type);
    restTemplate.postForEntity(apiBaseUrl + "/projectmanager/projectTemplate/api/delete", type,
        String.class);

    addMessage(redirectAttributes, "删除项目模板成功");
    return "redirect:" + Global.getAdminPath() + "/projectmanager/projectTemplate/?repage";
  }

  /**
   * 模板应用
   */
  @RequiresPermissions("projectmanager:projectTemplate:edit")
  @RequestMapping(value = "/apply")
  public String apply(ProjectTemplateEntity projectTemplate,
      RedirectAttributes redirectAttributes) {
    String apiBaseUrl = moduleLinkConfiguration.getLink("projectmanager");
    ProjectTemplate type = new ProjectTemplate();
    BeanUtils.copyProperties(projectTemplate, type);
    restTemplate.postForEntity(apiBaseUrl + "/projectmanager/projectTemplate/api/apply", type,
        String.class);
    addMessage(redirectAttributes, "应用项目模板成功");
    return "redirect:" + Global.getAdminPath() + "/projectmanager/projectTemplate/?repage";
  }


  /**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private ProjectTemplate resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    ProjectTemplate projectTemplate = JsonUtils
        .toSimpleObject(JsonUtils.toJson(source), ProjectTemplate.class);
    Date now = new Date();
    if (isNewRecord) {
      projectTemplate.setInsertTime(now);
      projectTemplate.setInsertBy(user.getName());
    }
    projectTemplate.setUpdateBy(user.getName());
    projectTemplate.setUpdateTime(now);
    return projectTemplate;
  }

}