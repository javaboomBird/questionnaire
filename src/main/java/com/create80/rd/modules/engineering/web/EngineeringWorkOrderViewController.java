/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.engineering.web;

import com.create80.rd.modules.customer.customer.web.CustomerEnterpriseViewController;
import com.create80.rd.modules.group.web.SysGroupViewController;
import com.create80.rd.modules.projectmanager.web.ProjectViewController;
import com.create80.rd.modules.sys.utils.DictUtils;
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
import org.springframework.web.bind.annotation.RequestParam;
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
import com.create80.rd.modules.engineering.entity.EngineeringWorkOrderEntity;
import com.create80.rd.modules.engineering.api.model.EngineeringWorkOrder;

/**
 * 工单管理Controller
 *
 * @author yzx
 * @version 2018-06-21
 */
@Controller
@RequestMapping(value = "${adminPath}/engineering/engineeringWorkOrder")
public class EngineeringWorkOrderViewController extends BaseController {

  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private CustomerEnterpriseViewController customerEnterpriseViewController;

  @Autowired
  private ProjectViewController projectViewController;

  @Autowired
  private SysGroupViewController sysGroupViewController;

  @ModelAttribute
  public EngineeringWorkOrderEntity get(@RequestParam(required = false) String id) {

    EngineeringWorkOrderEntity entity = new EngineeringWorkOrderEntity();
    if (StringUtils.isNotBlank(id)) {
      String apiBaseUrl = moduleLinkConfiguration.getLink("engineering");
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("id", id);
      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/engineering/engineeringWorkOrder/api/{id}", String.class,
              urlVariables);

      String type = responseEntity.getBody();
      entity = JsonUtils.toSimpleObject(type, EngineeringWorkOrderEntity.class);
    }
    return entity;
  }

  @RequiresPermissions("engineering:engineeringWorkOrder:view")
  @RequestMapping(value = {"list", ""})
  public String list(EngineeringWorkOrderEntity engineeringWorkOrder, HttpServletRequest request,
      HttpServletResponse response, Model model) {
    Page<EngineeringWorkOrderEntity> page = new Page<>(request, response);
    engineeringWorkOrder.setSponsorId(UserUtils.getUser().getId());

    PageInfo<EngineeringWorkOrderEntity> engineeringWorkOrderPageInfo = getPageInfoEngineeringWorkOrder(
        engineeringWorkOrder, page.getPageNo(), page.getPageSize());

    page.setCount(engineeringWorkOrderPageInfo.getTotal());
    page.setPageNo(engineeringWorkOrderPageInfo.getPageNum());
    page.setList(engineeringWorkOrderPageInfo.getList());
    model.addAttribute("page", page);
    model.addAttribute("engineeringWorkOrder", engineeringWorkOrder);
    return "modules/engineering/engineeringWorkOrderList";
  }

  public PageInfo<EngineeringWorkOrderEntity> getPageInfoEngineeringWorkOrder(
      EngineeringWorkOrderEntity engineeringWorkOrder,
      int pageNum, int pageSize) {
    PageInfo<EngineeringWorkOrderEntity> engineeringWorkOrderPageInfo = new PageInfo<>();
    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("pageNum", pageNum);
    urlVariables.put("pageSize", pageSize);
    String apiBaseUrl = moduleLinkConfiguration.getLink("engineering");

    List<EngineeringWorkOrderEntity> engineeringWorkOrderEntityList = new ArrayList<>();
    try {
      EngineeringWorkOrder type = JsonUtils
          .toSimpleObject(JsonUtils.toJson(engineeringWorkOrder), EngineeringWorkOrder.class);

      ResponseEntity<String> pageResponseEntity = restTemplate
          .postForEntity(
              apiBaseUrl
                  + "/engineering/engineeringWorkOrder/api/list?pageNum={pageNum}&&pageSize={pageSize}",
              type, String.class, urlVariables);

      engineeringWorkOrderPageInfo = JsonUtils
          .fromJson(pageResponseEntity.getBody(), PageInfo.class, EngineeringWorkOrderEntity.class);

      if (engineeringWorkOrderPageInfo != null) {
        engineeringWorkOrderEntityList = engineeringWorkOrderPageInfo
            .getList();
      }
    } catch (RestClientException e) {
      e.printStackTrace();
    }

    if (engineeringWorkOrderEntityList != null) {
      engineeringWorkOrderEntityList.stream().forEach(engineeringWorkOrderEntity -> {
        engineeringWorkOrderEntity.setCustomer(
            customerEnterpriseViewController.get(engineeringWorkOrderEntity.getEnterpriseId()));

        engineeringWorkOrderEntity
            .setProject(projectViewController.get(engineeringWorkOrderEntity.getProjectId()));

        engineeringWorkOrderEntity
            .setSysGroup(sysGroupViewController.get(engineeringWorkOrderEntity.getTeamId()));
      });
    }
    return engineeringWorkOrderPageInfo;
  }

  @RequiresPermissions("engineering:engineeringWorkOrder:view")
  @RequestMapping(value = "form")
  public String form(EngineeringWorkOrderEntity engineeringWorkOrder, Model model) {
    model.addAttribute("engineeringWorkOrder", engineeringWorkOrder);
    return "modules/engineering/engineeringWorkOrderForm";
  }

  @RequiresPermissions("engineering:engineeringWorkOrder:edit")
  @RequestMapping(value = "save")
  public String save(EngineeringWorkOrderEntity engineeringWorkOrder, Model model,
      RedirectAttributes redirectAttributes) {
    if (!beanValidator(model, engineeringWorkOrder)) {
      return form(engineeringWorkOrder, model);
    }
    engineeringWorkOrder.setStatus("YTJ");
    engineeringWorkOrder.setSponsorId(UserUtils.getUser().getId());
    updateEngineeringInfo(engineeringWorkOrder);
    addMessage(redirectAttributes, "保存工单管理成功");

    return "redirect:" + Global.getAdminPath() + "/engineering/engineeringWorkOrder/?repage";
  }

  public void updateEngineeringInfo(EngineeringWorkOrderEntity engineeringWorkOrder) {

    EngineeringWorkOrder type = resolveBeanProperties(
        StringUtils.isEmpty(engineeringWorkOrder.getId()), engineeringWorkOrder);
    if (type == null) {
      logger.warn("resolveBeanProperties result is null ......");
      return;
    }
    String apiBaseUrl = moduleLinkConfiguration.getLink("engineering");
    try {
      restTemplate.postForObject(apiBaseUrl + "/engineering/engineeringWorkOrder/api/save", type,
          String.class);
    } catch (RestClientException e) {
      e.printStackTrace();
    }
  }

  @RequiresPermissions("engineering:engineeringWorkOrder:edit")
  @RequestMapping(value = "delete")
  public String delete(EngineeringWorkOrderEntity engineeringWorkOrder,
      RedirectAttributes redirectAttributes) {

    String apiBaseUrl = moduleLinkConfiguration.getLink("engineering");

    EngineeringWorkOrder type = new EngineeringWorkOrder();
    BeanUtils.copyProperties(engineeringWorkOrder, type);
    restTemplate.postForEntity(apiBaseUrl + "/engineering/engineeringWorkOrder/api/delete", type,
        String.class);

    addMessage(redirectAttributes, "删除工单管理成功");
    return "redirect:" + Global.getAdminPath() + "/engineering/engineeringWorkOrder/?repage";
  }

  /**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  public EngineeringWorkOrder resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    EngineeringWorkOrder engineeringWorkOrder = null;
    try {
      engineeringWorkOrder = JsonUtils
          .toSimpleObject(JsonUtils.toJson(source), EngineeringWorkOrder.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    Date now = new Date();
    if (isNewRecord) {
      engineeringWorkOrder.setInsertTime(now);
      engineeringWorkOrder.setInsertBy(user.getName());
    }
    engineeringWorkOrder.setUpdateBy(user.getName());
    engineeringWorkOrder.setUpdateTime(now);
    return engineeringWorkOrder;
  }

}