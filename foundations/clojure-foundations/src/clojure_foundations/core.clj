(ns clojure-foundations.core
  (:gen-class))

(defn print-coll-asc
	[vec]
	(if (empty? vec)
		(println "done")
		(do
			(println (first vec))
			(print-coll-asc (drop 1 vec)))))

(defn print-coll-desc
	[vec]
	(if (empty? vec)
		(println "done")
		(do 
			(println (last vec))
			(print-coll-desc (pop vec)))))

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