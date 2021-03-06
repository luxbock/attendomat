(defproject attendomat "0.1.0-SNAPSHOT"
  :license {:name "Mozilla Public License 2.0" :url "https://www.mozilla.org/en-US/MPL/2.0/"}

  :dependencies [[org.clojure/clojure "1.9.0-alpha13"]
                 [org.clojure/clojurescript "1.9.229"]]

  :source-paths ["src"]

  :plugins [[lein-cljsbuild "1.1.4"]]

  :clean-targets ^{:protect false} [:target-path :compile-path "resources/public/js/compiled"]

  :cljsbuild {:builds
              {:main {:source-paths ["src"]
                      :compiler {:main attendomat.core
                                 :optimizations :advanced
                                 :output-to "export/Code.gs"
                                 :output-dir "target"
                                 :pretty-print false
                                 :externs ["resources/gas.ext.js"]
                                 :foreign-libs [{:file "src/entry_points.js"
                                                 :provides ["attendomat.entry-points"]}]}}}})
