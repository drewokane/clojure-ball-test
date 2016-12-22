(ns game.common
  (:require [arcadia.core :refer :all]
            [arcadia.linear :refer :all])
  (:import [UnityEngine Color]))

(def field-scale 10)

(def num-cubes 10)

(def velocity 10)

(defn move-obj
  [obj pos]
  (set! (.. obj transform position) pos)
  obj)

(defn rename-obj
  [obj new-name]
  (set! (.. obj name) new-name)
  obj)