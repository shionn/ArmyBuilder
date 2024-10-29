<%@ page pageEncoding="UTF-8"%>
<%@ page import="armybuilder.db.dbo.option.ArmyOptionType" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:template>
<jsp:attribute name="content">
<h1>Liste Army</h1>
<table>
	<c:forEach items="${armies}" var="army">
		<tr>
			<spring:url value="/admin/army/edit/${army.id}" var="url"/>
			<td><a href="${url}">${army.name}</a></td>
			<td><a href="${url}">Edit</a></td>
		</tr>
	</c:forEach>
</table>

<h1>Édition Army ${army.name} (${army.id})</h1>
<spring:url value="/admin/army/edit/${army.id}" var="url"/>
<form:form action="${url}" method="POST" class="row">
	TODO
</form:form>

</jsp:attribute>
<jsp:attribute name="scripts">
	<script type="text/javascript" src='<spring:url value="/js/admin-keywords-edit.js"/>'></script>
</jsp:attribute>
</t:template>
