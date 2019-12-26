(ns day1
  (:require [clojure.string :as string]))

(defn payload-mass []
  (map (comp long bigdec)
    (string/split-lines
      (slurp "resources/day1.txt"))))

(defn mass->fuel [mass]
  (- (Math/floor (/ mass 3)) 2))

(def fuel-requirement
  (apply +
    (map mass->fuel (payload-mass)))) ;; 3367126

(defn sum-tail-fuel [mass]
  (apply +
    (take-while pos?
      (iterate mass->fuel mass))))

(def improved-fuel-requirement
  (->> (map mass->fuel (payload-mass))
       (map sum-tail-fuel)
       (apply +))) ;; 5047796
