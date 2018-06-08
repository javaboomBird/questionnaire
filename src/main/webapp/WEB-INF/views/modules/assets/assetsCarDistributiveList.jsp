<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>车辆分配管理</title>
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
    <li class="active"><a href="${ctx}/assets/assetsCarDistributive/">车辆分配列表</a></li>
    <shiro:hasPermission name="assets:assetsCarDistributive:edit">
        <li><a href="${ctx}/assets/assetsCarDistributive/form">车辆分配添加</a></li>
    </shiro:hasPermission>
</ul>
<form:form id="searchForm" modelAttribute="assetsCarDistributive"
           action="${ctx}/assets/assetsCarDistributive/" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li><label>车辆：</label>
            <sys:dynamicselect url="{assets}/assets/assetsManager/api/getAll?assetsType=CAR" cssClass="input-medium required" id="assetsId" name="assetsId" valueProperty="id" textProperty="plateNumber" />
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
        <th>部门</th>
        <th>组名</th>
        <th>组类别</th>
        <th>车牌号</th>
        <th>更新时间</th>
        <th>备注</th>
        <shiro:hasPermission name="assets:assetsCarDistributive:edit">
            <th>操作</th>
        </shiro:hasPermission>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="assetsCarDistributive">
        <tr>
            <td>
                    ${assetsCarDistributive.sysGroup.office.name}
            </td>
            <td>
                    ${assetsCarDistributive.sysGroup.groupName}
            </td>

            <td>
                    ${fns:getDictLabel(assetsCarDistributive.sysGroup.groupType, 'sys_group_type', '')}
            </td>
            <td>
                    ${assetsCarDistributive.assetsManager.plateNumber}
            </td>
            <td>
                <a href="${ctx}/assets/assetsCarDistributive/form?id=${assetsCarDistributive.id}">
                    <fmt:formatDate value="${assetsCarDistributive.updateDate}"
                                    pattern="yyyy-MM-dd HH:mm:ss"/>
                </a>
            </td>
            <td>
                    ${assetsCarDistributive.remarks}
            </td>
            <shiro:hasPermission name="assets:assetsCarDistributive:edit">
                <td>
                    <a href="${ctx}/assets/assetsCarDistributive/form?id=${assetsCarDistributive.id}">修改</a>
                    <a href="${ctx}/assets/assetsCarDistributive/delete?id=${assetsCarDistributive.id}"
                       onclick="return confirmx('确认要删除该车辆分配吗？', this.href)">删除</a>
                </td>
            </shiro:hasPermission>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>