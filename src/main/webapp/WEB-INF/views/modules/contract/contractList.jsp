<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>合同管理</title>
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
		<li class="active"><a href="${ctx}/contract/contract/">合同列表</a></li>
		<shiro:hasPermission name="contract:contract:edit"><li><a href="${ctx}/contract/contract/form">合同添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="contract" action="${ctx}/contract/contract/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
            <li>
                <label>项目名称：</label>
				<form:input path="projectName" htmlEscape="false" maxlength="128" class="input-medium"/>
			</li>
            <li>
                <label>合同状态: </label> <form:select
                    path="status"
                    class="input-medium"> <form:option
                    value=""
                    label="请选择"/> <form:options
                    items="${fns:getDictList('ecm_contract_status')}"
                    itemLabel="label"
                    itemValue="value"
                    htmlEscape="false"/> </form:select>
            </li>
            <li>
                <label>合同类别: </label> <form:select
                    path="type"
                    class="input-medium"> <form:option
                    value=""
                    label="请选择"/> <form:options
                    items="${fns:getDictList('ecm_contract_type')}"
                    itemLabel="label"
                    itemValue="value"
                    htmlEscape="false"/> </form:select>
            </li>
            <li>
                <label>合同级别: </label> <form:select
                    path="level"
                    class="input-medium"> <form:option
                    value=""
                    label="请选择"/> <form:options
                    items="${fns:getDictList('ecm_contract_level')}"
                    itemLabel="label"
                    itemValue="value"
                    htmlEscape="false"/> </form:select>
            </li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>合同项目名称</th>
				<th>合同状态</th>
				<th>合同类别</th>
				<th>合同级别</th>
				<th>合同总价</th>
				<th>签订日期</th>
				<th>生效日期</th>
				<th>甲方</th>
				<th>备注</th>
				<th>更新时间</th>
				<shiro:hasPermission name="contract:contract:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="contract">
			<tr>
				<td><a href="${ctx}/contract/contract/form?id=${contract.id}">
					${contract.projectName}
				</a></td>
				<td>
					${fns:getDictLabel(contract.status, 'ecm_contract_status', '')}
				</td>
				<td>
					${fns:getDictLabel(contract.type, 'ecm_contract_type', '')}
				</td>
				<td>
					${fns:getDictLabel(contract.level, 'ecm_contract_level', '')}
				</td>
				<td>
					${contract.contractTotalPrice}
				</td>
				<td>
					<fmt:formatDate value="${contract.signingDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${contract.validDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${contract.firstParty}
				</td>
				<td>
					${contract.remarks}
				</td>
				<td>
					<fmt:formatDate value="${contract.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="contract:contract:edit"><td>
    				<a href="${ctx}/contract/contract/form?id=${contract.id}">修改</a>
					<a href="${ctx}/contract/contract/delete?id=${contract.id}" onclick="return confirmx('确认要删除该合同吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>