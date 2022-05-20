<%@ tag pageEncoding="UTF-8"%>
<%@ tag import="armybuilder.model.army.option.Allegiance" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ attribute name="content" fragment="true"%>
<%@ attribute name="scripts" fragment="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<meta name="mobile-web-app-capable" content="yes" />
<link rel="shortcut icon" type="image/x-icon" href='<spring:url value="/img/favicon.ico"/>'/>
<link rel="stylesheet" href="<spring:url value="/css/style.css"/>" />
<script src="https://kit.fontawesome.com/064a1a2fe3.js" crossorigin="anonymous"></script>
<title>ArmyBuilder - by Shionn</title>
</head>
<body>
	<header>
		<nav>
			<ul>
				<c:forEach items="${Allegiance.values()}" var="allegiance">
					<li <c:if test="${army.is(allegiance)}">class="current"</c:if>>
						<a href=<spring:url value="/select/${allegiance}"/>>${allegiance}</a>
					</li>
				</c:forEach>
				<li>
					<a href='<spring:url value="/reset"/>'><i class="fas fa-file-alt"></i> Reset</a>
				</li>
				<li>
					<spring:url value="/load" var="url"/>
					<form:form method="POST" action="${url}" enctype="multipart/form-data">
						<span class="load">
							<input type="file" name="file">
							<i class="fas fa-upload"></i> Load
						</span>
					</form:form>
				</li>
				<li>
					<a href='<spring:url value="/save"/>'><i class="fas fa-download"></i> Save</a>
				</li>
			</ul>
		</nav>
	</header>
	<main>
		<jsp:invoke fragment="content" />
	</main>
	<footer>
		ArmyBuilder by <a href="mailto:shionn@gmail.com">shionn</a>
	</footer>
	<script type="text/javascript" src='<spring:url value="/js/scripts.js"/>'></script>
	<jsp:invoke fragment="scripts" />
</body>
</html>
