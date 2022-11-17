'use strict';

q(function() {
	q("body > header").on("click", "nav.menu > ul > li > a", function(e) {
		e.preventDefault();
		q("nav.menu ul.open").rmClass("open");
		q(e.target).parent("li").find("ul").addClass("open");
	});
	q("body").on("click", function(e) {
		if (!q(e.target).parent("nav.menu").exists()) {
			q("nav.menu ul.open").rmClass("open");
		}
	});
	
});