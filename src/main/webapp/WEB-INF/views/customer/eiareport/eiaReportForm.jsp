<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>环评报告信息管理管理</title>
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
                $(this).select2();
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
		<li><a href="${ctx}/eiareport/eiaReport/">环评报告信息管理列表</a></li>
		<li class="active"><a href="${ctx}/eiareport/eiaReport/form?id=${eiaReport.id}">环评报告信息管理<shiro:hasPermission name="eiareport:eiaReport:edit">${not empty eiaReport.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="eiareport:eiaReport:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="eiaReport" action="${ctx}/eiareport/eiaReport/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">企业：</label>
			<div class="controls">
        <sys:dynamicselect url="{customer}/enterprise/enterprise/api/getAll" cssClass="input-medium required" id="enterpriseId" name="enterpriseId" valueProperty="id" textProperty="enterpriseName" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">有审批：</label>
			<div class="controls">
				<form:select path="approved" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('eia_approved')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">审批时间：</label>
			<div class="controls">
				<input name="approveDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${eiaReport.approveDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">三同时验收：</label>
			<div class="controls">
				<form:select path="accepted" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('eia_accepted')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">验收时间：</label>
			<div class="controls">
				<input name="acceptDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${eiaReport.acceptDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">存在扩建：</label>
			<div class="controls">
				<form:select path="expanded" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('eia_expanded')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">扩建设备：</label>
			<div class="controls">
				<form:input path="expendedDevice" htmlEscape="false" maxlength="256" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">排污类型：</label>
			<div class="controls">
        <sys:dynamicselect url="{customer}/pt/pollutionType/api/getAll" cssClass="input-medium " id="pollutionTypeId" name="pollutionTypeId" valueProperty="id" textProperty="pollutionTypeName" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">排污许可状况：</label>
			<div class="controls">
				<form:select path="pollutionPermitStatus" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('pollution_permit_status')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">环评报告文件：</label>
			<div class="controls">
				<form:hidden id="reportFile" path="reportFile" htmlEscape="false" maxlength="256" class="input-xlarge"/>
				<sys:ckfinder input="reportFile" type="files" uploadPath="/eiareport/eiaReport" selectMultiple="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
			<div class="control-group">
				<label class="control-label">企业环评上传图片表：</label>
				<div class="controls">
					<table id="contentTable_eiaReportPic" class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th class="hide"></th>
								<th>图片类型</th>
								<th>图片名</th>
								<th>图片保存路径</th>
								<th>备注</th>
								<shiro:hasPermission name="eiareport:eiaReport:edit"><th width="10">&nbsp;</th></shiro:hasPermission>
							</tr>
						</thead>
						<tbody id="eiaReportPicList">
						</tbody>
						<shiro:hasPermission name="eiareport:eiaReport:edit"><tfoot>
							<tr><td colspan="6"><a href="javascript:" onclick="addRow('#eiaReportPicList', eiaReportPicRowIdx, eiaReportPicTpl);eiaReportPicRowIdx = eiaReportPicRowIdx + 1;" class="btn">新增</a></td></tr>
						</tfoot></shiro:hasPermission>
					</table>
					<script type="text/template" id="eiaReportPicTpl">//<!--
						<tr id="eiaReportPicList{{idx}}">
							<td class="hide">
								<input id="eiaReportPicList{{idx}}_id" name="eiaReportPicList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="eiaReportPicList{{idx}}_delFlag" name="eiaReportPicList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<input id="eiaReportPicList{{idx}}_type" name="eiaReportPicList[{{idx}}].type" type="text" value="{{row.type}}" maxlength="32" class="input-small "/>
							</td>
							<td>
								<input id="eiaReportPicList{{idx}}_name" name="eiaReportPicList[{{idx}}].name" type="text" value="{{row.name}}" maxlength="64" class="input-small "/>
							</td>
							<td>
								<input id="eiaReportPicList{{idx}}_filePath" name="eiaReportPicList[{{idx}}].filePath" type="hidden" value="{{row.filePath}}" maxlength="256"/>
								<sys:ckfinder input="eiaReportPicList{{idx}}_filePath" type="files" uploadPath="/eiareport/eiaReport" selectMultiple="true"/>
							</td>
							<td>
								<textarea id="eiaReportPicList{{idx}}_remarks" name="eiaReportPicList[{{idx}}].remarks" rows="4" maxlength="255" class="input-small ">{{row.remarks}}</textarea>
							</td>
							<shiro:hasPermission name="eiareport:eiaReport:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#eiaReportPicList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
					</script>
					<script type="text/javascript">
						var eiaReportPicRowIdx = 0, eiaReportPicTpl = $("#eiaReportPicTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(eiaReport.eiaReportPicList)};
							for (var i=0; i<data.length; i++){
								addRow('#eiaReportPicList', eiaReportPicRowIdx, eiaReportPicTpl, data[i]);
								eiaReportPicRowIdx = eiaReportPicRowIdx + 1;
							}
						});
					</script>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">企业环评排放物表：</label>
				<div class="controls">
					<table id="contentTable_eiaReportWaste" class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th class="hide"></th>
								<th>排放类型</th>
								<th>允许浓度</th>
								<th>允许总量</th>
								<th>备注</th>
								<shiro:hasPermission name="eiareport:eiaReport:edit"><th width="10">&nbsp;</th></shiro:hasPermission>
							</tr>
						</thead>
						<tbody id="eiaReportWasteList">
						</tbody>
						<shiro:hasPermission name="eiareport:eiaReport:edit"><tfoot>
							<tr><td colspan="6"><a href="javascript:" onclick="addRow('#eiaReportWasteList', eiaReportWasteRowIdx, eiaReportWasteTpl);eiaReportWasteRowIdx = eiaReportWasteRowIdx + 1;" class="btn">新增</a></td></tr>
						</tfoot></shiro:hasPermission>
					</table>
					<script type="text/template" id="eiaReportWasteTpl">//<!--
						<tr id="eiaReportWasteList{{idx}}">
							<td class="hide">
								<input id="eiaReportWasteList{{idx}}_id" name="eiaReportWasteList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="eiaReportWasteList{{idx}}_delFlag" name="eiaReportWasteList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<input id="eiaReportWasteList{{idx}}_type" name="eiaReportWasteList[{{idx}}].type" type="text" value="{{row.type}}" maxlength="32" class="input-small "/>
							</td>
							<td>
								<input id="eiaReportWasteList{{idx}}_allowConcentration" name="eiaReportWasteList[{{idx}}].allowConcentration" type="text" value="{{row.allowConcentration}}" maxlength="128" class="input-small "/>
							</td>
							<td>
								<input id="eiaReportWasteList{{idx}}_allowScale" name="eiaReportWasteList[{{idx}}].allowScale" type="text" value="{{row.allowScale}}" maxlength="128" class="input-small "/>
							</td>
							<td>
								<textarea id="eiaReportWasteList{{idx}}_remarks" name="eiaReportWasteList[{{idx}}].remarks" rows="4" maxlength="255" class="input-small ">{{row.remarks}}</textarea>
							</td>
							<shiro:hasPermission name="eiareport:eiaReport:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#eiaReportWasteList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
					</script>
					<script type="text/javascript">
						var eiaReportWasteRowIdx = 0, eiaReportWasteTpl = $("#eiaReportWasteTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(eiaReport.eiaReportWasteList)};
							for (var i=0; i<data.length; i++){
								addRow('#eiaReportWasteList', eiaReportWasteRowIdx, eiaReportWasteTpl, data[i]);
								eiaReportWasteRowIdx = eiaReportWasteRowIdx + 1;
							}
						});
					</script>
				</div>
			</div>
		<div class="form-actions">
			<shiro:hasPermission name="eiareport:eiaReport:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>