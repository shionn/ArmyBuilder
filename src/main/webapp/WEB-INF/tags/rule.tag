<%@ tag pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ attribute name="rule" type="armybuilder.model.army.rule.IArmyRule"%>
<%@ attribute name="army" type="armybuilder.model.army.Army"%>
<%@ attribute name="displayUnit" type="java.lang.Boolean" required="false"%>
<c:if test="${empty displayUnit}">
	<c:set var="displayUnit" value="true"/>
</c:if>
<c:if test="${rule.is('SubAllegiance')}">
	<div class="multirule"> 
		<h3>${rule.displayName()}</h3>
		${rule.description}
	</div>
</c:if>
<c:if test="${not rule.is('SubAllegiance')}">
	<div class="rule">
		<h3>${rule.displayName()} : </h3>
		<c:if test="${rule.is('TraisUnitee') && displayUnit}">
<%-- 			<c:forEach items="${army.units(rule)}" var="u"> --%>
<%-- 				<em>${u.displayName}</em> --%>
<%-- 			</c:forEach> --%>
		</c:if>
		${rule.description}
	</div>
</c:if>
