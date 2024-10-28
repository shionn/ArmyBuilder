<%@ page pageEncoding="UTF-8"%>
<%@ page import="armybuilder.db.dbo.unit.WeaponType" %>
<%@ page import="armybuilder.db.dbo.option.Option" %>
<%@ page import="armybuilder.db.dbo.option.OptionType" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:template>
<jsp:attribute name="content">
<spring:url value="/army/${army.id}" var="base"/>
<div class="title">${army.model.name} - ${army.cost}</div>
<form:form method="POST" action="${base}">
	
</form:form>
<div>
	<select class="ajax" name="model" data-url="${base}/add-unit" data-update="#units">
		<option value="-1">Add Unit</option>
		<c:forEach items="${army.model.units}" var="u">
			<option value="${u.id}">${u.name}</option>
		</c:forEach>
	</select>
</div>
<div id="units">
	<c:forEach items="${army.units}" var="unit">
		<article class="unit" id="unit${unit.id}">
			<header>${unit.model.name} - ${unit.cost} <a href="${base}/rm-unit/${unit.id}"><i class="fa fa-trash"></i></a>
				<span>
					<i class="fa fa-arrows"></i> ${unit.model.mvt}&quot;
					<i class="fa fa-heart"></i> ${unit.model.life}
					<i class="fa fa-flag"></i> ${unit.model.control}
					<i class="fa fa-shield"></i> ${unit.model.save}
				</span>
			</header>
			<main>
				<div class="bg" style="background-image: url('<spring:url value="/img/${army.model.name}/${unit.model.id}.png"/>');"></div>
				<table>
					<c:if test="${not empty unit.weapons(WeaponType.Distant)}">
						<thead>
							<tr>
								<th>${WeaponType.Distant.displayName}</th>
								<th>Port.</th>
								<th>Att.</th>
								<th>Tou.</th>
								<th>Ble.</th>
								<th>Per.</th>
								<th>Dég.</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${unit.weapons(WeaponType.Distant)}" var="w">
								<tr>
									<td>
										${w.name}
										<c:if test="${not empty w.aptitude}"><br/>${w.aptitude}</c:if>
									</td>
									<td>${w.range}</td>
									<td>${w.atk}</td>
									<td>${w.hit}</td>
									<td>${w.str}</td>
									<td>${w.perf}</td>
									<td>${w.deg}</td>
								</tr>
							</c:forEach>
						</tbody>
					</c:if>
					<c:if test="${not empty unit.weapons(WeaponType.Melee)}">
						<thead>
							<tr>
								<th colspan="2">${WeaponType.Melee.displayName}</th>
								<th>Att.</th>
								<th>Tou.</th>
								<th>Ble.</th>
								<th>Per.</th>
								<th>Dég.</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${unit.weapons(WeaponType.Melee)}" var="w">
								<tr>
									<td colspan="2">
										${w.name}
										<c:if test="${not empty w.aptitude}"><br/>${w.aptitude}</c:if>
									</td>
									<td>${w.atk}</td>
									<td>${w.hit}</td>
									<td>${w.str}</td>
									<td>${w.perf}</td>
									<td>${w.deg}</td>
								</tr>
							</c:forEach>
						</tbody>
					</c:if>
				</table>
				<c:if test="${not empty unit.model.composition}">
					<div class="composition">${markdown.format(unit.model.composition)}</div>
				</c:if>
				<div class="options">
					<c:forEach items="${Option.values()}" var="opt">
						<c:if test="${opt.isAvailable(unit)}">
							<c:if test="${opt.type == OptionType.checkbox}">
								<label><input name="value" type="checkbox" class="ajax" 
										<c:if test="${unit.is(opt)}">checked="checked"</c:if>
										data-url="${base}/unit/${unit.id}/option/${opt}" data-update="#unit${unit.id},.title">${opt.displayName}</label>
							</c:if>
						</c:if>
					</c:forEach>
				</div>
				<c:forEach items="${unit.rules}" var="rule">
					<article class="rule ${rule.timing.color}">
						<header>
							<img src="<spring:url value='/img/${rule.timing.icon}.png'/>">
							${rule.timing.displayName}
							<c:if test="${not empty rule.condition}">
								: ${rule.condition}
							</c:if>
							<c:if test="${not empty rule.cost}">
								<span class="cost">${rule.cost}</span>
							</c:if>
						</header>
						<main>
							<p><strong>${rule.name}</strong></p>
							<c:if test="${not empty rule.announce}">
								${markdown.format("__Annonce:__ ".concat(rule.announce))}
							</c:if>
							<c:if test="${not empty rule.effect}">
								${markdown.format("__Effet:__ ".concat(rule.effect))}
							</c:if>
						</main>
						<c:if test="${not empty rule.keywords}">
							<footer>
								<c:forEach items="${rule.keywords}" var="k">
									<span>${k.displayName}</span>
								</c:forEach>
							</footer>
						</c:if>
					</article>
				</c:forEach>
			</main>
			<footer>
				<c:forEach items="${unit.model.keywords}" var="k">
					<span>${k.displayName}</span>
				</c:forEach>
			</footer>
		</article>
	</c:forEach>
</div>
</jsp:attribute>
</t:template>
