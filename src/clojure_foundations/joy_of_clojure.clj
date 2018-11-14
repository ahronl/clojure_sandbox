(ns clojure-foundations.joy-of-clojure
  (:gen-class))

;simple tree strucutre in clojure
(defn xcond [t v]
  (cond (nil? t) {:val v :L nil :R nil}
        (< v (:val t)) {:val (:val t) :L (xcond (:L t) v) :R (:R t)}
        :else {:val (:val t) :L (:L t) :R (xcond (:R t) v)}))

(xcond nil 5)

(xcond {:val 3 :L nil :R nil} 4)

(xcond {:val 3 :L nil :R nil} 2)

(-> nil (xcond 5) (xcond 7) (xcond 3))

