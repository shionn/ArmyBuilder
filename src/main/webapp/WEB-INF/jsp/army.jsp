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
				<select name="unitChoice" class="ajax" data-url="<spring:url value="/unit/add"/>" data-update="body>main">
					<option value="" selected="selected">Ajouter une Unité</option>
					<c:forEach items="${army.unitChoices}" var="f">
						<option value="${f}">${f.displayName}</option>
					</c:forEach>
				</select>
			</div>
		</c:if>
		<div>
			<c:forEach items="${army.errors}" var="e">
				<div class="error">${e}</div>
			</c:forEach>
		</div>
		<div>
			<h1>Profile d'Armée</h1>
			<c:if test="${not empty army.getOption('GrandeStrategie')}">
				<h2>Grande Strategie</h2>
				<t:rule rule="${army.getOption('GrandeStrategie')}" army="${army}"/>
			</c:if>
			<c:if test="${not empty army.getRules('TraisDeBataille')}">
				<h2>Aptitudes D'Allégeance</h2>
				<c:forEach items="${army.getRules('TraisDeBataille')}" var="rule">
					<t:rule rule="${rule}" army="${army}"/>
				</c:forEach>
			</c:if>
		</div>
		<div>
			<h2>Composition</h2>
			<c:forEach items="${army.units}" var="unit">
				<t:unit army="${army}" unit="${unit}"/>
			</c:forEach>
		</div>
		<div>
			<h1>1 Phase des Héros</h1>
			<c:forEach items="${army.getRules('Aptitude', 'PhaseDesHeros')}" var="rule">
				<t:rule rule="${rule}" army="${army}"/>
			</c:forEach>
			<h2>1.1 Actions Héroique</h2>
			<c:forEach items="${army.getRules('ActionsHeroiques')}" var="rule">
				<t:rule rule="${rule}" army="${army}"/>
			</c:forEach>
			<h2>1.2 Aptitudes de Commandement</h2>
			<c:forEach items="${army.getRules('AptitudesDeCommandement', 'PhaseDesHeros')}" var="rule">
				<t:rule rule="${rule}" army="${army}"/>
			</c:forEach>
			<h2>1.3 Magie</h2>
			<c:forEach items="${army.getRules('Sort')}" var="rule">
				<t:rule rule="${rule}" army="${army}"/>
			</c:forEach>
			<h2>1.4 Priere</h2>
			<c:forEach items="${army.getRules('Priere')}" var="rule">
				<t:rule rule="${rule}" army="${army}"/>
			</c:forEach>
			<h1>2 Phase de Mouvement</h1>
			<c:forEach items="${army.getRules('AptitudesDeCommandement', 'PhaseDeMouvement')}" var="rule">
				<t:rule rule="${rule}" army="${army}"/>
			</c:forEach>
			<h1>3 Phase de Tir</h1>
			<c:forEach items="${army.getRules('AptitudesDeCommandement', 'PhaseDeTir')}" var="rule">
				<t:rule rule="${rule}" army="${army}"/>
			</c:forEach>
			<h1>4 Phase de Charge</h1>
			<h2>4.1 Aptitudes de Commandement</h2>
			<c:forEach items="${army.getRules('AptitudesDeCommandement', 'PhaseDeCharge')}" var="rule">
				<t:rule rule="${rule}" army="${army}"/>
			</c:forEach>
			<h2>4.2 Artefact</h2>
			<c:forEach items="${army.getRules('Artefact', 'PhaseDeCharge')}" var="rule">
				<t:rule rule="${rule}" army="${army}"/>
			</c:forEach>
			<h1>5 Phase de Combat</h1>
			<c:forEach items="${army.getRules('AptitudesDeCommandement', 'PhaseDeCombat')}" var="rule">
				<t:rule rule="${rule}" army="${army}"/>
			</c:forEach>
			<h1>6 Phase de Deroute</h1>
			<c:forEach items="${army.getRules('AptitudesDeCommandement', 'PhaseDeDeroute')}" var="rule">
				<t:rule rule="${rule}" army="${army}"/>
			</c:forEach>
		</div>
	</jsp:attribute>
	<jsp:attribute name="scripts">
		<script type="text/javascript" src='<spring:url value="/js/army.js"/>'></script>
	</jsp:attribute>
</t:template>