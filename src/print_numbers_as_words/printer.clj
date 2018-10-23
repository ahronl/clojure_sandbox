(ns print-numbers-as-words.printer
  (:require [clojure.pprint :as pp])
  (:gen-class))

(defn to-words [num]
 (let [under-twenty {0 "zero" 1 "one" 2 "two" 3 "three" 4 "four" 5 "five" 6 "six" 7 "seven" 8 "eight"
                     9 "nine" 10 "ten" 11 "eleven" 12 "twelve" 13 "thirteen" 14 "fourteen" 15 "fifteen" 
                     16 "sixteen" 17 "seventeen" 18 "eighteen" 19 "nineteen"}
       under-handred {2 "twenty" 3 "thirty" 4 "forty" 5 "fifty" 6 "sixty" 7 "seventy" 8 "eighty" 9 "ninety"}
       over-thousand {0 "thousand" 1 "million" 2 "billion"}
       space " "]
  (cond
    (< num 20)
    (under-twenty num)
    (< num 100)
    (let [uh-key (quot num 10)
          rem-key (rem num 10)]
      (str (under-handred uh-key) space (under-twenty rem-key)))
    (< num 1000)
    (let [div-num (quot num 100)
          rem-key (rem num 100)]
      (str (to-words div-num) " handred " (if (zero? rem-key) "" (to-words rem-key))))
    :else
    (loop [items [] num num ot-key -1]
      (if (zero? num) (clojure.string/join space items)
          (let [rem-key (rem num 1000)
                num (quot num 1000)
                items (if (zero? rem-key) items (cons (if (< -1 ot-key) (str (to-words rem-key) space (over-thousand ot-key)) (to-words rem-key)) items))]
            (recur items num (inc ot-key))))))))
    
(defn to-words-v1 [num]
  (pp/cl-format nil "~@(~@[~R~]~^ ~A.~)" num))