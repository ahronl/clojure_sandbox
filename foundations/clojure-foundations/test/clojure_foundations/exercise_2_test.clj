(ns clojure-foundations.exercise-2-test
  (:require [clojure.test :refer :all]
            [clojure-foundations.exercise-2 :refer :all]))

(def my-character
	{:attributes {:intelligence 110 :strength {:harms 90 :legs 10}}})

(deftest attr-test
  (testing "attr")
    (is (= 110 ((clojure-foundations.exercise-2/attr :intelligence) my-character))))

(deftest new-comp-test
	(testing "new-comp")
	(is (= 90 ((clojure-foundations.exercise-2/new-comp :harms :strength :attributes) my-character))))