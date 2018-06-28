<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>资产管理管理</title>
    <meta name="decorator" content="default"/>
    <%--<script type="text/javascript" src="${ctxStatic}/jquery-qrcode/jquery.print.jss"></script>--%>
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

      String.prototype.startWith = function (s) {
        if (s == null || s == "" || this.length == 0 || s.length > this.length)
          return false;
        if (this.substr(0, s.length) == s)
          return true;
        else
          return false;
        return true;
      };

      //资产类型change事件
      $("#assetsType").change(function () {
        var selectVal = $(this).val();
        var assetsNo = selectVal + "-" +${fns:getDate("yyyyMMddHHmmss")};
        $("#assetsNo").val(assetsNo);
        //显示车牌号输入框
        if (selectVal.startWith('CAR')) {
          $("#div_plate_number").show();
        } else {
          $("#div_plate_number").hide();
        }

      });
      //资产性质change事件
      $("#assetsNature").change(function () {
        var selectVal = $(this).val();
        if ("1" != selectVal) {
          $("#div_contact").show();
          $("#div_enterprise_department").show();
          $("#div_office_department").hide();
        } else {
          //内部
          $("#div_contact").hide();
          $("#div_enterprise_department").hide();
          $("#div_office_department").show();
        }
        $("#assetsUseDepartment").select2("val", "");
        $("#assetsUseUnit").select2("val", "");
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
<p style="display:inline-block;" class="p-title">资产信息查看</p>
<input id="btnCancel" class="btn" style="margin-bottom:10px;float: right;" type="button" value="返 回" onclick="history.go(-1)"/>
<div class="container-fluit container-fluit-m">
<form:form id="inputForm" modelAttribute="assetsManager" action="${ctx}/assets/assetsManager/save"
           method="post" class="form-horizontal">
    <form:hidden path="id"/>
    <sys:message content="${message}"/>

    <div class="row-fluid row-border">
        <div class="span12">
            <label class="control-label">资产类型：</label>
            <div class="controls">
                <form:select path="assetsType" class="input-xlarge required">
                    <form:option value="" label=""/>
                    <form:options items="${fns:getDictList('assets_type')}" itemLabel="label"
                                  itemValue="value" htmlEscape="false"/>
                </form:select>
                <span class="help-inline"><font color="red">*</font> </span>
            </div>
        </div>
    </div>

    <div class="row-fluid row-border row-m-t">
        <div class="span6">
            <label class="control-label">资产编号：</label>
            <div class="controls">
                <form:input path="assetsNo" htmlEscape="false" maxlength="64"
                            class="input-xlarge required " readonly="true"/>
                <span class="help-inline"><font color="red">*</font> </span>
            </div>
        </div>
        <div class="span6">
            <label class="control-label">资产名称：</label>
            <div class="controls">
                <form:input path="assetsName" htmlEscape="false" maxlength="64"
                            class="input-xlarge required"/>
                <span class="help-inline"><font color="red">*</font> </span>
            </div>

        </div>
    </div>

    <div class="row-fluid row-border row-m-t">
        <div class="span6">
            <label class="control-label">原厂家：</label>
            <div class="controls">
                <form:input path="originalManufactor" htmlEscape="false" maxlength="64"
                            class="input-xlarge "/>
            </div>
        </div>
        <div class="span6">
            <label class="control-label">资产型号：</label>
            <div class="controls">
                <form:input path="assetsModel" htmlEscape="false" maxlength="64"
                            class="input-xlarge required "/>
                <span class="help-inline"><font color="red">*</font> </span>
            </div>
        </div>
    </div>
    <div class="row-fluid row-border row-m-t">
        <div class="span6">
            <label class="control-label">资产序列号：</label>
            <div class="controls">
                <form:input path="assetsSerialNum" htmlEscape="false" maxlength="64"
                            class="input-xlarge required"/>
                <span class="help-inline"><font color="red">*</font> </span>
            </div>
        </div>
        <div class="span6">
            <label class="control-label">资产性质：</label>
            <div class="controls">
                <form:select path="assetsNature" class="input-xlarge required">
                    <form:options items="${fns:getDictList('assets_nature_type')}" itemLabel="label"
                                  itemValue="value" htmlEscape="false"/>
                </form:select>
                <span class="help-inline"><font color="red">*</font> </span>
            </div>
        </div>
    </div>

    <c:choose>
        <c:when test="${assetsManager.assetsNature!='1'&&not empty assetsManager.assetsNature}">
           <div class="row-fluid row-border row-m-t">
               <div class="span6" id="div_enterprise_department">
                   <label class="control-label">资产使用单位：</label>
                   <div class="controls">
                       <select id="assetsUseUnit" name="assetsUseUnit"
                               class="input-xlarge required">
                           <option value="">请选择</option>
                           <c:forEach items="${enterpriseEntityList}" var="enterprise">
                               <c:if test="${assetsManager.assetsUseUnit==enterprise.id}">
                                   <option value="${enterprise.id}"
                                           selected="selected">${enterprise.name}</option>
                               </c:if>
                               <c:if test="${assetsManager.assetsUseUnit!=enterprise.id}">
                                   <option value="${enterprise.id}">${enterprise.name}</option>
                               </c:if>
                           </c:forEach>
                       </select>
                   </div>
               </div>
               <%--<div class="span6" id="div_office_department" style="display: none">
                   <label class="control-label">资产使用部门：</label>
                   <div class="controls">
                       <select id="assetsUseDepartment" name="assetsUseDepartment"
                               class="input-xlarge required">
                           <option value="">请选择</option>
                           <c:forEach items="${allOfficeList}" var="office">
                               <c:if test="${assetsManager.assetsUseDepartment==office.id}">
                                   <option value="${office.id}"
                                           selected="selected">${office.name}</option>
                               </c:if>
                               <c:if test="${assetsManager.assetsUseDepartment!=office.id}">
                                   <option value="${office.id}">${office.name}</option>
                               </c:if>
                           </c:forEach>
                       </select>
                   </div>
               </div>--%>
               <div class="span6">
                   <label class="control-label">资产使用地址：</label>
                   <div class="controls">
                       <form:input path="assetsLocation" htmlEscape="false" maxlength="64"
                                   class="input-xlarge "/>
                   </div>
               </div>
           </div>

        </c:when>
        <c:otherwise>
    <div class="row-fluid row-border row-m-t">
        <%--<div class="span6" id="div_enterprise_department" style="display: none">
            <label class="control-label">资产使用单位：</label>
            <div class="controls">
                <select id="assetsUseUnit" name="assetsUseUnit"
                        class="input-xlarge required">
                    <option value="">请选择</option>
                    <c:forEach items="${enterpriseEntityList}" var="enterprise">
                        <c:if test="${assetsManager.assetsUseUnit==enterprise.id}">
                            <option value="${enterprise.id}"
                                    selected="selected">${enterprise.name}</option>
                        </c:if>
                        <c:if test="${assetsManager.assetsUseUnit!=enterprise.id}">
                            <option value="${enterprise.id}">${enterprise.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
        </div>--%>
        <div class="span6" id="div_office_department">
            <label class="control-label">资产使用部门：</label>
            <div class="controls">
                <select id="assetsUseDepartment" name="assetsUseDepartment"
                        class="input-xlarge required">
                    <option value="">请选择</option>
                    <c:forEach items="${allOfficeList}" var="office">
                        <c:if test="${assetsManager.assetsUseDepartment==office.id}">
                            <option value="${office.id}"
                                    selected="selected">${office.name}</option>
                        </c:if>
                        <c:if test="${assetsManager.assetsUseDepartment!=office.id}">
                            <option value="${office.id}">${office.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="span6">
            <label class="control-label">资产使用地址：</label>
            <div class="controls">
                <form:input path="assetsLocation" htmlEscape="false" maxlength="64"
                            class="input-xlarge "/>
            </div>
        </div>
    </div>
        </c:otherwise>
    </c:choose>


    <div class="row-fluid row-border row-m-t">
        <div class="span6">
            <label class="control-label">保修开始时间：</label>
            <div class="controls">
                <input name="repairStartTime" type="text" readonly="readonly" maxlength="20"
                       class="input-medium Wdate "
                       value="<fmt:formatDate value="${assetsManager.repairStartTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                       onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
            </div>
        </div>
        <div class="span6">
            <label class="control-label">保修结束时间：</label>
            <div class="controls">
                <input name="repairEndTime" type="text" readonly="readonly" maxlength="20"
                       class="input-medium Wdate "
                       value="<fmt:formatDate value="${assetsManager.repairEndTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                       onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
            </div>
        </div>
    </div>
    <div class="row-fluid row-border row-m-t">
        <div class="span6">
            <label class="control-label">资产状态：</label>
            <div class="controls">
                <form:select path="assetsStatus" class="input-xlarge required">
                    <form:option value="" label=""/>
                    <form:options items="${fns:getDictList('assets_status')}" itemLabel="label"
                                  itemValue="value" htmlEscape="false"/>
                </form:select>
                <span class="help-inline"><font color="red">*</font> </span>
            </div>
        </div>

            <c:if test="${assetsManager.assetsType=='CAR'}">
             <div class="span6" id="div_plate_number">
                    <label class="control-label">车牌号：</label>
                    <div class="controls">
                        <form:input path="plateNumber" htmlEscape="false" maxlength="64"
                                    class="input-xlarge "/>
                    </div>
        </div>
            </c:if>
            <c:if test="${assetsManager.assetsType!='CAR'}">
                <div class="span6" id="div_plate_number" style="display:none;">
                    <label class="control-label">车牌号：</label>
                    <div class="controls">
                        <form:input path="plateNumber" htmlEscape="false" maxlength="64"
                                    class="input-xlarge "/>
                    </div>
                </div>
            </c:if>

    </div>

<div class="row-fluid row-border row-m-t">
    <div class="span6">
        <label class="control-label">资产负责人：</label>
        <div class="controls">
            <sys:treeselect id="manager" property="managerId" name="manager.id"
                            value="${assetsManager.manager.id}" labelName=""
                            labelValue="${assetsManager.manager.name}"
                            title="用户" url="/sys/office/treeData?type=3" cssClass="required"
                            allowClear="true" notAllowSelectParent="true"/>
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


    <div class="control-group" id="div_contact" style="display: none">
        <label class="control-label">合同：</label>
        <div class="controls">
            <sys:dynamicselect url="{contract}/contract/contract/api/getAll"
                               cssClass="input-medium " id="contactId" name="contactId"
                               valueProperty="id" textProperty="majorContractId"/>
        </div>
    </div>


    <div class="control-group">
        <label class="control-label">资产图片表：</label>
        <div class="controls">
            <table id="contentTable_assetsImage"
                   class="table table-striped table-bordered table-condensed">
                <thead>
                <tr>
                    <th class="hide"></th>
                    <th>保存路径</th>
                    <th>备注</th>
                    <shiro:hasPermission name="assets:assetsManager:edit">
                        <th width="10">&nbsp;</th>
                    </shiro:hasPermission>
                </tr>
                </thead>
                <tbody id="assetsImageList">
                </tbody>
                <shiro:hasPermission name="assets:assetsManager:edit">
                    <tfoot>
                    <tr>
                        <td colspan="4"></td>
                    </tr>
                    </tfoot>
                </shiro:hasPermission>
            </table>
            <script type="text/template" id="assetsImageTpl">//<!--
						<tr id="assetsImageList{{idx}}">
							<td class="hide">
								<input id="assetsImageList{{idx}}_id" name="assetsImageList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="assetsImageList{{idx}}_delFlag" name="assetsImageList[{{idx}}].isDeleted" type="hidden" value="N"/>
							</td>
							<td>
	<input id="assetsImageList{{idx}}_path" name="assetsImageList[{{idx}}].path" type="hidden" value="{{row.path}}" maxlength="64"/>
								<sys:ckfinder input="assetsImageList{{idx}}_path" type="files" uploadPath="/assets/group/assetsManager" selectMultiple="true"/>							</td>
							<td>
								<textarea id="assetsImageList{{idx}}_remarks" name="assetsImageList[{{idx}}].remarks" rows="4" maxlength="255" class="input-small ">{{row.remarks}}</textarea>
							</td>
							<shiro:hasPermission name="assets:assetsManager:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#assetsImageList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
            </script>
            <script type="text/javascript">
            var assetsImageRowIdx = 0,
                assetsImageTpl = $("#assetsImageTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,
                    "");
            $(document).ready(function () {
              var data = ${fns:toJson(assetsManager.assetsImageList)};
              for (var i = 0; i < data.length; i++) {
                addRow('#assetsImageList', assetsImageRowIdx, assetsImageTpl, data[i]);
                assetsImageRowIdx = assetsImageRowIdx + 1;
              }
            });
            </script>
        </div>
    </div>
    <div class="container text-center">

        <input id="btnCancel" class="btn btn-size" type="button" value="返 回" onclick="history.go(-1)"/>
    </div>
</form:form>
</div>
</body>
</html>