(ns clojure-foundations.core-test
  (:require [clojure.test :refer :all]
            [clojure-foundations.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 0)))
  (testing "sum")
    (is (= 10 (clojure-foundations.core/sum 5 5)))
  (testing "sum range")
    (is (= 15 (clojure-foundations.core/sum_range 1 2 3 4 5))))


