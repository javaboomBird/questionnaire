package com.create80.rd.modules.engineering.web;


import com.create80.rd.common.config.Global;
import com.create80.rd.common.persistence.Page;
import com.create80.rd.common.utils.StringUtils;
import com.create80.rd.common.utils.page.PageInfo;
import com.create80.rd.common.web.BaseController;
import com.create80.rd.modules.engineering.api.model.EngineeringWorkOrder;
import com.create80.rd.modules.engineering.entity.EngineeringWorkOrderEntity;
import com.create80.rd.modules.sys.utils.UserUtils;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 工单管理Controller
 *
 * @author yzx
 * @version 2018-06-21
 */
@Controller
@RequestMapping(value = "${adminPath}/engineering/engineeringOrderAssignment")
public class EngineeringOrderAssignmentViewController extends BaseController {

  @Autowired
  private EngineeringWorkOrderViewController engineeringWorkOrderViewController;

  @Autowired
  private RestTemplate restTemplate;

  @ModelAttribute
  public EngineeringWorkOrderEntity get(@RequestParam(required = false) String id) {
    return engineeringWorkOrderViewController.get(id);
  }

  @RequiresPermissions("engineering:engineeringOrderAssignment:view")
  @RequestMapping(value = {"list", ""})
  public String list(EngineeringWorkOrderEntity engineeringWorkOrder, HttpServletRequest request,
      HttpServletResponse response, Model model) {

    Page<EngineeringWorkOrderEntity> page = new Page<>(request, response);
    PageInfo<EngineeringWorkOrderEntity> pageInfo = engineeringWorkOrderViewController
        .getPageInfoEngineeringWorkOrder(engineeringWorkOrder, page.getPageNo(),
            page.getPageSize());

    page.setCount(pageInfo.getTotal());
    page.setPageNo(pageInfo.getPageNum());
    page.setList(pageInfo.getList());
    model.addAttribute("page", page);
    model.addAttribute("engineeringWorkOrder", engineeringWorkOrder);
    return "modules/engineering/engineeringOrderAssignmentList";
  }

  @RequiresPermissions("engineering:engineeringOrderAssignment:view")
  @RequestMapping(value = "form")
  public String form(EngineeringWorkOrderEntity engineeringWorkOrder, Model model) {
    model.addAttribute("engineeringWorkOrder", engineeringWorkOrder);
    return "modules/engineering/engineeringOrderAssignmentForm";
  }


  @RequiresPermissions("engineering:engineeringOrderAssignment:edit")
  @RequestMapping(value = "save")
  public String save(EngineeringWorkOrderEntity engineeringWorkOrder, Model model,
      RedirectAttributes redirectAttributes) {

    engineeringWorkOrder.setStatus("YFP");
    engineeringWorkOrder.setAssignorTime(new Date());
    engineeringWorkOrder.setAssignorId(UserUtils.getUser().getId());

    engineeringWorkOrderViewController.updateEngineeringInfo(engineeringWorkOrder);
    addMessage(redirectAttributes, "保存工单成功");
    return "redirect:" + Global.getAdminPath() + "/engineering/engineeringOrderAssignment/?repage";
  }

  @RequiresPermissions("engineering:engineeringOrderAssignment:edit")
  @RequestMapping(value = "delete")
  public String delete(EngineeringWorkOrderEntity engineeringWorkOrder,
      RedirectAttributes redirectAttributes) {
    engineeringWorkOrderViewController.delete(engineeringWorkOrder, redirectAttributes);
    return "redirect:" + Global.getAdminPath() + "/engineering/engineeringOrderAssignment/?repage";
  }

  @RequiresPermissions("engineering:engineeringOrderAssignment:edit")
  @RequestMapping(value = "cancel")
  public String cancel(EngineeringWorkOrderEntity engineeringWorkOrder,
      RedirectAttributes redirectAttributes) {

    engineeringWorkOrder.setStatus("YQX");
    engineeringWorkOrderViewController.updateEngineeringInfo(engineeringWorkOrder);
    return "redirect:" + Global.getAdminPath() + "/engineering/engineeringOrderAssignment/?repage";
  }


}
