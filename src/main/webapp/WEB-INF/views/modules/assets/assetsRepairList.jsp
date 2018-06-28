<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>资产维修管理</title>
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
    <li class="active"><a href="${ctx}/assets/assetsRepair/">资产维修列表</a></li>
    <shiro:hasPermission name="assets:assetsRepair:edit">
        <li><a href="${ctx}/assets/assetsRepair/form">资产维修添加</a></li>
    </shiro:hasPermission>
</ul>
<form:form id="searchForm" modelAttribute="assetsRepair" action="${ctx}/assets/assetsRepair/"
           method="post" class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li><label>维修编号：</label>
            <form:input path="repairNo" htmlEscape="false" maxlength="64" class="input-medium"/>
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
        <th>维修编号</th>
        <th>资产</th>
        <th>申请人</th>
        <th>送修时间</th>
        <th>维修是否完成</th>
        <th>完成时间</th>
        <th>故障分析</th>
        <shiro:hasPermission name="assets:assetsRepair:edit">
            <th>操作</th>
        </shiro:hasPermission>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="assetsRepair">
        <tr>
            <td><a href="${ctx}/assets/assetsRepair/formView?id=${assetsRepair.id}">
                    ${assetsRepair.repairNo}
            </a></td>
            <td>
                    ${assetsRepair.assetsManager.assetsNo}
            </td>
            <td>
                    ${assetsRepair.applicant.name}
            </td>
            <td>
                <fmt:formatDate value="${assetsRepair.repairTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <td>
                    ${fns:getDictLabel(assetsRepair.repairComplete,'assets_repair_status' ,'' )}
            </td>
            <td>
                <fmt:formatDate value="${assetsRepair.completeTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <td>
                    ${assetsRepair.faultAnalysis}
            </td>
            <shiro:hasPermission name="assets:assetsRepair:edit">
                <td>
                    <a href="${ctx}/assets/assetsRepair/form?id=${assetsRepair.id}">修改</a>
                    <a href="${ctx}/assets/assetsRepair/delete?id=${assetsRepair.id}"
                       onclick="return confirmx('确认要删除该资产维修吗？', this.href)">删除</a>
                </td>
            </shiro:hasPermission>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>