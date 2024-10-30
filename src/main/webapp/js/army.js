'use strict';

q(function() {
	q("article.rule").on("click", function(e) {
		const t = q(this);
		t.toggleClass("hidden")
	});
	q("article.unit>header").on("click", function(e) {
		const toHide = q(this).parent().find(".rule:not(.hidden)");
		const toShow = q(this).parent().find(".rule.hidden");
		if (toHide.size()>=toShow.size()) {
			toHide.addClass("hidden");
		} else {
			toShow.rmClass("hidden");
		}
	});
});