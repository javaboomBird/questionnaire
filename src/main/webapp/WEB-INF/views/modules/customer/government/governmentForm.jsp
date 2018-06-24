<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>政府信息管理管理</title>
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
</head>
<body>
<ul class="nav nav-tabs">
    <li><a href="${ctx}/customer/government/">政府信息管理列表</a></li>
    <li class="active"><a
            href="${ctx}/customer/government/form?id=${government.id}">政府信息管理<shiro:hasPermission
            name="customer:government:edit">${not empty government.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission
            name="customer:government:edit">查看</shiro:lacksPermission></a></li>
</ul>
<br/>
<form:form id="inputForm" modelAttribute="customer" action="${ctx}/customer/government/save"
           method="post" class="form-horizontal">
    <form:hidden path="id"/>
    <input type="hidden" name="type"  value="${empty customer.type?'GT':customer.type}"/>
    <sys:message content="${message}"/>
    <div class="control-group">
        <label class="control-label">政府名称：</label>
        <div class="controls">
            <form:input path="name" htmlEscape="false" maxlength="64"
                        class="input-xlarge required"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">纬度：</label>
        <div class="controls">
            <form:input path="lat" htmlEscape="false" class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">经度：</label>
        <div class="controls">
            <form:input path="lng" htmlEscape="false" class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">统一社会信用代码：</label>
        <div class="controls">
            <form:input path="uscCode" htmlEscape="false" maxlength="32"
                        class="input-xlarge required"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">地址：</label>
        <div class="controls">
            <form:input path="registeredAddress" htmlEscape="false" maxlength="128"
                        class="input-xlarge required"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">注册邮编：</label>
        <div class="controls">
            <form:input path="registeredPostcode" htmlEscape="false" class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">办公电话：</label>
        <div class="controls">
            <form:input path="businessPhone" htmlEscape="false" maxlength="32"
                        class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">fax 号码：</label>
        <div class="controls">
            <form:input path="businessFax" htmlEscape="false" maxlength="32" class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">银行账户名称：</label>
        <div class="controls">
            <form:input path="bankAccount" htmlEscape="false" maxlength="64" class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">银行账户卡号：</label>
        <div class="controls">
            <form:input path="bankNumber" htmlEscape="false" maxlength="32" class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">开户行名称：</label>
        <div class="controls">
            <form:input path="bankName" htmlEscape="false" maxlength="32" class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">税号：</label>
        <div class="controls">
            <form:input path="taxNumber" htmlEscape="false" maxlength="32" class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">开票电话：</label>
        <div class="controls">
            <form:input path="taxPhone" htmlEscape="false" maxlength="32" class="input-xlarge "/>
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
        <label class="control-label">区域：</label>
        <div class="controls">
            <sys:treeselect id="area" property="areaId" name="area.id" value="${customer.area.id}"
                            labelName="area.name" labelValue="${customer.area.name}"
                            title="区域" url="/sys/area/treeData" cssClass="" allowClear="true"
                            notAllowSelectParent="true"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">联系人表：</label>
        <div class="controls">
            <table id="contentTable_contact"
                   class="table table-striped table-bordered table-condensed">
                <thead>
                <tr>
                    <th class="hide"></th>
                        <%--<th>联系人类型</th>--%>
                    <th>联系人</th>
                    <th>职务</th>
                    <th>电话</th>
                    <th>邮箱</th>
                    <th>备注</th>
                    <shiro:hasPermission name="customer:government:edit">
                        <th width="10">&nbsp;</th>
                    </shiro:hasPermission>
                </tr>
                </thead>
                <tbody id="customerContactList">
                </tbody>
                <shiro:hasPermission name="customer:government:edit">
                    <tfoot>
                    <tr>
                        <td colspan="8"><a href="javascript:"
                                           onclick="addRow('#customerContactList', contactRowIdx, contactTpl);contactRowIdx = contactRowIdx + 1;"
                                           class="btn">新增</a></td>
                    </tr>
                    </tfoot>
                </shiro:hasPermission>
            </table>
            <script type="text/template" id="contactTpl">//<!--
						<tr id="customerContactList{{idx}}">
							<td class="hide">
								<input id="customerContactList{{idx}}_id" name="customerContactList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="customerContactList{{idx}}_delFlag" name="customerContactList[{{idx}}].isDeleted" type="hidden" value="N"/>
							</td>
							<%--<td>--%>
								<%--<select id="customerContactList{{idx}}_customerType" name="customerContactList[{{idx}}].customerType" data-value="{{row.customerType}}" class="input-small required">--%>
									<%--<option value=""></option>--%>
									<%--<c:forEach items="${fns:getDictList('customer_type')}" var="dict">--%>
										<%--<option value="${dict.value}">${dict.label}</option>--%>
									<%--</c:forEach>--%>
								<%--</select>--%>
							<%--</td>--%>
							<td>
								<input id="customerContactList{{idx}}_name" name="customerContactList[{{idx}}].name" type="text" value="{{row.name}}" maxlength="32" class="input-small "/>
							</td>
							<td>
								<input id="customerContactList{{idx}}_title" name="customerContactList[{{idx}}].title" type="text" value="{{row.title}}" maxlength="32" class="input-small "/>
							</td>
							<td>
								<input id="customerContactList{{idx}}_phone" name="customerContactList[{{idx}}].phone" type="text" value="{{row.phone}}" maxlength="32" class="input-small "/>
							</td>
							<td>
								<input id="customerContactList{{idx}}_email" name="customerContactList[{{idx}}].email" type="text" value="{{row.email}}" maxlength="32" class="input-small "/>
							</td>
							<td>
								<textarea id="customerContactList{{idx}}_remarks" name="customerContactList[{{idx}}].remarks" rows="4" maxlength="255" class="input-small ">{{row.remarks}}</textarea>
							</td>
							<shiro:hasPermission name="customer:government:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#customerContactList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
            </script>
            <script type="text/javascript">
            var contactRowIdx = 0,
                contactTpl = $("#contactTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g, "");
            $(document).ready(function () {
              var data = ${fns:toJson(customer.customerContactList)};
              for (var i = 0; i < data.length; i++) {
                addRow('#customerContactList', contactRowIdx, contactTpl, data[i]);
                contactRowIdx = contactRowIdx + 1;
              }
            });
            </script>
        </div>
    </div>
    <div class="form-actions">
        <shiro:hasPermission name="customer:government:edit"><input id="btnSubmit"
                                                                      class="btn btn-primary"
                                                                      type="submit"
                                                                      value="保 存"/>&nbsp;</shiro:hasPermission>
        <input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
    </div>
</form:form>
</body>
</html>