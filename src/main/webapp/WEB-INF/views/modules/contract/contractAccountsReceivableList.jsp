<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>合同收款管理</title>
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
		<li class="active"><a href="${ctx}/contract/contractAccountsReceivable/">合同收款列表</a></li>
		<shiro:hasPermission name="contract:contractAccountsReceivable:edit"><li><a href="${ctx}/contract/contractAccountsReceivable/form">合同收款添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="contractAccountsReceivable" action="${ctx}/contract/contractAccountsReceivable/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li>
				<label class="control-label">合同名称：</label> <sys:dynamicselect
					url="{contract}/contract/contract/api/getAll"
					cssClass="input-xlarge"
					id="contractId"
					name="contractId"
					valueProperty="id"
					textProperty="projectName"/>
			</li>
			<li><label>应收款名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>应收款名称</th>
				<th>应收账款</th>
				<th>更新时间</th>
				<shiro:hasPermission name="contract:contractAccountsReceivable:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="contractAccountsReceivable">
			<tr>
				<td><a href="${ctx}/contract/contractAccountsReceivable/form?id=${contractAccountsReceivable.id}">
					${contractAccountsReceivable.name}
				</a></td>
				<td>
					${contractAccountsReceivable.accountsReceivable}
				</td>
				<td>
					<fmt:formatDate value="${contractAccountsReceivable.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="contract:contractAccountsReceivable:edit"><td>
    				<a href="${ctx}/contract/contractAccountsReceivable/form?id=${contractAccountsReceivable.id}">修改</a>
					<a href="${ctx}/contract/contractAccountsReceivable/delete?id=${contractAccountsReceivable.id}" onclick="return confirmx('确认要删除该合同收款吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>