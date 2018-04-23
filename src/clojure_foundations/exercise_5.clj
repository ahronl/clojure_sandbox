(ns clojure-foundations.exercise-5
  (:gen-class))


(defmulti full-moon-behavior-multimethod (fn [were-creature] (:were-type were-creature)))

(defmethod full-moon-behavior-multimethod :wolf
  [were-creature]
  (str (:name were-creature) " will howl and murder"))

(defmethod full-moon-behavior-multimethod :simmons
  [were-creature]
  (str (:name were-creature) " will encourage people and sweat to the oldies"))


(defmethod full-moon-behavior-multimethod :dancer
  [were-creature]
  (str (:name were-creature) " will dance"))

(defprotocol WereCreature
	(full-moon-behavior-protocal [x]))

(defrecord WereWolf [name title]
  WereCreature
  (full-moon-behavior-protocal [x]
    (str name " will howl and murder")))

(defrecord Dancer [name title]
  WereCreature
  (full-moon-behavior-protocal [x]
    (str name " will dance")))

(full-moon-behavior-protocal (map->WereWolf {:name "Lucian" :title "CEO of Melodrama"}))