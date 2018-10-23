(ns print-numbers-as-words.printer
  (:gen-class))

(defn to-words [num]
 (let [under-twenty ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine" "ten" "eleven" "twelve" "thirteen" "fourteen" "fifteen" "sixteen" "seventeen" "eighteen" "nineteen"]
       under-handred ["twenty" "thirty" "forty" "fifty" "sixty" "seventy" "eighty" "ninety"]
       over-thousand ["thousand" "million" "billion"]]
  (cond
    (< num 20)
     (under-twenty num)
    (< num 100)
    (let [uh-index (- (quot num 10) 2) rem-index (rem num 10)]
      (str (under-handred uh-index) " " (under-twenty rem-index)))
    (< num 1000)
    (let [div-num (quot num 100) rem-index (rem num 100)] (str (to-words div-num) " handred " (if (zero? rem-index) "" (to-words rem-index))))
    :else
    (loop [items [] num num ot-index -1]
      (if (zero? num) (clojure.string/join " " items)
          (let [rem-index (rem num 1000)
                num (quot num 1000)
                items (if (zero? rem-index) items (cons (if (< -1 ot-index) (str (to-words rem-index) " " (over-thousand ot-index)) (to-words rem-index)) items))]
            (recur items num (inc ot-index))))))))




