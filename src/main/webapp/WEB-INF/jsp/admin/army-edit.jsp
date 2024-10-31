<%@ page pageEncoding="UTF-8"%>
<%@ page import="armybuilder.db.dbo.option.ArmyOptionType" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:template>
<jsp:attribute name="content">
<h1>Liste Armies</h1>
<table>
	<c:forEach items="${armies}" var="army">
		<tr>
			<spring:url value="/admin/army/edit/${army.id}" var="url"/>
			<td><a href="${url}">${army.name}</a></td>
			<td><a href="${url}">${army.model.name}</a></td>
			<td><a href="${url}">Edit</a></td>
		</tr>
	</c:forEach>
</table>

<c:if test="${not empty army}">
<h1>Édition ${army.name} (${army.id})</h1>
<spring:url value="/admin/army/edit/${army.id}" var="url"/>
<form:form action="${url}" method="POST" class="row" id="form">
	<input type="hidden" name="id" value="${army.id}"/>
	<div>
		<label>Name</label>
		<input type="text" name="name" value="${army.name}"/>
	</div>
	<div>
		<label>Model</label>
		<select name="army.id">
			<option value="-1">--</option>
			<c:forEach items="${models}" var="m">
				<option value="${m.id}" <c:if test="${m.id == army.model.id}">selected="selected"</c:if>>${m.name}</option>
			</c:forEach>
		</select>
	</div>
	<div>
		<input type="submit">
	</div>
</form:form>
</c:if>

<h1>Creation Armée</h1>
<spring:url value="/admin/army/create" var="url"/>
<form:form action="${url}" method="POST" class="row">
	<div>
		<label>Name</label>
		<input type="text" name="name"/>
	</div>
	<div>
		<input type="submit">
	</div>
</form:form>


<h1>Liste Army Model</h1>
<table>
	<c:forEach items="${models}" var="m">
		<tr>
			<spring:url value="/admin/army/model/edit/${m.id}" var="url"/>
			<td><a href="${url}">${m.name}</a></td>
			<td><a href="${url}">Edit</a></td>
		</tr>
	</c:forEach>
</table>

<h1>Édition Army Model ${model.name} (${model.id})</h1>
<spring:url value="/admin/army/model/edit/${model.id}" var="url"/>
<form:form action="${url}" method="POST" class="row">
	TODO
</form:form>

</jsp:attribute>
<jsp:attribute name="scripts">
	<script type="text/javascript" src='<spring:url value="/js/admin-keywords-edit.js"/>'></script>
</jsp:attribute>
</t:template>
