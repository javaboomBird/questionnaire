<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>分组管理管理</title>
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
    <li><a href="${ctx}/group/sysGroup/">分组管理列表</a></li>
    <li class="active"><a
            href="${ctx}/group/sysGroup/form?id=${sysGroup.id}">分组管理<shiro:hasPermission
            name="group:sysGroup:edit">${not empty sysGroup.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission
            name="group:sysGroup:edit">查看</shiro:lacksPermission></a></li>
</ul>
<br/>
<form:form id="inputForm" modelAttribute="sysGroup" action="${ctx}/group/sysGroup/save"
           method="post" class="form-horizontal">
    <form:hidden path="id"/>
    <sys:message content="${message}"/>
    <div class="control-group">
        <label class="control-label">组织：</label>
        <div class="controls">
            <sys:treeselect id="office" property="officeId" name="office.id"
                            value="${sysGroup.office.id}" labelName="office.name"
                            labelValue="${sysGroup.office.name}"
                            title="部门" url="/sys/office/treeData?type=2" cssClass="required"
                            allowClear="true" notAllowSelectParent="true"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">组名：</label>
        <div class="controls">
            <form:input path="groupName" htmlEscape="false" maxlength="32" class="input-xlarge "/>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label">小组类别：</label>
        <div class="controls">
            <form:select path="groupType" class="input-xlarge ">
                <form:option value="" label=""/>
                <form:options items="${fns:getDictList('sys_group_type')}" itemLabel="label"
                              itemValue="value" htmlEscape="false"/>
            </form:select>
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
        <label class="control-label">分组用户表：</label>
        <div class="controls">
            <table id="contentTable_sysUserGroup"
                   class="table table-striped table-bordered table-condensed">
                <thead>
                <tr>
                    <th class="hide"></th>
                    <th>用户</th>
                    <th>小组角色</th>
                    <th>备注</th>
                    <shiro:hasPermission name="group:sysGroup:edit">
                        <th width="10">&nbsp;</th>
                    </shiro:hasPermission>
                </tr>
                </thead>
                <tbody id="sysUserGroupList">
                </tbody>
                <shiro:hasPermission name="group:sysGroup:edit">
                    <tfoot>
                    <tr>
                        <td colspan="5"><a href="javascript:"
                                           onclick="addRow('#sysUserGroupList', sysUserGroupRowIdx, sysUserGroupTpl);sysUserGroupRowIdx = sysUserGroupRowIdx + 1;"
                                           class="btn">新增</a></td>
                    </tr>
                    </tfoot>
                </shiro:hasPermission>
            </table>
            <script type="text/template" id="sysUserGroupTpl">//<!--
						<tr id="sysUserGroupList{{idx}}">
							<td class="hide">
								<input id="sysUserGroupList{{idx}}_id" name="sysUserGroupList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="sysUserGroupList{{idx}}_delFlag" name="sysUserGroupList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<sys:treeselect id="sysUserGroupList{{idx}}_user" property="sysUserGroupList[{{idx}}].userId" name="sysUserGroupList[{{idx}}].user.id" value="{{row.user.id}}" labelName="sysUserGroupList{{idx}}.user.name" labelValue="{{row.user.name}}"
									title="用户" url="/sys/office/treeData?type=3" cssClass="" allowClear="true" notAllowSelectParent="true"/>
							</td>

							<td>
								<select id="sysUserGroupList{{idx}}_groupRole" name="sysUserGroupList[{{idx}}].groupRole" data-value="{{row.groupRole}}" class="input-small ">
									<option value=""></option>
									<c:forEach items="${fns:getDictList('sys_group_member_role')}" var="dict">
										<option value="${dict.value}">${dict.label}</option>
									</c:forEach>
								</select>
							</td>
							<td>
								<textarea id="sysUserGroupList{{idx}}_remarks" name="sysUserGroupList[{{idx}}].remarks" rows="4" maxlength="255" class="input-small ">{{row.remarks}}</textarea>
							</td>
							<shiro:hasPermission name="group:sysGroup:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#sysUserGroupList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
            </script>
            <script type="text/javascript">
            var sysUserGroupRowIdx = 0,
                sysUserGroupTpl = $("#sysUserGroupTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,
                    "");
            $(document).ready(function () {
              var data = ${fns:toJson(sysGroup.sysUserGroupList)};
              for (var i = 0; i < data.length; i++) {
                addRow('#sysUserGroupList', sysUserGroupRowIdx, sysUserGroupTpl, data[i]);
                sysUserGroupRowIdx = sysUserGroupRowIdx + 1;
              }
            });
            </script>
        </div>
    </div>
    <div class="form-actions">
        <shiro:hasPermission name="group:sysGroup:edit"><input id="btnSubmit"
                                                               class="btn btn-primary" type="submit"
                                                               value="保 存"/>&nbsp;</shiro:hasPermission>
        <input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
    </div>
</form:form>
</body>
</html>