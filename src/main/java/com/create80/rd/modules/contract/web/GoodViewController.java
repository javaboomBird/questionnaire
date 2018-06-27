/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.contract.web;

import com.create80.rd.common.config.Global;
import com.create80.rd.common.persistence.Page;
import com.create80.rd.common.utils.DateUtils;
import com.create80.rd.common.utils.JsonUtils;
import com.create80.rd.common.utils.StringUtils;
import com.create80.rd.common.utils.page.PageInfo;
import com.create80.rd.common.web.BaseController;
import com.create80.rd.modules.contract.api.model.Good;
import com.create80.rd.modules.contract.entity.GoodEntity;
import com.create80.rd.modules.sys.entity.User;
import com.create80.rd.modules.sys.utils.UserUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * 合同商品管理Controller
 *
 * @author lzp
 * @version 2018-06-12
 */
@Controller
@RequestMapping(value = "${adminPath}/contract/good")
public class GoodViewController extends BaseController {

  @Autowired
  private RestTemplate restTemplate;


  @ResponseBody
  @RequestMapping(method = RequestMethod.GET, value = "getById")
  public GoodEntity getById(String id) {
    return get(id);
  }

  @ModelAttribute
  public GoodEntity get(@RequestParam(required = false) String id) {

    GoodEntity entity = new GoodEntity();
    if (StringUtils.isNotBlank(id)) {
      String apiBaseUrl = moduleLinkConfiguration.getLink("contract");
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("id", id);
      ResponseEntity<String> responseEntity = restTemplate
          .getForEntity(apiBaseUrl + "/contract/good/api/{id}", String.class,
              urlVariables);

      entity = JsonUtils.toSimpleObject(responseEntity.getBody(), GoodEntity.class);

    }
    return entity;
  }

  @RequiresPermissions("contract:good:view")
  @RequestMapping(value = {"list", ""})
  public String list(GoodEntity good, HttpServletRequest request, HttpServletResponse response,
      Model model) {

    Page<GoodEntity> page = new Page<>(request, response);
    Good type = JsonUtils
        .toSimpleObject(JsonUtils.toJson(good), Good.class);

    Map<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("pageNum", page.getPageNo());
    urlVariables.put("pageSize", page.getPageSize());

    String apiBaseUrl = moduleLinkConfiguration.getLink("contract");
    ResponseEntity<String> pageResponseEntity = restTemplate
        .postForEntity(
            apiBaseUrl + "/contract/good/api/list?pageNum={pageNum}&&pageSize={pageSize}",
            type, String.class, urlVariables);

    PageInfo<GoodEntity> goodPageInfo = JsonUtils
        .fromJson(pageResponseEntity.getBody(), PageInfo.class, GoodEntity.class);

    page.setCount(goodPageInfo.getTotal());
    page.setPageNo(goodPageInfo.getPageNum());
    page.setList(goodPageInfo.getList());
    model.addAttribute("page", page);
    model.addAttribute("good", good);

    return "modules/contract/goodList";
  }

  @RequiresPermissions("contract:good:view")
  @RequestMapping(value = "form")
  public String form(GoodEntity good, Model model) {
    model.addAttribute("good", good);
    return "modules/contract/goodForm";
  }

  @RequestMapping(value = "formView")
  public String formView(GoodEntity good, Model model) {
    model.addAttribute("good", good);
    return "modules/contract/goodFormView";
  }

  @RequiresPermissions("contract:good:edit")
  @RequestMapping(value = "save")
  public String save(GoodEntity good, Model model, RedirectAttributes redirectAttributes) {
    if (!beanValidator(model, good)) {
      return form(good, model);
    }

    Good type = resolveBeanProperties(StringUtils.isEmpty(good.getId()), good);
    String apiBaseUrl = moduleLinkConfiguration.getLink("contract");

    restTemplate.postForObject(apiBaseUrl + "/contract/good/api/save", type, String.class);
    addMessage(redirectAttributes, "保存合同商品成功");

    return "redirect:" + Global.getAdminPath() + "/contract/good/?repage";
  }

  @RequiresPermissions("contract:good:edit")
  @RequestMapping(value = "delete")
  public String delete(GoodEntity good, RedirectAttributes redirectAttributes) {

    String apiBaseUrl = moduleLinkConfiguration.getLink("contract");

    Good type = new Good();
    BeanUtils.copyProperties(good, type);
    restTemplate.postForEntity(apiBaseUrl + "/contract/good/api/delete", type, String.class);

    addMessage(redirectAttributes, "删除合同商品成功");
    return "redirect:" + Global.getAdminPath() + "/contract/good/?repage";
  }

  /**
   * @param isNewRecord 是否为新记录
   * @param source 源对象
   */
  private Good resolveBeanProperties(boolean isNewRecord, Object source) {
    User user = UserUtils.getUser();
    Good good = JsonUtils.toSimpleObject(JsonUtils.toJson(source), Good.class);
    Date now = DateUtils.getNow();
    if (isNewRecord) {
      good.setInsertTime(now);
      good.setInsertBy(user.getName());
    }
    good.setUpdateBy(user.getName());
    good.setUpdateTime(now);
    return good;
  }

}