(ns clojure-foundations.core
  (:gen-class))

(defn print-coll-asc
	[vec]
	(loop [[head & all-the-rest] vec] 
		(if (= head nil)
			(println "done")
			(do 
				(println head)
				(recur all-the-rest)))))

(defn print-coll-desc
	[vec]
	(let [v (reverse vec)](print-coll-asc v)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (do
  	(println "Hello, World!")
  	(print-coll-asc [1 2 3])
  	(print-coll-desc [4 5 6])))

(defn sum [x y]
  (+ x y))

;multiple arguments
(defn sum_range [a b c & more]
  (+ a b c (apply + more)))

(def numbers [1 2 3 4 5 6 7])

;overloading
(defn multiple
  ([a b] (* a b))
  ([a b c & more] (* a b c (apply * more))))


(def some_object 9)