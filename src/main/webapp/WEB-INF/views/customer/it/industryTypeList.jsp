<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>污染行业类型管理</title>
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
		<li class="active"><a href="${ctx}/it/industryType/">污染行业类型列表</a></li>
		<shiro:hasPermission name="it:industryType:edit"><li><a href="${ctx}/it/industryType/form">污染行业类型添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="industryType" action="${ctx}/it/industryType/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>类型名称：</label>
				<form:input path="industryTypeName" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>类型名称</th>
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="it:industryType:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="industryType">
			<tr>
				<td><a href="${ctx}/it/industryType/form?id=${industryType.id}">
					${industryType.industryTypeName}
				</a></td>
				<td>
					<fmt:formatDate value="${industryType.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${industryType.remarks}
				</td>
				<shiro:hasPermission name="it:industryType:edit"><td>
    				<a href="${ctx}/it/industryType/form?id=${industryType.id}">修改</a>
					<a href="${ctx}/it/industryType/delete?id=${industryType.id}" onclick="return confirmx('确认要删除该污染行业类型吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>