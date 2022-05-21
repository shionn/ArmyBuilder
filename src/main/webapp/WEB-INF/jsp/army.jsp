<%@ page pageEncoding="UTF-8"%>
<%@ page import="armybuilder.model.army.option.SubAllegiance" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:template>
	<jsp:attribute name="content">
		<h1>${army.displayName}</h1>
		<c:forEach items="${army.listings}" var="listing">
			<div id="listing-${listing.id}" class="listing">
				<h2>${listing.displayName} <span>${listing.points}</span></h2>
				<div class="options">
					<select name="SubAllegiance" class="ajax" data-url="<spring:url value="/listing/${listing.id}/SubAllegiance"/>" data-update="#listing-${listing.id}">
						<c:forEach items="${army.availableSubAllegiance}" var="sub">
							<option value="${sub}" <c:if test="${listing.is(sub)}"> selected="selected"</c:if>>${sub.displayName}</option>
						</c:forEach>
					</select>
					<select name="unitChoice" class="ajax" data-url="<spring:url value="/listing/${listing.id}/unit/add"/>" data-update="#listing-${listing.id}">
						<option value="" selected="selected">-- Ajout Unitée --</option>
						<c:forEach items="${listing.availableUnitChoice}" var="f">
							<option value="${f}">${f.displayName} ${f.value}</option>
						</c:forEach>
					</select>
				</div>
				<c:forEach items="${listing.units}" var="unit">
					<div>
						<h3>${unit.displayName} <span>${unit.points} <a href='<spring:url value="/unit/remove/${unit.hashCode()}"/>'>X</a></span></h3>
					</div>
				</c:forEach>
			</div>
		</c:forEach>
		<a href='<spring:url value="/listing/add"/>'>Ajouter un listing</a>
		
