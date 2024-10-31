<%@ tag pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
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
<link rel="stylesheet" href="<spring:url value="/css/font-awesome.css"/>" />
<title>AoS v4 Army Builder - by Shionn</title>
</head>
<body>
	<header>
		<nav>
			<ul>
				<c:forEach items="${menu.children}" var="a">
					<li>${a.name}
						<ul>
							<c:forEach items="${a.children}" var="c">
								<spring:url value="/army/${c.id}" var="url"/>
								<li><a href="${url}">${c.name}</a>
							</c:forEach>
						</ul>
					</li>
				</c:forEach>
				<li>
					<spring:url value="/army/0" var="url"/>
					<a href="${url}">Référence</a>
				</li>
				<li>Admin
					<ul>
						<spring:url value="/admin/army/edit" var="url"/>
						<li><a href="${url}">Army</a></li>
						<spring:url value="/admin/unit/edit" var="url"/>
						<li><a href="${url}">Unit</a></li>
						<spring:url value="/admin/rule/edit" var="url"/>
						<li><a href="${url}">Rule</a></li>
					</ul>
				</li>
			</ul>
		</nav>
	</header>
	<main>
		<jsp:invoke fragment="content" />
	</main>
	<footer class="print-hidden">
		ArmyBuilder by <a href="mailto:shionn@gmail.com">shionn</a>
	</footer>
	<script type="text/javascript" src='<spring:url value="/js/scripts.js"/>'></script>
	<script type="text/javascript" src='<spring:url value="/js/ajax.js"/>'></script>
	<jsp:invoke fragment="scripts" />
</body>
</html>
