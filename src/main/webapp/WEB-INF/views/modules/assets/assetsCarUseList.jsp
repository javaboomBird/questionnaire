<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>车辆使用管理</title>
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
    <li class="active"><a href="${ctx}/assets/assetsCarUse/">车辆使用列表</a></li>
    <shiro:hasPermission name="assets:assetsCarUse:edit">
        <li><a href="${ctx}/assets/assetsCarUse/form">车辆使用添加</a></li>
    </shiro:hasPermission>
</ul>
<form:form id="searchForm" modelAttribute="assetsCarUse" action="${ctx}/assets/assetsCarUse/"
           method="post" class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li><label>车辆：</label>
            <sys:dynamicselect url="{assets}/assets/assetsManager/api/getAll?assetsType=CAR"
                               cssClass="input-medium " id="assetsId" name="assetsId"
                               valueProperty="id" textProperty="plateNumber"/>
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
        <th>车辆</th>
        <th>使用人</th>
        <th>使用目的</th>
        <th>使用前里程</th>
        <th>使用后里程</th>
        <th>开始时间</th>
        <th>结束时间</th>
        <shiro:hasPermission name="assets:assetsCarUse:edit">
            <th>操作</th>
        </shiro:hasPermission>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="assetsCarUse">
        <tr>
            <td><a href="${ctx}/assets/assetsCarUse/form?id=${assetsCarUse.id}">
                    ${assetsCarUse.assetsManager.plateNumber}
            </a></td>
            <td>
                    ${fns:getUserById(assetsCarUse.managerId).name}
            </td>
            <td>
                    ${assetsCarUse.usePurpose}
            </td>
            <td>
                    ${assetsCarUse.beforeMileage}
            </td>
            <td>
                    ${assetsCarUse.afterMileage}
            </td>
            <td>
                <fmt:formatDate value="${assetsCarUse.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <td>
                <fmt:formatDate value="${assetsCarUse.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <shiro:hasPermission name="assets:assetsCarUse:edit">
                <td>
                    <a href="${ctx}/assets/assetsCarUse/form?id=${assetsCarUse.id}">修改</a>
                    <a href="${ctx}/assets/assetsCarUse/delete?id=${assetsCarUse.id}"
                       onclick="return confirmx('确认要删除该车辆使用吗？', this.href)">删除</a>
                </td>
            </shiro:hasPermission>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>