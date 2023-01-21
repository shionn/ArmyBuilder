<%@ tag pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="<spring:url value="/css/rpg-awesome.css"/>" />
<script src="https://kit.fontawesome.com/064a1a2fe3.js" crossorigin="anonymous"></script>
<title>ArmyBuilder - by Shionn</title>
</head>
<body>
	<header>
		<nav class="menu">
			<ul>
				<c:forEach items="${menus}" var="e">
					<li>
						<a href="#">${e.key.name()}</a>
						<ul>
							<c:forEach items="${e.value}" var="a">
								<li><a href=<spring:url value="/select/${a.id}"/>>${a.name}</a></li>
							</c:forEach>
						</ul>
					</li>
				</c:forEach>
				<li>
					<a href='<spring:url value="/army/create"/>'><i class="fas fa-plus-circle"></i> New</a>
				</li>
			</ul>
		</nav>
	</header>
	<main>
		<jsp:invoke fragment="content" />
	</main>
	<footer class="print-hidden">
		ArmyBuilder by <a href="mailto:shionn@gmail.com">shionn</a>
	</footer>e
	<script type="text/javascript" src='<spring:url value="/js/scripts.js"/>'></script>
	<script type="text/javascript" src='<spring:url value="/js/menu.js"/>'></script>
	<script type="text/javascript" src='<spring:url value="/js/ajax.js"/>'></script>
	<jsp:invoke fragment="scripts" />
</body>
</html>
