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
                             {:name "first-eye" :size 1}
                             {:name "first-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "first-shoulder" :size 3}
                             {:name "first-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "first-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "first-kidney" :size 1}
                             {:name "first-hand" :size 2}
                             {:name "first-knee" :size 2}
                             {:name "first-thigh" :size 4}
                             {:name "first-lower-leg" :size 3}
                             {:name "first-achilles" :size 1}
                             {:name "first-foot" :size 2}])

(def full-hobbit-body-parts [{:name "head" :size 3}
                             {:name "first-eye" :size 1}
                             {:name "second-eye" :size 1}
                             {:name "third-eye" :size 1}
                             {:name "forth-eye" :size 1}
                             {:name "fifth-eye" :size 1}
                             {:name "first-ear" :size 1}
                             {:name "second-ear" :size 1}
                             {:name "third-ear" :size 1}
                             {:name "forth-ear" :size 1}
                             {:name "fifth-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "first-shoulder" :size 3}
                             {:name "second-shoulder" :size 3}
                             {:name "third-shoulder" :size 3}
                             {:name "forth-shoulder" :size 3}
                             {:name "fifth-shoulder" :size 3}
                             {:name "first-upper-arm" :size 3}
                             {:name "second-upper-arm" :size 3}
                             {:name "third-upper-arm" :size 3}
                             {:name "forth-upper-arm" :size 3}
                             {:name "fifth-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "first-forearm" :size 3}
                             {:name "second-forearm" :size 3}
                             {:name "third-forearm" :size 3}
                             {:name "forth-forearm" :size 3}
                             {:name "fifth-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "first-kidney" :size 1}
                             {:name "second-kidney" :size 1}
                             {:name "third-kidney" :size 1}
                             {:name "forth-kidney" :size 1}
                             {:name "fifth-kidney" :size 1}
                             {:name "first-hand" :size 2}
                             {:name "second-hand" :size 2}
                             {:name "third-hand" :size 2}
                             {:name "forth-hand" :size 2}
                             {:name "fifth-hand" :size 2}
                             {:name "first-knee" :size 2}
                             {:name "second-knee" :size 2}
                             {:name "third-knee" :size 2}
                             {:name "forth-knee" :size 2}
                             {:name "fifth-knee" :size 2}
                             {:name "first-thigh" :size 4}
                             {:name "second-thigh" :size 4}
                             {:name "third-thigh" :size 4}
                             {:name "forth-thigh" :size 4}
                             {:name "fifth-thigh" :size 4}
                             {:name "first-lower-leg" :size 3}
                             {:name "second-lower-leg" :size 3}
                             {:name "third-lower-leg" :size 3}
                             {:name "forth-lower-leg" :size 3}
                             {:name "fifth-lower-leg" :size 3}
                             {:name "first-achilles" :size 1}
                             {:name "second-achilles" :size 1}
                             {:name "third-achilles" :size 1}
							 {:name "forth-achilles" :size 1}
							 {:name "fifth-achilles" :size 1}
                             {:name "first-foot" :size 2}
                             {:name "second-foot" :size 2}
                             {:name "third-foot" :size 2}
                             {:name "forth-foot" :size 2}
                             {:name "fifth-foot" :size 2}])

(deftest symmetrize-body-parts-test
	(testing "symmetrize-body-parts add four boady parts")
	(is (= full-hobbit-body-parts (clojure-foundations.exercise-1/make-body-parts asym-hobbit-body-parts))))

