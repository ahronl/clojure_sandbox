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
	(if ks
		(assoc m k (new-assoc-in (get m k {}) ks v))
		(assoc m k v)))

(defn new-update-in
	;question #5
	[m [k & ks] f & args]
	(if ks
		(assoc m k (apply new-assoc-in (get m k {}) ks f)))
		(assoc m k (apply f (get m k) args)))


