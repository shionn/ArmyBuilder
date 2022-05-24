<%@ tag pageEncoding="UTF-8"%>
<%@ tag import="armybuilder.model.unit.RoleTactique" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ attribute name="model" type="armybuilder.model.unit.IUnitModel"%>
<%@ attribute name="army" type="armybuilder.model.army.Army"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<article class="unit" style="page-break-inside:avoid;">
	<header>${model.displayName()}
		<span>
			<c:if test="${not model.is(RoleTactique.SortsPersistantsEtInvocation)}">
				<i class="fa fa-walking"></i> ${model.profile().mvt}&quot; 
				<i class="fa fa-heart"></i> ${model.profile().life} 
				<i class="fa fa-flag"></i> ${model.profile().cmd} 
				<i class="fa fa-shield-alt"></i> ${model.profile().svg}
			</c:if>
		</span>
	</header>
	<main>
		<table>
			<c:if test="${not empty army.weapons(model,'Projectil')}">
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
					<c:forEach items="${army.weapons(model,'Projectil')}" var="w">
						<tr>
							<td>${w.displayName}<c:if test="${not model.is(w)}"><sup>*</sup></c:if></td>
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
			<c:if test="${not empty army.weapons(model,'Melee')}">
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
					<c:forEach items="${army.weapons(model,'Melee')}" var="w">
						<tr>
							<td>${w.displayName}<c:if test="${not model.is(w)}"><sup>*</sup></c:if></td>
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
		<c:if test="${not empty model.profileDegressif()}">
			<table>
				<thead>
					<tr>
						<th colspan="${model.profileDegressif().titles.size()}">Tableau de Dégâts</th>
					</tr>
					<tr>
						<c:forEach items="${model.profileDegressif().titles}" var="t"><th>${t}</th></c:forEach>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${model.profileDegressif().lines}" var="l">
						<tr><c:forEach items="${l}" var="c"><td>${c}</td></c:forEach></tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<div>
			<c:forEach items="${army.rules(model)}" var="rule">
				<div class="rule">
					<h3>${rule.displayName()}<c:if test="${not model.is(rule)}"><sup>*</sup></c:if> : </h3>
					${rule.description}
				</div>
			</c:forEach>
		</div>
	</main>
	<c:if test="${not empty army.keyWords(model)}">
		<footer>
			<c:forEach items="${army.keyWords(model)}" var="k">
				<span>${k.displayName}<c:if test="${not model.is(k)}"><sup>*</sup></c:if></span>
			</c:forEach>
		</footer>
	</c:if>
</article>
