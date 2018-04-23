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

(def users 
	[{:name "James" :age 26}  {:name "John" :age 43}])

(deftest assoc-in-test
	(testing "assoc-in-test")
	(is (= [{:name "James", :age 26} {:name "John", :age 44}] (clojure-foundations.exercise-2/new-assoc-in users [1 :age] 44)))
	(is (= [{:name "James", :age 26} {:name "John", :age 43} {:name "Jack", :age 19}] (clojure-foundations.exercise-2/new-assoc-in users [2] {:name "Jack" :age 19}))))

(deftest update-in-test
	(testing "update-in-test")
	(is (= [{:name "James", :age 27} {:name "John", :age 43}] (update-in users [0 :age] inc)))
	(is (= [{:name "James", :age 26} {:name "John", :age 62}] (update-in users [1 :age] + 19))))