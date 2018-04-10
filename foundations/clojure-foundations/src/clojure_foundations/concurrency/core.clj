;run using this command ==>lein run -m clojure-foundations.concurrency.core

(ns clojure-foundations.concurrency.core
	(:gen-class))

(def bing-url "https://www.bing.com/search?q=")
(def google-url "https://www.bing.com/search?q=") ;google api does not work

(defn search-me-ex1 [word]
 (let [search-result (promise)]
   (doseq [engine [bing-url google-url]]
     (future (if-let [search-page (slurp (str engine word))]
               (deliver search-result search-page))))
   	@search-result))

(defn search-me-ex2 [word & engine_names]
 (let [engines {:bing bing-url :google google-url}
 		search-result (promise)]
   (doseq [eng engine_names]
     (future (if-let [search-page (slurp (str (get engines eng) word))]
               (deliver search-result search-page))))
   	@search-result))

(defn get-urls [word]
	(let [res-page (search-me-ex1 word)
		   found (re-seq #"href=\"([^\" ]*)\"" res-page)
		   urls (map second found)
		   external-links (filter #(re-find #"http(?s)://" %) urls)]
		external-links))

(defn -main
	[]
	(println (str "found ex1: " (search-me-ex1 "clojure")))
	(println (str "found ex2: " (search-me-ex2 "clojure" :bing)))
	(println (get-urls "clojure")))