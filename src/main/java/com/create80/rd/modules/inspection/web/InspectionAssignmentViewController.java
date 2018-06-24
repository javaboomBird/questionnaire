/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.inspection.web;

import com.create80.rd.common.utils.DateUtils;
import com.create80.rd.modules.assets.api.model.AssetsManager;
import com.create80.rd.modules.assets.entity.AssetsManagerEntity;
import com.create80.rd.modules.assets.web.AssetsManagerViewController;

import com.create80.rd.modules.customer.customer.entity.CustomerEntity;
import com.create80.rd.modules.customer.customer.web.CustomerEnterpriseViewController;
import com.create80.rd.modules.group.api.model.SysGroup;
import com.create80.rd.modules.group.web.SysGroupViewController;
import com.create80.rd.modules.inspection.api.model.InspectionAssignment;
import com.create80.rd.modules.inspection.entity.ZTreeNode;
import com.create80.rd.modules.sys.entity.User;
import com.create80.rd.modules.sys.utils.UserUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.client.RestTemplate;

import com.create80.rd.common.utils.JsonUtils;
import com.create80.rd.common.config.Global;
import com.create80.rd.common.persistence.Page;
import com.create80.rd.common.web.BaseController;
import com.create80.rd.common.utils.StringUtils;
import com.create80.rd.common.utils.page.PageInfo;
import com.create80.rd.modules.inspection.entity.InspectionAssignmentEntity;

/**
 * 巡检分配Controller
 *
 * @author yzx
 * @version 2018-06-13
 */
@Controller
@RequestMapping(value = "${adminPath}/inspection/inspectionAssignment")
public class InspectionAssignmentViewController extends BaseController {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private CustomerEnterpriseViewController customerEnterpriseViewController;

  @Autowired
  private AssetsManagerViewController assetsManagerViewController;

  @Autowired
  private SysGroupViewController sysGroupViewController;

  @ModelAttribute
  public InspectionAssignmentEntity get(
      @RequestParam(required = false, value = "teamId") String id, Model model) {

    InspectionAssignmentEntity entity = new InspectionAssignmentEntity();
    if (StringUtils.isNotBlank(id)) {
      List<InspectionAssignmentEntity> inspectionAssignmentEntityList = getInspectionAssignmentEntities(
          id);
      if (inspectionAssignmentEntityList != null && inspectionAssignmentEntityList.size() > 0) {
        entity = inspectionAssignmentEntityList.get(0);
      }
    }
    return entity;
  }

  /**
   * 获取巡检分配列表信息
   *
   * @param teamId 组ID
   */
  private List<InspectionAssignmentEntity> getInspectionAssignmentEntities(
      String teamId) {
    if (StringUtils.isEmpty(teamId)) {
      return new ArrayList<>();
    }
    String apiUrl = moduleLinkConfiguration.getLink("inspection");
    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("teamId", teamId);
    ResponseEntity<String> responseEntity = restTemplate
        .getForEntity(apiUrl + "/inspectionAssignment/team?teamId={teamId}",
            String.class, urlVariables);

    PageInfo<InspectionAssignmentEntity> inspectionAssignmentEntityPageInfo = JsonUtils
        .fromJson(responseEntity.getBody(), PageInfo.class, InspectionAssignmentEntity.class);

    return inspectionAssignmentEntityPageInfo
        .getList();
  }

