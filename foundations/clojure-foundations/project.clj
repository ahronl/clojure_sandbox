(defproject clojure-foundations "0.1.0-SNAPSHOT"
  :description "FIXME: learn how to program with clojure"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot clojure-foundations.core
  :target-path "target/%s"
  :resource-paths ["src/clojure_foundations/fwpd/resources"]
  :profiles {:uberjar {:aot [clojure-foundations.core clojure-foundations.fwpd.core]}})
