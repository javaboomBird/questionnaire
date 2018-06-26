<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>工单管理管理</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
    $(document).ready(function () {
      //$("#name").focus();
      $("#inputForm").validate({
        submitHandler: function (form) {
          loading('正在提交，请稍等...');
          form.submit();
        },
        errorContainer: "#messageBox",
        errorPlacement: function (error, element) {
          $("#messageBox").text("输入有误，请先更正。");
          if (element.is(":checkbox") || element.is(":radio") || element.parent().is(
              ".input-append")) {
            error.appendTo(element.parent().parent());
          } else {
            error.insertAfter(element);
          }
        }
      });
      var orderNumber = "ON-" +${fns:getDate("yyyyMMddHHmmss")};
      $("#orderNumber").val(orderNumber);

      //客户change事件
      $("#enterpriseId").change(function () {
        var value = $(this).val();
        $.ajax({
          type: "get",
          url: "${ctx}/contract/contract/getAll?firstParty=" + value,
          dataType: "JSON",
          success: function (data) {
            $("#contractId").empty();
            $("#contractId").prepend("<option value=''>请选择</option>");

            if (data.length > 0) {
              for (var index = 0; index < data.length; index++) {
                $("#contractId").append("<option value='" + data[index].id + "'>"
                    + data[index].majorContractId + "</option>");
              }
            }
          }, error: function () {

          }
        });
      });
      //合同change事件
      $("#contractId").change(function () {
        var value = $(this).val();
        $.ajax({
          type: "get",
          url: "${ctx}/projectmanager/project/getProjectIdByContact?contactId=" + value,
          dataType: "JSON",
          success: function (data) {
            var projectId = data.projectId;
            if (projectId != "") {
              $("#projectId").val(projectId).select2()
            }
          }, error: function () {

          }
        });

      });

    });
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li><a href="${ctx}/engineering/engineeringWorkOrder/">工单列表</a></li>
    <li class="active"><a
            href="${ctx}/engineering/engineeringWorkOrder/form?id=${engineeringWorkOrder.id}">工单<shiro:hasPermission
            name="engineering:engineeringWorkOrder:edit">${not empty engineeringWorkOrder.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission
            name="engineering:engineeringWorkOrder:edit">查看</shiro:lacksPermission></a></li>
</ul>
<br/>
<form:form id="inputForm" modelAttribute="engineeringWorkOrder"
           action="${ctx}/engineering/engineeringWorkOrder/save" method="post"
           class="form-horizontal">
    <form:hidden path="id"/>
    <sys:message content="${message}"/>
    <div class="control-group">
        <label class="control-label">工单号：</label>
        <div class="controls">
            <form:input path="orderNumber" htmlEscape="false" maxlength="64"
                        class="input-medium required" readonly="true"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">工单类型：</label>
        <div class="controls">
            <form:select path="orderType" class="input-xlarge required">
                <form:options items="${fns:getDictList('engineering_order_type')}" itemLabel="label"
                              itemValue="value" htmlEscape="false"/>
            </form:select>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label">工单优先级：</label>
        <div class="controls">
            <form:select path="priority" class="input-xlarge required">
                <form:options items="${fns:getDictList('engineering_order_priority')}"
                              itemLabel="label"
                              itemValue="value" htmlEscape="false"/>
            </form:select>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>


    <div class="control-group">
        <label class="control-label">客户：</label>
        <div class="controls">
            <sys:dynamicselect url="{customer}/customer/api/getEnterpriseList"
                               cssClass="input-xlarge required" id="enterpriseId"
                               name="enterpriseId" valueProperty="id"
                               textProperty="name"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label">合同：</label>
        <div class="controls">
            <sys:dynamicselect
                    url="{contract}/contract/contract/api/getAll?firstParty=${engineeringWorkOrder.enterpriseId}"
                    cssClass="input-xlarge required" id="contractId"
                    name="contractId" valueProperty="id"
                    textProperty="majorContractId"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label">项目：</label>
        <div class="controls">
            <sys:dynamicselect url="{projectmanager}/projectmanager/project/api/getAll"
                               cssClass="input-xlarge" id="projectId" name="projectId"
                               valueProperty="id" textProperty="projectName"
            />
        </div>
    </div>


    <div class="control-group">
        <label class="control-label">描述：</label>
        <div class="controls">
            <form:textarea path="description" htmlEscape="false" maxlength="100"
                           class="input-xlarge "/>
        </div>
    </div>

    <div class="form-actions">
        <shiro:hasPermission name="engineering:engineeringWorkOrder:edit"><input id="btnSubmit"
                                                                                 class="btn btn-primary"
                                                                                 type="submit"
                                                                                 value="保 存"/>&nbsp;</shiro:hasPermission>
        <input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
    </div>
</form:form>
</body>
</html>