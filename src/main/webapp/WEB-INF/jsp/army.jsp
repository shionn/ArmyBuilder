<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:template>
	<jsp:attribute name="title">Home</jsp:attribute>
	<jsp:attribute name="content">
		<div id="allegiance">
			<select name="allegiance" class="ajax" data-url="<spring:url value="/allegiance"/>" data-update="main">
				<c:if test="${army.getOption('Allegiance') == null}">
					<option value="" selected="selected">Allegiance</option>
				</c:if>
				<c:forEach items="${allegiances}" var="f">
					<option value="${f}" <c:if test="${army.getOption('Allegiance') == f}"> selected="selected"</c:if>>
						${f.displayName}</option>
				</c:forEach>
			</select>
			<c:if test="${not empty subAllegiances}">
				<select name="suballegiance" class="ajax" data-url="<spring:url value="/suballegiance"/>"
						data-update="#allegiance,#aptitudes,#tour">
					<c:if test="${army.getOption('SubAllegiance') == null}">
						<option value="" selected="selected">Sous Allegiance</option>
					</c:if>
					<c:forEach items="${subAllegiances}" var="f">
						<option value="${f}" <c:if test="${army.getOption('SubAllegiance') == f}"> selected="selected"</c:if>>${f.displayName}</option>
					</c:forEach>
				</select>
			</c:if>
			<input type="checkbox" name="generique" class="ajax" data-url="<spring:url value="/generique"/>"
					data-update="main"<c:if test="${army.getOption('Generique') == 'Yes'}"> checked="checked"</c:if>> Inclure les aptitudes Générique.
		</div>
		<div id="aptitudes">
			<h1>Aptitudes D'allégeance</h1>
			<c:forEach items="${army.getRules('TraisDeBataille')}" var="rule">
				<jsp:include page="rule/${rule}.jsp"/>
			</c:forEach>
		</div>
		<div id="tour">
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
		</div>
	</jsp:attribute>
	<jsp:attribute name="scripts">
		<script type="text/javascript" src='<spring:url value="/js/army.js"/>'></script>
	</jsp:attribute>
</t:template>