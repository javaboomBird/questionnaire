<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>车辆使用管理</title>
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

      //车辆change事件
      $("#assetsId").change(function () {
        var selectVal = $(this).val();
        $.ajax({
          url: "${ctx}/assets/assetsCarDistributive/getDistributiveAssetsCarMembers",
          type: "GET",
          data: { "assetsId": selectVal },
          success: function (data) {
            $("#managerId").empty();
            if (data != null) {
              $.each(data, function (index, value) {
                $("#managerId").append("<option value='" + value.userId + "'>"
                    + value.user.name
                    + "</option>");
              })
            }
          }
        });
      });
    });
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li><a href="${ctx}/assets/assetsCarUse/">车辆使用列表</a></li>
    <li class="active"><a
            href="${ctx}/assets/assetsCarUse/form?id=${assetsCarUse.id}">车辆使用<shiro:hasPermission
            name="assets:assetsCarUse:edit">${not empty assetsCarUse.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission
            name="assets:assetsCarUse:edit">查看</shiro:lacksPermission></a></li>
</ul>
<br/>
<form:form id="inputForm" modelAttribute="assetsCarUse" action="${ctx}/assets/assetsCarUse/save"
           method="post" class="form-horizontal">
    <form:hidden path="id"/>
    <sys:message content="${message}"/>
    <div class="control-group">
        <label class="control-label">车辆：</label>
        <div class="controls">
            <sys:dynamicselect url="{assets}/assets/assetsManager/api/getAll?assetsType=CAR"
                               cssClass="input-xlarge required" id="assetsId" name="assetsId"
                               valueProperty="id" textProperty="plateNumber"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">使用人：</label>
        <div class="controls">
            <form:select path="managerId" class="input-xlarge required">
                <form:option value="" label=""/>
            </form:select>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">使用目的：</label>
        <div class="controls">
            <form:input path="usePurpose" htmlEscape="false" maxlength="255" class="input-xlarge required"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">使用前里程：</label>
        <div class="controls">
            <form:input path="beforeMileage" htmlEscape="false" maxlength="20"
                        class="input-xlarge required"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">使用后里程：</label>
        <div class="controls">
            <form:input path="afterMileage" htmlEscape="false" maxlength="20"
                        class="input-xlarge required"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">开始时间：</label>
        <div class="controls">
            <input name="startTime" type="text" readonly="readonly" maxlength="20"
                   class="input-medium Wdate required"
                   value="<fmt:formatDate value="${assetsCarUse.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">结束时间：</label>
        <div class="controls">
            <input name="endTime" type="text" readonly="readonly" maxlength="20"
                   class="input-medium Wdate required"
                   value="<fmt:formatDate value="${assetsCarUse.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
            <span class="help-inline"><font color="red">*</font> </span>
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
        <shiro:hasPermission name="assets:assetsCarUse:edit"><input id="btnSubmit"
                                                                    class="btn btn-primary"
                                                                    type="submit"
                                                                    value="保 存"/>&nbsp;</shiro:hasPermission>
        <input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
    </div>
</form:form>
</body>
</html>