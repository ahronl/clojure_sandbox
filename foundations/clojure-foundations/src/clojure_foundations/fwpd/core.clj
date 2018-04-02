;run using this command ==>lein run -m clojure-foundations.fwpd.core

(ns clojure-foundations.fwpd.core
	(:gen-class))

(def filename "suspects.csv")

(def vamp-keys [:name :glitter-index])
(def validators {:name string?, :glitter-index number?})

(defn str->int
  [str]
  (Integer. str))

(def conversions {:name identity
                  :glitter-index str->int})
(defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))

(defn parse
  "Convert a CSV into rows of columns"
  [string]
  (map #(clojure.string/split % #",")
       (clojure.string/split string #"\n")))

(defn mapify
  "Return a seq of maps like {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [vamp-key value]]
                   (assoc row-map vamp-key (convert vamp-key value)))
                 {}
                 (map vector vamp-keys unmapped-row)))
       rows))

(defn glitter-filter
  [minimum-glitter records]
  (filter #(>= (:glitter-index %) minimum-glitter) records))

(defn to-list-of-names
	[glitter]
	(into '() (map (fn [x] (:name x)) glitter)))

(defn get-glitter-names
	"the answer to question number 1"
	[]
	(to-list-of-names (glitter-filter 3 (mapify (parse (slurp (clojure.java.io/resource filename)))))))

(defn append
	"the answer to question number 2"
	[suspects suspect]
	(conj suspect suspects))

(defn not-nil?
  [val] ((complement nil?) val))

(defn validate
	"the answer to question number 3"
	[validators record]
	(reduce (fn [is_valid vamp-key] (and is_valid (not-nil? (get record vamp-key)) ((get validators vamp-key)(get record vamp-key)))
	true	
	vamp-keys))

(defn -main
  [& args]
  (println (get-glitter-names)))
  