<%@ tag pageEncoding="UTF-8"%>
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
					<span>
						<c:choose>
							<c:when test="${o.type == 'bool'}">
								${o.displayName} 
								<input type="checkbox" name="value" class="ajax" 
									data-url='<spring:url value="/unit/${unit.hashCode()}/${o.name()}"/>' data-update="body>main"
									<c:if test="${unit.is(o)}"> checked="checked"</c:if>>
							</c:when>
							<c:when test="${o.type == 'select' and not empty unit.optionValues(o)}">
								${o.displayName}
								<select name="value" class="ajax"
										data-url='<spring:url value="/unit/${unit.hashCode()}/${o.name()}"/>' data-update="body>main">
									<option value="null">----</option>
									<c:forEach items="${unit.optionValues(o)}" var="v">
										<option value="${v}" <c:if test="${v.name() == unit.get(o).name()}">selected="selected"</c:if>>${v.displayName}</option>
									</c:forEach>
								</select>
							</c:when>
						</c:choose>
					</span>
				</c:forEach>
			</div>
		</c:if>
	</main>
</article>
