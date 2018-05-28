<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>项目管理管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/projectmanager/project/">项目管理列表</a></li>
		<shiro:hasPermission name="projectmanager:project:edit"><li><a href="${ctx}/projectmanager/project/form">项目管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="project" action="${ctx}/projectmanager/project/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>项目编号：</label>
				<form:input path="projectCode" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>项目名称：</label>
				<form:input path="projectName" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>项目编号</th>
				<th>项目名称</th>
				<th>项目类型</th>
				<th>项目状态</th>
				<th>进度</th>
				<shiro:hasPermission name="projectmanager:project:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="project">
			<tr>
				<td><a href="${ctx}/projectmanager/project/form?id=${project.id}">
					${project.projectCode}
				</a></td>
				<td>
					${project.projectName}
				</td>
				<td>
					${fns:getDictLabel(project.projectType, 'project_type', '')}
				</td>
				<td>
					${fns:getDictLabel(project.projectStatus, 'project_status', '')}
				</td>
				<td>
					${project.progress}
				</td>
				<shiro:hasPermission name="projectmanager:project:edit"><td>
    				<a href="${ctx}/projectmanager/project/form?id=${project.id}">修改</a>
					<a href="${ctx}/projectmanager/project/delete?id=${project.id}" onclick="return confirmx('确认要删除该项目管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>