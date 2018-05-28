<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<%@ attribute name="url" type="java.lang.String" required="true" %>
<%@ attribute name="id" type="java.lang.String" required="true" %>
<%@ attribute name="name" type="java.lang.String" required="true" %>
<%@ attribute name="valueProperty" type="java.lang.String" required="true" %>
<%@ attribute name="textProperty" type="java.lang.String" required="true" %>
<%@ attribute name="cssClass" type="java.lang.String" required="false" description="css" %>
<select id="${id}" name="${name}" class="${cssClass}">
    <c:if test="${not empty url}">
        <c:forEach
                items="${fns:getDataList(url,valueProperty , textProperty)}"
                var='data'>
            <option value='${data.value}'>${data.text}</option>
        </c:forEach>
    </c:if>
</select>
