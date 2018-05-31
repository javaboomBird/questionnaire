<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>项目阶段管理管理</title>
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
		<li class="active"><a href="${ctx}/projectmanager/projectStage/">项目阶段管理列表</a></li>
		<shiro:hasPermission name="projectmanager:projectStage:edit"><li><a href="${ctx}/projectmanager/projectStage/form">项目阶段管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="projectStage" action="${ctx}/projectmanager/projectStage/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>项目名称：</label>
			  <sys:dynamicselect url="{projectmanager}//projectmanager/project/api/getAll" cssClass="input-medium required" id="projectId" name="projectId" valueProperty="id" textProperty="projectName" />
			</li>
			<li><label>阶段名称：</label>
				<form:input path="stageName" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>项目名称</th>
				<th>阶段名称</th>
                <th>阶段状态</th>
                <th>阶段进度</th>
				<th>更新时间</th>
				<shiro:hasPermission name="projectmanager:projectStage:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="projectStage">
			<tr>
				<td><a href="${ctx}/projectmanager/projectStage/form?id=${projectStage.id}">
					${projectStage.project.projectName}
				</a></td>
				<td>
					${projectStage.stageName}
				</td>
                <td>
                        ${fns:getDictLabel(projectStage.stageStatus, 'project_status', '')}
                </td>
                <td>
                        ${projectStage.progress}
                </td>
				<td>
					<fmt:formatDate value="${projectStage.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>

				<shiro:hasPermission name="projectmanager:projectStage:edit"><td>
    				<a href="${ctx}/projectmanager/projectStage/form?id=${projectStage.id}">修改</a>
					<a href="${ctx}/projectmanager/projectStage/delete?id=${projectStage.id}" onclick="return confirmx('确认要删除该项目阶段管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>