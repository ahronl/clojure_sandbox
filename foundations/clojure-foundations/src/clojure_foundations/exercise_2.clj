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
	(if (empty? ks)
		(assoc m k v)
		(assoc m k (new-assoc-in (get m k {}) ks v))))

(defn new-update-in
	;question #5
	[m [k & ks] f & args]
	(let [
		map m
		key k
		keys ks
		fn f
     	args args]
		(if (empty? keys)
			(let [conv (partial fn (get map key))]
				(assoc map key (apply conv args)))
			(let [updater (partial new-update-in (get map key {}) keys fn)]
				(assoc map key (apply updater args))))))


