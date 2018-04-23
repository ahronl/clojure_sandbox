(ns clojure-foundations.exercise-5
  (:gen-class))

(defprotocol WereCreature
	(full-moon-behavior [x]))

(defrecord WereWolf [name title]
  WereCreature
  (full-moon-behavior [x]
    (str name " will howl and murder")))

(defrecord Dancer [name title]
  WereCreature
  (full-moon-behavior [x]
    (str name " will dance")))

(full-moon-behavior (map->WereWolf {:name "Lucian" :title "CEO of Melodrama"}))