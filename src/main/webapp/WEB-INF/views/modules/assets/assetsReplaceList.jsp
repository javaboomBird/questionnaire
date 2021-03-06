<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>资产替换管理</title>
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
    <li class="active"><a href="${ctx}/assets/assetsReplace/">资产替换列表</a></li>
    <shiro:hasPermission name="assets:assetsReplace:edit">
        <li><a href="${ctx}/assets/assetsReplace/form">资产替换添加</a></li>
    </shiro:hasPermission>
</ul>
<form:form id="searchForm" modelAttribute="assetsReplace" action="${ctx}/assets/assetsReplace/"
           method="post" class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li><label>更换单号：</label>
            <form:input path="replaceNo" htmlEscape="false" maxlength="64" class="input-medium"/>
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
        <th>更换单号</th>
        <th>被替换资产编号</th>
        <th>替换资产编号</th>
        <th>更换负责人</th>
        <th>更新时间</th>
        <th>备注</th>
        <shiro:hasPermission name="assets:assetsReplace:edit">
            <th>操作</th>
        </shiro:hasPermission>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="assetsReplace">
        <tr>
            <td>
                <a href="${ctx}/assets/assetsReplace/form?id=${assetsReplace.id}">
                        ${assetsReplace.replaceNo}
                </a>
            </td>
            <td>
                    ${assetsReplace.originalAssetsManager.assetsNo}
            </td>
            <td>
                    ${assetsReplace.replaceAssetsManager.assetsNo}
            </td>
            <td>
                    ${assetsReplace.replaceManager.name}
            </td>
            <td>
                <fmt:formatDate value="${assetsReplace.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <td>
                    ${assetsReplace.remarks}
            </td>
            <shiro:hasPermission name="assets:assetsReplace:edit">
                <td>
                    <a href="${ctx}/assets/assetsReplace/form?id=${assetsReplace.id}">修改</a>
                    <a href="${ctx}/assets/assetsReplace/delete?id=${assetsReplace.id}"
                       onclick="return confirmx('确认要删除该资产替换吗？', this.href)">删除</a>
                </td>
            </shiro:hasPermission>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>