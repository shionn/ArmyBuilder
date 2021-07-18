'use strict';

let _q = function(obj) {
	this.obj = obj;
};

_q.prototype._each = function(callback) {
	this.obj.forEach(callback);
}

_q.prototype.css = function(attr, value) {
	if (!value) return obj[0].style[attr];
	this._each(o => o.style[attr] = value);
	return this;
}

_q.prototype.find = function(selector) {
	let objs = new Array();
	this._each(o => Array.prototype.push.apply(objs, o.querySelectorAll(selector)));
	return q(objs);
}

_q.prototype.on = function(type, selector, callback) {
	this.find(selector)._each(child => child.addEventListener(type, callback));
	this._each(o => o.addEventListener("DOMNodeInserted", function() {
		o.querySelectorAll(selector).forEach(c => c.removeEventListener(type, callback));
		o.querySelectorAll(selector).forEach(c => c.addEventListener(type, callback));
	}));
}

let q = function(selector) {
	if (!selector) return this;
	if (typeof selector === "function") {
		document.addEventListener("DOMContentLoaded", selector);
		return this;
	} else if (typeof selector === "string") {
		return new _q(document.querySelectorAll(selector));
	} else {
		return new _q(selector);
	}
};

q.ajax = function(url, success) {
	let req = new XMLHttpRequest();
	req.onreadystatechange = function() {
		if (req.readyState === XMLHttpRequest.DONE) {
			if (req.status === 200) {
				success(req.response);
			} else {
				document.write(req.response);
			}
		}
	};
	req.open('GET', url);
	req.send();
};



//
//q.prototype.css = function(attr, value) {
//	obj.style[attr] = value;
//};

//q.prototype.find = function(selector) {
//	return new q(obj.querySelectorAll(selector));
//};


