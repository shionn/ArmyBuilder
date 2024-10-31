<%@ tag pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ attribute name="rule" type="armybuilder.db.dbo.rule.Rule"%>
<c:if test="${not empty rule.timing}">
	<article class="rule ${rule.timing.color} hidden">
		<header>
			<img src="<spring:url value='/img/${rule.timing.icon}.png'/>">
			${rule.timing.displayName}
			<c:if test="${not empty rule.condition}">
				: ${rule.condition}
			</c:if>
			<c:if test="${not empty rule.cost}">
				<span class="cost">${rule.cost}</span>
			</c:if>
		</header>
		<main>
			<p><strong>${rule.name}</strong></p>
			<c:if test="${not empty rule.announce}">
				${markdown.format("__Annonce:__ ".concat(rule.announce))}
			</c:if>
			<c:if test="${not empty rule.useby}">
				${markdown.format("__Utilisé par:__ ".concat(rule.useby))}
			</c:if>
			<c:if test="${not empty rule.effect}">
				${markdown.format("__Effet:__ ".concat(rule.effect))}
			</c:if>
		</main>
		<c:if test="${not empty rule.keywords}">
			<footer>
				<c:forEach items="${rule.keywords}" var="k">
					<span>${k.displayName}</span>
				</c:forEach>
			</footer>
		</c:if>
	</article>
</c:if>