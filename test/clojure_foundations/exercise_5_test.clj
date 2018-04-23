(ns clojure-foundations.exercise-5-test
  (:require [clojure.test :refer :all]
            [clojure-foundations.exercise-5 :refer :all]))

(deftest full-moon-behavior-multimethod-test
  (testing "full-moon-behavior polymorphism using multimethod")
    (is (= "Rachel from next door will howl and murder" (full-moon-behavior-multimethod {:were-type :wolf :name "Rachel from next door"})))
    (is (= "Andy the baker will encourage people and sweat to the oldies" (full-moon-behavior-multimethod {:name "Andy the baker" :were-type :simmons}))))

(deftest full-moon-behavior-protocal-test
  (testing "full-moon-behavior polymorphism using recored and protocal")
    (is (= "Lucian will howl and murder" (full-moon-behavior-protocal (map->WereWolf {:name "Lucian" :title "CEO of Melodrama"}))))
    (is (= "Lucian will dance" (full-moon-behavior-protocal (map->Dancer {:name "Lucian" :title "CEO of Melodrama"})))))

(deftest Emotions-protocal-test
	(testing "Emotions protocal")
	(is (= "what it's all about?" (ask-me-to-think 3)))
	(is (= "crying....." (ask-me-to-cry 7)))
	(is (= "no strings attached" (ask-me-to-think "string")))
	(is (= "still crying....." (ask-me-to-cry "string"))))