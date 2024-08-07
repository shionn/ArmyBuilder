<%@ page pageEncoding="UTF-8"%>
<%@ page import="armybuilder.v3.model.army.Allegiance" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib tagdir="/WEB-INF/tags/v3" prefix="t"%>
<t:template>
	<jsp:attribute name="content">
<h1>Nouvelle armee</h1>
<spring:url value="/v3/army/create" var="url" />
<form:form action="${url}" method="POST">
	<fieldset>
		<label>Nom</label>
		<input type="text" name="name" required="required" />
		<label>Allegiance</label>
		<select name="allegiance">
			<c:forEach items="${Allegiance.values()}" var="a">
				<option value="${a}">${a.displayName}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Ajouter">
	</fieldset>
</form:form>

</jsp:attribute>
	<jsp:attribute name="scripts"></jsp:attribute>
</t:template>


