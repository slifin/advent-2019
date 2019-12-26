(ns day1
  (:require [clojure.string :as string]))

(defn payload-mass []
  (map (comp long bigdec)
    (string/split-lines
      (slurp "resources/day1.txt"))))

(defn mass->fuel [mass]
  (- (Math/floor (/ mass 3)) 2))

(apply +
  (map mass->fuel (payload-mass)))
