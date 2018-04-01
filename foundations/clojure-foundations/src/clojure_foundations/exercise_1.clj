(ns clojure-foundations.exercise-1
  (:gen-class))

(defn add-onehandred [num]
	(+ 100 num))

(defn dec-maker [num]
	(- num 1))

(defn mapset [f vec]
	(set (map f vec)))

(def lims ["second" "third" "forth" "fifth"])

(defn match-part
	[part]
	(into [] (set (map (fn [x] 
					{:name (clojure.string/replace (:name part) #"^first-" (str x "-"))
   					:size (:size part)}) lims))
	))

(defn make-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set (into [part] (match-part part)))))
          []
          asym-body-parts))