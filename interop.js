const { interop } = require("./cljs_dist/core/node/interop")
console.log(interop("I'm JS")) 

// global.test = require('./test.js');
// interop(global.test)

// global.bar = require('./cljs/cljs/core/bar.js');
// interop(global.bar)