<%@ tag pageEncoding="UTF-8"%>
<%@ tag import="armybuilder.model.rule.RuleIcons" %>
<%@ tag import="armybuilder.model.rule.desc.DescriptionMode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ attribute name="rules" type="java.util.List"%>
<%@ attribute name="mode" type="DescriptionMode"%>
<c:forEach items="${rules}" var="rule">
	<t:rule rule="${rule}" mode="${mode}"></t:rule>
</c:forEach>
