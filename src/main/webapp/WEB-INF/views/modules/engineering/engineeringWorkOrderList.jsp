<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>工单管理</title>
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
    <li class="active"><a href="${ctx}/engineering/engineeringWorkOrder/">工单列表</a></li>
    <shiro:hasPermission name="engineering:engineeringWorkOrder:edit">
        <li><a href="${ctx}/engineering/engineeringWorkOrder/form">工单添加</a></li>
    </shiro:hasPermission>
</ul>
<form:form id="searchForm" modelAttribute="engineeringWorkOrder"
           action="${ctx}/engineering/engineeringWorkOrder/" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <input type="hidden" id="sponsorId" name="sponsorId" value="${fns:getUser()}"/>

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
        <th>工单优先级</th>
        <th>工单状态</th>

        <th>备注</th>
        <shiro:hasPermission name="engineering:engineeringWorkOrder:edit">
            <th>操作</th>
        </shiro:hasPermission>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="engineeringWorkOrder">
        <tr>
            <td>
                <a href="${ctx}/engineering/engineeringWorkOrder/formView?id=${engineeringWorkOrder.id}">
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
                    ${fns:getDictLabel(engineeringWorkOrder.priority, 'engineering_order_priority', '')}
            </td>
            <td>
                    ${fns:getDictLabel(engineeringWorkOrder.status, 'engineering_order_status', '')}
            </td>
            <td>
                    ${engineeringWorkOrder.remarks}
            </td>
            <shiro:hasPermission name="engineering:engineeringWorkOrder:edit">
                <td>
                    <c:choose>
                        <c:when test="${engineeringWorkOrder.status=='YTJ'}">
                            <a href="${ctx}/engineering/engineeringWorkOrder/form?id=${engineeringWorkOrder.id}">修改</a>
                            <a href="${ctx}/engineering/engineeringWorkOrder/delete?id=${engineeringWorkOrder.id}"
                               onclick="return confirmx('确认要删除该工单管理吗？', this.href)">删除</a>
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