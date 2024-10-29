<%@ page pageEncoding="UTF-8"%>
<%@ page import="armybuilder.db.dbo.option.ArmyOptionType" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:template>
<jsp:attribute name="content">
<h1>Liste Option</h1>
<table>
	<c:forEach items="${options}" var="option">
		<tr>
			<spring:url value="/admin/army/option/edit/${option.id}" var="url"/>
			<td>${option.army.name}</td>
			<td><a href="${url}">${option.name}</a></td>
			<td><a href="${url}">Edit</a></td>
		</tr>
	</c:forEach>
</table>

<c:if test="${not empty option}">
<h1>Édition Option</h1>
<spring:url value="/admin/army/option/edit/${option.id}" var="url"/>
<form:form action="${url}" method="POST" class="row">
	<div>
		<label>Name</label>
		<input type="text" name="name" value="${option.name}"/>
	</div>
	<div>
		<label>Armée</label>
		<select name="army.id">
			<option value="--">--</option>
			<c:forEach items="${armies}" var="a">
				<option value="${a.id}"
				<c:if test="${a.id == option.army.id}">selected="selected"</c:if>>${a.name}</option>
			</c:forEach>
		</select>
	</div>
	<div>
		<label>Type</label>
		<select name="type">
			<option value="--">--</option>
			<c:forEach items="${ArmyOptionType.values()}" var="t">
				<option value="${t}"
				<c:if test="${t == option.type}">selected="selected"</c:if>>${t.name}</option>
			</c:forEach>
		</select>
	</div>
	<div >
		<label>Script</label>
		<textarea rows="5" cols="50" name="script">${option.script}</textarea>
	</div>
	<div><input type="submit"></div>

</form:form>
</c:if>

<h1>Creation</h1>
<spring:url value="/admin/army/option/create" var="url"/>
<form:form action="${url}" method="POST" class="row">
	<div>
		<label>Name</label>
		<input type="text" name="name"/>
	</div>
	<div>
		<input type="submit">
	</div>
</form:form>
</jsp:attribute>
<jsp:attribute name="scripts">
	<script type="text/javascript" src='<spring:url value="/js/admin-keywords-edit.js"/>'></script>
</jsp:attribute>
</t:template>
