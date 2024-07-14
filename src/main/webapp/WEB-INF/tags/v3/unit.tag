<%@ tag pageEncoding="UTF-8"%>
<%@ tag import="armybuilder.v3.model.unit.Unit" %>
<%@ tag import="armybuilder.v3.model.army.Army" %>
<%@ tag import="armybuilder.v3.model.army.SubAllegiance" %>
<%@ tag import="armybuilder.v3.model.army.Allegiance" %>
<%@ tag import="armybuilder.v3.model.army.PackDeBataille" %>
<%@ tag import="armybuilder.v3.model.army.AptitudeDeCommandement" %>
<%@ tag import="armybuilder.v3.model.army.GrandeStrategie" %>
<%@ tag import="armybuilder.v3.model.army.Triomphes" %>
<%@ tag import="armybuilder.v3.model.army.bataillon.BataillonType" %>
<%@ tag import="armybuilder.v3.model.rule.RuleType" %>
<%@ tag import="armybuilder.v3.model.rule.RuleIcons" %>
<%@ tag import="armybuilder.v3.model.unit.model.UnitModel" %>
<%@ tag import="armybuilder.v3.model.unit.role.RoleTactique" %>
<%@ tag import="armybuilder.v3.model.rule.desc.DescriptionMode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags/v3" prefix="t"%>
<%@ attribute name="unit" type="Unit"%>
<%@ attribute name="army" type="Army"%>
<article class="unit">
	<spring:url value="/v3/unit/rm/${unit.id}" var="url" />
	<header>${unit.displayName} - ${unit.points} <a href="${url}"><i class="fa fa-trash"></i></a>
		<span>
			<c:if test="${not unit.isOne(RoleTactique.SortsPersistantsEtInvocation,RoleTactique.TerrainDeFaction)}">
				<i class="fa fa-walking"></i> ${unit.profile.mvt}&quot;
				<i class="fa fa-heart"></i> ${unit.profile.life}
				<i class="fa fa-flag"></i> ${unit.profile.cmd}
				<i class="fa fa-shield-alt"></i> ${unit.profile.svg}
			</c:if>
		</span>
	</header>
	<main>
		<table>
			<c:if test="${not empty unit.weapons('Projectil')}">
				<thead>
					<tr>
						<th>Armes à Projectiles</th>
						<th>Portée</th>
						<th>Attaques</th>
						<th>Toucher</th>
						<th>Blesser</th>
						<th>Perf.</th>
						<th>Dégâts</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${unit.weapons('Projectil')}" var="w">
						<tr>
							<td>${w.displayName}</td>
							<td>${w.portee}</td>
							<td>${w.attaques}</td>
							<td>${w.toucher}</td>
							<td>${w.blesser}</td>
							<td>${w.perf}</td>
							<td>${w.degats}</td>
						</tr>
					</c:forEach>
				</tbody>
			</c:if>
			<c:if test="${not empty unit.weapons('Melee')}">
				<thead>
					<tr>
						<th>Armes de Mêlée</th>
						<th>Portée</th>
						<th>Attaques</th>
						<th>Toucher</th>
						<th>Blesser</th>
						<th>Perf.</th>
						<th>Dégâts</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${unit.weapons('Melee')}" var="w">
						<tr>
							<td>${w.displayName}</td>
							<td>${w.portee}</td>
							<td>${w.attaques}</td>
							<td>${w.toucher}</td>
							<td>${w.blesser}</td>
							<td>${w.perf}</td>
							<td>${w.degats}</td>
						</tr>
					</c:forEach>
				</tbody>
			</c:if>
		</table>
		<c:if test="${not empty unit.profileDegressif}">
			<table>
				<thead>
					<tr>
						<th colspan="${unit.profileDegressif.titles.size()}">Tableau de Dégâts</th>
					</tr>
					<tr>
						<c:forEach items="${unit.profileDegressif.titles}" var="t"><th>${t}</th></c:forEach>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${unit.profileDegressif.lines}" var="l">
						<tr><c:forEach items="${l}" var="c"><td>${c}</td></c:forEach></tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<form:form>
			<fieldset>
				<c:forEach items="${unit.optionsCategories}" var="cat">
					<c:if test="${cat.type == 'bool' }">
						<spring:url value="/v3/unit/edit/${unit.id}/${unit.optionValue(cat)}" var="url" />
						<label>${unit.optionValue(cat).displayName}</label>
						<input type="checkbox" name="${cat}" class="ajax" data-url="${url}" data-update="body>main" <c:if test="${unit.is(cat)}"> checked="checked"</c:if>>
					</c:if>
					<c:if test="${cat.type == 'select' and not empty unit.optionValues(cat)}">
						<spring:url value="/v3/unit/edit/${unit.id}" var="url" />
						<select name="option" class="ajax" data-url="${url}" data-update="body>main" >
							<option value="null">-- ${cat.displayName} --
							<c:forEach items="${unit.optionValues(cat)}" var="opt">
								<option value="${opt}"<c:if test="${unit.is(opt)}"> selected="selected"</c:if>>${opt.fullDisplayName}
							</c:forEach>
						</select>
						<c:if test="${not empty cat.get(unit)}">
							<spring:url value="/v3/unit/${unit.id}/rmopt/${cat}" var="url" />
							<a href="${url}"><i class="fa fa-trash"></i></a>
						</c:if>
					</c:if>
				</c:forEach>
				<c:if test="${not empty army.bataillons(unit)}">
					<spring:url value="/v3/unit/bataillon/${unit.id}" var="url" />
					<select name="bataillon" class="ajax" data-url="${url}" data-update="body>main" >
						<option value="0">Aucun
						<c:forEach items="${army.bataillons(unit)}" var="bat">
							<option value="${bat.id}"<c:if test="${unit.bataillon.id == bat.id}"> selected="selected"</c:if>>${bat.displayName} ${bat.id}
						</c:forEach>
					</select>
				</c:if>
			</fieldset>
		</form:form>
		<t:rules rules="${unit.displayRules}" mode="${army.descriptionMode}"></t:rules>
	</main>
	<c:if test="${not empty unit.keyWords}">
		<footer>
			<c:forEach items="${unit.roleTactiques}" var="r">
				<span>${r.name()}</span>
			</c:forEach>
			<c:forEach items="${unit.keyWords}" var="k">
				<span>${k.displayName}</span>
			</c:forEach>
		</footer>
	</c:if>
</article>
