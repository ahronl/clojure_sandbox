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

(deftest mapset-test
	(testing "mapset apply f on each item in input")
		(is (= #{2 3} (clojure-foundations.exercise-1/mapset inc [1 1 2 2])))
		(is (= #{0 1} (clojure-foundations.exercise-1/mapset dec [1 1 2 2]))))

(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])

(def full-hobbit-body-parts [{:name "head" :size 3}
                             {:name "eye" :size 1}
                             {:name "eye" :size 1}
                             {:name "eye" :size 1}
                             {:name "eye" :size 1}
                             {:name "eye" :size 1}
                             {:name "ear" :size 1}
                             {:name "ear" :size 1}
                             {:name "ear" :size 1}
                             {:name "ear" :size 1}
                             {:name "ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "shoulder" :size 3}
                             {:name "shoulder" :size 3}
                             {:name "shoulder" :size 3}
                             {:name "shoulder" :size 3}
                             {:name "shoulder" :size 3}
                             {:name "upper-arm" :size 3}
                             {:name "upper-arm" :size 3}
                             {:name "upper-arm" :size 3}
                             {:name "upper-arm" :size 3}
                             {:name "upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "forearm" :size 3}
                             {:name "forearm" :size 3}
                             {:name "forearm" :size 3}
                             {:name "forearm" :size 3}
                             {:name "forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "kidney" :size 1}
                             {:name "kidney" :size 1}
                             {:name "kidney" :size 1}
                             {:name "kidney" :size 1}
                             {:name "kidney" :size 1}
                             {:name "hand" :size 2}
                             {:name "hand" :size 2}
                             {:name "hand" :size 2}
                             {:name "hand" :size 2}
                             {:name "hand" :size 2}
                             {:name "knee" :size 2}
                             {:name "knee" :size 2}
                             {:name "knee" :size 2}
                             {:name "knee" :size 2}
                             {:name "knee" :size 2}
                             {:name "thigh" :size 4}
                             {:name "thigh" :size 4}
                             {:name "thigh" :size 4}
                             {:name "thigh" :size 4}
                             {:name "thigh" :size 4}
                             {:name "lower-leg" :size 3}
                             {:name "lower-leg" :size 3}
                             {:name "lower-leg" :size 3}
                             {:name "lower-leg" :size 3}
                             {:name "lower-leg" :size 3}
                             {:name "achilles" :size 1}
                             {:name "achilles" :size 1}
                             {:name "achilles" :size 1}
							 {:name "achilles" :size 1}
							 {:name "achilles" :size 1}
                             {:name "foot" :size 2}
                             {:name "foot" :size 2}
                             {:name "foot" :size 2}
                             {:name "foot" :size 2}
                             {:name "foot" :size 2}])

(deftest symmetrize-body-parts-test
	(testing "symmetrize-body-parts add four boady parts")
	(is (= full-hobbit-body-parts (clojure-foundations.exercise-1/make-body-parts asym-hobbit-body-parts))))

