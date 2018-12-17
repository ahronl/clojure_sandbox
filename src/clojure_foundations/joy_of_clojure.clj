(ns clojure-foundations.joy-of-clojure
  (:gen-class))

;simple tree strucutre in clojure
(defn xcond [t v]
  (cond (nil? t) {:val v :L nil :R nil}
        (< v (:val t)) {:val (:val t) :L (xcond (:L t) v) :R (:R t)}
        :else {:val (:val t) :L (:L t) :R (xcond (:R t) v)}))

(xcond nil 5)

(xcond {:val 3 :L nil :R nil} 4)

(xcond {:val 3 :L nil :R nil} 2)

(def tree (-> nil (xcond 5) (xcond 7) (xcond 3) (xcond 9) (xcond 4)))

(defn xseq [t]
  (when t (concat (xseq (:L t)) [(:val t)] (xseq (:R t)))))

(xseq tree)

;;;;;;;lazy
;non lazy example
(defn rec-steps [[x & xs]]
  (if x
    [x (rec-steps xs)]
    []))

(rec-steps [1 2 3 4])

(rec-steps (range 2000))

;lazy version
(defn lz-rec-steps [s]
  (lazy-seq
   (if (seq s)
     [(first s) (lz-rec-steps (rest s))]
     [])))

(dorun (lz-rec-steps (range 2000)))
(lz-rec-steps [1 2 3 4])

(defn triangle [n]
  (/ (* (inc n) n) 2))

(def tri-nums (map triangle (range)))

(comment (take 10 tri-nums))

(defn rand-ints [n] (take n (repeatedly #(rand-int n))))

(comment (rand-ints 100))

;;;;;;;;;;quick sort
(defn- sort-parts [work]
  (lazy-seq
   (loop [[part & parts] work]
     (if-let [[pivot & xs] (seq part)]
       (let [smaller? #(< % pivot)]
         (recur (list*
                 (filter smaller? xs)
                 pivot
                 (remove smaller? xs)
                 parts)))
       (when-let [[x & parts] parts]
         (cons x (sort-parts parts)))))))

(defn qsort [xs]
  (sort-parts (list xs)))

(comment (take 10 (qsort (rand-ints 100))))

;;;;;;;tail recur
(defn pow [base exp]
  (if (zero? exp)
    1
    (* base (pow base (dec exp)))))

(comment (pow 2N 20000000))

(defn pow-v1
  ([base exp]
   (pow-v1 base exp 1))
  ([base exp acc]
   (if (zero? exp)
     acc
     (recur base (dec exp) (* base acc)))))

(comment (pow-v1 2N 20000000 1))

(defn pow-v2 [base exp]
  (letfn [(k [b e a]
              (if (zero? e)
                a
                (recur b (dec e) (* base a))))] 
                (k base exp 1)))
(comment (pow-v2 2N 20000000))

;;; generic recur convert function 
(def simple-metric
  {:meter 1 :km 1000 :cm 1/100 :mm [1/10 :cm]})

(defn convert [ctx desc]
  (reduce (fn [r [mag unit]]
            (+ r (let [val (get ctx unit)]
                   (if (vector? val)
                     (* mag (convert ctx val))
                        (* mag val)))))
          0 (partition 2 desc)))

                          
(comment (convert simple-metric [3 :km]))
(comment (convert simple-metric [3 :km 10 :meter 80 :cm 10 :mm]))

;;;GCD recur
(defn gcd [a b]
  (if (zero? b)
    a 
  (recur b (mod a b))))

(comment (= 21 (gcd 252 105)))

;;a finite state machine
(defn mk-soldier [x y]
  {:data {:location {:x x :y y}}
   :commands {:left (fn [this i]
                      (update-in this [:data :location :x] #(- % i)))
              :right (fn [this i]
                       (update-in this [:data :location :x] #(+ % i)))
              :up (fn [this i]
                    (update-in this [:data :location :y] #(+ % i)))
              :down (fn [this i]
                      (update-in this [:data :location :y] #(- % i)))}})

(defn move [soldier command & args]
  (apply (command (:commands soldier)) soldier args))

(-> (mk-soldier 0 0)
    (move :left 10)
    (move :up 2)
    (move :down 3)
    (move :right 4))


(defn elevator [commands]
  (letfn [(ff-open [[c & r]] #(case c
                                :close (ff-closed r)
                                :done true
                                false))
          (ff-closed [[c & r]] #(case c
                                  :open (ff-open r)
                                  :up (sf-closed r)
                                  false))
          (sf-closed [[c & r]] #(case c
                                  :open (sf-open r)
                                  :down (ff-closed r)
                                  false))
          (sf-open [[c & r]] #(case c
                                :close (sf-closed r)
                                :done true
                                false))]
    (trampoline ff-open commands)))

(comment (= false (elevator [:close :open :close :up :open :open :done])))
(comment (= true (elevator [:close :up :open :close :down :open :done])))


