<%@ tag pageEncoding="UTF-8"%>
<%@ tag import="armybuilder.v3.model.rule.RuleIcons" %>
<%@ tag import="armybuilder.v3.model.rule.desc.DescriptionMode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ attribute name="rule" type="armybuilder.v3.model.rule.IRule"%>
<%@ attribute name="mode" type="DescriptionMode"%>
<div class="rule">
	<span>${rule.displayName} <c:forEach var="icon" items="${RuleIcons.get(rule)}"><i class="${icon.style}"></i></c:forEach>:</span>${rule.description.mode(mode)}
</div>
