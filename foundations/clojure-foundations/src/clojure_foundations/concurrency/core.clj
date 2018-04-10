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
   (println "And the winner is:" @search-result)))

(defn search-me-ex2 [word & engine_names]
 (let [engines {:bing bing-url :google google-url}
 		search-result (promise)]
   (doseq [eng engine_names]
     (future (if-let [search-page (slurp (str (get engines eng) word))]
               (deliver search-result search-page))))
   (println "And the winner is:" @search-result)))

(defn -main
	[]
	(search-me-ex1 "clojure")
	(search-me-ex2 "clojure" :bing))