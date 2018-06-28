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
    <style>
        .container-fluit-m{
            margin-top:30px;
        }

        .row-border{
            border-bottom:1px solid #eee;
            padding-bottom: 10px;
        }

        .row-m-t{
            margin-top:10px;
        }

        .p-title{
            font-size:20px;
            color:#08c;
            margin:10px;
            font-weight:600;
        }

        .btn-size{
            width: 10%!important;
            height: 35px;
            font-size: 16px;
        }

        .table-label-m-b{
            margin-bottom:10px;
        }

        .input-xxlarge{
            width:260px;
        }

        @media (max-width: 979px) and (min-width: 768px){
            .input-xlarge{
                width:160px;
            }

            .input-medium{
                width:160px;
            }

            .form-horizontal .control-label{
                width:120px;
            }
        }
    </style>
</head>
<body>
<p style="display:inline-block;" class="p-title">工单信息查看</p>
<input id="btnCancel" class="btn" style="margin-bottom:10px;float: right;" type="button" value="返 回" onclick="history.go(-1)"/>
<div class="container-fluit container-fluit-m">
<form:form id="inputForm" modelAttribute="engineeringWorkOrder"
           action="${ctx}/engineering/engineeringWorkOrder/save" method="post"
           class="form-horizontal">
    <form:hidden path="id"/>
    <sys:message content="${message}"/>

    <div class="row-fluid row-border">
        <div class="span12">
            <label class="control-label">工单号：</label>
            <div class="controls">
                <form:input path="orderNumber" htmlEscape="false" maxlength="64"
                            class="input-medium required" readonly="true"/>
                <span class="help-inline"><font color="red">*</font> </span>
            </div>
        </div>
    </div>
    <div class="row-fluid row-border row-m-t">
        <div class="span6">
            <label class="control-label">工单类型：</label>
            <div class="controls">
                <form:select path="orderType" class="input-xlarge required">
                    <form:options items="${fns:getDictList('engineering_order_type')}" itemLabel="label"
                                  itemValue="value" htmlEscape="false"/>
                </form:select>
                <span class="help-inline"><font color="red">*</font> </span>
            </div>
        </div>
        <div class="span6">
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
    </div>
    <div class="row-fluid row-border row-m-t">
        <div class="span6">
            <label class="control-label">客户：</label>
            <div class="controls">
                <sys:dynamicselect url="{customer}/customer/api/getEnterpriseList"
                                   cssClass="input-xlarge required" id="enterpriseId"
                                   name="enterpriseId" valueProperty="id"
                                   textProperty="name"/>
                <span class="help-inline"><font color="red">*</font> </span>
            </div>
        </div>
        <div class="span6">
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
    </div>

    <div class="row-fluid row-border row-m-t">
        <div class="span6">
            <label class="control-label">项目：</label>
            <div class="controls">
                <sys:dynamicselect url="{projectmanager}/projectmanager/project/api/getAll"
                                   cssClass="input-xlarge" id="projectId" name="projectId"
                                   valueProperty="id" textProperty="projectName"
                />
            </div>
        </div>
        <div class="span6">
            <label class="control-label">描述：</label>
            <div class="controls">
                <form:textarea path="description" htmlEscape="false" maxlength="100"
                               class="input-xlarge "/>
            </div>
        </div>
    </div>



    <div class="container text-center">
        <input id="btnCancel" class="btn btn-size" type="button" value="返 回" onclick="history.go(-1)"/>
    </div>
</form:form>
</div>
</body>
</html>