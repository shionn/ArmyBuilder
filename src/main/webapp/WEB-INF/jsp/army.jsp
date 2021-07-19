<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:template>
	<jsp:attribute name="title">Home</jsp:attribute>
	<jsp:attribute name="content">
		<div id="allegiance">
			<select name="allegiance" class="ajax" data-url="<spring:url value="/allegiance"/>"
					data-update="#allegiance,#aptitudes">
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
						data-update="#allegiance,#aptitudes">
					<c:if test="${army.getOption('SubAllegiance') == null}">
						<option value="" selected="selected">Sous Allegiance</option>
					</c:if>
					<c:forEach items="${subAllegiances}" var="f">
						<option value="${f}" <c:if test="${army.getOption('SubAllegiance') == f}"> selected="selected"</c:if>>${f.displayName}</option>
					</c:forEach>
				</select>
			</c:if>
		</div>
		<div id="aptitudes">
			<h1>Aptitudes D'allégeance</h1>
			<c:forEach items="${army.getRules('TraisDeBataille')}" var="rule">
				<jsp:include page="rule/${rule}.jsp"/>
			</c:forEach>
		</div>
	</jsp:attribute>
	<jsp:attribute name="scripts">
		<script type="text/javascript" src='<spring:url value="/js/army.js"/>'></script>
	</jsp:attribute>
</t:template>