<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>工程签到管理</title>
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
      //工单change事件
      $("#engineeringId").change(function () {
        var value = $(this).val();
        $.ajax({
          type: "get",
          url: "${ctx}/engineering/engineeringWorkOrder/getById?id=" + value,
          dataType: "JSON",
          success: function (data) {
            var teamId = data.sysGroup.id;
            var teamName = data.sysGroup.groupName;
            var customerId = data.customer.id;
            var customerName = data.customer.name;
            $("#teamId").val(teamId);
            $("#teamName").val(teamName);
            $("#customerId").val(customerId);
            $("#customerName").val(customerName);
          }, error: function () {

          }
        });
      });

    });
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li><a href="${ctx}/engineering/engineeringSignIn/">工程签到列表</a></li>
    <li class="active"><a
            href="${ctx}/engineering/engineeringSignIn/form?id=${engineeringSignIn.id}">工程签到<shiro:hasPermission
            name="engineering:engineeringSignIn:edit">${not empty engineeringSignIn.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission
            name="engineering:engineeringSignIn:edit">查看</shiro:lacksPermission></a></li>
</ul>
<br/>
<form:form id="inputForm" modelAttribute="engineeringSignIn"
           action="${ctx}/engineering/engineeringSignIn/save" method="post" class="form-horizontal">
    <form:hidden path="id"/>
    <sys:message content="${message}"/>
    <div class="control-group">
        <label class="control-label">工单：</label>
        <div class="controls">
            <sys:dynamicselect url="{engineering}/engineering/engineeringWorkOrder/api/getAll"
                               cssClass="input-xlarge required "
                               id="engineeringId" name="engineeringId" valueProperty="id"
                               textProperty="orderNumber"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">分组：</label>
        <div class="controls">
            <input id="teamName" type="text" class="input-xlarge " readonly="readonly"
                   value="${engineeringSignIn.engineeringWorkOrder.sysGroup.groupName}"/>
            <form:hidden path="teamId"/>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label">客户：</label>
        <div class="controls">
            <input id="customerName" type="text" class="input-xlarge "
                   value="${engineeringSignIn.engineeringWorkOrder.customer.name}"
                   readonly="readonly"/>
            <form:hidden path="customerId"/>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label">签到时间：</label>
        <div class="controls">
            <input name="signTime" type="text" readonly="readonly" maxlength="20"
                   class="input-medium Wdate required"
                   value="<fmt:formatDate value="${engineeringSignIn.signTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">签到位置纬度：</label>
        <div class="controls">
            <form:input path="signLat" htmlEscape="false" class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">签到位置经度：</label>
        <div class="controls">
            <form:input path="signLng" htmlEscape="false" class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">签到类型：</label>
        <div class="controls">
            <form:select path="signType" class="input-xlarge required">
                <form:option value="" label="请选择"/>
                <form:options items="${fns:getDictList('engineering_sign_in_type')}"
                              itemLabel="label"
                              itemValue="value" htmlEscape="false"/>
            </form:select>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label">签到描述：</label>
        <div class="controls">
            <form:input path="description" htmlEscape="false" maxlength="100"
                        class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">备注：</label>
        <div class="controls">
            <form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255"
                           class="input-xxlarge "/>
        </div>
    </div>
    <div class="form-actions">
        <shiro:hasPermission name="engineering:engineeringSignIn:edit"><input id="btnSubmit"
                                                                              class="btn btn-primary"
                                                                              type="submit"
                                                                              value="保 存"/>&nbsp;</shiro:hasPermission>
        <input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
    </div>
</form:form>
</body>
</html>