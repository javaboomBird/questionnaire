<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>项目任务信息管理管理</title>
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
    <li class="active"><a href="${ctx}/projectmanager/projectTask/">项目任务信息管理列表</a></li>
    <shiro:hasPermission name="projectmanager:projectTask:edit">
        <li><a href="${ctx}/projectmanager/projectTask/form">项目任务信息管理添加</a></li>
    </shiro:hasPermission>
</ul>
<form:form id="searchForm" modelAttribute="projectTask" action="${ctx}/projectmanager/projectTask/"
           method="post" class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li><label>项目名称：${projectId}</label>
            <sys:dynamicselect url="{projectmanager}/projectmanager/project/api/getAll"
                               cssClass="input-medium required" id="projectId" name="projectId"
                               valueProperty="id" textProperty="projectName"/>
        </li>
        <li><label>任务名称：</label>
            <form:input path="taskName" htmlEscape="false" maxlength="32" class="input-medium"/>
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
        <th>项目名称</th>
        <th>阶段名称</th>
        <th>任务名称</th>
        <th>任务进度</th>
        <th>任务状态</th>
        <th>更新时间</th>
        <shiro:hasPermission name="projectmanager:projectTask:edit">
            <th>操作</th>
        </shiro:hasPermission>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="projectTask">
        <tr>
            <td>
                <a href="${ctx}/projectmanager/projectTask/form?id=${projectTask.id}">
                        ${projectTask.project.projectName}
                </a>
            </td>
            <td>
                    ${projectTask.stage.stageName}
            </td>
            <td>
                    ${projectTask.taskName}
            </td>
            <td>
                    ${projectTask.progress}
            </td>
            <td>
                    ${fns:getDictLabel(projectTask.taskStatus, 'project_task_status', '')}
            </td>
            <td>
                <fmt:formatDate value="${projectTask.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <shiro:hasPermission name="projectmanager:projectTask:edit">
                <td>
                    <a href="${ctx}/projectmanager/projectTask/form?id=${projectTask.id}">修改</a>
                    <a href="${ctx}/projectmanager/projectTask/delete?id=${projectTask.id}"
                       onclick="return confirmx('确认要删除该项目任务信息管理吗？', this.href)">删除</a>
                </td>
            </shiro:hasPermission>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>