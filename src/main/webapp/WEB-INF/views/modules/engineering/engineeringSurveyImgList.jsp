<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>勘察图片管理</title>
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
		<li class="active"><a href="${ctx}/engineering/engineeringSurveyImg/">勘察图片列表</a></li>
		<shiro:hasPermission name="engineering:engineeringSurveyImg:edit"><li><a href="${ctx}/engineering/engineeringSurveyImg/form">勘察图片添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="engineeringSurveyImg" action="${ctx}/engineering/engineeringSurveyImg/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>工单：</label>
				<form:input path="engineeringId" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>工单</th>
				<th>客户</th>
				<th>上传时间</th>
				<th>上传者</th>
				<th>备注</th>
				<shiro:hasPermission name="engineering:engineeringSurveyImg:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="engineeringSurveyImg">
			<tr>
				<td><a href="${ctx}/engineering/engineeringSurveyImg/form?id=${engineeringSurveyImg.id}">
					${engineeringSurveyImg.engineeringWorkOrder.orderNumber}
				</a></td>
				<td>
					${engineeringSurveyImg.customer.name}
				</td>
				<td>
					<fmt:formatDate value="${engineeringSurveyImg.uploadTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${engineeringSurveyImg.uploadBy}
				</td>
				<td>
					${engineeringSurveyImg.remarks}
				</td>
				<shiro:hasPermission name="engineering:engineeringSurveyImg:edit"><td>
    				<a href="${ctx}/engineering/engineeringSurveyImg/form?id=${engineeringSurveyImg.id}">修改</a>
					<a href="${ctx}/engineering/engineeringSurveyImg/delete?id=${engineeringSurveyImg.id}" onclick="return confirmx('确认要删除该勘察图片吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>