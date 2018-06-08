<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>资产连接信息管理管理</title>
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

      //使用企业change事件
      $("#assetsEnterpriseId").change(function () {
        var selectVal = $(this).val();
        $.ajax({
          url: "${ctx}/assets/assetsConnectionInfo/getAssetsList",
          type: "GET",
          data: { "assetsEnterpriseId": selectVal },
          success: function (data) {
            $("#sourceAssetsId,#targetAssetsId").empty();
            if (data != null) {
              var jsonData = eval('(' + data + ')');
              $.each(jsonData, function (index, value) {
                $("#sourceAssetsId,#targetAssetsId").append("<option value='" + value.id + "'>"
                    + value.text
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
    <li><a href="${ctx}/assets/assetsConnectionInfo/">资产连接信息管理列表</a></li>
    <li class="active"><a
            href="${ctx}/assets/assetsConnectionInfo/form?id=${assetsConnectionInfo.id}">资产连接信息管理<shiro:hasPermission
            name="assets:assetsConnectionInfo:edit">${not empty assetsConnectionInfo.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission
            name="assets:assetsConnectionInfo:edit">查看</shiro:lacksPermission></a></li>
</ul>
<br/>
<form:form id="inputForm" modelAttribute="assetsConnectionInfo"
           action="${ctx}/assets/assetsConnectionInfo/save" method="post" class="form-horizontal">
    <form:hidden path="id"/>
    <sys:message content="${message}"/>

    <div class="control-group">
        <label class="control-label">使用企业：</label>
        <div class="controls">
            <select id="assetsEnterpriseId" name="enterpriseId"
                    class="input-xlarge required">
                <option value="">请选择</option>
                <c:forEach items="${enterpriseMap}" var="enterprise">
                    <c:if test="${assetsConnectionInfo.enterpriseId==enterprise.key}">
                        <option value="${enterprise.key}"
                                selected="selected">${enterprise.value}</option>
                    </c:if>
                    <c:if test="${assetsConnectionInfo.enterpriseId!=enterprise.key}">
                        <option value="${enterprise.key}">${enterprise.value}</option>
                    </c:if>
                </c:forEach>
            </select>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label">源资产：</label>
        <div class="controls">
            <select name="sourceAssetsId" id="sourceAssetsId" class="input-xlarge required">
                <c:forEach items="${assetsListMap}" var="item">
                    <c:if test="${assetsConnectionInfo.sourceAssetsId==item.id}">
                        <option value="${item.id}" selected="selected">${item.text}</option>
                    </c:if>
                    <c:if test="${assetsConnectionInfo.sourceAssetsId!=item.id}">
                        <option value="${item.id}">${item.text}</option>
                    </c:if>
                </c:forEach>
            </select>
            <span class="help-inline"><font color="red">*</font> </span>

        </div>
    </div>
    <div class="control-group">
        <label class="control-label">源资产接口地址：</label>
        <div class="controls">
            <form:input path="sourceApi" htmlEscape="false" maxlength="64"
                        class="input-xlarge required"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">目标资产：</label>
        <div class="controls">

            <select name="targetAssetsId" id="targetAssetsId" class="input-xlarge required">
                <c:forEach items="${assetsListMap}" var="item">
                    <c:if test="${assetsConnectionInfo.targetAssetsId==item.id}">
                        <option value="${item.id}" selected="selected">${item.text}</option>
                    </c:if>
                    <c:if test="${assetsConnectionInfo.targetAssetsId!=item.id}">
                        <option value="${item.id}">${item.text}</option>
                    </c:if>
                </c:forEach>
            </select>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">目标资产接口地址：</label>
        <div class="controls">
            <form:input path="targetApi" htmlEscape="false" maxlength="64"
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
        <shiro:hasPermission name="assets:assetsConnectionInfo:edit"><input id="btnSubmit"
                                                                            class="btn btn-primary"
                                                                            type="submit"
                                                                            value="保 存"/>&nbsp;</shiro:hasPermission>
        <input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
    </div>
</form:form>
</body>
</html>