(ns clojure-foundations.exercise-2
  (:gen-class))

(defn attr
	[item get-fn]
	(:attributes (get-fn item)))