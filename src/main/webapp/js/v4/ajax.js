'use strict';

q(function() {
	q("body").on("click", "a.ajax", function(e) {
		e.preventDefault();
		const t = q(e.target);
		const update = t.attr("data-update");
		const url = t.attr("href");
		q.ajax(url, "POST").success(function(data) {
			update.split(',').forEach(elem => {
				q(elem).replaceWith(data.find(elem));
			});
		}).process();
	});
		
});

