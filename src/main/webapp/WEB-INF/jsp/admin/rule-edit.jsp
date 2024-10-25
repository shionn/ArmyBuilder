<%@ page pageEncoding="UTF-8"%>
<%@ page import="armybuilder.db.dbo.Keyword" %>
<%@ page import="armybuilder.db.dbo.rule.Timing" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib tagdir="/WEB-INF/tags/v4" prefix="t"%>
<t:template>
<jsp:attribute name="content">
<h1>Liste</h1>
<table>
	<c:forEach items="${rules}" var="rule">
		<tr>
			<td>${rule.name}</td>
			<td>${rule.announce}</td>
			<td>${rule.effect}</td>
			<td>${rule.keywords}</td>
		</tr>
	</c:forEach>
</table>
<h1>Creation</h1>
<spring:url value="/admin/rule/create" var="url"/>
<form:form action="${url}" method="POST" class="row">
	<div>
		<label>Timing</label>
		<select name="timing">
			<option value="--">--</option>
			<c:forEach items="${Timing.values()}" var="timing">
				<option value="${timing}">${timing.displayName}</option>
			</c:forEach>
		</select>
	</div>
	<div>
		<label>Name</label>
		<input type="text" name="name"/>
	</div>
	<div>
		<label>Description</label>
		<textarea rows="5" cols="50"  name="description"></textarea>
	</div>
	<div>
		<label>Annonce</label>
		<textarea rows="5" cols="50"  name="announce"></textarea>
	</div>
	<div>
		<label>Effet</label>
		<textarea rows="5" cols="50"  name="effect"></textarea>
	</div>
	<div>
		<label>Mots-clés</label>
		<input type="text" name="keywords"/>
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
</jsp:attribute>
<jsp:attribute name="scripts">
	<script type="text/javascript" src='<spring:url value="/js/v4/scripts.js"/>'></script>
	<script type="text/javascript" src='<spring:url value="/js/v4/admin-rule-edit.js"/>'></script>
</jsp:attribute>
</t:template>
