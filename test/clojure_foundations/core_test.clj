(ns clojure-foundations.core-test
  (:require [clojure.test :refer :all]
            [clojure-foundations.core :refer :all]))

(deftest core_tests_sum
  (testing "sum")
    (is (= 10 (clojure-foundations.core/sum 5 5)))

  (testing "sum range")
    (is (= 15 (clojure-foundations.core/sum_range 1 2 3 4 5))))

(deftest core_tests_multiple
  (testing "multiple with 2 numbers")
  (is (= 10 (clojure-foundations.core/multiple 2 5)))

  (testing "multiple with 3 numbers")
  (is (= 90 (clojure-foundations.core/multiple 2 5 9)))

  (testing "multiple with more than 3 arguments")
  (is (= 100 (clojure-foundations.core/multiple 2 5 2 5)))

  (testing "multiple numbers")
  (is (= 5040 (apply clojure-foundations.core/multiple clojure-foundations.core/numbers))))

(deftest core_data_type
  (testing "long type")
  (is (= "class java.lang.Long" (.toString (class clojure-foundations.core/some_object))))

  (is (= "class clojure.lang.BigInt" (.toString (class (+ clojure-foundations.core/some_object 90000000000000000000000000))))))

