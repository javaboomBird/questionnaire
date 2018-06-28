<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>企业信息管理管理</title>
    <meta name="decorator" content="default"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
<p style="display:inline-block;" class="p-title">企业信息查看</p>
<input id="btnCancel" class="btn" style="margin-bottom:10px;float: right;" type="button" value="返 回" onclick="history.go(-1)"/>
<div class="container-fluit container-fluit-m">
    <form:form id="inputForm" modelAttribute="customer" action="${ctx}/customer/enterprise/save"
               method="post" class="form-horizontal">
        <form:hidden path="id"/>
        <input type="hidden" name="type"  value="${empty customer.type?'ET':customer.type}"/>
        <sys:message content="${message}"/>
        <div class="row-fluid row-border">
            <div class="span12">
                <label class="control-label">企业名称：</label>
                <div class="controls">
                    <form:input path="name" htmlEscape="false" maxlength="64" class="input-xlarge required"/>
                    <span class="help-inline"><font color="red">*</font> </span>
                </div>
            </div>
        </div>
        <div class="row-fluid row-border row-m-t">
            <div class="span6">
                <label class="control-label">纬度：</label>
                <div class="controls">
                    <form:input path="lat" htmlEscape="false" class="input-xlarge"/>
                </div>
            </div>
            <div class="span6">
                <label class="control-label">经度：</label>
                <div class="controls">
                    <form:input path="lng" htmlEscape="false" class="input-xlarge"/>
                </div>
            </div>
        </div>
        <div class="row-fluid row-border row-m-t">
            <div class="span6">
                <label class="control-label">信用代码：</label>
                <div class="controls">
                    <form:input path="uscCode" htmlEscape="false" class="input-xlarge "/>
                </div>
            </div>
            <div class="span6">
                <label class="control-label">法人：</label>
                <div class="controls">
                    <form:input path="legalPerson" htmlEscape="false" class="input-xlarge "/>
                </div>
            </div>
        </div>
        <div class="row-fluid row-border row-m-t">
            <div class="span6">
                <label class="control-label">注册资本：</label>
                <div class="controls">
                    <form:input path="registeredCapital" htmlEscape="false" class="input-xlarge "/>
                </div>
            </div>
            <div class="span6">
                <label class="control-label">注册日期：</label>
                <div class="controls">
                    <input name="registeredDate" type="text" readonly="readonly" maxlength="20"
                           class="input-medium Wdate "
                           value="<fmt:formatDate value="${customer.registeredDate}" pattern="yyyy-MM-dd"/>"
                           onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
                </div>
            </div>
        </div>
        <div class="row-fluid row-border row-m-t">
            <div class="span6">
                <label class="control-label">注册地址：</label>
                <div class="controls">
                    <form:input path="registeredAddress" htmlEscape="false" class="input-xlarge "/>
                </div>
            </div>
            <div class="span6">
                <label class="control-label">注册邮编：</label>
                <div class="controls">
                    <form:input path="lng" registeredPostcode="false" class="input-xlarge "/>
                </div>
            </div>
        </div>
        <div class="row-fluid row-border row-m-t">
            <div class="span6">
                <label class="control-label">区域：</label>
                <div class="controls">
                    <sys:treeselect id="area" property="areaId" name="area.id" value="${customer.area.id}"
                                    labelName="area.name" labelValue="${customer.area.name}"
                                    title="区域" url="/sys/area/treeData" cssClass="required"
                                    allowClear="true" notAllowSelectParent="true"/>
                    <span class="help-inline"><font color="red">*</font> </span>
                </div>
            </div>
            <div class="span6">
                <label class="control-label">经营范围：</label>
                <div class="controls">
                    <form:input path="businessScope" htmlEscape="false" maxlength="512" class="input-xlarge "/>
                </div>
            </div>
        </div>
        <div class="row-fluid row-border row-m-t">
            <div class="span6">
                <label class="control-label">办公电话：</label>
                <div class="controls">
                    <form:input path="businessPhone" htmlEscape="false" maxlength="512" class="input-xlarge "/>
                </div>
            </div>
            <div class="span6">
                <label class="control-label">fax 号码：</label>
                <div class="controls">
                    <form:input path="businessFax" htmlEscape="false" maxlength="512"  class="input-xlarge "/>
                </div>
            </div>
        </div>
        <div class="row-fluid row-border row-m-t">
            <div class="span6">
                <label class="control-label">银行账户名称：</label>
                <div class="controls">
                    <form:input path="bankAccount" htmlEscape="false" maxlength="64" class="input-xlarge "/>
                </div>
            </div>
            <div class="span6">
                <label class="control-label">银行账户卡号：</label>
                <div class="controls">
                    <form:input path="bankNumber" htmlEscape="false" maxlength="32" class="input-xlarge "/>
                </div>
            </div>
        </div>
        <div class="row-fluid row-border row-m-t">
            <div class="span6">
                <label class="control-label">开户行名称：</label>
                <div class="controls">
                    <form:input path="bankName" htmlEscape="false" maxlength="32" class="input-xlarge "/>
                </div>
            </div>
            <div class="span6">
                <label class="control-label">税号：</label>
                <div class="controls">
                    <form:input path="taxNumber" htmlEscape="false" maxlength="32"
                                class="input-xlarge required"/>
                    <span class="help-inline"><font color="red">*</font> </span>
                </div>
            </div>
        </div>
        <div class="row-fluid row-border row-m-t">
            <div class="span6">
                <label class="control-label">开票电话：</label>
                <div class="controls">
                    <form:input path="taxPhone" htmlEscape="false" maxlength="32" class="input-xlarge "/>
                </div>
            </div>
            <div class="span6">
                <label class="control-label">回用类型：</label>
                <div class="controls">
                    <form:select path="recyclingType" class="input-xlarge required">
                        <form:option value="" label=""/>
                        <form:options items="${fns:getDictList('recycling_type')}" itemLabel="label"
                                      itemValue="value" htmlEscape="false"/>
                    </form:select>
                    <span class="help-inline"><font color="red">*</font> </span>
                </div>
            </div>
        </div>
        <div class="row-fluid row-border row-m-t">
            <div class="span6">
                <label class="control-label">企业状态：</label>
                <div class="controls">
                    <form:select path="statusType" class="input-xlarge required">
                        <form:option value="" label=""/>
                        <form:options items="${fns:getDictList('status_type')}" itemLabel="label"
                                      itemValue="value" htmlEscape="false"/>
                    </form:select>
                    <span class="help-inline"><font color="red">*</font> </span>
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

        <div class="row-fluid row-border row-m-t">
            <div class="span12">
                <label class="control-label table-label-m-b">联系人表：</label>
                <div>
                    <table id="contentTable_contact"
                           class="table table-striped table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th class="hide"></th>
                            <th>联系人</th>
                            <th>职务</th>
                            <th>电话</th>
                            <th>邮箱</th>
                            <th>备注</th>
                            <shiro:hasPermission name="customer:enterprise:edit">
                                <th width="10">&nbsp;</th>
                            </shiro:hasPermission>
                        </tr>
                        </thead>
                        <tbody id="customerContactList">
                        </tbody>
                        <shiro:hasPermission name="customer:enterprise:edit">
                            <%--<tfoot>
                            <tr>
                                <td colspan="8"><a href="javascript:"
                                                   onclick="addRow('#customerContactList', contactRowIdx, contactTpl);contactRowIdx = contactRowIdx + 1;"
                                                   class="btn">新增</a></td>
                            </tr>
                            </tfoot>--%>
                        </shiro:hasPermission>
                    </table>
                    <script type="text/template" id="contactTpl">//<!--
						<tr id="customerContactList{{idx}}">
							<td class="hide">
								<input id="customerContactList{{idx}}_id" name="customerContactList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="customerContactList{{idx}}_delFlag" name="customerContactList[{{idx}}].isDeleted" type="hidden" value="N"/>
							</td>
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
							<shiro:hasPermission name="customer:enterprise:edit"><td class="text-center" width="10">
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
        </div>

        <div class="row-fluid row-border row-m-t">
            <div class="span12">
                <label class="control-label table-label-m-b">企业工商类型：</label>
                <div>
                    <table id="contentTable_enterpriseBusinessTypeRelation"
                           class="table table-striped table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th class="hide"></th>
                            <th>工商类型</th>
                            <th>备注</th>
                            <shiro:hasPermission name="customer:enterprise:edit">
                                <th width="10">&nbsp;</th>
                            </shiro:hasPermission>
                        </tr>
                        </thead>
                        <tbody id="customerBusinessTypeRelationList">
                        </tbody>
                        <shiro:hasPermission name="customer:enterprise:edit">
                           <%-- <tfoot>
                            <tr>
                                <td colspan="4"><a href="javascript:"
                                                   onclick="addRow('#customerBusinessTypeRelationList', enterpriseBusinessTypeRelationRowIdx, enterpriseBusinessTypeRelationTpl);enterpriseBusinessTypeRelationRowIdx = enterpriseBusinessTypeRelationRowIdx + 1;"
                                                   class="btn">新增</a></td>
                            </tr>
                            </tfoot>--%>
                        </shiro:hasPermission>
                    </table>
                    <script type="text/template" id="enterpriseBusinessTypeRelationTpl">//<!--
						<tr id="customerBusinessTypeRelationList{{idx}}">
							<td class="hide">
								<input id="customerBusinessTypeRelationList{{idx}}_id" name="customerBusinessTypeRelationList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="customerBusinessTypeRelationList{{idx}}_delFlag" name="customerBusinessTypeRelationList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
							<select id="customerBusinessTypeRelationList{{idx}}_businessTypeId" name="customerBusinessTypeRelationList[{{idx}}].businessTypeId" data-value="{{row.businessTypeId}}" class="input-small ">
									<option value=""></option>
									<c:forEach items="${fns:getDataList('{customer}/bt/customerBusinessType/api/getAll','id','businessTypeName')}" var="m">
										<option value="${m.key}">${m.value}</option>
									</c:forEach>
								</select>

							</td>
							<td>
								<textarea id="customerBusinessTypeRelationList{{idx}}_remarks" name="customerBusinessTypeRelationList[{{idx}}].remarks" rows="4" maxlength="255" class="input-small ">{{row.remarks}}</textarea>
							</td>
							<shiro:hasPermission name="customer:enterprise:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#customerBusinessTypeRelationList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
                    </script>
                    <script type="text/javascript">
                        var enterpriseBusinessTypeRelationRowIdx = 0, enterpriseBusinessTypeRelationTpl = $(
                            "#enterpriseBusinessTypeRelationTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,
                            "");
                        $(document).ready(function () {
                            var data = ${fns:toJson(customer.customerBusinessTypeRelationList)};
                            for (var i = 0; i < data.length; i++) {
                                addRow('#customerBusinessTypeRelationList', enterpriseBusinessTypeRelationRowIdx,
                                    enterpriseBusinessTypeRelationTpl, data[i]);
                                enterpriseBusinessTypeRelationRowIdx = enterpriseBusinessTypeRelationRowIdx + 1;
                            }
                        });
                    </script>
                </div>
            </div>
        </div>

        <div class="row-fluid row-border row-m-t">
            <div class="span12">
                <label class="control-label table-label-m-b">企业污染行业类型：</label>
                <div>
                    <table id="contentTable_enterpriseIndustryTypeRelation"
                           class="table table-striped table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th class="hide"></th>
                            <th>污染行业类型</th>
                            <th>备注</th>
                            <shiro:hasPermission name="customer:enterprise:edit">
                                <th width="10">&nbsp;</th>
                            </shiro:hasPermission>
                        </tr>
                        </thead>
                        <tbody id="customerIndustryTypeRelationList">
                        </tbody>
                        <shiro:hasPermission name="customer:enterprise:edit">
                            <%--<tfoot>
                            <tr>
                                <td colspan="4"><a href="javascript:"
                                                   onclick="addRow('#customerIndustryTypeRelationList', enterpriseIndustryTypeRelationRowIdx, enterpriseIndustryTypeRelationTpl);enterpriseIndustryTypeRelationRowIdx = enterpriseIndustryTypeRelationRowIdx + 1;"
                                                   class="btn">新增</a></td>
                            </tr>
                            </tfoot>--%>
                        </shiro:hasPermission>
                    </table>
                    <script type="text/template" id="enterpriseIndustryTypeRelationTpl">//<!--
                    <tr id="customerIndustryTypeRelationList{{idx}}">
                        <td class="hide">
                            <input id="customerIndustryTypeRelationList{{idx}}_id" name="customerIndustryTypeRelationList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
                            <input id="customerIndustryTypeRelationList{{idx}}_delFlag" name="customerIndustryTypeRelationList[{{idx}}].delFlag" type="hidden" value="0"/>
                        </td>
                        <td>
                        <select id="customerIndustryTypeRelationList{{idx}}_industryTypeId" name="customerIndustryTypeRelationList[{{idx}}].industryTypeId" data-value="{{row.industryTypeId}}" class="input-xlarge ">
                                <option value=""></option>
                                <c:forEach items="${fns:getDataList('{customer}/it/customerIndustryType/api/getAll','id','industryTypeName')}" var="m">
                                    <option value="${m.key}">${m.value}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <textarea id="customerIndustryTypeRelationList{{idx}}_remarks" name="customerIndustryTypeRelationList[{{idx}}].remarks" rows="4" maxlength="255" class="input-small ">{{row.remarks}}</textarea>
                        </td>
                        <shiro:hasPermission name="customer:enterprise:edit"><td class="text-center" width="10">
                            {{#delBtn}}<span class="close" onclick="delRow(this, '#customerIndustryTypeRelationList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
                        </td></shiro:hasPermission>
                    </tr>//-->
                    </script>
                    <script type="text/javascript">
                        var enterpriseIndustryTypeRelationRowIdx = 0, enterpriseIndustryTypeRelationTpl = $(
                            "#enterpriseIndustryTypeRelationTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,
                            "");
                        $(document).ready(function () {
                            var data = ${fns:toJson(customer.customerIndustryTypeRelationList)};
                            for (var i = 0; i < data.length; i++) {
                                addRow('#customerIndustryTypeRelationList', enterpriseIndustryTypeRelationRowIdx,
                                    enterpriseIndustryTypeRelationTpl, data[i]);
                                enterpriseIndustryTypeRelationRowIdx = enterpriseIndustryTypeRelationRowIdx + 1;
                            }
                        });
                    </script>
                </div>
            </div>
        </div>

        <div class="row-fluid row-border row-m-t">
            <div class="span12">
                <label class="control-label table-label-m-b">企业图片表：</label>
                <div>
                    <table id="contentTable_enterprisePic"
                           class="table table-striped table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th class="hide"></th>
                            <th>图片路径</th>
                            <th>备注</th>
                            <shiro:hasPermission name="customer:enterprise:edit">
                                <th width="10">&nbsp;</th>
                            </shiro:hasPermission>
                        </tr>
                        </thead>
                        <tbody id="customerPicList">
                        </tbody>
                        <shiro:hasPermission name="customer:enterprise:edit">
                            <%--<tfoot>
                            <tr>
                                <td colspan="4"><a href="javascript:"
                                                   onclick="addRow('#customerPicList', enterprisePicRowIdx, enterprisePicTpl);enterprisePicRowIdx = enterprisePicRowIdx + 1;"
                                                   class="btn">新增</a></td>
                            </tr>
                            </tfoot>--%>
                        </shiro:hasPermission>
                    </table>
                    <script type="text/template" id="enterprisePicTpl">//<!--
                            <tr id="customerPicList{{idx}}">
                                <td class="hide">
                                    <input id="customerPicList{{idx}}_id" name="customerPicList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
                                    <input id="customerPicList{{idx}}_delFlag" name="customerPicList[{{idx}}].delFlag" type="hidden" value="0"/>
                                </td>
                                <td>
                                    <input id="customerPicList{{idx}}_filePath" name="customerPicList[{{idx}}].filePath" type="hidden" value="{{row.filePath}}" maxlength="256"/>
                                    <sys:ckfinder input="customerPicList{{idx}}_filePath" type="files" uploadPath="/enterprise/enterprise" selectMultiple="true"/>
                                </td>
                                <td>
                                    <textarea id="customerPicList{{idx}}_remarks" name="customerPicList[{{idx}}].remarks" rows="4" maxlength="255" class="input-small ">{{row.remarks}}</textarea>
                                </td>
                                <shiro:hasPermission name="customer:enterprise:edit"><td class="text-center" width="10">
                                    {{#delBtn}}<span class="close" onclick="delRow(this, '#customerPicList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
                                </td></shiro:hasPermission>
                            </tr>//-->
                    </script>
                    <script type="text/javascript">
                        var enterprisePicRowIdx = 0, enterprisePicTpl = $("#enterprisePicTpl").html().replace(
                            /(\/\/\<!\-\-)|(\/\/\-\->)/g, "");
                        $(document).ready(function () {
                            var data = ${fns:toJson(customer.customerPicList)};
                            for (var i = 0; i < data.length; i++) {
                                addRow('#customerPicList', enterprisePicRowIdx, enterprisePicTpl, data[i]);
                                enterprisePicRowIdx = enterprisePicRowIdx + 1;
                            }
                        });
                    </script>
                </div>
            </div>
        </div>

        <div class="row-fluid row-border row-m-t">
            <div class="span12">
                <label class="control-label table-label-m-b">企业排污类型：</label>
                <div>
                    <table id="contentTable_enterprisePollutionTypeRelation"
                           class="table table-striped table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th class="hide"></th>
                            <th>排污类型</th>
                            <th>备注</th>
                            <shiro:hasPermission name="customer:enterprise:edit">
                                <th width="10">&nbsp;</th>
                            </shiro:hasPermission>
                        </tr>
                        </thead>
                        <tbody id="customerPollutionTypeRelationList">
                        </tbody>
                        <shiro:hasPermission name="customer:enterprise:edit">
                            <%--<tfoot>
                            <tr>
                                <td colspan="4"><a href="javascript:"
                                                   onclick="addRow('#customerPollutionTypeRelationList', enterprisePollutionTypeRelationRowIdx, enterprisePollutionTypeRelationTpl);enterprisePollutionTypeRelationRowIdx = enterprisePollutionTypeRelationRowIdx + 1;"
                                                   class="btn">新增</a></td>
                            </tr>
                            </tfoot>--%>
                        </shiro:hasPermission>
                    </table>
                    <script type="text/template" id="enterprisePollutionTypeRelationTpl">//<!--
                    <tr id="customerPollutionTypeRelationList{{idx}}">
                        <td class="hide">
                            <input id="customerPollutionTypeRelationList{{idx}}_id" name="customerPollutionTypeRelationList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
                            <input id="customerPollutionTypeRelationList{{idx}}_delFlag" name="customerPollutionTypeRelationList[{{idx}}].delFlag" type="hidden" value="0"/>
                        </td>
                        <td>
                        <select id="customerPollutionTypeRelationList{{idx}}_pollutionTypeId" name="customerPollutionTypeRelationList[{{idx}}].pollutionTypeId" data-value="{{row.pollutionTypeId}}" class="input-small ">
                                <option value=""></option>
                                <c:forEach items="${fns:getDataList('{customer}/pt/customerPollutionType/api/getAll','id','pollutionTypeName')}" var="m">
                                    <option value="${m.key}">${m.value}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <textarea id="customerPollutionTypeRelationList{{idx}}_remarks" name="customerPollutionTypeRelationList[{{idx}}].remarks" rows="4" maxlength="255" class="input-small ">{{row.remarks}}</textarea>
                        </td>
                        <shiro:hasPermission name="customer:enterprise:edit"><td class="text-center" width="10">
                            {{#delBtn}}<span class="close" onclick="delRow(this, '#customerPollutionTypeRelationList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
                        </td></shiro:hasPermission>
                    </tr>//-->
                    </script>
                    <script type="text/javascript">
                        var enterprisePollutionTypeRelationRowIdx = 0, enterprisePollutionTypeRelationTpl = $(
                            "#enterprisePollutionTypeRelationTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,
                            "");
                        $(document).ready(function () {
                            var data = ${fns:toJson(customer.customerPollutionTypeRelationList)};
                            for (var i = 0; i < data.length; i++) {
                                addRow('#customerPollutionTypeRelationList',
                                    enterprisePollutionTypeRelationRowIdx, enterprisePollutionTypeRelationTpl,
                                    data[i]);
                                enterprisePollutionTypeRelationRowIdx = enterprisePollutionTypeRelationRowIdx + 1;
                            }
                        });
                    </script>
                </div>
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