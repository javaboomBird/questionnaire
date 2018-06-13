<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>项目阶段管理管理</title>
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

    function addRow(list, idx, tpl, row) {
      $(list).append(Mustache.render(tpl, {
        idx: idx, delBtn: true, row: row
      }));
      $(list + idx).find("select").each(function () {
        $(this).val($(this).attr("data-value"));
        $(this).select2();
      });
      $(list + idx).find("input[type='checkbox'], input[type='radio']").each(function () {
        var ss = $(this).attr("data-value").split(',');
        for (var i = 0; i < ss.length; i++) {
          if ($(this).val() == ss[i]) {
            $(this).attr("checked", "checked");
          }
        }
      });
    }

    function delRow(obj, prefix) {
      var id = $(prefix + "_id");
      var delFlag = $(prefix + "_delFlag");
      if (id.val() == "") {
        $(obj).parent().parent().remove();
      } else if (delFlag.val() == "0") {
        delFlag.val("1");
        $(obj).html("&divide;").attr("title", "撤销删除");
        $(obj).parent().parent().addClass("error");
      } else if (delFlag.val() == "1") {
        delFlag.val("0");
        $(obj).html("&times;").attr("title", "删除");
        $(obj).parent().parent().removeClass("error");
      }
    }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li><a href="${ctx}/projectmanager/projectStage/">项目阶段管理列表</a></li>
    <li class="active"><a href="${ctx}/projectmanager/projectStage/form?id=${projectStage.id}">项目阶段管理<shiro:hasPermission
            name="projectmanager:projectStage:edit">${not empty projectStage.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission
            name="projectmanager:projectStage:edit">查看</shiro:lacksPermission></a></li>
</ul>
<br/>
<form:form id="inputForm" modelAttribute="projectStage"
           action="${ctx}/projectmanager/projectStage/save" method="post" class="form-horizontal">
    <form:hidden path="id"/>
    <sys:message content="${message}"/>
    <div class="control-group">
        <label class="control-label">项目：</label>
        <div class="controls">
            <sys:dynamicselect url="{projectmanager}//projectmanager/project/api/getAll"
                               cssClass="input-medium required" id="projectId" name="projectId"
                               valueProperty="id" textProperty="projectName"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">阶段名称：</label>
        <div class="controls">
            <form:input path="stageName" htmlEscape="false" maxlength="64"
                        class="input-xlarge required"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">阶段类型：</label>
        <div class="controls">
            <form:select path="stageType" class="input-xlarge ">
                <form:option value="" label=""/>
                <form:options items="${fns:getDictList('project_stage_type')}" itemLabel="label"
                              itemValue="value" htmlEscape="false"/>
            </form:select>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">阶段状态：</label>
        <div class="controls">
            <form:select path="stageStatus" class="input-xlarge ">
                <form:option value="" label=""/>
                <form:options items="${fns:getDictList('project_status')}" itemLabel="label"
                              itemValue="value" htmlEscape="false"/>
            </form:select>
        </div>
    </div>
    <%--<div class="control-group">--%>
    <%--<label class="control-label">阶段序号：</label>--%>
    <%--<div class="controls">--%>
    <%--<form:input path="stageNum" htmlEscape="false" class="input-xlarge required"/>--%>
    <%--</div>--%>
    <%--</div>--%>
    <div class="control-group">
        <label class="control-label">负责人：</label>
        <div class="controls">
            <sys:treeselect id="manager" property="managerId" name="manager.id"
                            value="${projectStage.manager.id}" labelName="manager.name"
                            labelValue="${projectStage.manager.name}"
                            title="用户" url="/sys/office/treeData?type=3" cssClass="required"
                            allowClear="true" notAllowSelectParent="true"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">计划开始时间：</label>
        <div class="controls">
            <input name="planStartTime" type="text" readonly="readonly" maxlength="20"
                   class="input-medium Wdate "
                   value="<fmt:formatDate value="${projectStage.planStartTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">计划结束时间：</label>
        <div class="controls">
            <input name="planEndTime" type="text" readonly="readonly" maxlength="20"
                   class="input-medium Wdate "
                   value="<fmt:formatDate value="${projectStage.planEndTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">实际开始时间：</label>
        <div class="controls">
            <input name="actualStartTime" type="text" readonly="readonly" maxlength="20"
                   class="input-medium Wdate "
                   value="<fmt:formatDate value="${projectStage.actualStartTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">实际结束时间：</label>
        <div class="controls">
            <input name="actualEndTime" type="text" readonly="readonly" maxlength="20"
                   class="input-medium Wdate "
                   value="<fmt:formatDate value="${projectStage.actualEndTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">进度：</label>
        <div class="controls">
            <input name="progress" value="${projectStage.progress==null?0:projectStage.progress}"
                   maxlength="10" class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">有交接文档：</label>
        <div class="controls">
            <form:checkboxes path="hasDocument" items="${fns:getDictList('project_has_document')}"
                             itemLabel="label" itemValue="value" htmlEscape="false" class=""/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">备注：</label>
        <div class="controls">
            <form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255"
                           class="input-xxlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">项目文档：</label>
        <div class="controls">
            <table id="contentTable_projectDocument"
                   class="table table-striped table-bordered table-condensed">
                <thead>
                <tr>
                    <th class="hide"></th>
                    <th>文档名称</th>
                    <th>文档类型</th>
                    <th>附件</th>
                        <%--<th>文档序号</th>--%>
                    <th>备注</th>
                    <shiro:hasPermission name="projectmanager:projectStage:edit">
                        <th width="10">&nbsp;</th>
                    </shiro:hasPermission>
                </tr>
                </thead>
                <tbody id="projectDocumentList">
                </tbody>
                <shiro:hasPermission name="projectmanager:projectStage:edit">
                    <tfoot>
                    <tr>
                        <td colspan="8"><a href="javascript:"
                                           onclick="addRow('#projectDocumentList', projectDocumentRowIdx, projectDocumentTpl);projectDocumentRowIdx = projectDocumentRowIdx + 1;"
                                           class="btn">新增</a></td>
                    </tr>
                    </tfoot>
                </shiro:hasPermission>
            </table>
            <script type="text/template" id="projectDocumentTpl">//<!--
						<tr id="projectDocumentList{{idx}}">
							<td class="hide">
								<input id="projectDocumentList{{idx}}_id" name="projectDocumentList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="projectDocumentList{{idx}}_delFlag" name="projectDocumentList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<input id="projectDocumentList{{idx}}_documentName" name="projectDocumentList[{{idx}}].documentName" type="text" value="{{row.documentName}}" maxlength="64" class="input-small  required"/>
							</td>
							<td>
								<select id="projectDocumentList{{idx}}_documentType" name="projectDocumentList[{{idx}}].documentType" data-value="{{row.documentType}}" class="input-small required">
									<option value=""></option>
									<c:forEach items="${fns:getDictList('project_document_type')}" var="dict">
										<option value="${dict.value}">${dict.label}</option>
									</c:forEach>
								</select>
							</td>
							<td>
								<input id="projectDocumentList{{idx}}_filePath" name="projectDocumentList[{{idx}}].filePath" type="hidden" value="{{row.filePath}}" maxlength="255"/>
								<sys:ckfinder input="projectDocumentList{{idx}}_filePath" type="files" uploadPath="/projectmanager/projectStage" selectMultiple="true"/>
							</td>
							<%--<td>--%>
								<%--<input id="projectDocumentList{{idx}}_documentNum" name="projectDocumentList[{{idx}}].documentNum" type="text" value="{{row.documentNum}}" class="input-small "/>--%>
							<%--</td>--%>
							<td>
								<textarea id="projectDocumentList{{idx}}_remarks" name="projectDocumentList[{{idx}}].remarks" rows="4" maxlength="255" class="input-small ">{{row.remarks}}</textarea>
							</td>
							<shiro:hasPermission name="projectmanager:projectStage:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#projectDocumentList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
            </script>
            <script type="text/javascript">
            var projectDocumentRowIdx = 0,
                projectDocumentTpl = $("#projectDocumentTpl").html().replace(
                    /(\/\/\<!\-\-)|(\/\/\-\->)/g, "");
            $(document).ready(function () {
              var data = ${fns:toJson(projectStage.projectDocumentList)};
              for (var i = 0; i < data.length; i++) {
                addRow('#projectDocumentList', projectDocumentRowIdx, projectDocumentTpl, data[i]);
                projectDocumentRowIdx = projectDocumentRowIdx + 1;
              }
            });
            </script>
        </div>
    </div>
    <div class="form-actions">
        <shiro:hasPermission name="projectmanager:projectStage:edit"><input id="btnSubmit"
                                                                            class="btn btn-primary"
                                                                            type="submit"
                                                                            value="保 存"/>&nbsp;</shiro:hasPermission>
        <input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
    </div>
</form:form>
</body>
</html>