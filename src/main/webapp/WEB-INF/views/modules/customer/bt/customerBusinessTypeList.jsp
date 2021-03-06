<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>工商行业类型管理</title>
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
		<li class="active"><a href="${ctx}/customer/bt/">工商行业类型列表</a></li>
		<shiro:hasPermission name="bt:customerBusinessType:edit"><li><a href="${ctx}/customer/bt/form">工商行业类型添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="customerBusinessType" action="${ctx}/customer/bt/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>类型名称：</label>
				<form:input path="businessTypeName" htmlEscape="false" maxlength="32" class="input-medium"/>
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
				<shiro:hasPermission name="bt:customerBusinessType:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="businessType">
			<tr>
				<td><a href="${ctx}/customer/bt/form?id=${businessType.id}">
					${businessType.businessTypeName}
				</a></td>
				<td>
					<fmt:formatDate value="${businessType.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${businessType.remarks}
				</td>
				<shiro:hasPermission name="bt:customerBusinessType:edit"><td>
    				<a href="${ctx}/customer/bt/form?id=${businessType.id}">修改</a>
					<a href="${ctx}/customer/bt/delete?id=${businessType.id}" onclick="return confirmx('确认要删除该工商行业类型吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>