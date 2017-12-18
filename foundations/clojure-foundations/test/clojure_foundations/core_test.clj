(ns clojure-foundations.core-test
  (:require [clojure.test :refer :all]
            [clojure-foundations.core :refer :all]))

(deftest core_tests
  (testing "sum")
    (is (= 10 (clojure-foundations.core/sum 5 5)))

  (testing "sum range")
    (is (= 15 (clojure-foundations.core/sum_range 1 2 3 4 5)))

  (testing "multiple with 2 numbers")
    (is (= 10 (clojure-foundations.core/multiple 2 5)))

  (testing "multiple with 3 numbers")
    (is (= 90 (clojure-foundations.core/multiple 2 5 9)))

  (testing "multiple with more than 3 arguments")
    (is (= 100 (clojure-foundations.core/multiple 2 5 2 5))))


