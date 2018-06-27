<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>环评报告信息管理管理</title>
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
    <li class="active"><a href="${ctx}/customer/eiareport/">环评报告信息管理列表</a></li>
    <shiro:hasPermission name="eiareport:customerEiaReport:edit">
        <li><a href="${ctx}/customer/eiareport/form">环评报告信息管理添加</a></li>
    </shiro:hasPermission>
</ul>
<form:form id="searchForm" modelAttribute="customerEiaReport" action="${ctx}/customer/eiareport/"
           method="post" class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li><label>排污类型：</label>
            <sys:dynamicselect url="{customer}/pt/customerPollutionType/api/getAll"
                               cssClass="input-medium"
                               id="pollutionTypeId" name="pollutionTypeId" valueProperty="id"
                               textProperty="pollutionTypeName"/>
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
        <th>企业</th>
        <th>扩建设备</th>
        <th>排污类型</th>
        <th>排污许可状况</th>
        <th>更新时间</th>
        <th>备注</th>
        <shiro:hasPermission name="eiareport:customerEiaReport:edit">
            <th>操作</th>
        </shiro:hasPermission>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="customerEiaReport">
        <tr>
            <td>
                <a href="${ctx}/customer/enterprise/formView?id=${customerEiaReport.customer.id}">
                        ${customerEiaReport.customer.name}
                </a>
            </td>
            <td>
                    ${customerEiaReport.expendedDevice}
            </td>
            <td>
                    ${customerEiaReport.customerPollutionType.pollutionTypeName}
            </td>
            <td>
                    ${fns:getDictLabel(customerEiaReport.pollutionPermitStatus, 'pollution_permit_status', '')}
            </td>
            <td>
                <fmt:formatDate value="${customerEiaReport.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <td>
                    ${customerEiaReport.remarks}
            </td>
            <shiro:hasPermission name="eiareport:customerEiaReport:edit">
                <td>
                    <a href="${ctx}/customer/eiareport/form?id=${customerEiaReport.id}">修改</a>
                    <a href="${ctx}/customer/eiareport/delete?id=${customerEiaReport.id}"
                       onclick="return confirmx('确认要删除该环评报告信息管理吗？', this.href)">删除</a>
                </td>
            </shiro:hasPermission>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>