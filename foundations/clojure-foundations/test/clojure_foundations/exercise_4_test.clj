(ns clojure-foundations.exercise-4-test
  (:require [clojure.test :refer :all]
            [clojure-foundations.exercise-4 :refer :all]))

(deftest inc-my-atom-value_ten_times-test
  (testing "inc-my-atom-value_ten_times")
    (is (= nil (clojure-foundations.exercise-4/inc-my-atom-value-ten-times)))
    (is (= 10 @clojure-foundations.exercise-4/my-atom-value)))