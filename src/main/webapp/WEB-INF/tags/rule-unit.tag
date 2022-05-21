<%@ tag pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ attribute name="rule" type="armybuilder.model.army.rule.IArmyRule"%>
<%@ attribute name="army" type="armybuilder.model.army.Army"%>
<div class="rule">
	<h3>${rule.displayName} : </h3>
	${rule.description}
</div>
