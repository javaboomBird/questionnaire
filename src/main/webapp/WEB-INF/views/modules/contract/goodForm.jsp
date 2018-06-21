<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>合同商品管理</title>
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
    <li><a href="${ctx}/contract/good/">合同商品列表</a></li>
    <li class="active"><a href="${ctx}/contract/good/form?id=${good.id}">合同商品<shiro:hasPermission
            name="contract:good:edit">${not empty good.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission
            name="contract:good:edit">查看</shiro:lacksPermission></a></li>
</ul>
<br/>
<form:form id="inputForm" modelAttribute="good" action="${ctx}/contract/good/save" method="post"
           class="form-horizontal">
    <form:hidden path="id"/>
    <sys:message content="${message}"/>
    <div class="control-group">
        <label class="control-label">商品编号：</label>
        <div class="controls">
            <form:input path="no" htmlEscape="false" maxlength="128" class="input-xlarge required"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">商品名称：</label>
        <div class="controls">
            <form:input path="name" htmlEscape="false" maxlength="128"
                        class="input-xlarge required"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">商品单位：</label>
        <div class="controls">
            <form:input path="unit" htmlEscape="false" maxlength="32" class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">商品型号：</label>
        <div class="controls">
            <form:input path="model" htmlEscape="false" maxlength="128" class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">商品类型：</label>
        <div class="controls">
            <form:select path="type" class="input-xlarge ">
                <form:option value="" label=""/>
                <form:options items="${fns:getDictList('ecm_good_type')}" itemLabel="label"
                              itemValue="value" htmlEscape="false"/>
            </form:select>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">生产厂商：</label>
        <div class="controls">
            <form:input path="manufacturer" htmlEscape="false" maxlength="128"
                        class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">供应厂商：</label>
        <div class="controls">
            <form:input path="supplier" htmlEscape="false" maxlength="128" class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">采购价：</label>
        <div class="controls">
            <form:input path="purchasePrice" htmlEscape="false" class="input-xlarge  number"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">建议售价：</label>
        <div class="controls">
            <form:input path="tagPrice" htmlEscape="false" class="input-xlarge  number"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">商品介绍：</label>
        <div class="controls">
            <form:input path="introduction" htmlEscape="false" maxlength="256"
                        class="input-xlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">备注：</label>
        <div class="controls">
            <form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="256"
                           class="input-xxlarge "/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">商品图片表：</label>
        <div class="controls">
            <table id="contentTable_goodPic"
                   class="table table-striped table-bordered table-condensed">
                <thead>
                <tr>
                    <th class="hide"></th>
                    <th>图片描述</th>
                    <th>文件名</th>
                    <th>文件类型</th>
                    <th>图片路径</th>
                    <shiro:hasPermission name="contract:good:edit">
                        <th width="10">&nbsp;</th>
                    </shiro:hasPermission>
                </tr>
                </thead>
                <tbody id="goodPicList">
                </tbody>
                <shiro:hasPermission name="contract:good:edit">
                    <tfoot>
                    <tr>
                        <td colspan="6"><a href="javascript:"
                                           onclick="addRow('#goodPicList', goodPicRowIdx, goodPicTpl);goodPicRowIdx = goodPicRowIdx + 1;"
                                           class="btn">新增</a></td>
                    </tr>
                    </tfoot>
                </shiro:hasPermission>
            </table>
            <script type="text/template" id="goodPicTpl">//<!--
						<tr id="goodPicList{{idx}}">
							<td class="hide">
								<input id="goodPicList{{idx}}_id" name="goodPicList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="goodPicList{{idx}}_delFlag" name="goodPicList[{{idx}}].isDeleted" type="hidden" value="N"/>
							</td>
							<td>
								<input id="goodPicList{{idx}}_description" name="goodPicList[{{idx}}].description" type="text" value="{{row.description}}" maxlength="128" class="input-small "/>
							</td>
							<td>
								<input id="goodPicList{{idx}}_name" name="goodPicList[{{idx}}].name" type="text" value="{{row.name}}" maxlength="128" class="input-small "/>
							</td>
							<td>
								<input id="goodPicList{{idx}}_type" name="goodPicList[{{idx}}].type" type="text" value="{{row.type}}" maxlength="32" class="input-small "/>
							</td>
							<td>
								<input id="goodPicList{{idx}}_path" name="goodPicList[{{idx}}].path" type="hidden" value="{{row.path}}" maxlength="256"/>
								<sys:ckfinder input="goodPicList{{idx}}_path" type="files" uploadPath="/contract/good" selectMultiple="true"/>
							</td>
							<shiro:hasPermission name="contract:good:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#goodPicList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
            </script>
            <script type="text/javascript">
            var goodPicRowIdx = 0,
                goodPicTpl = $("#goodPicTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g, "");
            $(document).ready(function () {
              var data = ${fns:toJson(good.goodPicList)};
              for (var i = 0; i < data.length; i++) {
                addRow('#goodPicList', goodPicRowIdx, goodPicTpl, data[i]);
                goodPicRowIdx = goodPicRowIdx + 1;
              }
            });
            </script>
        </div>
    </div>
    <div class="form-actions">
        <shiro:hasPermission name="contract:good:edit"><input id="btnSubmit" class="btn btn-primary"
                                                              type="submit"
                                                              value="保 存"/>&nbsp;</shiro:hasPermission>
        <input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
    </div>
</form:form>
</body>
</html>