(ns clojure-foundations.exercise-1
  (:gen-class))

(defn add-onehandred [num]
	(+ 100 num))

(defn dec-maker [num]
	(- num 1))

(defn mapset [f vec]
	(set (map f vec)))

(defn multiply_by
	[x]
	#(repeat x %))

(defn matching-part
	[part multiplier]
	(if (re-find #"^left-" (:name part))
		(multiplier {:name (clojure.string/replace (:name part) #"^left-" "")
   					:size (:size part)})
		[{:name (:name part)
   					:size (:size part)}]
		))

(defn make-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts num-of-parts]
  (reduce (fn [parts part]
            (into parts (matching-part part (multiply_by num-of-parts))))
          []
          asym-body-parts))