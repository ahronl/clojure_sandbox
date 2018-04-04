(ns clojure-foundations.exercise-2-test
  (:require [clojure.test :refer :all]
            [clojure-foundations.exercise-2 :refer :all]))

(def my-character
	{:attributes {:intelligence 110 :strength {:harms 90 :legs 10}}})

(deftest attr-test
  (testing "attr")
    (is (= 110 ((clojure-foundations.exercise-2/attr :intelligence) my-character))))

(deftest two-comp-test
	(testing "two-comp")
	(is (= 90 ((clojure-foundations.exercise-2/two-comp :harms :strength :attributes) my-character))))