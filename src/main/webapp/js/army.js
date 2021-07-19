'use strict';

q(function() {
	q("body").on("change", "select.ajax", function(e) {
		let t = q(e.target);
		q.ajax(t.attr("data-url")).header(t.attr("name"), t.value()).success(function(data) {
			q(e.target).attr("data-update").split(',').forEach(elem => {
				q(elem).replaceWith(data.find(elem));
			});
		}).process();
	});
	q("body").on("change", "input[type=checkbox].ajax", function(e) {
		let t = q(e.target);
		q.ajax(t.attr("data-url")).header(t.attr("name"), t.value()).success(function(data) {
			q(e.target).attr("data-update").split(',').forEach(elem => {
				q(elem).replaceWith(data.find(elem));
			});
		}).process();
	});
});

