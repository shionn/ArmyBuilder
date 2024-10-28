<%@ page pageEncoding="UTF-8"%>
<%@ page import="armybuilder.db.dbo.Keyword" %>
<%@ page import="armybuilder.db.dbo.rule.Timing" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:template>
<jsp:attribute name="content">
<h1>Liste</h1>
<table>
	<c:forEach items="${rules}" var="rule">
		<tr>
			<td>${rule.timing}</td>
			<td>${rule.name}</td>
			<td>${fn:substring(rule.announce,0,40)}...</td>
			<td>${fn:substring(rule.effect,0,40)}...</td>
			<spring:url value="/admin/rule/edit/${rule.id}" var="url"/>
			<td><a href="${url}">Edit</a></td>
		</tr>
	</c:forEach>
</table>

<c:if test="${not empty rule}">
<h1>Édition</h1>
<spring:url value="/admin/rule/edit/${rule.id}" var="url"/>
<form:form action="${url}" method="POST" class="row">
	<input type="hidden" name="id" value="${rule.id}"/>
	<div>
		<label>Name</label>
		<input type="text" name="name" value="${rule.name}"/>
	</div>
	<div>
		<label>Timing</label>
		<select name="timing">
			<option value="--">--</option>
			<c:forEach items="${Timing.values()}" var="timing">
				<option value="${timing}" <c:if test="${timing == rule.timing}">selected="selected"</c:if>>${timing.displayName} (${timing})</option>
			</c:forEach>
		</select>
	</div>
	<div>
		<label>Condition</label>
		<textarea rows="5" cols="50" name="condition">${rule.condition}</textarea>
	</div>
	<div>
		<label>Description</label>
		<textarea rows="5" cols="50" name="description">${rule.description}</textarea>
	</div>
	<div>
		<label>Annonce</label>
		<textarea rows="5" cols="50" name="announce">${rule.announce}</textarea>
	</div>
	<div>
		<label>Effet</label>
		<textarea rows="5" cols="50" name="effect">${rule.effect}</textarea>
	</div>
	<div>
		<label>Mots-clés</label>
		<input type="text" name="keywords" value="${rule.keywordsAsString()}"/>
		<select name="keyword">
			<option value="--">--</option>
			<c:forEach items="${Keyword.values()}" var="key">
				<option value="${key}">${key}</option>
			</c:forEach>
		</select>
	</div>
	<div>
		<input type="submit">
	</div>

</form:form>
</c:if>

<h1>Creation</h1>
<spring:url value="/admin/rule/create" var="url"/>
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
