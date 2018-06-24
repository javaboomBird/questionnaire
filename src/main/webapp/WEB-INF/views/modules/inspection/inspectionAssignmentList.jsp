<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>巡检分配管理</title>
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
    <li class="active"><a href="${ctx}/inspection/inspectionAssignment/">巡检分配列表</a></li>
    <shiro:hasPermission name="inspection:inspectionAssignment:edit">
        <li><a href="${ctx}/inspection/inspectionAssignment/form">巡检分配添加</a></li>
    </shiro:hasPermission>
</ul>
<form:form id="searchForm" modelAttribute="inspectionAssignment"
           action="${ctx}/inspection/inspectionAssignment/" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li><label>运维组名：</label>
            <sys:dynamicselect url="{group}/group/sysGroup/api/getAll" cssClass="input-medium required" id="teamId" name="teamId" valueProperty="id" textProperty="groupName" />
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
        <th>地区</th>
        <th>运维组</th>
        <th>企业名称</th>
        <th>数采仪资产</th>
        <th>每月维护次数</th>
        <th>生效月份</th>
        <shiro:hasPermission name="inspection:inspectionAssignment:edit">
            <th>操作</th>
        </shiro:hasPermission>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="inspectionAssignment">
        <tr>
            <td>
                    ${inspectionAssignment.assetsManager.customer.area.name}
            </td>
            <td>
                    ${inspectionAssignment.sysGroup.groupName}
            </td>
            <td>
                    ${inspectionAssignment.assetsManager.customer.name}
            </td>
            <td>
                    ${inspectionAssignment.assetsManager.assetsName}
            </td>
            <td>
                    ${inspectionAssignment.inspectionTimes}
            </td>
            <td>
                <fmt:formatDate value="${inspectionAssignment.inspectionMonth}"
                                pattern="yyyy-MM-dd"/>
            </td>
            <shiro:hasPermission name="inspection:inspectionAssignment:edit">
                <td>
                    <a href="${ctx}/inspection/inspectionAssignment/form?teamId=${inspectionAssignment.teamId}">修改</a>
                    <a href="${ctx}/inspection/inspectionAssignment/delete?id=${inspectionAssignment.id}"
                       onclick="return confirmx('确认要删除该巡检分配吗？', this.href)">删除</a>
                </td>
            </shiro:hasPermission>
        </tr>

    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>