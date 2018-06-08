<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>资产连接信息管理管理</title>
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
		<li class="active"><a href="${ctx}/assets/assetsConnectionInfo/">资产连接信息管理列表</a></li>
		<shiro:hasPermission name="assets:assetsConnectionInfo:edit"><li><a href="${ctx}/assets/assetsConnectionInfo/form">资产连接信息管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="assetsConnectionInfo" action="${ctx}/assets/assetsConnectionInfo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>源资产：</label>
			  <sys:dynamicselect url="{assets}/assets/assetsManager/api/getEnterpriseAll" cssClass="input-xlarge required" id="sourceAssetsId" name="sourceAssetsId" valueProperty="id" textProperty="assetsName" />
			</li>
			<li><label>目标资产：</label>
			  <sys:dynamicselect url="{assets}/assets/assetsManager/api/getEnterpriseAll" cssClass="input-xlarge required" id="targetAssetsId" name="targetAssetsId" valueProperty="id" textProperty="assetsName" />
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>源资产</th>
				<th>源资产接口地址</th>
				<th>目标资产</th>
				<th>目标资产接口地址</th>
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="assets:assetsConnectionInfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="assetsConnectionInfo">
			<tr>
				<td><a href="${ctx}/assets/assetsConnectionInfo/form?id=${assetsConnectionInfo.id}">
					${assetsConnectionInfo.sourceAssets.assetsName}
				</a></td>
				<td>
					${assetsConnectionInfo.sourceApi}
				</td>
				<td>
					${assetsConnectionInfo.targetAssets.assetsName}
				</td>
				<td>
					${assetsConnectionInfo.targetApi}
				</td>
				<td>
					<fmt:formatDate value="${assetsConnectionInfo.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${assetsConnectionInfo.remarks}
				</td>
				<shiro:hasPermission name="assets:assetsConnectionInfo:edit"><td>
    				<a href="${ctx}/assets/assetsConnectionInfo/form?id=${assetsConnectionInfo.id}">修改</a>
					<a href="${ctx}/assets/assetsConnectionInfo/delete?id=${assetsConnectionInfo.id}" onclick="return confirmx('确认要删除该资产连接信息管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>