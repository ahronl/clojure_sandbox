(ns clojure-foundations.exercise-2
  (:gen-class))

(defn attr
	;question #1
	[name]
	(comp name :attributes))

(defn two-comp
	([f g]
		(fn [& args]
			(f (apply g args)))))

(defn new-comp
	;question #2
  ([f] f)
  ([f & fs]
  (fn [& args] 
  	(f (apply (apply new-comp fs) args)))))

(defn new-assoc-in
	;question #3
	[m [k & ks] v]
	(loop 
		[map m
		key k
		keys ks 
		val v]
		(if (empty? keys)
			(assoc map key val)
			(assoc map key (new-assoc-in (get map key {}) keys val)))))


