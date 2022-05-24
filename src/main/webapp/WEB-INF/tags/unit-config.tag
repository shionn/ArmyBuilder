<%@ tag pageEncoding="UTF-8"%>
<%@ tag import="armybuilder.model.army.rule.ArmyRuleType" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ attribute name="unit" type="armybuilder.model.unit.Unit"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<article class="unit-config">
	<header>
		<h3>${unit.displayName} <span>${unit.points()} <a href='<spring:url value="/unit/remove/${unit.hashCode()}"/>'>X</a></span></h3>
	</header>
	<main>
		<c:if test="${not empty unit.options()}">
			<div class="options">
				<c:forEach items="${unit.options()}" var="o">
					<c:choose>
						<c:when test="${o.type == 'bool'}">
							<label>
								${o.displayName()}
								<input type="checkbox" name="value" class="ajax" 
									data-url='<spring:url value="/unit/${unit.hashCode()}/${o.name()}"/>' data-update="body>main"
									<c:if test="${unit.is(o)}"> checked="checked"</c:if>>
							</label>
						</c:when>
						<c:when test="${o.type == 'select' and not empty unit.optionValues(o)}">
							<select name="value" class="ajax" data-url='<spring:url value="/unit/${unit.hashCode()}/${o.name()}"/>' data-update="body>main">
								<option value="null">-- ${o.displayName()} --</option>
								<c:forEach items="${unit.optionValues(o)}" var="v">
									<option value="${v}" <c:if test="${v.name() == unit.get(o).name()}">selected="selected"</c:if>>${v.displayName()}</option>
								</c:forEach>
							</select>
						</c:when>
					</c:choose>
				</c:forEach>
				<c:forEach items="${unit.options()}" var="o">
					<c:if test="${not empty unit.get(o)}">
						<span class="print-only">${unit.get(o).displayName()}</span>
					</c:if>
				</c:forEach>
			</div>
		</c:if>
		<div class="rules">
			<c:forEach items="${unit.addedRules(ArmyRuleType.TraitsDeCommandement)}" var="r">
				<t:rule rule="${r}" displayUnit="false"/>
			</c:forEach>
			<c:forEach items="${unit.addedRules(ArmyRuleType.Artefact)}" var="r">
				<t:rule rule="${r}" displayUnit="false"/>
			</c:forEach>
			<c:forEach items="${unit.addedRules(ArmyRuleType.Sort)}" var="r">
				<t:rule rule="${r}" displayUnit="false"/>
			</c:forEach>
			<c:forEach items="${unit.addedRules(ArmyRuleType.Priere)}" var="r">
				<t:rule rule="${r}" displayUnit="false"/>
			</c:forEach>
		</div>
	</main>
</article>
