/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.assets.web;

import com.create80.rd.modules.customer.enterprise.entity.EnterpriseEntity;
import com.create80.rd.modules.sys.entity.Office;
import com.create80.rd.modules.sys.service.OfficeService;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Date;
import java.util.stream.Collectors;
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

import com.create80.rd.modules.sys.entity.User;
import com.create80.rd.modules.sys.utils.UserUtils;
import com.create80.rd.common.config.Global;
import com.create80.rd.common.persistence.Page;
import com.create80.rd.common.web.BaseController;
import com.create80.rd.common.utils.StringUtils;
import com.create80.rd.common.utils.JsonUtils;
import com.create80.rd.common.utils.DateUtils;
import com.create80.rd.common.utils.page.PageInfo;

import com.create80.rd.modules.assets.entity.AssetsManagerEntity;
import com.create80.rd.modules.assets.api.model.AssetsManager;

import com.create80.rd.modules.sys.service.UserService;

/**
 * 资产管理Controller
 *
 * @author yzx
 * @version 2018-06-05
 */
@Controller
@RequestMapping(value = "${adminPath}/assets/assetsManager")
public class AssetsManagerViewController extends BaseController {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private OfficeService officeService;

  @Autowired
  private UserService userService;

  @ModelAttribute
  public AssetsManagerEntity get(@RequestParam(required = false) String id) {

    AssetsManagerEntity entity = new AssetsManagerEntity();
    if (StringUtils.isNotBlank(id)) {
      String apiBaseUrl = moduleLinkConfiguration.getLink("assets");
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("id", id);
      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/assets/assetsManager/api/{id}", String.class,
              urlVariables);

      entity = JsonUtils.toSimpleObject(responseEntity.getBody(), AssetsManagerEntity.class);

      entity.setManager(userService.get(entity.getManagerId()));
    }
    return entity;
  }

  @RequiresPermissions("assets:assetsManager:view")
  @RequestMapping(value = {"list", ""})
  public String list(AssetsManagerEntity assetsManager, HttpServletRequest request,
      HttpServletResponse response, Model model) {

    Page<AssetsManagerEntity> page = new Page<>(request, response);
    AssetsManager type = JsonUtils
        .toSimpleObject(JsonUtils.toJson(assetsManager), AssetsManager.class);

    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("pageNum", page.getPageNo());
    urlVariables.put("pageSize", page.getPageSize());

    String apiBaseUrl = moduleLinkConfiguration.getLink("assets");
    ResponseEntity<String> pageResponseEntity = restTemplate
        .postForEntity(
            apiBaseUrl + "/assets/assetsManager/api/list?pageNum={pageNum}&&pageSize={pageSize}",
            type, String.class, urlVariables);

    PageInfo<AssetsManagerEntity> assetsManagerPageInfo = JsonUtils
        .fromJson(pageResponseEntity.getBody(), PageInfo.class, AssetsManagerEntity.class);

    List<AssetsManagerEntity> assetsManagerEntityList = assetsManagerPageInfo.getList();
    if (assetsManagerEntityList != null && assetsManagerEntityList.size() > 0) {
      assetsManagerEntityList.stream().forEach(assetsManagerEntity -> {
        assetsManagerEntity.setManager(userService.get(assetsManagerEntity.getManagerId()));
        //资产性质如果是内部则设置assetsUseDepartment，assetsUseUnit,如果是其他则设置assetsUseUnit
        if ("1".equals(assetsManagerEntity.getAssetsNature())) {
          Office dept = officeService.get(assetsManagerEntity.getAssetsUseDepartment());
          assetsManagerEntity.setAssetsUseDepartment(dept == null ? "" : dept.getName());
          Office unit = officeService.get(assetsManagerEntity.getAssetsUseUnit());
          assetsManagerEntity.setAssetsUseUnit(unit == null ? "" : unit.getName());
        } else {

          try {
            if (StringUtils.isNotEmpty(assetsManagerEntity.getAssetsUseUnit())) {
              String customerApiBaseUrl = moduleLinkConfiguration.getLink("customer");
              Map<String, Object> paramMap = new HashMap<>();
              paramMap.put("id", assetsManagerEntity.getAssetsUseUnit());
              ResponseEntity<String> responseEntity = restTemplate
                  .getForEntity(customerApiBaseUrl + "/enterprise/enterprise/api/{id}",
                      String.class,
                      paramMap);
              EnterpriseEntity entity = JsonUtils
                  .toSimpleObject(responseEntity.getBody(), EnterpriseEntity.class);
              assetsManagerEntity.setAssetsUseDepartment("");//清空显示
              assetsManagerEntity.setAssetsUseUnit(entity.getEnterpriseName());
            }
          } catch (Exception e) {
            e.printStackTrace();
          }

        }
      });
    }
    page.setCount(assetsManagerPageInfo.getTotal());
    page.setPageNo(assetsManagerPageInfo.getPageNum());
    page.setList(assetsManagerEntityList);
    model.addAttribute("page", page);
    model.addAttribute("assetsManager", assetsManager);

    return "modules/assets/assetsManagerList";
  }

  @RequiresPermissions("assets:assetsManager:view")
  @RequestMapping(value = "form")
  public String form(AssetsManagerEntity assetsManager, Model model) {

    //获取内部所有的部门信息列表

    List<Office> allOfficeList = officeService.findList(true).stream()
        .filter(e -> "2".equals(e.getType())).collect(Collectors.toList());

    //获取客户信息列表
    List<EnterpriseEntity> enterpriseEntityList = null;
    try {
      String apiBaseUrl = moduleLinkConfiguration.getLink("customer");
      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/enterprise/enterprise/api/getAll", String.class);
      enterpriseEntityList = JsonUtils
          .toListObject(responseEntity.getBody(), EnterpriseEntity.class);
    } catch (RestClientException e) {
      e.printStackTrace();
    }

    model.addAttribute("enterpriseEntityList", enterpriseEntityList);
    model.addAttribute("allOfficeList", allOfficeList);
    model.addAttribute("assetsManager", assetsManager);
    return "modules/assets/assetsManagerForm";
  }

  @RequiresPermissions("assets:assetsManager:edit")
  @RequestMapping(value = "save")
  public String save(AssetsManagerEntity assetsManager, Model model,
      RedirectAttributes redirectAttributes) {
    if (!beanValidator(model, assetsManager)) {
      return form(assetsManager, model);
    }
    //如果是车辆类型则验证车牌号是否填写
    if ("CAR".equalsIgnoreCase(assetsManager.getAssetsType())) {
      if (StringUtils.isEmpty(assetsManager.getPlateNumber())) {
        addMessage(model, "资产类型为车辆,车牌号必须填写.");
        return form(assetsManager, model);
      }
    }

    //资产性质如果是内部则设置assetsUseUnit
    if ("1".equals(assetsManager.getAssetsNature())) {
      Office dept = officeService.get(assetsManager.getAssetsUseDepartment());
      assetsManager.setAssetsUseUnit(dept.getParentId());
    }

    AssetsManager type = resolveBeanProperties(StringUtils.isEmpty(assetsManager.getId()),
        assetsManager);
    String apiBaseUrl = moduleLinkConfiguration.getLink("assets");

    restTemplate.postForObject(apiBaseUrl + "/assets/assetsManager/api/save", type, String.class);
    addMessage(redirectAttributes, "保存资产管理成功");

    return "redirect:" + Global.getAdminPath() + "/assets/assetsManager/?repage";
  }

  @RequiresPermissions("assets:assetsManager:edit")
  @RequestMapping(value = "delete")
  public String delete(AssetsManagerEntity assetsManager, RedirectAttributes redirectAttributes) {

    String apiBaseUrl = moduleLinkConfiguration.getLink("assets");

    AssetsManager type = new AssetsManager();
    BeanUtils.copyProperties(assetsManager, type);
    restTemplate.postForEntity(apiBaseUrl + "/assets/assetsManager/api/delete", type, String.class);

    addMessage(redirectAttributes, "删除资产管理成功");
    return "redirect:" + Global.getAdminPath() + "/assets/assetsManager/?repage";
  }

  /**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private AssetsManager resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    AssetsManager assetsManager = JsonUtils
        .toSimpleObject(JsonUtils.toJson(source), AssetsManager.class);
    Date now = DateUtils.getNow();
    if (isNewRecord) {
      assetsManager.setCreateDate(now);
      assetsManager.setCreateBy(user.getName());
    }
    assetsManager.setUpdateBy(user.getName());
    assetsManager.setUpdateDate(now);
    return assetsManager;
  }

}