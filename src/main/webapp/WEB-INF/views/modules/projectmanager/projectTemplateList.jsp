<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>项目模板管理</title>
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
    <li class="active"><a href="${ctx}/projectmanager/projectTemplate/">项目模板列表</a></li>
    <shiro:hasPermission name="projectmanager:projectTemplate:edit">
        <li><a href="${ctx}/projectmanager/projectTemplate/form">项目模板添加</a></li>
    </shiro:hasPermission>
</ul>
<form:form id="searchForm" modelAttribute="projectTemplate"
           action="${ctx}/projectmanager/projectTemplate/" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li><label>模板名称：</label>
            <form:input path="templateName" htmlEscape="false" maxlength="64" class="input-medium"/>
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
        <th>模板名称</th>
        <th>更新时间</th>
        <th>备注</th>
        <shiro:hasPermission name="projectmanager:projectTemplate:edit">
            <th>操作</th>
        </shiro:hasPermission>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="projectTemplate">
        <tr>
            <td>
                    ${projectTemplate.templateName}
            </td>
            <td><a href="${ctx}/projectmanager/projectTemplate/form?id=${projectTemplate.id}">
                <fmt:formatDate value="${projectTemplate.updateDate}"
                                pattern="yyyy-MM-dd HH:mm:ss"/>
            </a></td>
            <td>
                    ${projectTemplate.remarks}
            </td>
            <shiro:hasPermission name="projectmanager:projectTemplate:edit">
                <td>
                    <a href="${ctx}/projectmanager/projectTemplate/apply?id=${projectTemplate.id}"
                       onclick="return confirmx('确认要应用该项目模板吗？', this.href)">应用模板</a>
                    <a href="${ctx}/projectmanager/projectTemplate/form?id=${projectTemplate.id}">修改</a>
                    <a href="${ctx}/projectmanager/projectTemplate/delete?id=${projectTemplate.id}"
                       onclick="return confirmx('确认要删除该项目模板吗？', this.href)">删除</a>
                </td>
            </shiro:hasPermission>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>