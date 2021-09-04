(ns cljs.core.fn)

(defn ^:export interop [src]
  (str "jss hlvm frontend (js to swift)"))

(def fs (js/require "fs"))
(println (.readdirSync fs js/__dirname))


(prn (. js/Object entries (str "a")))