<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>巡检分配管理</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript" src="${ctxStatic}/ztree/jquery.ztree.all.min.js"></script>
    <link rel="stylesheet" href="${ctxStatic}/ztree/zTreeStyle.css" type="text/css">
    <script type="text/javascript">
    //企业树设置
    var setting = {
      check: {
        enable: true
      },
      data: {
        simpleData: {
          enable: true
        }
      }, callback: {
        beforeCheck: true,
        onCheck: onCheck
      }
    };

    function onCheck(e, treeId, treeNode) {
      var treeObj = $.fn.zTree.getZTreeObj("enterprise_tree"),
          nodes = treeObj.getCheckedNodes(true),
          assetsArray = new Array();

      $.each(nodes, function (index, node) {
        var pId = node.pId;
        if (pId != '-1' && pId != null) {
          assetsArray.push(node.id)
        }
      });
      var assetsIds = assetsArray.join(",");
      $("#assetId").val(assetsIds);
    }

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

      //企业树
      var zNodes = ${zTreeNoLis};
      $.fn.zTree.init($("#enterprise_tree"), setting, zNodes);
    });
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li><a href="${ctx}/inspection/inspectionAssignment/">巡检分配列表</a></li>
    <li class="active"><a
            href="${ctx}/inspection/inspectionAssignment/form?id=${inspectionAssignment.id}">巡检分配<shiro:hasPermission
            name="inspection:inspectionAssignment:edit">${not empty inspectionAssignment.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission
            name="inspection:inspectionAssignment:edit">查看</shiro:lacksPermission></a></li>
</ul>
<br/>
<form:form id="inputForm" modelAttribute="inspectionAssignment"
           action="${ctx}/inspection/inspectionAssignment/save" method="post"
           class="form-horizontal">
    <form:hidden path="id"/>
    <input type="hidden" name="assetId" id="assetId"/>
    <sys:message content="${message}"/>
    <div class="control-group">
        <label class="control-label">运维组：</label>
        <div class="controls">
            <form:select path="teamId" class="input-xlarge form-control required">
                <form:option value="" label="请选择"/>
                <form:options items="${sysUserGroupList}" itemLabel="groupName"
                              itemValue="id" htmlEscape="false"/>
            </form:select>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label">生效日期：</label>
        <div class="controls">
            <input name="inspectionMonth" type="text" readonly="readonly" maxlength="20"
                   class="input-medium Wdate required"
                   value="<fmt:formatDate value="${inspectionAssignment.inspectionMonth}" pattern="yyyy-MM"/>"
                   onclick="WdatePicker({dateFmt:'yyyy-MM',isShowClear:false});"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label">每月维护次数：</label>
        <div class="controls">
            <form:input path="inspectionTimes" htmlEscape="false" class="input-medium required"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label">企业：</label>
        <div class="controls">
            <ul id="enterprise_tree" class="ztree" style="margin-top:0; width:160px;"></ul>
        </div>
    </div>



    <div class="form-actions">
        <shiro:hasPermission name="inspection:inspectionAssignment:edit"><input id="btnSubmit"
                                                                                class="btn btn-primary"
                                                                                type="submit"
                                                                                value="保 存"/>&nbsp;</shiro:hasPermission>
        <input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
    </div>
</form:form>
</body>
</html>