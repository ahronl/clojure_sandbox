(ns clojure-foundations.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn sum [x y]
  (+ x y))

(defn sum_range [a b c & more]
  (+ a b c (apply + more)))

(def numbers [1 2 3 4 5 6 7])

(defn multiple
  ([a b] (* a b))
  ([a b c & more] (* a b c (apply * more))))