  @RequiresPermissions("inspection:inspectionAssignment:view")
  @RequestMapping(value = {"list", ""})
  public String list(InspectionAssignmentEntity inspectionAssignment, HttpServletRequest request,
      HttpServletResponse response, Model model) {

    Page<InspectionAssignmentEntity> page = new Page<>(request, response);
    String apiUrl = moduleLinkConfiguration.getLink("inspection");
    Date inspectionMonth = inspectionAssignment.getInspectionMonth();
    if (inspectionMonth == null) {
      inspectionMonth = DateUtils.getFirstDayOfMonth(System.currentTimeMillis());
    }
    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("inspectionMonth", DateUtils.formatDate(inspectionMonth));
    urlVariables.put("teamId", inspectionAssignment.getTeamId());
    urlVariables.put("pageSize", page.getPageSize());
    urlVariables.put("pageNum", page.getPageNo());
    ResponseEntity<String> responseEntity = restTemplate
        .getForEntity(apiUrl + "/inspectionAssignment?inspectionMonth={inspectionMonth}&&teamId={teamId}",
            String.class, urlVariables);
    //
    PageInfo<InspectionAssignmentEntity> inspectionAssignmentPageInfo = JsonUtils
        .fromJson(responseEntity.getBody(), PageInfo.class, InspectionAssignmentEntity.class);

    List<InspectionAssignmentEntity> inspectionAssignmentEntityList = inspectionAssignmentPageInfo
        .getList();

    inspectionAssignmentEntityList.stream().forEach(inspectionAssignmentEntity -> {
      AssetsManagerEntity assetsManagerEntity = assetsManagerViewController
          .get(inspectionAssignmentEntity.getAssetId());
      assetsManagerEntity.setCustomer(customerEnterpriseViewController
          .get(assetsManagerEntity.getAssetsUseUnit()));
      inspectionAssignmentEntity
          .setSysGroup(sysGroupViewController.get(inspectionAssignmentEntity.getTeamId()));
      inspectionAssignmentEntity.setAssetsManager(assetsManagerEntity);

    });

    page.setCount(inspectionAssignmentPageInfo.getTotal());
    page.setPageNo(inspectionAssignmentPageInfo.getPageNum());
    page.setList(inspectionAssignmentEntityList);
    model.addAttribute("page", page);
    model.addAttribute("inspectionAssignment", inspectionAssignment);

    return "modules/inspection/inspectionAssignmentList";
  }

  @RequiresPermissions("inspection:inspectionAssignment:view")
  @RequestMapping(value = "form")
  public String form(InspectionAssignmentEntity inspectionAssignment, Model model) {
    model.addAttribute("inspectionAssignment", inspectionAssignment);

    //获取当前登入用户所在部门的分组信息
    List<SysGroup> sysUserGroupList = getSysGroups();
    //获取资产为数采仪企业列表
    List<ZTreeNode> zTreeNodeList = getzTreeNodes();
    //获取所有的资产ID
    if (StringUtils.isNotEmpty(inspectionAssignment.getTeamId())) {
      List<InspectionAssignmentEntity> inspectionAssignmentEntityList = getInspectionAssignmentEntities(
          inspectionAssignment.getTeamId());
      List<String> assetsIdList = inspectionAssignmentEntityList.stream()
          .map(inspectionAssignmentEntity -> inspectionAssignmentEntity.getAssetId())
          .collect(Collectors.toList());

      zTreeNodeList.stream().forEach(zTreeNode -> {
        if (assetsIdList.contains(zTreeNode.getId())) {
          zTreeNode.setChecked(true);
        }
      });
    }

    model.addAttribute("zTreeNoLis", JsonUtils.toJson(zTreeNodeList));
    model.addAttribute("sysUserGroupList", sysUserGroupList);
    return "modules/inspection/inspectionAssignmentForm";
  }

  /**
   * 获取企业树信息列表
   */
  private List<ZTreeNode> getzTreeNodes() {
    List<AssetsManager> assetsManagerList = getAssetsManager();
    return getzTreeNodes(assetsManagerList);
  }

  private List<ZTreeNode> getzTreeNodes(List<AssetsManager> assetsManagerList) {
    List<ZTreeNode> zTreeNoLis = new ArrayList<>();
    if (assetsManagerList != null) {
      //根据资产所在公司区域作为树的根节点
      List<String> areaIdList = new ArrayList<>();
      assetsManagerList.stream().forEach(assetsManager -> {
        CustomerEntity enterpriseEntity = customerEnterpriseViewController
            .get(assetsManager.getAssetsUseUnit());
        String areaId = enterpriseEntity.getAreaId();
        if (areaIdList.contains(areaId)) {
          ZTreeNode enterpriseTreeNode = new ZTreeNode(assetsManager.getId(), areaId,
              enterpriseEntity.getName(), false, false);
          zTreeNoLis.add(enterpriseTreeNode);
        } else {
          ZTreeNode areaTreeNode = new ZTreeNode(areaId, "-1",
              enterpriseEntity.getArea().getName(), false, false);
          zTreeNoLis.add(areaTreeNode);

          ZTreeNode enterpriseTreeNode = new ZTreeNode(assetsManager.getId(), areaId,
              enterpriseEntity.getName(), false, false);
          zTreeNoLis.add(enterpriseTreeNode);
          areaIdList.add(areaId);
        }
      });

    }
    return zTreeNoLis;
  }

