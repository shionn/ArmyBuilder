<%@ tag pageEncoding="UTF-8"%>
<%@ tag import="armybuilder.model.unit.RoleTactique" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ attribute name="unit" type="armybuilder.model.unit.Unit"%>
<%@ attribute name="army" type="armybuilder.model.army.Army"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<article class="unit" style="page-break-inside:avoid;">
	<header>
		<span><a href='<spring:url value="/unit/remove/${unit.hashCode()}"/>'>X</a> ${unit.value}</span>
		${unit.displayName}
		<span>
			<c:if test="${not unit.is(RoleTactique.SortsPersistantsEtInvocation)}">
				<i class="fa fa-walking"></i> ${unit.mouvement}&quot; 
				<i class="fa fa-heart"></i> ${unit.blessures} 
				<i class="fa fa-flag"></i> ${unit.bravoure} 
				<i class="fa fa-shield-alt"></i> ${unit.sauvegarde}
			</c:if>
		</span>
	</header>
	<main>
		<table>
			<c:if test="${not empty unit.getWeapons('Projectil')}">
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
					<c:forEach items="${unit.getWeapons('Projectil')}" var="w">
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
			<c:if test="${not empty unit.getWeapons('Melee')}">
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
					<c:forEach items="${unit.getWeapons('Melee')}" var="w">
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
		<c:if test="${not empty unit.options}">
		<div class="options">
			<c:forEach items="${unit.options}" var="o">
				<span>
					<c:choose>
						<c:when test="${o.type == 'bool'}">
							${o.displayName} 
							<input type="checkbox" name="value" class="ajax" 
								data-url='<spring:url value="/unit/${unit.hashCode()}/${o.name()}"/>' data-update="body>main"
								<c:if test="${not empty unit.get(o)}"> checked="checked"</c:if>>
						</c:when>
						<c:when test="${o.type == 'select' and not empty unit.getOptionValues(o)}">
							${o.displayName}
							<select name="value" class="ajax"
									data-url='<spring:url value="/unit/${unit.hashCode()}/${o.name()}"/>' data-update="body>main">
								<option value="null">----</option>
								<c:forEach items="${unit.getOptionValues(o)}" var="v">
									<option value="${v}" <c:if test="${v.name() == unit.get(o).name()}">selected="selected"</c:if>>${v.displayName}</option>
								</c:forEach>
							</select>
						</c:when>
						<c:when test="${o.type == 'selectMultiOption' and not empty unit.getMultiOptionValues(o)}">
							${o.displayName}
							<select name="value" class="ajax" data-update="body>main"
									data-url='<spring:url value="/unit/${unit.hashCode()}/${o.name()}"/>'>
								<option value="null">----</option>
								<c:forEach items="${unit.getMultiOptionValues(o)}" var="v">
									<option value="${v.id}" <c:if test="${v.id == unit.getMultiOption(o).id}">selected="selected"</c:if>>${v.displayName}</option>
								</c:forEach>
							</select>
						</c:when>
					</c:choose>
				</span>
			</c:forEach>
		</div>
		</c:if>
		<div>
			<c:forEach items="${unit.displayedRules}" var="rule"><t:rule rule="${rule}" army="${army}" displayUnit="false"/></c:forEach>
		</div>
	</main>
	<c:if test="${not empty unit.keyWords}">
		<footer>
			<c:forEach items="${unit.keyWords}" var="k">
				<span>${k.displayName}</span>
			</c:forEach>
		</footer>
	</c:if>
</article>

