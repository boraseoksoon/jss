(ns cljs.core.fn
  (:require [clojure.core.async :as async])
  (:require [clojure.core.match :refer [match]])
  ;; (:require clojure.core.match refer :all)
  (:require ["acorn" :as acorn]
      			["./bar" :as bar]
      			["./foo" :as foo]))

; core.async
(async/go (println "Hello Processes!"))
(async/go-loop []
  (async/<! (async/timeout 100))
  (println "Hello from process 1")
  (recur))

; core.match
(doseq [n (range 1 101)]
  (println
   (match [(mod n 3) (mod n 5)]
     [0 0] "FizzBuzz"
     [0 _] "Fizz"
     [_ 0] "Buzz"
     :else n)))

;; cljs->js interop
(js/console.log "helloBar go bar!!")
(. bar helloBar)

(js/console.log "go test!!")
(. js/console log (. foo helloFoo2 "helloFoo2"))
(. foo helloFoo)

;; js->cljs interop
(defn ^:export interop [src]
 	(prn (str src "=> from JS")))

(. js/console log (. acorn parse "const map1 = {}"))