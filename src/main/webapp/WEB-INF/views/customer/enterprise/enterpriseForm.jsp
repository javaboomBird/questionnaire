<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>企业信息管理管理</title>
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
		<li><a href="${ctx}/enterprise/enterprise/">企业信息管理列表</a></li>
		<li class="active"><a href="${ctx}/enterprise/enterprise/form?id=${enterprise.id}">企业信息管理<shiro:hasPermission name="enterprise:enterprise:edit">${not empty enterprise.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="enterprise:enterprise:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="enterprise" action="${ctx}/enterprise/enterprise/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">企业名称：</label>
			<div class="controls">
				<form:input path="enterpriseName" htmlEscape="false" maxlength="64" class="input-xlarge required"/>
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
			<label class="control-label">信用代码：</label>
			<div class="controls">
				<form:input path="uscCode" htmlEscape="false" maxlength="32" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">法人：</label>
			<div class="controls">
				<form:input path="legalPerson" htmlEscape="false" maxlength="32" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">注册资本：</label>
			<div class="controls">
				<form:input path="registeredCapital" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">注册日期：</label>
			<div class="controls">
				<input name="registeredDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${enterprise.registeredDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">注册地址：</label>
			<div class="controls">
				<form:input path="registeredAddress" htmlEscape="false" maxlength="128" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">注册邮编：</label>
			<div class="controls">
				<form:input path="registeredPostcode" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">区域：</label>
			<div class="controls">
				<sys:treeselect id="area" name="area.id" value="${enterprise.area.id}" labelName="area.name" labelValue="${enterprise.area.name}"
					title="区域" url="/sys/area/treeData" cssClass="required" allowClear="true" notAllowSelectParent="true"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">经营范围：</label>
			<div class="controls">
				<form:input path="businessScope" htmlEscape="false" maxlength="512" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">办公电话：</label>
			<div class="controls">
				<form:input path="businessPhone" htmlEscape="false" maxlength="32" class="input-xlarge "/>
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
				<form:input path="taxNumber" htmlEscape="false" maxlength="32" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">开票电话：</label>
			<div class="controls">
				<form:input path="taxPhone" htmlEscape="false" maxlength="32" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">回用类型：</label>
			<div class="controls">
				<form:select path="recyclingType" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('recycling_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">企业状态：</label>
			<div class="controls">
				<form:select path="statusType" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('status_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
			<div class="control-group">
				<label class="control-label">企业工商类型：</label>
				<div class="controls">
					<table id="contentTable_enterpriseBusinessTypeRelation" class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th class="hide"></th>
								<th>工商类型</th>
								<th>备注</th>
								<shiro:hasPermission name="enterprise:enterprise:edit"><th width="10">&nbsp;</th></shiro:hasPermission>
							</tr>
						</thead>
						<tbody id="enterpriseBusinessTypeRelationList">
						</tbody>
						<shiro:hasPermission name="enterprise:enterprise:edit"><tfoot>
							<tr><td colspan="4"><a href="javascript:" onclick="addRow('#enterpriseBusinessTypeRelationList', enterpriseBusinessTypeRelationRowIdx, enterpriseBusinessTypeRelationTpl);enterpriseBusinessTypeRelationRowIdx = enterpriseBusinessTypeRelationRowIdx + 1;" class="btn">新增</a></td></tr>
						</tfoot></shiro:hasPermission>
					</table>
					<script type="text/template" id="enterpriseBusinessTypeRelationTpl">//<!--
						<tr id="enterpriseBusinessTypeRelationList{{idx}}">
							<td class="hide">
								<input id="enterpriseBusinessTypeRelationList{{idx}}_id" name="enterpriseBusinessTypeRelationList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="enterpriseBusinessTypeRelationList{{idx}}_delFlag" name="enterpriseBusinessTypeRelationList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
							<select id="enterpriseBusinessTypeRelationList{{idx}}_businessTypeId" name="enterpriseBusinessTypeRelationList[{{idx}}].businessTypeId" data-value="{{row.businessTypeId}}" class="input-small required">
									<option value="">请选择</option>
									<c:forEach items="${fns:getDataList('{customer}/bt/businessType/api/getAll','id' , 'businessTypeName')}" var="m">
										<option value="${m.key}">${m.value}</option>
									</c:forEach>
							</select>
							</td>
							<td>
								<textarea id="enterpriseBusinessTypeRelationList{{idx}}_remarks" name="enterpriseBusinessTypeRelationList[{{idx}}].remarks" rows="4" maxlength="255" class="input-small ">{{row.remarks}}</textarea>
							</td>
							<shiro:hasPermission name="enterprise:enterprise:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#enterpriseBusinessTypeRelationList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
					</script>
					<script type="text/javascript">
						var enterpriseBusinessTypeRelationRowIdx = 0, enterpriseBusinessTypeRelationTpl = $("#enterpriseBusinessTypeRelationTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(enterprise.enterpriseBusinessTypeRelationList)};
							for (var i=0; i<data.length; i++){
								addRow('#enterpriseBusinessTypeRelationList', enterpriseBusinessTypeRelationRowIdx, enterpriseBusinessTypeRelationTpl, data[i]);
								enterpriseBusinessTypeRelationRowIdx = enterpriseBusinessTypeRelationRowIdx + 1;
							}
						});
					</script>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">企业污染行业类型：</label>
				<div class="controls">
					<table id="contentTable_enterpriseIndustryTypeRelation" class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th class="hide"></th>
								<th>污染行业类型</th>
								<th>备注</th>
								<shiro:hasPermission name="enterprise:enterprise:edit"><th width="10">&nbsp;</th></shiro:hasPermission>
							</tr>
						</thead>
						<tbody id="enterpriseIndustryTypeRelationList">
						</tbody>
						<shiro:hasPermission name="enterprise:enterprise:edit"><tfoot>
							<tr><td colspan="4"><a href="javascript:" onclick="addRow('#enterpriseIndustryTypeRelationList', enterpriseIndustryTypeRelationRowIdx, enterpriseIndustryTypeRelationTpl);enterpriseIndustryTypeRelationRowIdx = enterpriseIndustryTypeRelationRowIdx + 1;" class="btn">新增</a></td></tr>
						</tfoot></shiro:hasPermission>
					</table>
					<script type="text/template" id="enterpriseIndustryTypeRelationTpl">//<!--
						<tr id="enterpriseIndustryTypeRelationList{{idx}}">
							<td class="hide">
								<input id="enterpriseIndustryTypeRelationList{{idx}}_id" name="enterpriseIndustryTypeRelationList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="enterpriseIndustryTypeRelationList{{idx}}_delFlag" name="enterpriseIndustryTypeRelationList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<select id="enterpriseIndustryTypeRelationList{{idx}}_industryTypeId" name="enterpriseIndustryTypeRelationList[{{idx}}].industryTypeId" data-value="{{row.industryTypeId}}" class="input-small required">
									<option value="">请选择</option>
									<c:forEach items="${fns:getDataList('{customer}/it/industryType/api/getAll','id' , 'industryTypeName')}" var="m">
										<option value="${m.key}">${m.value}</option>
									</c:forEach>
								</select>
							</td>
							<td>
								<textarea id="enterpriseIndustryTypeRelationList{{idx}}_remarks" name="enterpriseIndustryTypeRelationList[{{idx}}].remarks" rows="4" maxlength="255" class="input-small ">{{row.remarks}}</textarea>
							</td>
							<shiro:hasPermission name="enterprise:enterprise:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#enterpriseIndustryTypeRelationList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
					</script>
					<script type="text/javascript">
						var enterpriseIndustryTypeRelationRowIdx = 0, enterpriseIndustryTypeRelationTpl = $("#enterpriseIndustryTypeRelationTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(enterprise.enterpriseIndustryTypeRelationList)};
							for (var i=0; i<data.length; i++){
								addRow('#enterpriseIndustryTypeRelationList', enterpriseIndustryTypeRelationRowIdx, enterpriseIndustryTypeRelationTpl, data[i]);
								enterpriseIndustryTypeRelationRowIdx = enterpriseIndustryTypeRelationRowIdx + 1;
							}
						});
					</script>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">企业图片表：</label>
				<div class="controls">
					<table id="contentTable_enterprisePic" class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th class="hide"></th>
								<th>图片路径</th>
								<th>备注</th>
								<shiro:hasPermission name="enterprise:enterprise:edit"><th width="10">&nbsp;</th></shiro:hasPermission>
							</tr>
						</thead>
						<tbody id="enterprisePicList">
						</tbody>
						<shiro:hasPermission name="enterprise:enterprise:edit"><tfoot>
							<tr><td colspan="4"><a href="javascript:" onclick="addRow('#enterprisePicList', enterprisePicRowIdx, enterprisePicTpl);enterprisePicRowIdx = enterprisePicRowIdx + 1;" class="btn">新增</a></td></tr>
						</tfoot></shiro:hasPermission>
					</table>
					<script type="text/template" id="enterprisePicTpl">//<!--
						<tr id="enterprisePicList{{idx}}">
							<td class="hide">
								<input id="enterprisePicList{{idx}}_id" name="enterprisePicList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="enterprisePicList{{idx}}_delFlag" name="enterprisePicList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<input id="enterprisePicList{{idx}}_filePath" name="enterprisePicList[{{idx}}].filePath" type="hidden" value="{{row.filePath}}" maxlength="256"/>
								<sys:ckfinder input="enterprisePicList{{idx}}_filePath" type="files" uploadPath="/enterprise/enterprise" selectMultiple="true"/>
							</td>
							<td>
								<textarea id="enterprisePicList{{idx}}_remarks" name="enterprisePicList[{{idx}}].remarks" rows="4" maxlength="255" class="input-small ">{{row.remarks}}</textarea>
							</td>
							<shiro:hasPermission name="enterprise:enterprise:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#enterprisePicList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
					</script>
					<script type="text/javascript">
						var enterprisePicRowIdx = 0, enterprisePicTpl = $("#enterprisePicTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(enterprise.enterprisePicList)};
							for (var i=0; i<data.length; i++){
								addRow('#enterprisePicList', enterprisePicRowIdx, enterprisePicTpl, data[i]);
								enterprisePicRowIdx = enterprisePicRowIdx + 1;
							}
						});
					</script>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">企业排污类型：</label>
				<div class="controls">
					<table id="contentTable_enterprisePollutionTypeRelation" class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th class="hide"></th>
								<th>排污类型</th>
								<th>备注</th>
								<shiro:hasPermission name="enterprise:enterprise:edit"><th width="10">&nbsp;</th></shiro:hasPermission>
							</tr>
						</thead>
						<tbody id="enterprisePollutionTypeRelationList">
						</tbody>
						<shiro:hasPermission name="enterprise:enterprise:edit"><tfoot>
							<tr><td colspan="4"><a href="javascript:" onclick="addRow('#enterprisePollutionTypeRelationList', enterprisePollutionTypeRelationRowIdx, enterprisePollutionTypeRelationTpl);enterprisePollutionTypeRelationRowIdx = enterprisePollutionTypeRelationRowIdx + 1;" class="btn">新增</a></td></tr>
						</tfoot></shiro:hasPermission>
					</table>
					<script type="text/template" id="enterprisePollutionTypeRelationTpl">//<!--
						<tr id="enterprisePollutionTypeRelationList{{idx}}">
							<td class="hide">
								<input id="enterprisePollutionTypeRelationList{{idx}}_id" name="enterprisePollutionTypeRelationList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="enterprisePollutionTypeRelationList{{idx}}_delFlag" name="enterprisePollutionTypeRelationList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
							<select id="enterprisePollutionTypeRelationList{{idx}}_pollutionTypeId" name="enterprisePollutionTypeRelationList[{{idx}}].pollutionTypeId" data-value="{{row.pollutionTypeId}}" class="input-small required">
									<option value="">请选择</option>
									<c:forEach items="${fns:getDataList('{customer}/pt/pollutionType/api/getAll','id' , 'pollutionTypeName')}" var="m">
										<option value="${m.key}">${m.value}</option>
									</c:forEach>
								</select>
							</td>
							<td>
								<textarea id="enterprisePollutionTypeRelationList{{idx}}_remarks" name="enterprisePollutionTypeRelationList[{{idx}}].remarks" rows="4" maxlength="255" class="input-small ">{{row.remarks}}</textarea>
							</td>
							<shiro:hasPermission name="enterprise:enterprise:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#enterprisePollutionTypeRelationList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
					</script>
					<script type="text/javascript">
						var enterprisePollutionTypeRelationRowIdx = 0, enterprisePollutionTypeRelationTpl = $("#enterprisePollutionTypeRelationTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(enterprise.enterprisePollutionTypeRelationList)};
							for (var i=0; i<data.length; i++){
								addRow('#enterprisePollutionTypeRelationList', enterprisePollutionTypeRelationRowIdx, enterprisePollutionTypeRelationTpl, data[i]);
								enterprisePollutionTypeRelationRowIdx = enterprisePollutionTypeRelationRowIdx + 1;
							}
						});
					</script>
				</div>
			</div>
		<div class="form-actions">
			<shiro:hasPermission name="enterprise:enterprise:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>