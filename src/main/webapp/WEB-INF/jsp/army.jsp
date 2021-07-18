<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:template>
	<jsp:attribute name="title">Home</jsp:attribute>
	<jsp:attribute name="content">
		<div id="faction">
			<label for="faction">Faction</label>
			<select name="faction" class="ajax" data-url="<spring:url value="/faction"/>" data-update="faction">
				<c:forEach items="${factions}" var="f">
					<option value="${f}"<c:if test="${army.faction == f}"> selected="selected"</c:if>>${f.displayName}</option>
				</c:forEach>
			</select>
		</div>
	</jsp:attribute>
	<jsp:attribute name="scripts">
		<script type="text/javascript" src='<spring:url value="/js/army.js"/>'></script>
	</jsp:attribute>
</t:template>