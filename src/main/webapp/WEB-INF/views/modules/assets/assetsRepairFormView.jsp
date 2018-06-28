<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>资产维修管理</title>
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

      $("#repairNo").val("RNO-${fns:getDate('yyyyMMddHHmmss')}")
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
<p style="display:inline-block;" class="p-title">资产维修查看</p>
<input id="btnCancel" class="btn" style="margin-bottom:10px;float: right;" type="button" value="返 回" onclick="history.go(-1)"/>
<div class="container-fluit container-fluit-m">
<form:form id="inputForm" modelAttribute="assetsRepair" action="${ctx}/assets/assetsRepair/save"
           method="post" class="form-horizontal">
    <form:hidden path="id"/>
    <sys:message content="${message}"/>
    <div class="row-fluid row-border">
        <div class="span12">
            <label class="control-label">维修编号：</label>
            <div class="controls">
                <form:input path="repairNo" htmlEscape="false" maxlength="64"
                            class="input-xlarge required" readonly="true"/>
                <span class="help-inline"><font color="red">*</font> </span>
            </div>
        </div>
    </div>
    <div class="row-fluid row-border row-m-t">
        <div class="span6">
            <label class="control-label">资产：</label>
            <div class="controls">
                <sys:dynamicselect url="{assets}/assets/assetsManager/api/getAll"
                                   cssClass="input-xlarge required" id="assetsId" name="assetsId"
                                   valueProperty="id" textProperty="assetsNo"/>
                <span class="help-inline"><font color="red">*</font> </span>
            </div>
        </div>
        <div class="span6">
            <label class="control-label">申请人：</label>
            <div class="controls">
                <sys:treeselect id="applicant" property="applicantId" name="applicant.id"
                                value="${assetsRepair.applicant.id}" labelName="applicant.name"
                                labelValue="${assetsRepair.applicant.name}"
                                title="用户" url="/sys/office/treeData?type=3" cssClass="required"
                                allowClear="true" notAllowSelectParent="true"/>
                <span class="help-inline"><font color="red">*</font> </span>
            </div>
        </div>
    </div>
    <div class="row-fluid row-border row-m-t">
        <div class="span6">
            <label class="control-label">送修时间：</label>
            <div class="controls">
                <input name="repairTime" type="text" readonly="readonly" maxlength="20"
                       class="input-medium Wdate "
                       value="<fmt:formatDate value="${assetsRepair.repairTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                       onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
            </div>
        </div>
        <div class="span6">
            <label class="control-label">故障描述：</label>
            <div class="controls">
                <form:input path="faultDescription" htmlEscape="false" maxlength="255"
                            class="input-xlarge "/>
            </div>
        </div>
    </div>
    <div class="row-fluid row-border row-m-t">
        <div class="span6">
            <label class="control-label">维修是否完成：</label>
            <div class="controls">
                <form:checkboxes path="repairComplete" items="${fns:getDictList('assets_repair_status')}" itemLabel="label" itemValue="value" htmlEscape="false" class=""/>
            </div>
        </div>
        <div class="span6">
            <label class="control-label">完成时间：</label>
            <div class="controls">
                <input name="completeTime" type="text" readonly="readonly" maxlength="20"
                       class="input-medium Wdate "
                       value="<fmt:formatDate value="${assetsRepair.completeTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                       onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
            </div>
        </div>
    </div>
    <div class="row-fluid row-border row-m-t">
        <div class="span6">
            <label class="control-label">故障分析：</label>
            <div class="controls">
                <form:input path="faultAnalysis" htmlEscape="false" maxlength="255"
                            class="input-xlarge "/>
            </div>
        </div>
        <div class="span6">
            <label class="control-label">备注：</label>
            <div class="controls">
                <form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255"
                               class="input-xxlarge "/>
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