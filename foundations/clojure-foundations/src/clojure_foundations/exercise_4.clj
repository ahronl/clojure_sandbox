(ns clojure-foundations.exercise-4
  (:gen-class))

(def my-atom-value (atom 0))

(defn inc-my-atom-value-ten-times
	[]
	(dotimes [n 10]
		(swap! my-atom-value #(inc %))))