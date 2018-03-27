(ns clojure-foundations.exercise-1-test
  (:require [clojure.test :refer :all]
            [clojure-foundations.exercise-1 :refer :all]))

(deftest add-onehandred-test
  (testing "add-onehandred")
    (is (= 110 (clojure-foundations.exercise-1/add-onehandred 10))))


(deftest dec-maker-test
	(testing "dec-maker subract one from input")
		(is (= 0 (clojure-foundations.exercise-1/dec-maker 1)))
		(is (= 9 (clojure-foundations.exercise-1/dec-maker 10)))
		(is (- 99 (clojure-foundations.exercise-1/dec-maker 100))))
