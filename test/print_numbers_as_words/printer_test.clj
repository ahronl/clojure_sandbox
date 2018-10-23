(ns print-numbers-as-words.printer-test
  (:require
   [clojure.test :refer :all]
   [print-numbers-as-words.printer :refer :all]))

(deftest to-word-test
  (testing "testing print number as words")
  (is (= "one" (to-words 1)))
  (is (= "ten" (to-words 10)))
  (is (= "eighty one million nine handred twenty three thousand eight handred forty one" (to-words 81923841))))

(deftest to-word_v1-test
  (testing "testing print number as words")
  (is (= "One" (to-words-v1 1)))
  (is (= "Ten" (to-words-v1 10)))
  (is (= "Eighty-one million, nine hundred twenty-three thousand, eight hundred forty-one" "Eighty-one million, nine hundred twenty-three thousand, eight hundred forty-one" (to-words-v1 81923841))))