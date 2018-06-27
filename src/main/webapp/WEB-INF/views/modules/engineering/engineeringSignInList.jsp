<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>工程签到管理</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
    $(document).ready(function () {

    });

    function page(n, s) {
      $("#pageNo").val(n);
      $("#pageSize").val(s);
      $("#searchForm").submit();
      return false;
    }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/engineering/engineeringSignIn/">工程签到列表</a></li>
    <shiro:hasPermission name="engineering:engineeringSignIn:edit">
        <li><a href="${ctx}/engineering/engineeringSignIn/form">工程签到添加</a></li>
    </shiro:hasPermission>
</ul>
<form:form id="searchForm" modelAttribute="engineeringSignIn"
           action="${ctx}/engineering/engineeringSignIn/" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li><label>工单：</label>

            <sys:dynamicselect url="{engineering}/engineering/engineeringWorkOrder/api/getAll"
                               cssClass="input-xlarge "
                               id="engineeringId" name="engineeringId" valueProperty="id"
                               textProperty="orderNumber"/>
        </li>
        <li><label>分组：</label>
            <sys:dynamicselect url="{group}/group/sysGroup/api/getAll"
                               cssClass="input-xlarge required" id="teamId" name="teamId"
                               valueProperty="id" textProperty="groupName"/>
        </li>
        <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
        </li>
        <li class="clearfix"></li>
    </ul>
</form:form>
<sys:message content="${message}"/>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th>工单</th>
        <th>分组</th>
        <th>客户</th>
        <th>签到时间</th>
        <th>签到类型</th>
        <th>备注</th>
        <shiro:hasPermission name="engineering:engineeringSignIn:edit">
            <th>操作</th>
        </shiro:hasPermission>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="engineeringSignIn">
        <tr>
            <td><a href="${ctx}/engineering/engineeringSignIn/form?id=${engineeringSignIn.id}">
                    ${engineeringSignIn.engineeringWorkOrder.orderNumber}
            </a></td>
            <td>
                    ${engineeringSignIn.engineeringWorkOrder.sysGroup.groupName}
            </td>
            <td>
                    ${engineeringSignIn.engineeringWorkOrder.customer.name}
            </td>
            <td>
                <fmt:formatDate value="${engineeringSignIn.signTime}"
                                pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <td>
                    ${fns:getDictLabel(engineeringSignIn.signType,'engineering_sign_in_type' ,'')}
            </td>

            <td>
                    ${engineeringSignIn.remarks}
            </td>
            <shiro:hasPermission name="engineering:engineeringSignIn:edit">
                <td>
                    <a href="${ctx}/engineering/engineeringSignIn/form?id=${engineeringSignIn.id}">修改</a>
                    <a href="${ctx}/engineering/engineeringSignIn/delete?id=${engineeringSignIn.id}"
                       onclick="return confirmx('确认要删除该工程签到吗？', this.href)">删除</a>
                </td>
            </shiro:hasPermission>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>