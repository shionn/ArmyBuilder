<%@ page pageEncoding="UTF-8"%>
<%@ page import="armybuilder.model.army.SubAllegiance" %>
<%@ page import="armybuilder.model.army.Allegiance" %>
<%@ page import="armybuilder.model.army.PackDeBataille" %>
<%@ page import="armybuilder.model.army.AptitudeDeCommandement" %>
<%@ page import="armybuilder.model.army.GrandeStrategie" %>
<%@ page import="armybuilder.model.army.Triomphes" %>
<%@ page import="armybuilder.model.army.bataillon.BataillonType" %>
<%@ page import="armybuilder.model.rule.RuleType" %>
<%@ page import="armybuilder.model.rule.RuleIcons" %>
<%@ page import="armybuilder.model.unit.model.UnitModel" %>
<%@ page import="armybuilder.model.unit.role.RoleTactique" %>
<%@ page import="armybuilder.model.rule.desc.DescriptionMode" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:template>
<jsp:attribute name="content">
<h1>${army.name} - ${army.points}</h1>

<spring:url value="/army/edit" var="url" />
<form:form action="${url}" method="POST">
	<fieldset>
		<legend>Edition</legend>
		<select name="suballegiance">
			<c:if test="${empty army.subAllegiance}">
				<option>- Sous Allegiance -</option>
			</c:if>
			<c:forEach items="${SubAllegiance.values()}" var="sub">
				<c:if test="${sub.availableFor(army)}">
					<option value="${sub}"<c:if test="${army.is(sub)}"> selected="selected"</c:if>>${sub.displayName}</option>
				</c:if>
			</c:forEach>
		</select>
		<select name="packdebataille">
			<c:if test="${empty army.packDeBataille}">
				<option value="NULL">- Pacte de Bataille -</option>
			</c:if>
			<c:forEach items="${PackDeBataille.values()}" var="pack">
				<option value="${pack}"<c:if test="${army.is(pack)}"> selected="selected"</c:if>>${pack.displayName}</option>
			</c:forEach>
		</select>
		<select name="grandestrategie">
			<c:if test="${empty army.grandeStrategie}">
				<option value="NULL">- Grande Stratégie -</option>
			</c:if>
			<c:forEach items="${GrandeStrategie.values()}" var="sub">
				<c:if test="${sub.availableFor(army)}">
					<option value="${sub}"<c:if test="${army.is(sub)}"> selected="selected"</c:if>>${sub.displayName}</option>
				</c:if>
			</c:forEach>
		</select>
		<select name="triomphes">
			<c:if test="${empty army.triomphes}">
				<option value="NULL">- Triomphes -</option>
			</c:if>
			<c:forEach items="${Triomphes.values()}" var="sub">
				<option value="${sub}"<c:if test="${army.is(sub)}"> selected="selected"</c:if>>${sub.displayName}</option>
			</c:forEach>
		</select>
		<c:if test="${army.is(Allegiance.StormCast)}">
			<select name="aptitudeDeCommandement">
				<c:if test="${empty army.aptitudeDeCommandement}">
					<option value="NULL">- Aptitude De Commandement -</option>
				</c:if>
				<c:forEach items="${AptitudeDeCommandement.values()}" var="sub">
					<c:if test="${sub.availableFor(army)}">
						<option value="${sub}"<c:if test="${army.is(sub)}"> selected="selected"</c:if>>${sub.displayName}</option>
					</c:if>
				</c:forEach>
			</select>
		</c:if>
		<select name="descriptionMode">
			<c:forEach items="${DescriptionMode.values()}" var="sub">
				<option value="${sub}"<c:if test="${army.descriptionMode == sub}"> selected="selected"</c:if>>${sub}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Editer">
		<div class="print-hidden columns2">
			<c:forEach items="${army.subAllegiance.rules}" var="rule">
				<div class="rule"><span>${rule.displayName}:</span>${rule.description.full}</div>
			</c:forEach>
			<c:if test="${not empty army.grandeStrategie}">
				<div class="rule"><span>${army.grandeStrategie.displayName}:</span>${army.grandeStrategie.description.full}</div>
			</c:if>
			<c:if test="${not empty army.aptitudeDeCommandement}">
				<div class="rule"><span>${army.aptitudeDeCommandement.displayName}:</span>${army.aptitudeDeCommandement.description.full}</div>
			</c:if>
		</div>
	</fieldset>
