<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>分组管理管理</title>
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
		<li class="active"><a href="${ctx}/group/sysGroup/">分组管理列表</a></li>
		<shiro:hasPermission name="group:sysGroup:edit"><li><a href="${ctx}/group/sysGroup/form">分组管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sysGroup" action="${ctx}/group/sysGroup/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>组织：</label>
				<sys:treeselect id="office" name="office.id" value="${sysGroup.office.id}" labelName="office.name" labelValue="${sysGroup.office.name}"
					title="部门" url="/sys/office/treeData?type=2" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			<li><label>组名：</label>
				<form:input path="groupName" htmlEscape="false" maxlength="32" class="input-medium"/>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>组织</th>
				<th>组名</th>
				<th>备注</th>
				<shiro:hasPermission name="group:sysGroup:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sysGroup">
			<tr>
				<td><a href="${ctx}/group/sysGroup/form?id=${sysGroup.id}">
					${sysGroup.office.name}
				</a></td>
				<td>
					${sysGroup.groupName}
				</td>
				<td>
					${sysGroup.remarks}
				</td>
				<shiro:hasPermission name="group:sysGroup:edit"><td>
    				<a href="${ctx}/group/sysGroup/form?id=${sysGroup.id}">修改</a>
					<a href="${ctx}/group/sysGroup/delete?id=${sysGroup.id}" onclick="return confirmx('确认要删除该分组管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>