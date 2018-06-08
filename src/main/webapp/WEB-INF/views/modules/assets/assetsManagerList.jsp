<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>资产管理管理</title>
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
    <li class="active"><a href="${ctx}/assets/assetsManager/">资产管理列表</a></li>
    <shiro:hasPermission name="assets:assetsManager:edit">
        <li><a href="${ctx}/assets/assetsManager/form">资产管理添加</a></li>
    </shiro:hasPermission>
</ul>
<form:form id="searchForm" modelAttribute="assetsManager" action="${ctx}/assets/assetsManager/"
           method="post" class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li><label>资产编号：</label>
            <form:input path="assetsNo" htmlEscape="false" maxlength="64" class="input-sm"/>
        </li>
        <li><label>资产类型：</label>
            <form:select path="assetsType" class="input-medium">
                <form:option value="" label="请选择"/>
                <form:options items="${fns:getDictList('assets_type')}" itemLabel="label"
                              itemValue="value" htmlEscape="false"/>
            </form:select>
        </li>
        <li><label>资产名称：</label>
            <form:input path="assetsName" htmlEscape="false" maxlength="64" class="input-sm"/>
        </li>
        <li><label>使用单位：</label>
            <form:input path="assetsUseUnit" htmlEscape="false" maxlength="64" class="input-sm"/>
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
        <th>资产编号</th>
        <th>资产类型</th>
        <th>资产名称</th>
        <th>资产型号</th>
        <th>资产性质</th>
        <th>资产使用单位</th>
        <th>资产使用部门</th>
        <th>资产状态</th>
        <th>资产负责人</th>
        <shiro:hasPermission name="assets:assetsManager:edit">
            <th>操作</th>
        </shiro:hasPermission>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="assetsManager">
        <tr>
            <td><a href="${ctx}/assets/assetsManager/form?id=${assetsManager.id}">
                    ${assetsManager.assetsNo}
            </a></td>
            <td>
                    ${fns:getDictLabel(assetsManager.assetsType, 'assets_type', '')}
            </td>
            <td>
                    ${assetsManager.assetsName}
            </td>
            <td>
                    ${assetsManager.assetsModel}
            </td>
            <td>
                    ${fns:getDictLabel(assetsManager.assetsNature, 'assets_nature_type', '')}
            </td>

            <td>
                    ${assetsManager.assetsUseUnit}
            </td>
            <td>
                    ${assetsManager.assetsUseDepartment}
            </td>

            <td>
                    ${fns:getDictLabel(assetsManager.assetsStatus, 'assets_status', '')}
            </td>
            <td>
                    ${assetsManager.manager.name}
            </td>
            <shiro:hasPermission name="assets:assetsManager:edit">
                <td>
                    <a href="${ctx}/assets/assetsManager/form?id=${assetsManager.id}">修改</a>
                    <a href="${ctx}/assets/assetsManager/delete?id=${assetsManager.id}"
                       onclick="return confirmx('确认要删除该资产管理吗？', this.href)">删除</a>
                </td>
            </shiro:hasPermission>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>