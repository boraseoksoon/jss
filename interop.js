const { interop, interop2 } = require("./cljs_dist/core/node/interop")

console.log(interop("nodejs!")) 
function helloJS() {
	for (var value of Array(5).keys()) {
		console.log(value);
	}
}