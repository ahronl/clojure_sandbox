(ns clojure-foundations.exercise-1
  (:gen-class))

(defn add-onehandred [num]
	(+ 100 num))

(defn dec-maker [num]
	(- num 1))

(defn mapset [f vec]
	(set (map f vec)))
