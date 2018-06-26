<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>工单分派</title>
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
    <li><a href="${ctx}/engineering/engineeringOrderAssignment/">工单分派列表</a></li>
</ul>
<br/>
<form:form id="inputForm" modelAttribute="engineeringWorkOrder"
           action="${ctx}/engineering/engineeringOrderAssignment/save" method="post"
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
        <label class="control-label">小组：</label>
        <div class="controls">
            <sys:dynamicselect
                    url="{group}/group/sysGroup/api/getAll?officeId=${fns:getUser().office.id}&&groupType=1"
                    cssClass="input-medium required" id="teamId" name="teamId"
                    valueProperty="id" textProperty="groupName"
            />
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label">预估开始时间：</label>
        <div class="controls">
            <input name="estimateStartTime" type="text" readonly="readonly" maxlength="20"
                   class="input-medium Wdate required"
                   value="<fmt:formatDate value="${engineeringWorkOrder.estimateStartTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>

            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label">预估结束时间：</label>
        <div class="controls">
            <input name="estimateEndTime" type="text" readonly="readonly" maxlength="20"
                   class="input-medium Wdate required"
                   value="<fmt:formatDate value="${engineeringWorkOrder.estimateEndTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>

            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label">预估工时：</label>
        <div class="controls">
                <form:input path="estimateTime" htmlEscape="false" maxlength="64"
                            class="input-medium required"/>
                <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>


    <div class="form-actions">
        <c:choose>
            <c:when test="${engineeringWorkOrder.status=='YTJ'}">
                <shiro:hasPermission name="engineering:engineeringOrderAssignment:edit"><input
                        id="btnSubmit"
                        class="btn btn-primary"
                        type="submit"
                        value="分 派"/>&nbsp;</shiro:hasPermission>
                <input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
            </c:when>
            <c:otherwise>
                <input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
            </c:otherwise>
        </c:choose>


    </div>
</form:form>
</body>
</html>