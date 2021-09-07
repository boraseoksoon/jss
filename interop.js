const { generate_code } = require("./cljs_dist/core/node/interop")

const source = "let x = 10"
generate_code(source)


// global.test = require('./test.js');
// interop(global.test)

// global.bar = require('./cljs/cljs/core/bar.js');
// interop(global.bar)