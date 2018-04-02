(ns clojure-foundations.exercise-1
  (:gen-class))

(defn add-onehandred [num]
	(+ 100 num))

(defn dec-maker [num]
	(- num 1))

(defn mapset [f vec]
	(set (map f vec)))

(defn matching-part
	[part]
	(if (re-find #"^left-" (:name part))
		(repeat 5 {:name (clojure.string/replace (:name part) #"^left-" "")
   					:size (:size part)})
		[{:name (:name part)
   					:size (:size part)}]
		))

(defn make-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (matching-part part)))
          []
          asym-body-parts))