</form:form>
<div style="display: flex">
	<spring:url value="/unit/add" var="url" />
	<form:form action="${url}" method="POST" style="width: 50%">
		<fieldset>
			<legend>Ajout d'unitée</legend>
			<label>Unité</label>
			<select name="model">
				<c:forEach items="${UnitModel.sorteds()}" var="model">
					<c:if test="${model.availableFor(army)}">
						<option value="${model}">${model.roleTactiques.get(0)} ${model.displayName} ${model.points}</option>
					</c:if>
				</c:forEach>
			</select>
			<input type="submit" value="Ajouter">
		</fieldset>
	</form:form>
	<spring:url value="/bataillon/add" var="url" />
	<form:form action="${url}" method="POST" style="width: 50%">
		<fieldset>
			<legend>Ajout bataillon</legend>
			<label>Bataillon</label>
			<select name="type">
				<c:forEach items="${BataillonType.values()}" var="type">
					<c:if test="${type.availableFor(army)}">
						<option value="${type}">${type.displayName}</option>
					</c:if>
				</c:forEach>
			</select>
			<input type="submit" value="Ajouter">
		</fieldset>
	</form:form>
</div>

<h2 class="print-hidden">Erreurs</h2>
<div class="print-hidden">
	<ul>
		<c:forEach items="${army.checks}" var="c"><li>${c}</li></c:forEach>
	</ul>
</div>

<h2>Units</h2>
<div class="units columns2">
	<c:forEach items="${army.units}" var="unit">
		<t:unit army="${army}" unit="${unit}"></t:unit>
	</c:forEach>
</div>
<!-- <div class="units columns2"> -->
<%-- 	<c:forEach items="${army.leaders}" var="unit"> --%>
<%-- 		<t:unit army="${army}" unit="${unit}"></t:unit> --%>
<%-- 	</c:forEach> --%>
<!-- </div> -->
<!-- <hr> -->
<!-- <div class="units columns2"> -->
<%-- 	<c:forEach items="${army.troups}" var="unit"> --%>
<%-- 		<t:unit army="${army}" unit="${unit}"></t:unit> --%>
<%-- 	</c:forEach> --%>
<!-- </div> -->
<!-- <hr> -->
<!-- <div class="units columns2"> -->
<%-- 	<c:forEach items="${army.artilleries}" var="unit"> --%>
<%-- 		<t:unit army="${army}" unit="${unit}"></t:unit> --%>
<%-- 	</c:forEach> --%>
<!-- </div> -->
<!-- <hr> -->
<!-- <div class="units columns2"> -->
<%-- 	<c:forEach items="${army.others}" var="unit"> --%>
<%-- 		<t:unit army="${army}" unit="${unit}"></t:unit> --%>
<%-- 	</c:forEach> --%>
<!-- </div> -->
<!-- <hr> -->
<div style="page-break-inside: avoid;">
	<h3>Bataillons</h3>
	<div class="units columns2" >
	<c:forEach items="${army.bataillons}" var="bat">
		<article class="bataillon">
			<spring:url value="/bataillon/rm/${bat.id}" var="url" />
			<header>${bat.displayName} <a href="${url}"><i class="fa fa-trash"></i></a>
				<span>
					<c:forEach items="${bat.compositions}" var="c">
						<c:forEach begin="1" end="${c.count}">
							<img src="img/${c.img}.png"<c:if test="${c.opt}"> class="opt"</c:if>>
						</c:forEach>
					</c:forEach>
				</span>
			</header>
			<main>
				<ul>
					<c:forEach items="${bat.units}" var="unit">
						<li>${unit.displayName}</li>
					</c:forEach>
				</ul>
				<t:rules rules="${bat.rules}" mode="${army.descriptionMode}"></t:rules>
			</main>
		</article>
	</c:forEach>
	</div>
</div>


<div style="page-break-inside: avoid;">
	<h2>Rules</h2>
	<div class="columns2">
		<ol>
			<c:forEach items="${army.steps}" var="step">
				<li style="page-break-inside: avoid;"><strong>${step.name}</strong>
					<ol>
						<c:forEach items="${step.subs}" var="step">
							<li>${step.name}
								<ul>
									<c:forEach items="${step.subs}" var="step">
										<li>${step.name}
											<ul>
												<c:forEach items="${step.subs}" var="step">
													<li>${step.name}</li>
												</c:forEach>
											</ul>
										</li>
									</c:forEach>
								</ul>
							</li>
						</c:forEach>
					</ol>
				</li>
			</c:forEach>
		</ol>
	</div>
	<c:forEach items="${RuleType.values()}" var="type">
		<c:if test="${type.displayed and not empty army.rules(type)}">
			<h3>${type.displayName}</h3>
			<div class="columns2">
				<t:rules rules="${army.rules(type)}" mode="${army.descriptionMode}"></t:rules>
			</div>
		</c:if>
	</c:forEach>
</div>
</jsp:attribute>
<jsp:attribute name="scripts">
<%-- 	<script type="text/javascript" src='<spring:url value="/js/army.js"/>'></script> --%>
</jsp:attribute>
</t:template>


