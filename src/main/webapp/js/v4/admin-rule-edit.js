'use strict';

q(function() {
	q("select[name=keyword]").on("change", function(e) {
		const keyword = q(this).value();
		if (keyword !== '--') {
			var keywords = q("input[name=keywords]").value();
			if (keywords.includes(keyword)) {
				keywords = keywords.replace(keyword,'');
				keywords = keywords.replace(/,,/,",").replace(/^,/,"").replace(/,$/,"");
			} else {
				if (keywords !== "") {
					keywords = keywords + ',' + keyword;
				} else {
					keywords = keyword;
				}
			}
			q("input[name=keywords]").value(keywords);
			q(this).value('--');
		}
	});

});