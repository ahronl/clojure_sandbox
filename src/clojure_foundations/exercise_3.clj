(ns clojure-foundations.exercise-3
  (:gen-class))

(defn error-messages-for
  "Return a seq of error messages"
  [to-validate message-validator-pairs]
  (map first (filter #(not ((second %) to-validate))
                     (partition 2 message-validator-pairs))))

(defn validate
  "Returns a map with a vector of errors for each key"
  [to-validate validations]
  (reduce (fn [errors validation]
            (let [[fieldname validation-check-groups] validation
                  value (get to-validate fieldname)
                  error-messages (error-messages-for value validation-check-groups)]
              (if (empty? error-messages)
                errors
                (assoc errors fieldname error-messages))))
          {}
          validations))

(defmacro when-valid
  "Handle validation more concisely"
  [to-validate validations errors-name & body]
  `(let [~errors-name (validate ~to-validate ~validations)]
     (if (empty? ~errors-name)
       (do ~@body))))

(macroexpand
 '(when-valid order-details order-details-validations my-error-name
            (println :success)
            (println :failure my-error-name)))

(defmacro my-or
  ([] nil)
  ([x] x)
  ([x & next]
   `(let [or# ~x]
      (if or# or# (or ~@next)))))

(defmacro defattrs
	([] nil)
	([fn-name attr] 
	`(def ~fn-name (comp ~attr :attributes)))
	([fn-name attr & rest]
		`(do 
			(defattrs ~fn-name ~attr)
			(defattrs ~@rest))))


