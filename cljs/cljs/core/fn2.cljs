(ns cljs.core.fn2)

(defn function2 []
 	(prn "fn2!"))

(reduce * (range 1 10))
(take 30 (cycle (range 10)))