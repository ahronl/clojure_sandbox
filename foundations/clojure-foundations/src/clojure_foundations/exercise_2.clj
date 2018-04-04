(ns clojure-foundations.exercise-2
  (:gen-class))

(defn attr
	;question #1
	[name]
	(comp name :attributes))

(defn two-comp
  [f g & others]
  (fn [& args]
    (f (apply g args))))