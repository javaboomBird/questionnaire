<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>资产替换管理</title>
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

      //.
      $("#replaceNo").val("RP-${fns:getDate('yyyyMMddHHmmss')}");
    });


    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li><a href="${ctx}/assets/assetsReplace/">资产替换列表</a></li>
    <li class="active"><a
            href="${ctx}/assets/assetsReplace/form?id=${assetsReplace.id}">资产替换<shiro:hasPermission
            name="assets:assetsReplace:edit">${not empty assetsReplace.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission
            name="assets:assetsReplace:edit">查看</shiro:lacksPermission></a></li>
</ul>
<br/>
<form:form id="inputForm" modelAttribute="assetsReplace" action="${ctx}/assets/assetsReplace/save"
           method="post" class="form-horizontal">
    <form:hidden path="id"/>
    <sys:message content="${message}"/>
    <div class="control-group">
        <label class="control-label">更换单号：</label>
        <div class="controls">
            <form:input path="replaceNo" htmlEscape="false" maxlength="64"
                        class="input-xlarge required" readonly="true"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">被替换资产编号：</label>
        <div class="controls">
            <sys:dynamicselect url="{assets}/assets/assetsManager/api/getAll"
                               cssClass="input-xlarge required " id="originalAssetsId"
                               name="originalAssetsId" valueProperty="id" textProperty="assetsNo"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">替换资产编号：</label>
        <div class="controls">
            <sys:dynamicselect url="{assets}/assets/assetsManager/api/getAll"
                               cssClass="input-xlarge required" id="replaceAssetsId" name="replaceAssetsId"
                               valueProperty="id" textProperty="assetsNo"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">资产替换负责人：</label>
        <div class="controls">
            <sys:treeselect id="replaceManager" property="replaceManagerId" name="replaceManager.id"
                            value="${assetsReplace.replaceManager.id}" labelName=""
                            labelValue="${assetsReplace.replaceManager.name}"
                            title="用户" url="/sys/office/treeData?type=3" cssClass="required"
                            allowClear="true" notAllowSelectParent="true"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">更换时间：</label>
        <div class="controls">
            <input name="replaceTime" type="text" readonly="readonly" maxlength="20"
                   class="input-medium Wdate required"
                   value="<fmt:formatDate value="${assetsReplace.replaceTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">更换原因：</label>
        <div class="controls">
            <form:textarea path="replaceReason" htmlEscape="false" maxlength="255"
                        class="input-xlarge required"/>
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
        <shiro:hasPermission name="assets:assetsReplace:edit"><input id="btnSubmit"
                                                                     class="btn btn-primary"
                                                                     type="submit"
                                                                     value="保 存"/>&nbsp;</shiro:hasPermission>
        <input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
    </div>
</form:form>
</body>
</html>