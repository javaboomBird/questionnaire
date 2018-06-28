<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>项目任务信息管理管理</title>
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

      //项目下拉框change事件
      $("#projectId").change(function () {
        var projectId = $(this).val();
        $.ajax({
          type: "get",
          url: "${ctx}/projectmanager/projectStage/getAll?projectId=" + projectId,
          dataType: "JSON",
          success: function (data) {
            $("#stageId").empty();
            $("#stageId").prepend("<option value=''>请选择</option>");
            $("#taskPre").empty();
            $("#taskPre").prepend("<option value=''>请选择</option>");
            if (data.length > 0) {
              for (var index = 0; index < data.length; index++) {

                $("#stageId").append("<option value='" + data[index].id + "'>"
                    + data[index].stageName + "</option>");
              }
            }
          }, error: function () {

          }
        });
      });
      //项目阶段change事件
      $("#stageId").change(function () {
        var stageId = $(this).val();
        $.ajax({
          type: "get",
          url: "${ctx}/projectmanager/projectTask/getAll?stageId=" + stageId,
          dataType: "JSON",
          success: function (data) {
            $("#taskPre").empty();
            $("#taskPre").prepend("<option value=''>请选择</option>");
            if (data.length > 0) {
              var get = '${projectTask.taskPre}';
              for (var index = 0; index < data.length; index++) {
                if (get == data[index].id) {
                  $("#taskPre").append("<option value='" + data[index].id + "' selected>"
                      + data[index].taskName + "</option>");
                } else {
                  $("#taskPre").append("<option value='" + data[index].id + "'>"
                      + data[index].taskName + "</option>");
                }
              }
            }
          }, error: function () {

          }
        });
      });

    });

    function addRow(list, idx, tpl, row) {
      $(list).append(Mustache.render(tpl, {
        idx: idx, delBtn: true, row: row
      }));
      $(list + idx).find("select").each(function () {
        $(this).val($(this).attr("data-value"));
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
      } else if (delFlag.val() == "N") {
        delFlag.val("Y");
        $(obj).html("&divide;").attr("title", "撤销删除");
        $(obj).parent().parent().addClass("error");
      } else if (delFlag.val() == "Y") {
        delFlag.val("N");
        $(obj).html("&times;").attr("title", "删除");
        $(obj).parent().parent().removeClass("error");
      }
    }


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
<p style="display:inline-block;" class="p-title">项目任务信息查看</p>
<input id="btnCancel" class="btn" style="margin-bottom:10px;float: right;" type="button" value="返 回" onclick="history.go(-1)"/>
<div class="container-fluit container-fluit-m">
<form:form id="inputForm" modelAttribute="projectTask"
           action="${ctx}/projectmanager/projectTask/save" method="post" class="form-horizontal">
    <form:hidden path="id"/>
    <sys:message content="${message}"/>
    <div class="row-fluid row-border row-m-t">
        <div class="span6"><label class="control-label">项目：</label>
            <div class="controls">
                <sys:dynamicselect url="{projectmanager}/projectmanager/project/api/getAll"
                                   cssClass="input-medium required" id="projectId" name="projectId"
                                   valueProperty="id" textProperty="projectName"
                />
                <span class="help-inline"><font color="red">*</font> </span>
            </div>
        </div>
        <div class="span6">
            <label class="control-label">阶段：</label>
            <div class="controls">

                <sys:dynamicselect
                        url="{projectmanager}/projectmanager/projectStage/api/getAll?projectId=${projectTask.projectId}"
                        cssClass="input-medium required" id="stageId" name="stageId"
                        valueProperty="id" textProperty="stageName"/>

                <span class="help-inline"><font color="red">*</font> </span>
            </div>
        </div>
    </div>

    <div class="row-fluid row-border row-m-t">
        <div class="span6">
            <label class="control-label">前置任务：</label>
            <div class="controls">
                <sys:dynamicselect
                        url="{projectmanager}/projectmanager/projectTask/api/getAll?stageId=${projectTask.stageId}"
                        cssClass="input-medium" id="taskPre" name="taskPre"
                        valueProperty="id" textProperty="taskName"/>
            </div>
        </div>
        <div class="span6">
            <label class="control-label">任务名称：</label>
            <div class="controls">
                <form:input path="taskName" htmlEscape="false" maxlength="32"
                            class="input-xlarge required"/>
                <span class="help-inline"><font color="red">*</font> </span>
            </div>
        </div>
    </div>
    <div class=" row-fluid row-border row-m-t">
        <div class="span6">
            <label class="control-label">任务状态：</label>
            <div class="controls">
                <form:select path="taskStatus" class="input-xlarge ">
                    <form:option value="" label=""/>
                    <form:options items="${fns:getDictList('project_task_status')}" itemLabel="label"
                                  itemValue="value" htmlEscape="false"/>
                </form:select>
            </div>
        </div>
        <div class="span6">
            <label class="control-label">负责人：</label>
            <div class="controls">
                <sys:treeselect id="manager" property="managerId" name="manager.id"
                                value="${projectTask.manager.id}" labelName="manager.name"
                                labelValue="${projectTask.manager.name}"
                                title="用户" url="/sys/office/treeData?type=3" cssClass=""
                                allowClear="true" notAllowSelectParent="true"/>
            </div>
        </div>
    </div>

    <div class=" row-fluid row-border row-m-t">
        <div class="span6">
            <label class="control-label">预估工时：</label>
            <div class="controls">
                <form:input path="estimateTime" htmlEscape="false" class="input-xlarge  number"/>
            </div>
        </div>
        <div class="span6">
            <label class="control-label">实际工时：</label>
            <div class="controls">
                <form:input path="actualTime" htmlEscape="false" class="input-xlarge  number"/>
            </div>
        </div>
    </div>

    <div class=" row-fluid row-border row-m-t">
        <div class="span6">
            <label class="control-label">计划开始时间：</label>
            <div class="controls">
                <input name="planStartTime" type="text" readonly="readonly" maxlength="20"
                       class="input-medium Wdate "
                       value="<fmt:formatDate value="${projectTask.planStartTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                       onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
            </div>
        </div>
        <div class="span6">
            <label class="control-label">计划结束时间：</label>
            <div class="controls">
                <input name="planEndTime" type="text" readonly="readonly" maxlength="20"
                       class="input-medium Wdate "
                       value="<fmt:formatDate value="${projectTask.planEndTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                       onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
            </div>
        </div>
    </div>
    <div class=" row-fluid row-border row-m-t">
        <div class="span6">
            <label class="control-label">实际开始时间：</label>
            <div class="controls">
                <input name="actualStartTime" type="text" readonly="readonly" maxlength="20"
                       class="input-medium Wdate "
                       value="<fmt:formatDate value="${projectTask.actualStartTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                       onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
            </div>
        </div>
        <div class="span6">
            <label class="control-label">实际结束时间：</label>
            <div class="controls">
                <input name="actualEndTime" type="text" readonly="readonly" maxlength="20"
                       class="input-medium Wdate "
                       value="<fmt:formatDate value="${projectTask.actualEndTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                       onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
            </div>
        </div>
    </div>
    <div class=" row-fluid row-border row-m-t">
        <div class="span6">
            <label class="control-label">进度：</label>
            <div class="controls">
                <input name="progress"  value="${projectTask.progress==null?0:projectTask.progress}"   maxlength="10"  class="input-xlarge "/>
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

    <div class="control-group">
        <label class="control-label">项目任务成员：</label>
        <div class="controls">
            <table id="contentTable_projectTaskMember"
                   class="table table-striped table-bordered table-condensed">
                <thead>
                <tr>
                    <th class="hide"></th>
                    <th>成员</th>
                    <th>备注</th>
                    <shiro:hasPermission name="projectmanager:projectTask:edit">
                        <th width="10">&nbsp;</th>
                    </shiro:hasPermission>
                </tr>
                </thead>
                <tbody id="projectTaskMemberList">
                </tbody>
                <shiro:hasPermission name="projectmanager:projectTask:edit">
                    <tfoot>
                    <tr>
                        <td colspan="4"></td>
                    </tr>
                    </tfoot>
                </shiro:hasPermission>
            </table>
            <script type="text/template" id="projectTaskMemberTpl">//<!--
						<tr id="projectTaskMemberList{{idx}}">
							<td class="hide">
								<input id="projectTaskMemberList{{idx}}_id" name="projectTaskMemberList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="projectTaskMemberList{{idx}}_delFlag" name="projectTaskMemberList[{{idx}}].isDeleted" type="hidden" value="N"/>
							</td>
							<td>
								<sys:treeselect id="projectTaskMemberList{{idx}}_member" property="projectTaskMemberList[{{idx}}].memberId" name="projectTaskMemberList[{{idx}}].member.id" value="{{row.member.id}}" labelName="projectTaskMemberList{{idx}}.member.name" labelValue="{{row.member.name}}"
									title="用户" url="/sys/office/treeData?type=3" cssClass="required" allowClear="true" notAllowSelectParent="true"/>
							</td>
							<td>
								<textarea id="projectTaskMemberList{{idx}}_remarks" name="projectTaskMemberList[{{idx}}].remarks" rows="4" maxlength="255" class="input-small ">{{row.remarks}}</textarea>
							</td>
							<shiro:hasPermission name="projectmanager:projectTask:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#projectTaskMemberList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
            </script>
            <script type="text/javascript">
            var projectTaskMemberRowIdx = 0,
                projectTaskMemberTpl = $("#projectTaskMemberTpl").html().replace(
                    /(\/\/\<!\-\-)|(\/\/\-\->)/g, "");
            $(document).ready(function () {
              var data = ${fns:toJson(projectTask.projectTaskMemberList)};
              for (var i = 0; i < data.length; i++) {
                addRow('#projectTaskMemberList', projectTaskMemberRowIdx, projectTaskMemberTpl,
                    data[i]);
                projectTaskMemberRowIdx = projectTaskMemberRowIdx + 1;
              }
            });
            </script>
        </div>
    </div>
    <div class="container text-center">
            <%-- <shiro:hasPermission name="customer:enterprise:edit"><input id="btnSubmit"
                                                                         class="btn btn-primary btn-size"
                                                                         type="submit"
                                                                         value="保 存"/>&nbsp;</shiro:hasPermission>--%>
        <input id="btnCancel" class="btn btn-size" type="button" value="返 回" onclick="history.go(-1)"/>
    </div>
</form:form>
</div>
</body>
</html>