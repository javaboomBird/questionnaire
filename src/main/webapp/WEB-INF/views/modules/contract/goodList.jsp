<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>合同商品管理</title>
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
		<li class="active"><a href="${ctx}/contract/good/">合同商品列表</a></li>
		<shiro:hasPermission name="contract:good:edit"><li><a href="${ctx}/contract/good/form">合同商品添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="good" action="${ctx}/contract/good/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>商品名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="128" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>商品编号</th>
				<th>商品名称</th>
				<th>商品单位</th>
				<th>商品型号</th>
				<th>商品类型</th>
				<th>生产厂商</th>
				<th>供应厂商</th>
				<th>采购价</th>
				<th>建议售价</th>
				<th>商品介绍</th>
				<th>备注</th>
				<th>更新时间</th>
				<shiro:hasPermission name="contract:good:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="good">
			<tr>
				<td><a href="${ctx}/contract/good/form?id=${good.id}">
					${good.no}
				</a></td>
				<td>
					${good.name}
				</td>
				<td>
					${good.unit}
				</td>
				<td>
					${good.model}
				</td>
				<td>
					${fns:getDictLabel(good.type, 'ecm_good_type', '')}
				</td>
				<td>
					${good.manufacturer}
				</td>
				<td>
					${good.supplier}
				</td>
				<td>
					${good.purchasePrice}
				</td>
				<td>
					${good.tagPrice}
				</td>
				<td>
					${good.introduction}
				</td>
				<td>
					${good.remarks}
				</td>
				<td>
					<fmt:formatDate value="${good.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="contract:good:edit"><td>
    				<a href="${ctx}/contract/good/form?id=${good.id}">修改</a>
					<a href="${ctx}/contract/good/delete?id=${good.id}" onclick="return confirmx('确认要删除该合同商品吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>