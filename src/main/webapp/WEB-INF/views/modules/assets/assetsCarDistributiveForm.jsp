<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>车辆分配管理</title>
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
    });
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li><a href="${ctx}/assets/assetsCarDistributive/">车辆分配列表</a></li>
    <li class="active"><a
            href="${ctx}/assets/assetsCarDistributive/form?id=${assetsCarDistributive.id}">车辆分配<shiro:hasPermission
            name="assets:assetsCarDistributive:edit">${not empty assetsCarDistributive.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission
            name="assets:assetsCarDistributive:edit">查看</shiro:lacksPermission></a></li>
</ul>
<br/>
<form:form id="inputForm" modelAttribute="assetsCarDistributive"
           action="${ctx}/assets/assetsCarDistributive/save" method="post" class="form-horizontal">
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
        <label class="control-label">分组：</label>
        <div class="controls">
            <sys:dynamicselect url="{group}/group/sysGroup/api/getAll"
                               cssClass="input-xlarge required" id="groupId" name="groupId"
                               valueProperty="id" textProperty="groupName"/>
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
        <shiro:hasPermission name="assets:assetsCarDistributive:edit"><input id="btnSubmit"
                                                                             class="btn btn-primary"
                                                                             type="submit"
                                                                             value="保 存"/>&nbsp;</shiro:hasPermission>
        <input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
    </div>
</form:form>
</body>
</html>