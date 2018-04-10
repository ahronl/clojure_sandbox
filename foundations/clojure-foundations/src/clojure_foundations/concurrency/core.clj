;run using this command ==>lein run -m clojure-foundations.concurrency.core

(ns clojure-foundations.concurrency.core
	(:gen-class))

(def urls ["https://www.bing.com/search?q=" "https://www.bing.com/search?q="])

(defn run-search
	[url word]
	(slurp (str word url)))

(defn search-me-ex1
	[word]
	(map #(run-search word %) urls))

(defn -main
	[]
	(println (search-me-ex1 "clojure")))