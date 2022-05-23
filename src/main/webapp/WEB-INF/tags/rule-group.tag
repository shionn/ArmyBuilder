<%@ tag pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ attribute name="army" type="armybuilder.model.army.Army"%>
<%@ attribute name="types" type="java.util.List"%>
<c:set var="rules" value="${army.rules(types)}" />
<c:if test="${not empty rules}">
	<div style="page-break-inside: avoid;">
		<h2>${types[0].displayName}</h2>
		<c:forEach items="${rules}" var="rule">
			<t:rule rule="${rule}" army="${army}"/>
		</c:forEach>
	</div>
</c:if>