<%@ tag pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ attribute name="rule" type="armybuilder.model.rule.IArmyRule"%>
<%@ attribute name="army" type="armybuilder.model.Army"%>
<%@ attribute name="displayUnit" type="java.lang.Boolean" required="false"%>
<c:if test="${empty displayUnit}">
	<c:set var="displayUnit" value="true"/>
</c:if>
<div class="rule">
	<h3>${rule.displayName}</h3>
	<c:if test="${rule.is('TraisUnitee') && displayUnit}">
		<c:forEach items="${army.units(rule)}" var="u">
			<em>${u.displayName}</em>
		</c:forEach>
	</c:if> :
	${rule.description}
</div>
