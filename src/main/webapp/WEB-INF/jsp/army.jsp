<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:template>
	<jsp:attribute name="title">Home</jsp:attribute>
	<jsp:attribute name="content">
		<div>
			<c:forEach items="${armyOptions}" var="opt">
				<c:if test="${opt.select and not empty opt.getValues(army)}">
					<select name="${opt}" class="ajax" data-url="<spring:url value="/${opt}"/>" data-update="body>main">
						<c:if test="${army.getOption(opt) == null}">
							<option value="" selected="selected">${opt.displayName}</option>
						</c:if>
						<c:forEach items="${opt.getValues(army)}" var="f">
							<option value="${f}" <c:if test="${army.getOption(opt) == f}"> selected="selected"</c:if>>${f.displayName}</option>
						</c:forEach>
					</select>
				</c:if>
			</c:forEach>
		</div>
		<div>
			<c:forEach items="${armyOptions}" var="opt">
				<c:if test="${not opt.select and not empty opt.getValues(army)}">
					<input type="checkbox" name="${opt}" class="ajax" data-url="<spring:url value="/${opt}"/>"
							data-update="body>main"<c:if test="${army.getOption(opt) == 'Yes'}"> checked="checked"</c:if>> 
					${opt.displayName}
				</c:if>
			</c:forEach>
		</div>
		<c:if test="${not empty army.unitChoices}">
			<div>
				<select name="unitChoice" class="ajax" data-url="<spring:url value="/add-unit"/>" data-update="body>main">
					<option value="" selected="selected">Ajouter une Unité</option>
					<c:forEach items="${army.unitChoices}" var="f">
						<option value="${f}">${f.displayName}</option>
					</c:forEach>
				</select>
			</div>
		</c:if>
		<div>
			<h1>Profile d'Armée</h1>
			<c:if test="${not empty army.getOption('GrandeStrategie')}">
				<h2>Grande Strategie</h2>
				<jsp:include page="rule/${army.getOption('GrandeStrategie')}.jsp"/>
			</c:if>
			<c:if test="${not empty army.getRules('TraisDeBataille')}">
				<h2>Aptitudes D'Allégeance</h2>
				<c:forEach items="${army.getRules('TraisDeBataille')}" var="rule">
					<jsp:include page="rule/${rule}.jsp"/>
				</c:forEach>
			</c:if>
		</div>
		<div>
			<h2>Composition</h2>
			<c:forEach items="${army.units}" var="unit">
				<article>
					<header>${unit.displayName} 
					<span><i class="fa fa-walking"></i> ${unit.mouvement}&quot; 
						<i class="fa fa-heart"></i> ${unit.blessures} 
						<i class="fa fa-flag"></i> ${unit.bravoure} 
						<i class="fa fa-shield-alt"></i> ${unit.sauvegarde}</span>
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
										<c:forEach items="${unit.profileDegressif.titles}" var="t">
											<th>${t}</th>
										</c:forEach>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${unit.profileDegressif.lines}" var="l">
										<tr>
											<c:forEach items="${l}" var="c"><td>${c}</td></c:forEach>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:if>
						<c:if test="${not empty unit.options }">
						</c:if>
						<div>
							<c:forEach items="${unit.rules}" var="rule">
								<jsp:include page="rule/${rule}.jsp"/>
							</c:forEach>
						</div>
					</main>
					<footer>
						<c:forEach items="${unit.keyWords}" var="k">
							<span>${k.displayName} </span>
						</c:forEach>
					</footer>
				</article>
			</c:forEach>
		</div>
		<div>
			<h1>1 Phase des Héros</h1>
			<h2>1.1 Actions Héroique</h2>
			<c:forEach items="${army.getRules('ActionsHeroiques')}" var="rule">
				<jsp:include page="rule/${rule}.jsp"/>
			</c:forEach>
			<h2>1.2 Aptitudes de Commandement</h2>
			<c:forEach items="${army.getRules('AptitudesDeCommandement', 'PhaseDesHeros')}" var="rule">
				<jsp:include page="rule/${rule}.jsp"/>
			</c:forEach>
			<h1>2 Phase de Mouvement</h1>
			<c:forEach items="${army.getRules('AptitudesDeCommandement', 'PhaseDeMouvement')}" var="rule">
				<jsp:include page="rule/${rule}.jsp"/>
			</c:forEach>
			<h1>3 Phase de Tir</h1>
			<c:forEach items="${army.getRules('AptitudesDeCommandement', 'PhaseDeTir')}" var="rule">
				<jsp:include page="rule/${rule}.jsp"/>
			</c:forEach>
			<h1>4 Phase de Charge</h1>
			<c:forEach items="${army.getRules('AptitudesDeCommandement', 'PhaseDeCharge')}" var="rule">
				<jsp:include page="rule/${rule}.jsp"/>
			</c:forEach>
			<h1>5 Phase de Combat</h1>
			<c:forEach items="${army.getRules('AptitudesDeCommandement', 'PhaseDeCombat')}" var="rule">
				<jsp:include page="rule/${rule}.jsp"/>
			</c:forEach>
			<h1>6 Phase de Deroute</h1>
			<c:forEach items="${army.getRules('AptitudesDeCommandement', 'PhaseDeDeroute')}" var="rule">
				<jsp:include page="rule/${rule}.jsp"/>
			</c:forEach>
		</div>
	</jsp:attribute>
	<jsp:attribute name="scripts">
		<script type="text/javascript" src='<spring:url value="/js/army.js"/>'></script>
	</jsp:attribute>
</t:template>