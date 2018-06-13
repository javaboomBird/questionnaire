<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>合同收款管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
		function addRow(list, idx, tpl, row){
			$(list).append(Mustache.render(tpl, {
				idx: idx, delBtn: true, row: row
			}));
			$(list+idx).find("select").each(function(){
				$(this).val($(this).attr("data-value"));
			});
			$(list+idx).find("input[type='checkbox'], input[type='radio']").each(function(){
				var ss = $(this).attr("data-value").split(',');
				for (var i=0; i<ss.length; i++){
					if($(this).val() == ss[i]){
						$(this).attr("checked","checked");
					}
				}
			});
		}
		function delRow(obj, prefix){
			var id = $(prefix+"_id");
			var delFlag = $(prefix+"_delFlag");
			if (id.val() == ""){
				$(obj).parent().parent().remove();
			}else if(delFlag.val() == "0"){
				delFlag.val("1");
				$(obj).html("&divide;").attr("title", "撤销删除");
				$(obj).parent().parent().addClass("error");
			}else if(delFlag.val() == "1"){
				delFlag.val("0");
				$(obj).html("&times;").attr("title", "删除");
				$(obj).parent().parent().removeClass("error");
			}
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/contract/contractAccountsReceivable/">合同收款列表</a></li>
		<li class="active"><a href="${ctx}/contract/contractAccountsReceivable/form?id=${contractAccountsReceivable.id}">合同收款<shiro:hasPermission name="contract:contractAccountsReceivable:edit">${not empty contractAccountsReceivable.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="contract:contractAccountsReceivable:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="contractAccountsReceivable" action="${ctx}/contract/contractAccountsReceivable/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
            <label class="control-label">合同名称：</label>
			<div class="controls">
        <sys:dynamicselect url="{contract}/contract/contract/api/getAll" cssClass="input-medium " id="contractId" name="contractId" valueProperty="id" textProperty="projectName" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">应收款名称：</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">应收款条件：</label>
			<div class="controls">
				<form:input path="condition" htmlEscape="false" maxlength="128" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">应收账款：</label>
			<div class="controls">
				<form:input path="accountsReceivable" htmlEscape="false" class="input-xlarge  number"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">应收账款百分比：</label>
			<div class="controls">
				<form:input path="accountsReceivablePercent" htmlEscape="false" class="input-xlarge  digits"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">应收账款方式：</label>
			<div class="controls">
				<form:select path="accountsReceivableMethod" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('cms_accounts_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">应收账款时间：</label>
			<div class="controls">
				<input name="accountsReceivableDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${contractAccountsReceivable.accountsReceivableDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否持续提醒：</label>
			<div class="controls">
				<form:radiobuttons path="keepNotification" items="${fns:getDictList('boolean')}" itemLabel="label" itemValue="value" htmlEscape="false" class=""/>
			</div>
		</div>
			<div class="control-group">
				<label class="control-label">合同已收款信息表：</label>
				<div class="controls">
					<table id="contentTable_contractAccountsReceived" class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th class="hide"></th>
								<th>已收款名称</th>
								<th>已收账款</th>
								<th>已收账款百分比</th>
								<th>已收账款方式</th>
								<th>已收账款时间</th>
								<th>备注</th>
								<shiro:hasPermission name="contract:contractAccountsReceivable:edit"><th width="10">&nbsp;</th></shiro:hasPermission>
							</tr>
						</thead>
						<tbody id="contractAccountsReceivedList">
						</tbody>
						<shiro:hasPermission name="contract:contractAccountsReceivable:edit"><tfoot>
							<tr><td colspan="8"><a href="javascript:" onclick="addRow('#contractAccountsReceivedList', contractAccountsReceivedRowIdx, contractAccountsReceivedTpl);contractAccountsReceivedRowIdx = contractAccountsReceivedRowIdx + 1;" class="btn">新增</a></td></tr>
						</tfoot></shiro:hasPermission>
					</table>
					<script type="text/template" id="contractAccountsReceivedTpl">//<!--
						<tr id="contractAccountsReceivedList{{idx}}">
							<td class="hide">
								<input id="contractAccountsReceivedList{{idx}}_id" name="contractAccountsReceivedList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="contractAccountsReceivedList{{idx}}_delFlag" name="contractAccountsReceivedList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<input id="contractAccountsReceivedList{{idx}}_name" name="contractAccountsReceivedList[{{idx}}].name" type="text" value="{{row.name}}" maxlength="64" class="input-small "/>
							</td>
							<td>
								<input id="contractAccountsReceivedList{{idx}}_accountsReceived" name="contractAccountsReceivedList[{{idx}}].accountsReceived" type="text" value="{{row.accountsReceived}}" class="input-small  number"/>
							</td>
							<td>
								<input id="contractAccountsReceivedList{{idx}}_accountsReceivedPercent" name="contractAccountsReceivedList[{{idx}}].accountsReceivedPercent" type="text" value="{{row.accountsReceivedPercent}}" class="input-small  digits"/>
							</td>
							<td>
								<select id="contractAccountsReceivedList{{idx}}_accountsReceivedMethod" name="contractAccountsReceivedList[{{idx}}].accountsReceivedMethod" data-value="{{row.accountsReceivedMethod}}" class="input-small ">
									<option value=""></option>
									<c:forEach items="${fns:getDictList('cms_accounts_type')}" var="dict">
										<option value="${dict.value}">${dict.label}</option>
									</c:forEach>
								</select>
							</td>
							<td>
								<input id="contractAccountsReceivedList{{idx}}_accountsReceivedDate" name="contractAccountsReceivedList[{{idx}}].accountsReceivedDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
									value="{{row.accountsReceivedDate}}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
							</td>
							<td>
								<textarea id="contractAccountsReceivedList{{idx}}_remarks" name="contractAccountsReceivedList[{{idx}}].remarks" rows="4" maxlength="256" class="input-small ">{{row.remarks}}</textarea>
							</td>
							<shiro:hasPermission name="contract:contractAccountsReceivable:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#contractAccountsReceivedList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
					</script>
					<script type="text/javascript">
						var contractAccountsReceivedRowIdx = 0, contractAccountsReceivedTpl = $("#contractAccountsReceivedTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(contractAccountsReceivable.contractAccountsReceivedList)};
							for (var i=0; i<data.length; i++){
								addRow('#contractAccountsReceivedList', contractAccountsReceivedRowIdx, contractAccountsReceivedTpl, data[i]);
								contractAccountsReceivedRowIdx = contractAccountsReceivedRowIdx + 1;
							}
						});
					</script>
				</div>
			</div>
		<div class="form-actions">
			<shiro:hasPermission name="contract:contractAccountsReceivable:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>