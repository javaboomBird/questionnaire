<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>政府信息管理管理</title>
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
		<li class="active"><a href="${ctx}/government/government/">政府信息管理列表</a></li>
		<shiro:hasPermission name="government:government:edit"><li><a href="${ctx}/government/government/form">政府信息管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="government" action="${ctx}/government/government/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>政府名称：</label>
				<form:input path="governmentName" htmlEscape="false" maxlength="64" class="input-medium"/>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>政府名称</th>
				<th>统一社会信用代码</th>
				<th>地址</th>
				<th>注册邮编</th>
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="government:government:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="government">
			<tr>
				<td><a href="${ctx}/government/government/form?id=${government.id}">
					${government.governmentName}
				</a></td>
				<td>
					${government.uscCode}
				</td>
				<td>
					${government.address}
				</td>
				<td>
					${government.registeredPostcode}
				</td>
				<td>
					<fmt:formatDate value="${government.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${government.remarks}
				</td>
				<shiro:hasPermission name="government:government:edit"><td>
    				<a href="${ctx}/government/government/form?id=${government.id}">修改</a>
					<a href="${ctx}/government/government/delete?id=${government.id}" onclick="return confirmx('确认要删除该政府信息管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>