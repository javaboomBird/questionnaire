/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.engineering.web;

import com.create80.rd.modules.customer.customer.web.CustomerEnterpriseViewController;
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
import com.create80.rd.modules.engineering.entity.EngineeringSurveyImgEntity;
import com.create80.rd.modules.engineering.api.model.EngineeringSurveyImg;

/**
 * 勘察图片Controller
 *
 * @author yzx
 * @version 2018-06-27
 */
@Controller
@RequestMapping(value = "${adminPath}/engineering/engineeringSurveyImg")
public class EngineeringSurveyImgViewController extends BaseController {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private CustomerEnterpriseViewController customerEnterpriseViewController;

  @Autowired
  private EngineeringWorkOrderViewController engineeringWorkOrderViewController;

  @ModelAttribute
  public EngineeringSurveyImgEntity get(@RequestParam(required = false) String id) {

    EngineeringSurveyImgEntity entity = new EngineeringSurveyImgEntity();
    if (StringUtils.isNotBlank(id)) {
      String apiBaseUrl = moduleLinkConfiguration.getLink("engineering");
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("id", id);
      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/engineering/engineeringSurveyImg/api/{id}", String.class,
              urlVariables);

      String type = responseEntity.getBody();
      entity = JsonUtils.toSimpleObject(type, EngineeringSurveyImgEntity.class);
      setEntity(entity);
    }
    return entity;
  }

  @RequiresPermissions("engineering:engineeringSurveyImg:view")
  @RequestMapping(value = {"list", ""})
  public String list(EngineeringSurveyImgEntity engineeringSurveyImg, HttpServletRequest request,
      HttpServletResponse response, Model model) {

    Page<EngineeringSurveyImgEntity> page = new Page<>(request, response);
    EngineeringSurveyImg type = JsonUtils
        .toSimpleObject(JsonUtils.toJson(engineeringSurveyImg), EngineeringSurveyImg.class);

    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("pageNum", page.getPageNo());
    urlVariables.put("pageSize", page.getPageSize());

    String apiBaseUrl = moduleLinkConfiguration.getLink("engineering");
    ResponseEntity<String> pageResponseEntity = restTemplate
        .postForEntity(
            apiBaseUrl
                + "/engineering/engineeringSurveyImg/api/list?pageNum={pageNum}&&pageSize={pageSize}",
            type, String.class, urlVariables);

    PageInfo<EngineeringSurveyImgEntity> engineeringSurveyImgPageInfo = JsonUtils
        .fromJson(pageResponseEntity.getBody(), PageInfo.class, EngineeringSurveyImgEntity.class);

    List<EngineeringSurveyImgEntity> engineeringSurveyImgEntityList = engineeringSurveyImgPageInfo
        .getList();
    if (engineeringSurveyImgEntityList != null) {
      engineeringSurveyImgEntityList.stream().forEach(engineeringSurveyImgEntity -> {
        setEntity(engineeringSurveyImgEntity);

      });
    }
    page.setCount(engineeringSurveyImgPageInfo.getTotal());
    page.setPageNo(engineeringSurveyImgPageInfo.getPageNum());
    page.setList(engineeringSurveyImgEntityList);
    model.addAttribute("page", page);
    model.addAttribute("engineeringSurveyImg", engineeringSurveyImg);

    return "modules/engineering/engineeringSurveyImgList";
  }


  private void setEntity(EngineeringSurveyImgEntity engineeringSurveyImgEntity) {
    if (engineeringSurveyImgEntity != null) {
      engineeringSurveyImgEntity.setCustomer(
          customerEnterpriseViewController.get(engineeringSurveyImgEntity.getCustomerId()));

      engineeringSurveyImgEntity.setEngineeringWorkOrder(
          engineeringWorkOrderViewController.get(engineeringSurveyImgEntity.getEngineeringId()));
    }

  }

  @RequiresPermissions("engineering:engineeringSurveyImg:view")
  @RequestMapping(value = "form")
  public String form(EngineeringSurveyImgEntity engineeringSurveyImg, Model model) {
    model.addAttribute("engineeringSurveyImg", engineeringSurveyImg);
    return "modules/engineering/engineeringSurveyImgForm";
  }

  @RequiresPermissions("engineering:engineeringSurveyImg:edit")
  @RequestMapping(value = "save")
  public String save(EngineeringSurveyImgEntity engineeringSurveyImg, Model model,
      RedirectAttributes redirectAttributes) {
    if (!beanValidator(model, engineeringSurveyImg)) {
      return form(engineeringSurveyImg, model);
    }

    engineeringSurveyImg.setUploadTime(new Date());
    engineeringSurveyImg.setUploadBy(UserUtils.getUser().getId());

    EngineeringSurveyImg type = resolveBeanProperties(
        StringUtils.isEmpty(engineeringSurveyImg.getId()), engineeringSurveyImg);
    String apiBaseUrl = moduleLinkConfiguration.getLink("engineering");

    restTemplate.postForObject(apiBaseUrl + "/engineering/engineeringSurveyImg/api/save", type,
        String.class);
    addMessage(redirectAttributes, "保存勘察图片成功");

    return "redirect:" + Global.getAdminPath() + "/engineering/engineeringSurveyImg/?repage";
  }

  @RequiresPermissions("engineering:engineeringSurveyImg:edit")
  @RequestMapping(value = "delete")
  public String delete(EngineeringSurveyImgEntity engineeringSurveyImg,
      RedirectAttributes redirectAttributes) {

    String apiBaseUrl = moduleLinkConfiguration.getLink("engineering");

    EngineeringSurveyImg type = new EngineeringSurveyImg();
    BeanUtils.copyProperties(engineeringSurveyImg, type);
    restTemplate.postForEntity(apiBaseUrl + "/engineering/engineeringSurveyImg/api/delete", type,
        String.class);

    addMessage(redirectAttributes, "删除勘察图片成功");
    return "redirect:" + Global.getAdminPath() + "/engineering/engineeringSurveyImg/?repage";
  }

  /**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private EngineeringSurveyImg resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    EngineeringSurveyImg engineeringSurveyImg = JsonUtils
        .toSimpleObject(JsonUtils.toJson(source), EngineeringSurveyImg.class);
    Date now = new Date();
    if (isNewRecord) {
      engineeringSurveyImg.setInsertTime(now);
      engineeringSurveyImg.setInsertBy(user.getName());
    }
    engineeringSurveyImg.setUpdateBy(user.getName());
    engineeringSurveyImg.setUpdateTime(now);
    return engineeringSurveyImg;
  }

}