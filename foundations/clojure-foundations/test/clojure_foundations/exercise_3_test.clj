(ns clojure-foundations.exercise-3-test
  (:require [clojure.test :refer :all]
            [clojure-foundations.exercise-3 :refer :all]))

(def order-details {:name "my name" :email "my_name@gmail.com"})
(def empty-order-details {:name "" :email ""})
(def no-valid-email-order-details {:name "my name" :email "my_name.gmail.com"})

(def order-details-validations
  {:name
   ["Please enter a name" not-empty]

   :email
   ["Please enter an email address" not-empty

    "Your email address doesn't look like an email address"
    #(or (empty? %) (re-seq #"@" %))]})


(deftest validate-test
  (testing "validate")
    (is (= {} (clojure-foundations.exercise-3/validate order-details order-details-validations)))
    (is (= {:name '("Please enter a name") :email '("Please enter an email address")} 
    	(clojure-foundations.exercise-3/validate empty-order-details order-details-validations))))

(def counter (atom 0))

(deftest when-valid-test
	(testing "when-valid")
	(is (= 3 (when-valid order-details order-details-validations my-error-name
            (swap! counter inc)
            (swap! counter inc)
            (swap! counter inc)))))

(deftest my-or-test
	(testing "my-or")
	(is (= nil (my-or nil)))
	(is (= false (my-or false)))
	(is (= true (my-or true)))
	(is (= true (my-or false true)))
	(is (= true (my-or true true)))
	(is (= true (my-or true false false)))
	(is (= false (my-or false false)))
	(is (= false (my-or false false false))))