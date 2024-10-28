<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:template>
<jsp:attribute name="content">
<spring:url value="/army/${army.id}" var="base"/>
<form:form method="POST" action="${base}">
	
</form:form>
<div>
	<select class="ajax" name="model" data-url="${base}/add-unit" data-update="#units">
		<option value="-1">Add Unit</option>
		<c:forEach items="${army.model.units}" var="u">
			<option value="${u.id}">${u.name}</option>
		</c:forEach>
	</select>
</div>
<div id="units">

</div>
</jsp:attribute>
</t:template>
