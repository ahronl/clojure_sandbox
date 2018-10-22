(ns print-numbers-as-words.printer-test
  (:require
   [clojure.test :refer :all]
   [print-numbers-as-words.printer :refer :all]))

(deftest to-word-test
  (testing "testing print number as words")
  (is (= "one" (to-words 1)))
  (is (= "ten" (to-words 10)))
  (is (= "eighty one million nine handred twenty three thousand eight handred forty one" (to-words 81923841))))