(ns clojure-foundations.exercise-4
  (:gen-class))

(def my-atom-value (atom 0))

(defn inc-my-atom-value-ten-times
	[]
	(do (dotimes [n 10]
		(swap! my-atom-value #(inc %)))
	@my-atom-value))

(defn count-the-words [quote]
	(frequencies (map #(clojure.string/lower-case %) (filter #(not (empty? %)) (clojure.string/split quote #"[ .;?!\-\n\r]")))))

(def rq-url "https://www.braveclojure.com/random-quote")

(def word-count-map (atom {}))

(defn get-word-count-from-quotes [num]
	(do 
		(dosync 
			(doseq [futures (map (fn [x] (future (swap! word-count-map (fn [wc] (merge-with + wc (count-the-words (slurp rq-url))))))) (range num))] 
				((fn [f] @f) futures)))
		@word-count-map))
		