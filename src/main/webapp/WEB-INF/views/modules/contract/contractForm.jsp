<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>合同管理</title>
    <meta
            name="decorator"
            content="default"/>
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
      });
      $(list + idx).find("input[type='checkbox'], input[type='radio']").each(function () {
        var ss = $(this).attr("data-value").split(',');
        for (var i = 0; i < ss.length; i++) {
          if ($(this).val() == ss[i]) {
            $(this).attr("checked", "checked");
          }
        }
      });
      $(list + idx).change(function () {
        var goodId = $(list + idx + "_goodId").val();
        $.ajax({
          url: "${ctx}/contract/good/getById",
          type: "GET",
          data: { "id": goodId },
          success: function (data) {
            if (data != null) {
              $("#contractGoodList" + idx + "_sellingPrice").val(data.tagPrice)
            }
          }
        });
      })
      $(list + idx + "_sellingQuantity").change(function () {
        var quantity = $(list + idx + "_sellingQuantity").val();
        var singlePrice = $("#contractGoodList" + idx + "_sellingPrice").val();
        console.log(quantity)
        console.log(singlePrice)
        $(list + idx + "_totalPrice").val(quantity * singlePrice);
      })
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
    <li><a href="${ctx}/contract/contract/">合同列表</a></li>
    <li class="active">
        <a href="${ctx}/contract/contract/form?id=${contract.id}">合同<shiro:hasPermission name="contract:contract:edit">${not empty contract.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="contract:contract:edit">查看</shiro:lacksPermission></a>
    </li>
</ul>
<br/> <form:form
        id="inputForm"
        modelAttribute="contract"
        action="${ctx}/contract/contract/save"
        method="post"
        class="form-horizontal"> <form:hidden path="id"/> <sys:message content="${message}"/>
    <div class="control-group">
        <label class="control-label">是否补充协议：</label>
        <div class="controls">
            <form:radiobuttons
                    path="supplemental"
                    items="${fns:getDictList('boolean')}"
                    itemLabel="label"
                    itemValue="value"
                    htmlEscape="false"
                    class=""/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">是否虚拟合同：</label>
        <div class="controls">
            <form:radiobuttons
                    path="virtual"
                    items="${fns:getDictList('boolean')}"
                    itemLabel="label"
                    itemValue="value"
                    htmlEscape="false"
                    class=""/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">主合同编号：</label>
        <div class="controls">
            <form:input
                    path="majorContractId"
                    htmlEscape="false"
                    maxlength="64"
                    class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">合同项目名称：</label>
        <div class="controls">
            <form:input
                    path="projectName"
                    htmlEscape="false"
                    maxlength="128"
                    class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">合同状态：</label>
        <div class="controls">
            <form:radiobuttons
                    path="status"
                    items="${fns:getDictList('ecm_contract_status')}"
                    itemLabel="label"
                    itemValue="value"
                    htmlEscape="false"
                    class=""/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">合同类别：</label>
        <div class="controls">
            <form:radiobuttons
                    path="type"
                    items="${fns:getDictList('ecm_contract_type')}"
                    itemLabel="label"
                    itemValue="value"
                    htmlEscape="false"
                    class=""/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">合同级别：</label>
        <div class="controls">
            <form:radiobuttons
                    path="level"
                    items="${fns:getDictList('ecm_contract_level')}"
                    itemLabel="label"
                    itemValue="value"
                    htmlEscape="false"
                    class=""/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">合同总价：</label>
        <div class="controls">
            <form:input
                    path="contractTotalPrice"
                    htmlEscape="false"
                    class="input-xlarge  number"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">工程总价：</label>
        <div class="controls">
            <form:input
                    path="projectTotalPrice"
                    htmlEscape="false"
                    class="input-xlarge  number"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">维护总价：</label>
        <div class="controls">
            <form:input
                    path="maintainTotalPrice"
                    htmlEscape="false"
                    class="input-xlarge  number"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">签订日期：</label>
        <div class="controls">
            <input
                    name="signingDate"
                    type="text"
                    readonly="readonly"
                    maxlength="20"
                    class="input-medium Wdate "
                    value="<fmt:formatDate value="${contract.signingDate}" pattern="yyyy-MM-dd"/>"
                    onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">生效日期：</label>
        <div class="controls">
            <input
                    name="validDate"
                    type="text"
                    readonly="readonly"
                    maxlength="20"
                    class="input-medium Wdate "
                    value="<fmt:formatDate value="${contract.validDate}" pattern="yyyy-MM-dd"/>"
                    onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">甲方：</label>
        <div class="controls">
            <form:input
                    path="firstParty"
                    htmlEscape="false"
                    maxlength="64"
                    class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">甲方联系人：</label>
        <div class="controls">
            <form:input
                    path="firstPartyContact"
                    htmlEscape="false"
                    maxlength="32"
                    class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">甲方联系人电话：</label>
        <div class="controls">
            <form:input
                    path="firstPartyContactPhone"
                    htmlEscape="false"
                    maxlength="32"
                    class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">乙方：</label>
        <div class="controls">
            <form:input
                    path="secondParty"
                    htmlEscape="false"
                    maxlength="64"
                    class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">乙方联系人：</label>
        <div class="controls">
            <form:input
                    path="secondPartyContact"
                    htmlEscape="false"
                    maxlength="32"
                    class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">乙方联系人电话：</label>
        <div class="controls">
            <form:input
                    path="secondPartyContactPhone"
                    htmlEscape="false"
                    maxlength="32"
                    class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">丙方：</label>
        <div class="controls">
            <form:input
                    path="thirdParty"
                    htmlEscape="false"
                    maxlength="64"
                    class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">丙方联系人：</label>
        <div class="controls">
            <form:input
                    path="thirdPartyContact"
                    htmlEscape="false"
                    maxlength="32"
                    class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">丙方联系人电话：</label>
        <div class="controls">
            <form:input
                    path="thirdPartyContactPhone"
                    htmlEscape="false"
                    maxlength="32"
                    class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">交付地点：</label>
        <div class="controls">
            <form:input
                    path="deliveryPlace"
                    htmlEscape="false"
                    maxlength="128"
                    class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">服务期限：</label>
        <div class="controls">
            <form:input
                    path="serviceTerm"
                    htmlEscape="false"
                    maxlength="32"
                    class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">服务开始日期：</label>
        <div class="controls">
            <input
                    name="serviceStartDate"
                    type="text"
                    readonly="readonly"
                    maxlength="20"
                    class="input-medium Wdate "
                    value="<fmt:formatDate value="${contract.serviceStartDate}" pattern="yyyy-MM-dd"/>"
                    onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">服务结束日期：</label>
        <div class="controls">
            <input
                    name="serviceEndDate"
                    type="text"
                    readonly="readonly"
                    maxlength="20"
                    class="input-medium Wdate "
                    value="<fmt:formatDate value="${contract.serviceEndDate}" pattern="yyyy-MM-dd"/>"
                    onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">经办人：</label>
        <div class="controls">
            <form:input
                    path="agent"
                    htmlEscape="false"
                    maxlength="64"
                    class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">备注：</label>
        <div class="controls">
            <form:textarea
                    path="remarks"
                    htmlEscape="false"
                    rows="4"
                    maxlength="256"
                    class="input-xxlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">合同附件表：</label>
        <div class="controls">
            <table
                    id="contentTable_contractAttachment"
                    class="table table-striped table-bordered table-condensed">
                <thead>
                <tr>
                    <th class="hide"></th>
                    <th>文件描述</th>
                    <th>文件名</th>
                    <th>文件类型</th>
                    <th>文件路径</th>
                    <shiro:hasPermission name="contract:contract:edit">
                        <th width="10">&nbsp;</th>
                    </shiro:hasPermission>
                </tr>
                </thead>
                <tbody id="contractAttachmentList"></tbody>
                <shiro:hasPermission name="contract:contract:edit">
                    <tfoot>
                    <tr>
                        <td colspan="6"><a
                                href="javascript:"
                                onclick="addRow('#contractAttachmentList', contractAttachmentRowIdx, contractAttachmentTpl);contractAttachmentRowIdx = contractAttachmentRowIdx + 1;"
                                class="btn">新增</a></td>
                    </tr>
                    </tfoot>
                </shiro:hasPermission>
            </table>
            <script
                    type="text/template"
                    id="contractAttachmentTpl">//<!--
						<tr id="contractAttachmentList{{idx}}">
							<td class="hide">
								<input id="contractAttachmentList{{idx}}_id" name="contractAttachmentList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="contractAttachmentList{{idx}}_delFlag" name="contractAttachmentList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<input id="contractAttachmentList{{idx}}_description" name="contractAttachmentList[{{idx}}].description" type="text" value="{{row.description}}" maxlength="128" class="input-small "/>
							</td>
							<td>
								<input id="contractAttachmentList{{idx}}_name" name="contractAttachmentList[{{idx}}].name" type="text" value="{{row.name}}" maxlength="128" class="input-small "/>
							</td>
							<td>
								<input id="contractAttachmentList{{idx}}_type" name="contractAttachmentList[{{idx}}].type" type="text" value="{{row.type}}" maxlength="32" class="input-small "/>
							</td>
							<td>
								<input id="contractAttachmentList{{idx}}_path" name="contractAttachmentList[{{idx}}].path" type="hidden" value="{{row.path}}" maxlength="256"/>
								<sys:ckfinder input="contractAttachmentList{{idx}}_path" type="files" uploadPath="/contract/contract" selectMultiple="true"/>
							</td>
							<shiro:hasPermission name="contract:contract:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#contractAttachmentList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
            </script>
            <script type="text/javascript">
            var contractAttachmentRowIdx = 0,
              contractAttachmentTpl = $("#contractAttachmentTpl").html().replace(
                /(\/\/\<!\-\-)|(\/\/\-\->)/g, "");
            $(document).ready(function () {
              var data = ${fns:toJson(contract.contractAttachmentList)};
              for (var i = 0; i < data.length; i++) {
                addRow('#contractAttachmentList', contractAttachmentRowIdx, contractAttachmentTpl,
                  data[i]);
                contractAttachmentRowIdx = contractAttachmentRowIdx + 1;
              }
            });
            </script>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">合同商品表：</label>
        <div class="controls">
            <table
                    id="contentTable_contractGood"
                    class="table table-striped table-bordered table-condensed">
                <thead>
                <tr>
                    <th class="hide"></th>
                    <th>商品名称</th>
                    <th>销售单价</th>
                    <th>销售数量</th>
                    <th>销售总价</th>
                    <shiro:hasPermission name="contract:contract:edit">
                        <th width="10">&nbsp;</th>
                    </shiro:hasPermission>
                </tr>
                </thead>
                <tbody id="contractGoodList"></tbody>
                <shiro:hasPermission name="contract:contract:edit">
                    <tfoot>
                    <tr>
                        <td colspan="6"><a
                                href="javascript:"
                                onclick="addRow('#contractGoodList', contractGoodRowIdx, contractGoodTpl);contractGoodRowIdx = contractGoodRowIdx + 1;"
                                class="btn">新增</a></td>
                    </tr>
                    </tfoot>
                </shiro:hasPermission>
            </table>
            <script
                    type="text/template"
                    id="contractGoodTpl">//<!--
						<tr id="contractGoodList{{idx}}">
							<td class="hide">
								<input id="contractGoodList{{idx}}_id" name="contractGoodList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="contractGoodList{{idx}}_delFlag" name="contractGoodList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
							<select id="contractGoodList{{idx}}_goodId" name="contractGoodList[{{idx}}].goodId" data-value="{{row.goodId}}" class="input-small ">
									<option value=""></option>
									<c:forEach items="${fns:getDataList('{contract}/contract/good/api/getAll','id','name')}" var="m">
										<option value="${m.key}">${m.value}</option>
									</c:forEach>
								</select>
							</td>
							<td>
								<input id="contractGoodList{{idx}}_sellingPrice" name="contractGoodList[{{idx}}].sellingPrice" type="text" value="{{row.sellingPrice}}" class="input-small  number"/>
							</td>
							<td>
								<input id="contractGoodList{{idx}}_sellingQuantity" name="contractGoodList[{{idx}}].sellingQuantity" type="text" value="{{row.sellingQuantity}}" class="input-small  digits"/>
							</td>
							<td>
								<input id="contractGoodList{{idx}}_totalPrice" name="contractGoodList[{{idx}}].totalPrice" type="text" value="{{row.totalPrice}}" class="input-small  number"/>
							</td>
							<shiro:hasPermission name="contract:contract:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#contractGoodList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
            </script>
            <script type="text/javascript">
            var contractGoodRowIdx = 0,
              contractGoodTpl = $("#contractGoodTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,
                "");
            $(document).ready(function () {
              var data = ${fns:toJson(contract.contractGoodList)};
              for (var i = 0; i < data.length; i++) {
                addRow('#contractGoodList', contractGoodRowIdx, contractGoodTpl, data[i]);
                contractGoodRowIdx = contractGoodRowIdx + 1;
              }
            });
            </script>
        </div>
    </div>
    <div class="form-actions">
        <shiro:hasPermission name="contract:contract:edit"><input
                id="btnSubmit"
                class="btn btn-primary"
                type="submit"
                value="保 存"/>&nbsp;</shiro:hasPermission> <input
            id="btnCancel"
            class="btn"
            type="button"
            value="返 回"
            onclick="history.go(-1)"/>
    </div>
</form:form>
</body>
</html>