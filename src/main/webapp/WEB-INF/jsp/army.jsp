<%@ page pageEncoding="UTF-8"%>
<%@ page import="armybuilder.model.rule.ArmyRuleType" %>
<%@ page import="armybuilder.model.unit.RoleTactique" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:template>
	<jsp:attribute name="content">
		<div class="options">
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
		<div class="options">
			<c:forEach items="${armyOptions}" var="opt">
				<c:if test="${not opt.select and not empty opt.getValues(army)}">
					<input type="checkbox" name="${opt}" class="ajax" data-url="<spring:url value="/${opt}"/>"
							data-update="body>main"<c:if test="${army.getOption(opt) == 'Yes'}"> checked="checked"</c:if>> 
					${opt.displayName}
				</c:if>
			</c:forEach>
		</div>
		<c:if test="${not empty army.unitChoices}">
			<div class="options">
				<select name="unitChoice" class="ajax" data-url="<spring:url value="/unit/add"/>" data-update="body>main">
					<option value="" selected="selected">Leader</option>
					<c:forEach items="${army.unitChoices(RoleTactique.Leader)}" var="f">
						<option value="${f}">${f.displayName} ${f.value}</option>
					</c:forEach>
				</select>
				<select name="unitChoice" class="ajax" data-url="<spring:url value="/unit/add"/>" data-update="body>main">
					<option value="" selected="selected">Troupe</option>
					<c:forEach items="${army.unitChoices(RoleTactique.Ligne, RoleTactique.None)}" var="f">
						<option value="${f}">${f.displayName} ${f.value}</option>
					</c:forEach>
				</select>
				<select name="unitChoice" class="ajax" data-url="<spring:url value="/unit/add"/>" data-update="body>main">
					<option value="" selected="selected">Behemoth</option>
					<c:forEach items="${army.unitChoices(RoleTactique.Behemoth)}" var="f">
						<option value="${f}">${f.displayName} ${f.value}</option>
					</c:forEach>
				</select>
				<select name="unitChoice" class="ajax" data-url="<spring:url value="/unit/add"/>" data-update="body>main">
					<option value="" selected="selected">Sorts Persistants</option>
					<c:forEach items="${army.unitChoices(RoleTactique.SortsPersistantsEtInvocation)}" var="f">
						<option value="${f}">${f.displayName} ${f.value}</option>
					</c:forEach>
				</select>
			</div>
		</c:if>
		<div>
			<c:forEach items="${army.errors}" var="e">
				<div class="error">${e}</div>
			</c:forEach>
		</div>
		<div style="page-break-after:always">
			<h1>Profile d'Armée <span>${army.value}</span></h1>
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
			<c:forEach items="${army.units}" var="unit">
				<div>
					<a href='<spring:url value="/unit/remove/${unit.hashCode()}"/>'>X</a>
					${unit.displayName}
					${unit.value}
				</div>
			</c:forEach>
		</div>
		<div style="page-break-after:always">
			<h2>Composition</h2>
			<c:forEach items="${army.units}" var="unit">
				<t:unit army="${army}" unit="${unit}"/>
			</c:forEach>
		</div>
		<div style="page-break-inside:avoid">
			<h1>1 Phase des Héros</h1>
			<t:rule-group types="${[ArmyRuleType.Aptitude, ArmyRuleType.PhaseDesHeros]}"/>
			<t:rule-group types="${[ArmyRuleType.ActionsHeroiques]}"/>
			<t:rule-group types="${[ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDesHeros]}"/>
			<t:rule-group types="${[ArmyRuleType.Sort]}"/>
			<t:rule-group types="${[ArmyRuleType.Priere]}"/>
		</div>
		<div style="page-break-inside:avoid">
			<h1>2 Phase de Mouvement</h1>
			<t:rule-group types="${[ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDeMouvement]}"/>
		</div>
		<div style="page-break-inside:avoid">
			<h1>3 Phase de Tir</h1>
			<t:rule-group types="${[ArmyRuleType.Triomphes, ArmyRuleType.PhaseDeTir]}"/>
			<t:rule-group types="${[ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDeTir]}"/>
		</div>
		<div style="page-break-inside:avoid">
			<h1>4 Phase de Charge</h1>
			<t:rule-group types="${[ArmyRuleType.Triomphes, ArmyRuleType.PhaseDeCharge]}"/>
			<t:rule-group types="${[ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDeCharge]}"/>
			<t:rule-group types="${[ArmyRuleType.Artefact, ArmyRuleType.PhaseDeCharge]}"/>
		</div>
		<div style="page-break-inside:avoid">
			<h1>5 Phase de Combat</h1>
			<t:rule-group types="${[ArmyRuleType.Triomphes, ArmyRuleType.PhaseDeCombat]}"/>
			<t:rule-group types="${[ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDeCombat]}"/>
		</div>
		<div style="page-break-inside:avoid">
			<h1>6 Phase de Deroute</h1>
			<t:rule-group types="${[ArmyRuleType.Triomphes, ArmyRuleType.PhaseDeCharge]}"/>
			<t:rule-group types="${[ArmyRuleType.AptitudesDeCommandement, ArmyRuleType.PhaseDeDeroute]}"/>
		</div>
	</jsp:attribute>
	<jsp:attribute name="scripts">
		<script type="text/javascript" src='<spring:url value="/js/army.js"/>'></script>
	</jsp:attribute>
</t:template>