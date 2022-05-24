<%@ page pageEncoding="UTF-8"%>
<%@ page import="armybuilder.model.army.option.SubAllegiance" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:template>
<jsp:attribute name="content">
<h1>${army.displayName}</h1>
<a href='<spring:url value="/listing/add"/>'>Ajouter un listing</a>
<c:forEach items="${army.listings()}" var="listing">
	<article id="listing-${listing.id}" class="listing">
		<header>
			<h2>${listing.displayName()} <sup>(${listing.id})</sup> <span>${listing.points()} <a href="<spring:url value="/listing/rm/${listing.id}"/>">X</a></span></h2>
		</header>
		<main>
			<div class="options">
				<c:forEach items="${listing.options()}" var="opt">
					<select name="${opt}" class="ajax" data-update="body>main"
							data-url="<spring:url value="/listing/${listing.id}/${opt}"/>">
						<c:if test="${empty listing.get(opt)}">
							<option selected="selected">-- ${opt.displayName()} --</option>
						</c:if>
						<c:forEach items="${opt.values(listing)}" var="value">
							<option value="${value}" <c:if test="${listing.is(value)}"> selected="selected"</c:if>>${value.displayName()}</option>
						</c:forEach>
					</select>
				</c:forEach>
			</div>
			<div class="options">
				<!-- non generique -->
				<select name="bataillon" class="ajax" data-url="<spring:url value="/listing/${listing.id}/Bataillon/add"/>" data-update="body>main">
					<option value="" selected="selected">-- Ajout Bataillon --</option>
					<c:forEach items="${listing.availableBataillon()}" var="bat">
						<option value="${bat}">${bat.displayName()}</option>
					</c:forEach>
				</select>
				<select name="unitChoice" class="ajax" data-url="<spring:url value="/listing/${listing.id}/unit/add"/>" data-update="body>main">
					<option value="" selected="selected">-- Ajout Unitée --</option>
					<c:forEach items="${listing.availableUnitChoice}" var="f">
						<option value="${f}">${f.displayName()} ${f.points()}</option>
					</c:forEach>
				</select>
			</div>
			<div class="options">
				Bataillons :
				<c:forEach items="${listing.bataillons()}" var="bat">
					<span>${bat.displayName()} <a href="<spring:url value="/listing/${listing.id}/Bataillon/rm/${bat}"/>"> X</a></span>
				</c:forEach>
			</div>
			<c:forEach items="${listing.units()}" var="unit">
				<t:unit-config unit="${unit}"/>
			</c:forEach>
		</main>
	</article>
</c:forEach>

<h2>Aptitudes D'Allégeance</h2>
<c:forEach items="${army.allegiance().rules()}" var="rule">
	<t:rule rule="${rule}" army="${army}"/>
</c:forEach>
<c:forEach items="${army.options('SubAllegiance')}" var="sub">
	<h2>${sub.displayName()}</h2>
	<c:forEach items="${sub.rules()}" var="rule">
		<t:rule rule="${rule}" army="${army}"/>
	</c:forEach>
</c:forEach>

<c:if test="${not empty army.bataillons()}">
	<h2>Bataillons</h2>
	<c:forEach items="${army.bataillons()}" var="bat">
		<article class="rule">
			<header>
				${bat.displayName()}
				<span>
					<c:forEach items="${bat.compositions()}" var="c">
						<c:forEach begin="1" end="${c.count}">
							<img src="img/${c.img}.png" <c:if test="${c.opt}">style="opacity: 0.5"</c:if>>
						</c:forEach>
					</c:forEach>
				</span>
			</header>
			<main>
				<c:forEach items="${bat.rules()}" var="rule">
					<t:rule rule="${rule}" army="${army}"/>
				</c:forEach>
			</main>
		</article>
	</c:forEach>
</c:if>

<c:if test="${not empty army.options('GrandeStrategie')}">
	<h2>Grande Stratégie</h2>
	<c:forEach items="${army.options('GrandeStrategie')}" var="rule">
		<t:rule rule="${rule}" army="${army}"/>
	</c:forEach>
</c:if>

<c:if test="${not empty army.rules('Triomphes')}">
	<h2>Triomphes</h2>
	<c:forEach items="${army.rules('Triomphes')}" var="rule">
		<t:rule rule="${rule}" army="${army}"/>
	</c:forEach>
</c:if>

<%-- <c:if test="${not empty army.options('Triomphes')}"> --%>
<!-- 	<h2>TODO Tacticte de Bataille</h2> -->
<%-- 	<c:forEach items="${army.options('Triomphes')}" var="rule"> --%>
<%-- 		<t:rule rule="${rule}" army="${army}"/> --%>
<%-- 	</c:forEach> --%>
<%-- </c:if> --%>

<%-- <c:if test="${not empty army.rules('ActionsHeroiques')}"> --%>
<!-- 	<h2>Actions Heroique</h2> -->
<%-- 	<c:forEach items="${army.rules('ActionsHeroiques')}" var="rule"> --%>
<%-- 		<t:rule rule="${rule}" army="${army}"/> --%>
<%-- 	</c:forEach> --%>
<%-- </c:if> --%>

<c:if test="${not empty army.rules('TraitsDeCommandement')}">
	<h2>Traits de Commandement</h2>
	<c:forEach items="${army.rules('TraitsDeCommandement')}" var="rule">
		<t:rule rule="${rule}" army="${army}"/>
	</c:forEach>
</c:if>

<c:if test="${not empty army.rules('Artefact')}">
	<h2>Artefact</h2>
	<c:forEach items="${army.rules('Artefact')}" var="rule">
		<t:rule rule="${rule}" army="${army}"/>
	</c:forEach>
</c:if>

<c:if test="${not empty army.rules('Sort')}">
	<h2>Sort</h2>
	<c:forEach items="${army.rules('Sort')}" var="rule">
		<t:rule rule="${rule}" army="${army}"/>
	</c:forEach>
</c:if>

<c:if test="${not empty army.rules('Priere')}">
	<h2>Priere</h2>
	<c:forEach items="${army.rules('Priere')}" var="rule">
		<t:rule rule="${rule}" army="${army}"/>
	</c:forEach>
</c:if>




<h2>Unitées</h2>
<c:forEach items="${army.units()}" var="model">
	<t:unit model="${model}" army="${army}"/>
</c:forEach>

<c:forEach items="${turn.phases}" var="p">
	<div>
		<h1>${p.name}</h1>
		<c:forEach items="${p.steps}" var="s">
			<t:rule-group types="${s}" army="${army}"/>
		</c:forEach>
	</div>
</c:forEach>


</jsp:attribute>
<jsp:attribute name="scripts">
	<script type="text/javascript" src='<spring:url value="/js/army.js"/>'></script>
</jsp:attribute>
</t:template>


