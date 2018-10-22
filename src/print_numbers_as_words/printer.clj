(ns print-numbers-as-words.printer
  (:gen-class))

(defn to-words [n]
 (let [smalls ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine" "ten" "eleven" "twelve" "thirteen" "fourteen" "fifteen" "sixteen" "seventeen" "eighteen" "nineteen"]
       tens ["twenty" "thirty" "forty" "fifty" "sixty" "seventy" "eighty" "ninety"]
       magnitudes ["thousand" "million" "billion"]]
  (cond
    (< n 20)
    (smalls n)
    (< n 100)
    (let [t (- (quot n 10) 2) r (rem n 10)]
      (str (tens t) " " (smalls r)))
    (< n 1000)
    (let [h (quot n 100) r (rem n 100)] (str (to-words h) " handred " (if (zero? r) "" (to-words r))))
    :else
    (loop [res [] n n index -1]
      (if (zero? n) (clojure.string/join " " res)
          (let [x (rem n 1000)
                n (quot n 1000)
                res (if (zero? x) res (cons (if (< -1 index) (str (to-words x) " " (magnitudes index)) (to-words x)) res))]
            (recur res n (inc index))))))))




