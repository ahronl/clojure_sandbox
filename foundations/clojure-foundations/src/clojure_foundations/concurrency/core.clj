;run using this command ==>lein run -m clojure-foundations.concurrency.core

(ns clojure-foundations.concurrency.core
	(:gen-class))

(def urls ["https://www.bing.com/search?q=" "https://www.bing.com/search?q="])

(def urls-map {:bing "https://www.bing.com/search?q=" :google "https://www.bing.com/search?q="})

(defn run-search
	[url word]
	(slurp (str word url)))

(defn search-me-ex1
	[word]
	(map #(run-search word %) urls))

(defn search-me-ex2
	[word engine]
	(map #(run-search word %) [(get urls-map engine)]))

(defn -main
	[]
	(do 
		(println (search-me-ex1 "clojure"))
		(println (search-me-ex2 "clojure" :bing))))