/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.assets.web;

import com.create80.rd.modules.assets.entity.AssetsManagerEntity;
import com.create80.rd.modules.customer.enterprise.entity.EnterpriseEntity;
import com.create80.rd.modules.sys.entity.Office;
import com.create80.rd.modules.sys.service.OfficeService;
import java.util.ArrayList;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
import com.create80.rd.modules.assets.entity.AssetsConnectionInfoEntity;
import com.create80.rd.modules.assets.api.model.AssetsConnectionInfo;

/**
 * 资产连接信息管理Controller
 *
 * @author yzx
 * @version 2018-06-07
 */
@Controller
@RequestMapping(value = "${adminPath}/assets/assetsConnectionInfo")
public class AssetsConnectionInfoViewController extends BaseController {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private OfficeService officeService;

  //临时存储
  private final static List<String> localThreadOfficeCache = new ArrayList<>();
  private final static List<String> localThreadEnterpriseCache = new ArrayList<>();

  @ModelAttribute
  public AssetsConnectionInfoEntity get(@RequestParam(required = false) String id, Model model) {

    AssetsConnectionInfoEntity entity = new AssetsConnectionInfoEntity();
    if (StringUtils.isNotBlank(id)) {
      String apiBaseUrl = moduleLinkConfiguration.getLink("assets");
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("id", id);
      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/assets/assetsConnectionInfo/api/{id}", String.class,
              urlVariables);

      String type = responseEntity.getBody();
      entity = JsonUtils.toSimpleObject(type, AssetsConnectionInfoEntity.class);

    }
    List<Map<String, Object>> resultList = new ArrayList<>();
    resultList = getAssetsManagerListByEnterpriseId(entity.getEnterpriseId());
    model.addAttribute("assetsListMap", resultList);
    return entity;
  }

  @RequiresPermissions("assets:assetsConnectionInfo:view")
  @RequestMapping(value = {"list", ""})
  public String list(AssetsConnectionInfoEntity assetsConnectionInfo, HttpServletRequest request,
      HttpServletResponse response, Model model) {

    Page<AssetsConnectionInfoEntity> page = new Page<>(request, response);
    AssetsConnectionInfo type = JsonUtils
        .toSimpleObject(JsonUtils.toJson(assetsConnectionInfo), AssetsConnectionInfo.class);

    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("pageNum", page.getPageNo());
    urlVariables.put("pageSize", page.getPageSize());

    String apiBaseUrl = moduleLinkConfiguration.getLink("assets");
    ResponseEntity<String> pageResponseEntity = restTemplate
        .postForEntity(
            apiBaseUrl
                + "/assets/assetsConnectionInfo/api/list?pageNum={pageNum}&&pageSize={pageSize}",
            type, String.class, urlVariables);

    PageInfo<AssetsConnectionInfoEntity> assetsConnectionInfoPageInfo = JsonUtils
        .fromJson(pageResponseEntity.getBody(), PageInfo.class, AssetsConnectionInfo.class);

    page.setCount(assetsConnectionInfoPageInfo.getTotal());
    page.setPageNo(assetsConnectionInfoPageInfo.getPageNum());
    page.setList(assetsConnectionInfoPageInfo.getList());
    model.addAttribute("page", page);
    model.addAttribute("assetsConnectionInfo", assetsConnectionInfo);

    return "modules/assets/assetsConnectionInfoList";
  }


  /**
   * 根据企业ID获取资产信息
   */
  @RequestMapping(value = "/getAssetsList")
  @ResponseBody
  public ResponseEntity<String> getAssetsList(
      @RequestParam(value = "assetsEnterpriseId", required = true) String assetsEnterpriseId) {
    List<Map<String, Object>> resultList = getAssetsManagerListByEnterpriseId(assetsEnterpriseId);
    String s = JsonUtils.toJson(resultList);
    return new ResponseEntity<>(s, HttpStatus.OK);
  }

  private List<Map<String, Object>> getAssetsManagerListByEnterpriseId(
      String assetsEnterpriseId) {
    List<Map<String, Object>> resultList = new ArrayList<>();

    if (StringUtils.isEmpty(assetsEnterpriseId)) {
      return resultList;
    }
    List<AssetsManagerEntity> assetsManagerEntityList = null;
    try {
      String apiBaseUrl = moduleLinkConfiguration.getLink("assets");
      Map<String, Object> urlVariableMap = new HashMap<>();
      urlVariableMap.put("paramValue", assetsEnterpriseId);
      if (localThreadEnterpriseCache.contains(assetsEnterpriseId)) {
        urlVariableMap.put("param", "assetsUseUnit");
      } else if (localThreadOfficeCache.contains(assetsEnterpriseId)) {
        urlVariableMap.put("param", "assetsUseDepartment");
      }

      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/assets/assetsManager/api/getAll?{param}={paramValue}",
              String.class, urlVariableMap);
      assetsManagerEntityList = JsonUtils
          .toListObject(responseEntity.getBody(), AssetsManagerEntity.class);
    } catch (RestClientException e) {
      e.printStackTrace();
    }

    if (assetsManagerEntityList != null) {
      assetsManagerEntityList.stream().forEach(assetsManagerEntity -> {
        Map<String, Object> entity = new HashMap<>();
        entity.put("id", assetsManagerEntity.getId());
        entity.put("text", assetsManagerEntity.getAssetsName());
        resultList.add(entity);
      });
    }
    return resultList;
  }

  @RequiresPermissions("assets:assetsConnectionInfo:view")
  @RequestMapping(value = "form")
  public String form(AssetsConnectionInfoEntity assetsConnectionInfo, Model model) {

    Map<String, Object> resultMap = new HashMap<>();

    /**
     * 目前只是针对企业用户,内部用户不包含
     */
//    officeService.findList(true).stream()
//        .filter(e -> "2".equals(e.getType())).forEach(office -> {
//      localThreadOfficeCache.add(office.getId());
//      resultMap.put(office.getId(), office.getName());
//    });

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
    if (enterpriseEntityList != null) {
      enterpriseEntityList.stream().forEach(enterpriseEntity -> {
        localThreadEnterpriseCache.add(enterpriseEntity.getId());
        resultMap.put(enterpriseEntity.getId(), enterpriseEntity.getEnterpriseName());
      });
    }
    model.addAttribute("enterpriseMap", resultMap);
    model.addAttribute("assetsConnectionInfo", assetsConnectionInfo);
    return "modules/assets/assetsConnectionInfoForm";
  }

  @RequiresPermissions("assets:assetsConnectionInfo:edit")
  @RequestMapping(value = "save")
  public String save(AssetsConnectionInfoEntity assetsConnectionInfo, Model model,
      RedirectAttributes redirectAttributes) {
    if (!beanValidator(model, assetsConnectionInfo)) {
      return form(assetsConnectionInfo, model);
    }

    AssetsConnectionInfo type = resolveBeanProperties(
        StringUtils.isEmpty(assetsConnectionInfo.getId()), assetsConnectionInfo);
    String apiBaseUrl = moduleLinkConfiguration.getLink("assets");

    restTemplate
        .postForObject(apiBaseUrl + "/assets/assetsConnectionInfo/api/save", type, String.class);
    addMessage(redirectAttributes, "保存资产连接信息管理成功");

    return "redirect:" + Global.getAdminPath() + "/assets/assetsConnectionInfo/?repage";
  }

  @RequiresPermissions("assets:assetsConnectionInfo:edit")
  @RequestMapping(value = "delete")
  public String delete(AssetsConnectionInfoEntity assetsConnectionInfo,
      RedirectAttributes redirectAttributes) {

    String apiBaseUrl = moduleLinkConfiguration.getLink("assets");

    AssetsConnectionInfo type = new AssetsConnectionInfo();
    BeanUtils.copyProperties(assetsConnectionInfo, type);
    restTemplate
        .postForEntity(apiBaseUrl + "/assets/assetsConnectionInfo/api/delete", type, String.class);

    addMessage(redirectAttributes, "删除资产连接信息管理成功");
    return "redirect:" + Global.getAdminPath() + "/assets/assetsConnectionInfo/?repage";
  }

  /**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private AssetsConnectionInfo resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    AssetsConnectionInfo assetsConnectionInfo = JsonUtils
        .toSimpleObject(JsonUtils.toJson(source), AssetsConnectionInfo.class);
    Date now = new Date();
    if (isNewRecord) {
      assetsConnectionInfo.setCreateDate(now);
      assetsConnectionInfo.setCreateBy(user.getName());
    }
    assetsConnectionInfo.setUpdateBy(user.getName());
    assetsConnectionInfo.setUpdateDate(now);
    return assetsConnectionInfo;
  }

}