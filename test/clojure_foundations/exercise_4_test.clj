(ns clojure-foundations.exercise-4-test
  (:require [clojure.test :refer :all]
            [clojure-foundations.exercise-4 :refer :all]))

(deftest inc-my-atom-value_ten_times-test
  (testing "inc-my-atom-value_ten_times")
    (is (= 10 (inc-my-atom-value-ten-times))))

(deftest get-word-count-from-quotes-test
	(testing "get-word-count-from-quotes"
		(println (get-word-count-from-quotes 5))))

(deftest heal-test
	(testing "heal"
		(heal)))
