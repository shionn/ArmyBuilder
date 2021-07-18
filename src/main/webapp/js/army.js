
q(function() {
	q("body").on("click", "button", () => {
		let l = document.createElement("button");
		l.innerText = "ajouter";
		document.body.appendChild(l);
	});
});

