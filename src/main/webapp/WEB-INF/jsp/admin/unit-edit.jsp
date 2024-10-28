<%@ page pageEncoding="UTF-8"%>
<%@ page import="armybuilder.db.dbo.Keyword" %>
<%@ page import="armybuilder.db.dbo.rule.Timing" %>
<%@ page import="armybuilder.db.dbo.unit.WeaponType" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:template>
<jsp:attribute name="content">
<h1>Liste</h1>
<table>
	<c:forEach items="${units}" var="unit">
		<tr>
			<td>${unit.army.name}</td>
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
		<label>Armée</label>
		<select name="army.id">
			<option value="--">--</option>
			<c:forEach items="${armies}" var="a">
				<option value="${a.id}"
				<c:if test="${a.id == unit.army.id}">selected="selected"</c:if>>${a.name}</option>
			</c:forEach>
		</select>
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
	<div>
		<label>Cout</label>
		<input type="text" name="cost" value="${unit.cost}"/>
	</div>
	<div>
		<label>Taille</label>
		<input type="text" name="size" value="${unit.size}"/>
	</div>
	<div id="weapons">
		<label>Armes</label>
		<span>
			<table>
				<tr>
					<th>Nom</th><th>type</th><th>Port.</th>
					<th>Att.</th><th>Tou.</th><th>Ble.</th><th>Per.</th><th>Dég.</th>
					<th>Aptitude</th>
					<th>
						<spring:url value="/admin/unit/edit/${unit.id}/add-weapon" var="url"/>
						<a class="ajax" data-update="#weapons" href="${url}">Ajouter</a>
					</th>
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
						<td><input type="text" name="weapons[${s.index}].range" value="${w.range}" size="4"/></td>
						<td><input type="text" name="weapons[${s.index}].atk" value="${w.atk}" size="4"/></td>
						<td><input type="text" name="weapons[${s.index}].hit" value="${w.hit}" size="4"/></td>
						<td><input type="text" name="weapons[${s.index}].str" value="${w.str}" size="4"/></td>
						<td><input type="text" name="weapons[${s.index}].perf" value="${w.perf}" size="4"/></td>
						<td><input type="text" name="weapons[${s.index}].deg" value="${w.deg}" size="4"/></td>
						<td><input type="text" name="weapons[${s.index}].aptitude" value="${w.aptitude}" size="16"/></td>
						<td>
							<spring:url value="/admin/unit/edit/${unit.id}/rm-weapon/${w.id}" var="url"/>
							<a class="ajax" data-update="#weapons" href="${url}">Suppr</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</span>
	</div>
	<div id="rules">
		<label>Règle</label>
		<span>
			<table>
				<tr>
					<th>Nom</th>
					<th>
						<spring:url value="/admin/unit/edit/${unit.id}/add-rule" var="url"/>
						<a class="ajax" data-update="#rules" href="${url}">Ajouter</a>
					</th>
				</tr>
				<c:forEach items="${unit.rules}" var="m" varStatus="s">
					<tr>
						<td>
							<input type="hidden" name="rules[${s.index}].id" value="${m.id}"/>
							<select name="rules[${s.index}].rule.id">
								<option value="--">--</option>
								<c:forEach items="${rules}" var="rule">
									<option value="${rule.id}" <c:if test="${m.rule.id == rule.id}">selected="selected"</c:if>>${rule.name}</option>
								</c:forEach>
							</select>
						</td>
						<td>
							<spring:url value="/admin/unit/edit/${unit.id}/rm-rule/${m.id}" var="url"/>
							<a class="ajax" data-update="#rules" href="${url}">Suppr</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</span>
	</div>
	<div>
		<label>Mots-clés</label>
		<span>
			<input type="text" name="keywords" value="${unit.keywordsAsString()}" readonly="readonly"/><br/>
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
	<script type="text/javascript" src='<spring:url value="/js/admin-keywords-edit.js"/>'></script>
</jsp:attribute>
</t:template>
