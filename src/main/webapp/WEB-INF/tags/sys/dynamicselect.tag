<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<%@ attribute name="url" type="java.lang.String" required="true" %>
<%@ attribute name="id" type="java.lang.String" required="false" %>
<%@ attribute name="name" type="java.lang.String" required="true" %>
<%@ attribute name="valueProperty" type="java.lang.String" required="true" %>
<%@ attribute name="textProperty" type="java.lang.String" required="true" %>
<%--<%@ attribute name="value" type="java.lang.String" required="true" %>--%>
<%@ attribute name="cssClass" type="java.lang.String" required="false" description="css" %>
<%--<select id="${id}" name="${name}" class="${cssClass}">--%>
    <%--<option value=''>请选择</option>--%>
    <%--<c:if test="${not empty url}">--%>
        <%--<c:forEach--%>
                <%--items="${fns:getDataList(url,valueProperty , textProperty)}"--%>
                <%--var='data'>--%>
            <%--<c:if test="${value==data.value}">--%>
                <%--<option value='${data.value}' selected>${data.text}</option>--%>
            <%--</c:if>--%>
            <%--<c:if test="${value!=data.value}">--%>
                <%--<option value='${data.value}'>${data.text}</option>--%>
            <%--</c:if>--%>
        <%--</c:forEach>--%>
    <%--</c:if>--%>
<%--</select>--%>

<form:select id="${id}" path="${name}" class="${cssClass}">
    <form:option value="" label="请选择"/>
    <form:options items="${fns:getDataList(url,valueProperty , textProperty)}" htmlEscape="false"/>
</form:select>
