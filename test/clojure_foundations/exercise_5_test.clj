(ns clojure-foundations.exercise-5-test
  (:require [clojure.test :refer :all]
            [clojure-foundations.exercise-5 :refer :all]))

(deftest full-moon-behavior-test
  (testing "ifull-moon-behavior")
    (is (= "Lucian will howl and murder" (full-moon-behavior (map->WereWolf {:name "Lucian" :title "CEO of Melodrama"}))))
    (is (= "Lucian will howl and murder" (full-moon-behavior (map->WereWolf {:name "Lucian" :title "CEO of Melodrama"})))))

