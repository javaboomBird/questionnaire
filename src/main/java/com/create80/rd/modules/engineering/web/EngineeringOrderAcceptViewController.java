package com.create80.rd.modules.engineering.web;


import com.create80.rd.common.config.Global;
import com.create80.rd.common.persistence.Page;
import com.create80.rd.common.utils.JsonUtils;
import com.create80.rd.common.utils.StringUtils;
import com.create80.rd.common.utils.page.PageInfo;
import com.create80.rd.common.web.BaseController;
import com.create80.rd.modules.engineering.api.model.EngineeringWorkOrder;
import com.create80.rd.modules.engineering.entity.EngineeringWorkOrderEntity;
import com.create80.rd.modules.group.api.model.SysGroup;
import com.create80.rd.modules.group.web.SysGroupViewController;
import com.create80.rd.modules.sys.utils.UserUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 工单管理Controller
 *
 * @author yzx
 * @version 2018-06-21
 */
@Controller
@RequestMapping(value = "${adminPath}/engineering/engineeringOrderAccept")
public class EngineeringOrderAcceptViewController extends BaseController {

  @Autowired
  private EngineeringWorkOrderViewController engineeringWorkOrderViewController;

  @Autowired
  private RestTemplate restTemplate;


  @ModelAttribute
  public EngineeringWorkOrderEntity get(@RequestParam(required = false) String id) {
    return engineeringWorkOrderViewController.get(id);
  }

  @RequiresPermissions("engineering:engineeringOrderAccept:view")
  @RequestMapping(value = {"list", ""})
  public String list(EngineeringWorkOrderEntity engineeringWorkOrder, HttpServletRequest request,
      HttpServletResponse response, Model model) {

    Page<EngineeringWorkOrderEntity> page = new Page<>(request, response);

    String officeId = UserUtils.getUser().getOffice().getId();
    List<SysGroup> sysGroupList = getSysGroups(officeId);
    PageInfo<EngineeringWorkOrderEntity> pageInfo = engineeringWorkOrderViewController
        .getPageInfoEngineeringWorkOrder(engineeringWorkOrder, page.getPageNo(),
            page.getPageSize());

    //查询分派自己所在组的工单列表
    List<EngineeringWorkOrderEntity> result = new ArrayList<>();
    if (pageInfo.getList() != null && sysGroupList != null) {
      pageInfo.getList().stream().forEach(engineeringWorkOrderEntity -> {
        String teamId = engineeringWorkOrderEntity.getTeamId();
        sysGroupList.stream().forEach(sysGroup -> {
          if (teamId.equals(sysGroup.getId())) {
            result.add(engineeringWorkOrderEntity);
          }
        });
      });
    }
    page.setCount(pageInfo.getTotal());
    page.setPageNo(pageInfo.getPageNum());
    page.setList(result);
    model.addAttribute("page", page);
    model.addAttribute("engineeringWorkOrder", engineeringWorkOrder);
    return "modules/engineering/engineeringOrderAcceptList";
  }

  private List<SysGroup> getSysGroups(String officeId) {
    try {
      String apiBaseUrl = moduleLinkConfiguration.getLink("group");
      Map<String, Object> urlVariables = new HashMap<>();
      urlVariables.put("officeId", officeId);
      ResponseEntity<String> responseEntity =
          restTemplate.getForEntity(apiBaseUrl + "/group/sysGroup/api/getAll?officeId={officeId}",
              String.class,
              urlVariables);
      return JsonUtils.toListObject(responseEntity.getBody(), SysGroup.class);
    } catch (RestClientException e) {
      e.printStackTrace();
    }
    return null;
  }

  @RequiresPermissions("engineering:engineeringOrderAccept:view")
  @RequestMapping(value = "form")
  public String form(EngineeringWorkOrderEntity engineeringWorkOrder, Model model) {
    model.addAttribute("engineeringWorkOrder", engineeringWorkOrder);
    return "modules/engineering/engineeringOrderAcceptForm";
  }

  @RequiresPermissions("engineering:engineeringOrderAccept:edit")
  @RequestMapping(value = "save")
  public String save(EngineeringWorkOrderEntity engineeringWorkOrder, Model model,
      RedirectAttributes redirectAttributes) {
    engineeringWorkOrder.setStatus("YSL");
    engineeringWorkOrder.setAcceptTime(new Date());
    EngineeringWorkOrder type = engineeringWorkOrderViewController.resolveBeanProperties(
        StringUtils.isEmpty(engineeringWorkOrder.getId()), engineeringWorkOrder);
    String apiBaseUrl = moduleLinkConfiguration.getLink("engineering");
    restTemplate.postForObject(apiBaseUrl + "/engineering/engineeringWorkOrder/api/save", type,
        String.class);
    addMessage(redirectAttributes, "保存工单管理成功");
    return "redirect:" + Global.getAdminPath() + "/engineering/engineeringOrderAccept/?repage";
  }

  @RequiresPermissions("engineering:engineeringOrderAccept:edit")
  @RequestMapping(value = "delete")
  public String delete(EngineeringWorkOrderEntity engineeringWorkOrder,
      RedirectAttributes redirectAttributes) {
    engineeringWorkOrderViewController.delete(engineeringWorkOrder, redirectAttributes);
    return "redirect:" + Global.getAdminPath() + "/engineering/engineeringOrderAccept/?repage";
  }


}
