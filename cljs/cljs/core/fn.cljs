(ns cljs.core.fn
  (:require [clojure.core.async :as async])
  (:require [clojure.core.match :refer [match]])
  (:require [cljs.core.fn2 :as fn2])
  (:require ["acorn" :as acorn]
           	["acorn-walk" :as walk]
      			["./bar" :as bar]
      			["./foo" :as foo]))

(defn ^:export generate-code [source]  
  (prn (str "let's walk " source))
  
  (let [full-walk (aget walk "full")
      	AST (. acorn parse source)]
 		(defn each-walk [node] 
  		(.log js/console (str "walking... => " (.stringify js/JSON node) "\n")))
  		
		(full-walk AST each-walk))
)

;; (reduce + (range 0 100))

(defn test-generate-code [source]
  (prn (str "let's walk " source))

  (let [full-walk (aget walk "full")
        AST (. acorn parse source)]
    
	 (defn each-walk [node]
      (.log js/console (str "test walking... => " (.stringify js/JSON node) "\n")))

    (full-walk AST each-walk)))

(test-generate-code "var code = {}")

	;; (require '["acorn-walk" :as walk])
  ;; (def AST (. acorn parse source))
  ;; (def full-walk (aget walk "full"))
	;; (full-walk AST (fn [node]
	;; 								(.log js/console (str "walking... node : " (.stringify js/JSON node)))))

;; js->cljs interop
;; (defn ^:export interop [src]
;;  	(prn (str src "=> from JS")))
  
;; (. acorn parse source)
;; walk
;; (. acorn parse source)
;; walk
;; (fn [node] (.log js/console (str "we've got : " node)))
;; AST

;; (. js/console log (. acorn parse "const map1 = {}"))

;; (require '[core.fn2 :as fn2])
;; (fn2/function2)

;; (def function2 (cljs.core.fn2/function2))
;; (cljs.core.fn2/function2)
;; (require '[clojure.string])
;; (clojure.string/upper-case "clojure")

;; (require '[clojure.string :as str])
;; (str/upper-case "clojure")

;; (require '[clojure.string :refer [upper-case]])
;; (upper-case "hlvm")

; core.async
;; (async/go (println "Hello Processes!"))
;; (async/go-loop []
;;   (async/<! (async/timeout 100))
;;   (println "Hello from process 1")
;;   (recur))

; core.match
;; (doseq [n (range 1 101)]
;;   (println
;;    (match [(mod n 3) (mod n 5)]
;;      [0 0] "FizzBuzz"
;;      [0 _] "Fizz"
;;      [_ 0] "Buzz"
;;      :else n)))

;; ;; cljs->js interop
;; (js/console.log "helloBar go bar!!")
;; (. bar helloBar)

;; (js/console.log "go test!!")
;; (. js/console log (. foo helloFoo2 "helloFoo2"))
;; (. foo helloFoo)
;; 
;; 
;; 
;; 