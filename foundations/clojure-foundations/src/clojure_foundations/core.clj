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
