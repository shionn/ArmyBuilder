'use strict';

q(function() {
	q("body").on("click", "article.rule", function(e) {
		const t = q(this);
		t.toggleClass("hidden")
	});
	q("body").on("click", "article.unit>header", function(e) {
		const toHide = q(this).parent().find(".rule:not(.hidden)");
		const toShow = q(this).parent().find(".rule.hidden");
		if (toHide.size()>=toShow.size()) {
			toHide.addClass("hidden");
		} else {
			toShow.rmClass("hidden");
		}
	});
});