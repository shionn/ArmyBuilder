<%@ page pageEncoding="UTF-8"%>
<%@ page import="armybuilder.db.dbo.Keyword" %>
<%@ page import="armybuilder.db.dbo.rule.Timing" %>
<%@ page import="armybuilder.db.dbo.unit.WeaponType" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib tagdir="/WEB-INF/tags/v4" prefix="t"%>
<t:template>
<jsp:attribute name="content">
<h1>Liste</h1>
<table>
	<c:forEach items="${units}" var="unit">
		<tr>
			<td>${unit.name}</td>
			<td>${unit.keywords}</td>
			<spring:url value="/admin/unit/edit/${unit.id}" var="url"/>
			<td><a href="${url}">Edit</a></td>
		</tr>
	</c:forEach>
</table>

<c:if test="${not empty unit}">
<h1>Édition</h1>
<spring:url value="/admin/unit/edit/${unit.id}" var="url"/>
<form:form action="${url}" method="POST" class="row">
	<div>
		<label>Name</label>
		<input type="text" name="name" value="${unit.name}"/>
	</div>
	<div>
		<label>Mouv.</label>
		<input type="text" name="mvt" value="${unit.mvt}"/>
	</div>
	<div>
		<label>Santé</label>
		<input type="text" name="life" value="${unit.life}"/>
	</div>
	<div>
		<label>Contrôle</label>
		<input type="text" name="control" value="${unit.control}"/>
	</div>
	<div>
		<label>Sauv.</label>
		<input type="text" name="save" value="${unit.save}"/>
	</div>
	<div id="weapons">
		<label>Armes</label>
		<span>
			<table>
				<tr>
					<th>Nom</th><th>type</th><th>Att.</th><th>Tou.</th><th>Ble.</th><th>Per.</th><th>Dég</th><th>#</th>
				</tr>
				<c:forEach items="${unit.weapons}" var="w" varStatus="s">
					<tr>
						
						<td>
							<input type="hidden" name="weapons[${s.index}].id" value="${w.id}"/>
							<input type="text" name="weapons[${s.index}].name" value="${w.name}"/>
						</td>
						<td>
							<select name="weapons[${s.index}].type">
								<option value="--">--</option>
								<c:forEach items="${WeaponType.values()}" var="type">
									<option value="${type}" <c:if test="${w.type == type}">selected="selected"</c:if>>${type}</option>
								</c:forEach>
							</select>
						</td>
						<td><input type="text" name="weapons[${s.index}].atk" value="${w.atk}" size="4"/></td>
						<td><input type="text" name="weapons[${s.index}].hit" value="${w.hit}" size="4"/></td>
						<td><input type="text" name="weapons[${s.index}].str" value="${w.str}" size="4"/></td>
						<td><input type="text" name="weapons[${s.index}].perf" value="${w.perf}" size="4"/></td>
						<td><input type="text" name="weapons[${s.index}].deg" value="${w.deg}" size="4"/></td>
						<td>
							<spring:url value="/admin/unit/edit/${unit.id}/rm-weapons/${w.id}" var="url"/>
							<a class="ajax" data-update="#weapons" href="${url}">Suppr</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<spring:url value="/admin/unit/edit/${unit.id}/add-weapons" var="url"/>
			<a class="ajax" data-update="#weapons" href="${url}">Ajouter</a>
		</span>
	</div>
	<div>
		<label>Mots-clés</label>
		<span>
			<input type="text" name="keywords" value="${unit.keywordsAsString}" readonly="readonly"/><br/>
			<select name="keyword">
				<option value="--">--</option>
				<c:forEach items="${Keyword.values()}" var="key">
					<option value="${key}">${key}</option>
				</c:forEach>
			</select>
		</span>
	</div>
	<div><input type="submit"></div>

</form:form>
</c:if>

<h1>Creation</h1>
<spring:url value="/admin/unit/create" var="url"/>
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
	<script type="text/javascript" src='<spring:url value="/js/v4/scripts.js"/>'></script>
	<script type="text/javascript" src='<spring:url value="/js/v4/ajax.js"/>'></script>
	<script type="text/javascript" src='<spring:url value="/js/v4/admin-keywords-edit.js"/>'></script>
</jsp:attribute>
</t:template>
