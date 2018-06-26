<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>工单分派</title>
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
    <li class="active"><a href="${ctx}/engineering/engineeringOrderAssignment/">工单分派列表</a></li>
</ul>
<form:form id="searchForm" modelAttribute="engineeringWorkOrder"
           action="${ctx}/engineering/engineeringOrderAssignment/" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li><label>工单号：</label>
            <form:input path="orderNumber" htmlEscape="false" maxlength="64" class="input-medium"/>
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
        <th>工单号</th>
        <th>工单类型</th>
        <th>发起人</th>
        <th>项目</th>
        <th>客户</th>
        <th>分配小组</th>
        <th>工单状态</th>
        <shiro:hasPermission name="engineering:engineeringWorkOrder:edit">
            <th>操作</th>
        </shiro:hasPermission>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="engineeringWorkOrder">
        <tr>
            <td>
                <a href="${ctx}/engineering/engineeringOrderAssignment/form?id=${engineeringWorkOrder.id}">
                        ${engineeringWorkOrder.orderNumber}
                </a>
            </td>
            <td>
                    ${fns:getDictLabel(engineeringWorkOrder.orderType, 'engineering_order_type', '')}
            </td>
            <td>
                    ${fns:getUserById(engineeringWorkOrder.sponsorId).name}
            </td>
            <td>
                    ${engineeringWorkOrder.project.projectName}
            </td>
            <td>
                    ${engineeringWorkOrder.customer.name}
            </td>
            <td>
                ${engineeringWorkOrder.sysGroup.groupName}
            </td>
            <td>
                   ${fns:getDictLabel(engineeringWorkOrder.status, 'engineering_order_status', '')}
            </td>
            <shiro:hasPermission name="engineering:engineeringOrderAssignment:edit">
                <td>
                    <c:choose>
                        <c:when test="${engineeringWorkOrder.status=='YTJ'}">
                            <a href="${ctx}/engineering/engineeringOrderAssignment/form?id=${engineeringWorkOrder.id}">分派</a>
                            <a href="${ctx}/engineering/engineeringOrderAssignment/cancel?id=${engineeringWorkOrder.id}"
                               onclick="return confirmx('确认要取消该工单吗？', this.href)">取消</a>
                        </c:when>
                        <c:when test="${engineeringWorkOrder.status=='YFP'}">
                            <a href="${ctx}/engineering/engineeringOrderAssignment/cancel?id=${engineeringWorkOrder.id}"
                               onclick="return confirmx('确认要取消该工单吗？', this.href)">取消</a>
                        </c:when>
                    </c:choose>

                </td>
            </shiro:hasPermission>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>