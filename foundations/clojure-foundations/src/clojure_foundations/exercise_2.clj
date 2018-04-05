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
	(if (empty? ks)
		(let [conv (partial f (get m k))]
			(assoc m k (apply conv args)))
		(let [updater (partial new-update-in (get m k {}) ks f)]
			(assoc m k (apply updater args)))))