<!-- 		<div class="options"> -->
<%-- 			<c:forEach items="${armyOptions}" var="opt"> --%>
<%-- 				<c:if test="${not opt.select and not empty opt.getValues(army)}"> --%>
<%-- 					<input type="checkbox" name="${opt}" class="ajax" data-url="<spring:url value="/${opt}"/>" --%>
<%-- 							data-update="body>main"<c:if test="${army.option(opt) == 'Yes'}"> checked="checked"</c:if>>  --%>
<%-- 					${opt.displayName} --%>
<%-- 				</c:if> --%>
<%-- 			</c:forEach> --%>
<!-- 		</div> -->
<%-- 		<c:if test="${not empty army.unitChoices}"> --%>
<!-- 			<div class="options"> -->
<%-- 				<select name="unitChoice" class="ajax" data-url="<spring:url value="/unit/add"/>" data-update="body>main"> --%>
<!-- 					<option value="" selected="selected">Leader</option> -->
<%-- 					<c:forEach items="${army.unitChoices(RoleTactique.Leader)}" var="f"> --%>
<%-- 						<option value="${f}">${f.displayName} ${f.value}</option> --%>
<%-- 					</c:forEach> --%>
<!-- 				</select> -->
<%-- 				<select name="unitChoice" class="ajax" data-url="<spring:url value="/unit/add"/>" data-update="body>main"> --%>
<!-- 					<option value="" selected="selected">Troupe : Ligne</option> -->
<%-- 					<c:forEach items="${army.unitChoices(RoleTactique.Ligne)}" var="f"> --%>
<%-- 						<option value="${f}">${f.displayName} ${f.value}</option> --%>
<%-- 					</c:forEach> --%>
<!-- 				</select> -->
<%-- 				<select name="unitChoice" class="ajax" data-url="<spring:url value="/unit/add"/>" data-update="body>main"> --%>
<!-- 					<option value="" selected="selected">Troupe : Autres</option> -->
<%-- 					<c:forEach items="${army.unitChoices(RoleTactique.Elite)}" var="f"> --%>
<%-- 						<option value="${f}">${f.displayName} ${f.value}</option> --%>
<%-- 					</c:forEach> --%>
<!-- 				</select> -->
<%-- 				<select name="unitChoice" class="ajax" data-url="<spring:url value="/unit/add"/>" data-update="body>main"> --%>
<!-- 					<option value="" selected="selected">Behemoth</option> -->
<%-- 					<c:forEach items="${army.unitChoices(RoleTactique.Behemoth, RoleTactique.Leader)}" var="f"> --%>
<%-- 						<option value="${f}">${f.displayName} ${f.value}</option> --%>
<%-- 					</c:forEach> --%>
<!-- 				</select> -->
<%-- 				<select name="unitChoice" class="ajax" data-url="<spring:url value="/unit/add"/>" data-update="body>main"> --%>
<!-- 					<option value="" selected="selected">Sorts Persistants</option> -->
<%-- 					<c:forEach items="${army.unitChoices(RoleTactique.SortsPersistantsEtInvocation)}" var="f"> --%>
<%-- 						<option value="${f}">${f.displayName} ${f.value}</option> --%>
<%-- 					</c:forEach> --%>
<!-- 				</select> -->
<%-- 				<select name="optimisation" class="ajax" data-url="<spring:url value="/optimisation/add"/>" data-update="body>main"> --%>
<!-- 					<option value="" selected="selected">Optimisation</option> -->
<%-- 					<c:forEach items="${army.optimisationChoices}" var="f"> --%>
<%-- 						<option value="${f}">${f.getFullDisplayName()}</option> --%>
<%-- 					</c:forEach> --%>
<!-- 				</select> -->
<!-- 			</div> -->
<%-- 		</c:if> --%>
<!-- 		<div> -->
<%-- 			<c:forEach items="${army.errors}" var="e"> --%>
<%-- 				<div class="error">${e}</div> --%>
<%-- 			</c:forEach> --%>
<!-- 		</div> -->
<!-- 		<div style="page-break-inside:avoid"> -->
<!-- 			<h1> -->
<%-- 				${army.option(ArmyOption.Allegiance).displayName} - --%>
<%-- 				<small>${army.option(ArmyOption.PackDeBataille).displayName}</small> --%>
<%-- 				<span>${army.value}</span> --%>
<!-- 			</h1> -->
<%-- 			<c:if test="${not empty army.option('GrandeStrategie')}"> --%>
<!-- 				<h2>Grande Strategie</h2> -->
<%-- 				<t:rule rule="${army.option('GrandeStrategie')}" army="${army}"/> --%>
<%-- 			</c:if> --%>
<%-- 			<c:if test="${not empty army.getRules('TraisDeBataille')}"> --%>
<%-- 				<h2>Aptitudes D'Allégeance - <small>${army.option('SubAllegiance').displayName}</small></h2> --%>
<%-- 				<c:forEach items="${army.getRules('TraisDeBataille')}" var="rule"> --%>
<%-- 					<t:rule rule="${rule}" army="${army}"/> --%>
<%-- 				</c:forEach> --%>
<%-- 				<c:forEach items="${army.getRules('SubAllegiance')}" var="rule"> --%>
<%-- 					<t:rule rule="${rule}" army="${army}"/> --%>
<%-- 				</c:forEach> --%>
<%-- 			</c:if> --%>
<!-- 		</div> -->
<!-- 		<div style="page-break-after:always"> -->
<!-- 			<h2>Composition</h2> -->
<!-- 			<div style="padding-bottom: 10px; display: flex; flex-wrap: wrap; justify-content: space-between;"> -->
<%-- 				<c:forEach items="${army.units}" var="unit"> --%>
<!-- 					<div style="width: 33%"> -->
<%-- 						<a href='<spring:url value="/unit/remove/${unit.hashCode()}"/>'>X</a> --%>
<%-- 						${unit.displayName} --%>
<%-- 						${unit.value} --%>
<!-- 					</div> -->
<%-- 				</c:forEach> --%>
<!-- 			</div> -->
<!-- 			<div style="page-break-inside:avoid"> -->
<%-- 				<c:forEach items="${army.multiOptions(ArmyOption.Bataillon)}" var="o"> --%>
<!-- 					<h2> -->
<%-- 						${o.displayName} --%>
<%-- 						<c:forEach items="${o.compositions}" var="c"> --%>
<%-- 							<c:forEach begin="1" end="${c.count}"> --%>
<%-- 								<img src="img/${c.img}.png" <c:if test="${c.opt}">style="opacity: 0.5"</c:if>> --%>
<%-- 							</c:forEach> --%>
<%-- 						</c:forEach> --%>
<%-- 						<a href='<spring:url value="/multioptions/rm/${o.id}"/>'>X</a> --%>
<!-- 					</h2> -->
<%-- 					<c:forEach items="${o.value.rules}" var="r"> --%>
<%-- 						<t:rule rule="${r}"/> --%>
<%-- 					</c:forEach> --%>
<!-- 					<div style="padding-bottom: 10px; display: flex; flex-wrap: wrap; justify-content: space-between;"> -->
<%-- 						<c:forEach items="#{army.units(o)}" var="unit"> --%>
<%-- 							<span style="width: 33%">${unit.displayName} ${unit.value}</span> --%>
<%-- 						</c:forEach> --%>
<!-- 					</div> -->
<%-- 				</c:forEach> --%>
<!-- 			</div> -->
<!-- 			<div style="page-break-inside:avoid"> -->
<%-- 				<c:forEach items="${army.optimisations}" var="opti"> --%>
<!-- 					<article class="unit" style="page-break-inside:avoid;"> -->
<!-- 						<header> -->
<%-- 							<span><a href='<spring:url value="/optimisation/remove/${opti.hashCode()}"/>'>X</a></span> --%>
<%-- 							${opti.getFullDisplayName()} --%>
<!-- 							<span> </span> -->
<!-- 						</header> -->
<!-- 						<main> -->
<!-- 							<div> -->
<%-- 								<c:forEach items="${opti.getDisplayedRules()}" var="rule"> --%>
<%-- 									<t:rule rule="${rule}" army="${army}" displayUnit="false"/> --%>
<%-- 								</c:forEach> --%>
<!-- 							</div> -->
<!-- 						</main> -->
<!-- 					</article> -->
<%-- 				</c:forEach> --%>
<!-- 			</div> -->
<%-- 			<c:forEach items="${army.units}" var="unit"> --%>
<%-- 				<t:unit army="${army}" unit="${unit}"/> --%>
<%-- 			</c:forEach> --%>
<!-- 		</div> -->
<%-- 		<c:forEach items="${turn.phases}" var="p"> --%>
<!-- 			<div> -->
<%-- 				<h1>${p.name}</h1> --%>
<%-- 				<c:forEach items="${p.steps}" var="s"> --%>
<%-- 					<t:rule-group types="${s}"/> --%>
<%-- 				</c:forEach> --%>
<!-- 			</div> -->
<%-- 		</c:forEach> --%>
	</jsp:attribute>
	<jsp:attribute name="scripts">
		<script type="text/javascript" src='<spring:url value="/js/army.js"/>'></script>
	</jsp:attribute>
</t:template>