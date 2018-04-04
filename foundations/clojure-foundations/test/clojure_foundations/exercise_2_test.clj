(ns clojure-foundations.exercise-2-test
  (:require [clojure.test :refer :all]
            [clojure-foundations.exercise-2 :refer :all]))

(deftest attr-test
  (testing "attr")
    (is (= 110 (clojure-foundations.exercise-2/attr {:intelligence {:attributes 110 }} :intelligence))))