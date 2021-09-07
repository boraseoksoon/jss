exports.helloFoo = function() {
	for (var value of Array(100).keys()) {
		console.log("test : ", value);
	}
}

exports.helloFoo2 = function (str) {
	return "helloFoo2 => " + str
}