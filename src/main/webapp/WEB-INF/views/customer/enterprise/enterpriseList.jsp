<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>企业信息管理管理</title>
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
		<li class="active"><a href="${ctx}/enterprise/enterprise/">企业信息管理列表</a></li>
		<shiro:hasPermission name="enterprise:enterprise:edit"><li><a href="${ctx}/enterprise/enterprise/form">企业信息管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="enterprise" action="${ctx}/enterprise/enterprise/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>企业名称：</label>
				<form:input path="enterpriseName" htmlEscape="false" maxlength="64" class="input-medium"/>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>企业名称</th>
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="enterprise:enterprise:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="enterprise">
			<tr>
				<td><a href="${ctx}/enterprise/enterprise/form?id=${enterprise.id}">
					${enterprise.enterpriseName}
				</a></td>
				<td>
					<fmt:formatDate value="${enterprise.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${enterprise.remarks}
				</td>
				<shiro:hasPermission name="enterprise:enterprise:edit"><td>
    				<a href="${ctx}/enterprise/enterprise/form?id=${enterprise.id}">修改</a>
					<a href="${ctx}/enterprise/enterprise/delete?id=${enterprise.id}" onclick="return confirmx('确认要删除该企业信息管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>