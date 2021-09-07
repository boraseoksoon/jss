module.exports.helloBar = function() {
	for (var value of Array(10).keys()) {
		console.log("helloBar : ", value);
	}
}