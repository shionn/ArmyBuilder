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
<link rel="stylesheet" href="<spring:url value="/css/v4/style.css"/>" />
<title>AoS v4 Army Builder - by Shionn</title>
</head>
<body>
	<header>
		<nav>
			<ul>
				<li>DoK</li>
				<li>Skaven
					<ul>
						<li><a>Exemple Moulder 1000</a></li>
						<li><a>Nouvelle</a></li>
					</ul>
				</li>
				<li>Admin
					<spring:url value="/admin/rule/edit" var="url"/>
					<ul><a href="${url}">Rule</a></ul>
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
	<jsp:invoke fragment="scripts" />
</body>
</html>
