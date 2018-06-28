<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>勘察图片管理</title>
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

      $("#engineeringId").change(function () {
        var value = $(this).val();
        if (value == '') {
          $("#customerId").val('');
          $("#customerName").val('');
        } else {
          $.ajax({
            type: "get",
            url: "${ctx}/engineering/engineeringWorkOrder/getById?id=" + value,
            dataType: "JSON",
            success: function (data) {

              var customerId = data.customer.id;
              var customerName = data.customer.name;

              $("#customerId").val(customerId);
              $("#customerName").val(customerName);
            }, error: function () {

            }
          });
        }
      });
    });
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li><a href="${ctx}/engineering/engineeringSurveyImg/">勘察图片列表</a></li>
    <li class="active"><a
            href="${ctx}/engineering/engineeringSurveyImg/form?id=${engineeringSurveyImg.id}">勘察图片<shiro:hasPermission
            name="engineering:engineeringSurveyImg:edit">${not empty engineeringSurveyImg.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission
            name="engineering:engineeringSurveyImg:edit">查看</shiro:lacksPermission></a></li>
</ul>
<br/>
<form:form id="inputForm" modelAttribute="engineeringSurveyImg"
           action="${ctx}/engineering/engineeringSurveyImg/save" method="post"
           class="form-horizontal">
    <form:hidden path="id"/>
    <sys:message content="${message}"/>

    <div class="control-group">
        <label class="control-label">工单：</label>
        <div class="controls">
            <sys:dynamicselect url="{engineering}/engineering/engineeringWorkOrder/api/getAll"
                               cssClass="input-xlarge required"
                               id="engineeringId" name="engineeringId" valueProperty="id"
                               textProperty="orderNumber"/>

            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">客户：</label>
        <div class="controls">
            <form:hidden path="customerId"/>
            <input id="customerName" type="text" maxlength="64" class="input-xlarge required" value="${engineeringSurveyImg.customer.name}" readonly="readonly"/>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label">图片路径：</label>
        <div class="controls">
            <form:hidden id="iamgePath" path="iamgePath" htmlEscape="false" maxlength="500"
                         class="input-xlarge required"/>
            <sys:ckfinder input="iamgePath" type="files"
                          uploadPath="/engineering/engineeringSurveyImg" selectMultiple="true"/>

            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">描述：</label>
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
        <shiro:hasPermission name="engineering:engineeringSurveyImg:edit"><input id="btnSubmit"
                                                                                 class="btn btn-primary"
                                                                                 type="submit"
                                                                                 value="保 存"/>&nbsp;</shiro:hasPermission>
        <input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
    </div>
</form:form>
</body>
</html>