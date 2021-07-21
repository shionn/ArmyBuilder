<%@ tag pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ attribute name="unit" type="armybuilder.model.unit.Unit"%>
<%@ attribute name="army" type="armybuilder.model.Army"%>
<article class="unit">
	<header>${unit.displayName}
		<span>
			<i class="fa fa-walking"></i> ${unit.mouvement}&quot; 
			<i class="fa fa-heart"></i> ${unit.blessures} 
			<i class="fa fa-flag"></i> ${unit.bravoure} 
			<i class="fa fa-shield-alt"></i> ${unit.sauvegarde}
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
		<c:if test="${not empty unit.options }">
		<div class="options">
			<c:forEach items="${unit.options}" var="o">
				<span>
					<c:choose>
						<c:when test="${o.type == 'bool'}">
							${o.displayName} 
							<input type="checkbox" name="value" class="ajax" 
								data-url='<spring:url value="/unit/${unit.hashCode()}/${o.name()}"/>' data-update="body>main"
								<c:if test="${unit.getOption(o)}"> checked="checked"</c:if>>
						</c:when>
						<c:when test="${o.type == 'select'}">
							${o.displayName}
							<select name="value">
								<option value="null">----</option>
								<c:forEach items="${unit.getOptionValues(o)}" var="v">
									<option value="${v}">${v.displayName}</option>
								</c:forEach>
							</select>
						</c:when>
						<c:otherwise>TODO ${o.type}</c:otherwise>
					</c:choose>
				</span>
			</c:forEach>
		</div>
		</c:if>
		<div>
			<c:forEach items="${unit.rules}" var="rule"><jsp:include page="rule/${rule}.jsp" /></c:forEach>
		</div>
	</main>
	<footer>
		<c:forEach items="${unit.keyWords}" var="k">
			<span>${k.displayName}</span>
		</c:forEach>
	</footer>
</article>