  /**
   * 获取当前用户部门的组列表
   */
  private List<SysGroup> getSysGroups() {
    String officeId = UserUtils.getUser().getOffice().getId();
    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("officeId", officeId);
    urlVariables.put("groupType", "2");
    String apiBaseUrl = moduleLinkConfiguration.getLink("group");
    ResponseEntity<String> responseEntity = restTemplate
        .getForEntity(
            apiBaseUrl + "/group/sysGroup/api/getAll?officeId={officeId}&&groupType={groupType}",
            String.class, urlVariables);

    return JsonUtils
        .toListObject(responseEntity.getBody(), SysGroup.class);
  }

  private List<AssetsManager> getAssetsManager() {
    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("assetsType", "SCY");
    String apiBaseUrl = moduleLinkConfiguration.getLink("assets");
    ResponseEntity<String> responseEntity = restTemplate
        .getForEntity(
            apiBaseUrl + "/assets/assetsManager/api/getEnterpriseAll?assetsType={assetsType}",
            String.class, urlVariables);

    return JsonUtils
        .toListObject(responseEntity.getBody(), AssetsManager.class);
  }

  @RequiresPermissions("inspection:inspectionAssignment:edit")
  @RequestMapping(value = "save")
  public String save(InspectionAssignmentEntity inspectionAssignment, HttpServletRequest request,
      Model model,
      RedirectAttributes redirectAttributes) {
    if (!beanValidator(model, inspectionAssignment)) {
      return form(inspectionAssignment, model);
    }
    List<InspectionAssignment> inspectionAssignmentList = getInspectionAssignmentList(
        inspectionAssignment);

    String apiBaseUrl = moduleLinkConfiguration.getLink("inspection");
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> httpEntity = new HttpEntity<>(JsonUtils.toJson(inspectionAssignmentList),
        httpHeaders);
    restTemplate
        .postForEntity(apiBaseUrl + "/inspectionAssignment/batch", httpEntity, String.class);
    addMessage(redirectAttributes, "保存巡检分配成功");

    return "redirect:" + Global.getAdminPath() + "/inspection/inspectionAssignment/?repage";
  }

  private List<InspectionAssignment> getInspectionAssignmentList(
      InspectionAssignmentEntity inspectionAssignment) {
    List<InspectionAssignment> result = new ArrayList<>();
    if (inspectionAssignment == null || StringUtils.isEmpty(inspectionAssignment.getAssetId())) {
      return result;
    }

    String assetId = inspectionAssignment.getAssetId();
    String[] assetsIds = StringUtils.split(assetId, ",");
    for (String id : assetsIds) {
      InspectionAssignment assignment = new InspectionAssignment();
      assignment.setAssetId(id);
      assignment.setInspectionMonth(
          DateUtils.getFirstDayOfMonth(inspectionAssignment.getInspectionMonth().getTime()));
      assignment.setTeamId(inspectionAssignment.getTeamId());
      assignment.setInspectionTimes(inspectionAssignment.getInspectionTimes());
      result.add(assignment);
    }
    return result;
  }

  @RequiresPermissions("inspection:inspectionAssignment:edit")
  @RequestMapping(value = "delete")
  public String delete(InspectionAssignmentEntity inspectionAssignment,
      RedirectAttributes redirectAttributes) {

    return "redirect:" + Global.getAdminPath() + "/inspection/inspectionAssignment/?repage";
  }


  /**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private InspectionAssignment resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    InspectionAssignment inspectionAssignment = JsonUtils
        .toSimpleObject(JsonUtils.toJson(source), InspectionAssignment.class);
    Date now = new Date();
    if (isNewRecord) {
      inspectionAssignment.setInsertTime(now);
      inspectionAssignment.setInsertBy(user.getName());
    }
    inspectionAssignment.setUpdateBy(user.getName());
    inspectionAssignment.setUpdateTime(now);
    return inspectionAssignment;
  }

}