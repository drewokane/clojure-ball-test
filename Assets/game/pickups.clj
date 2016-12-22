(ns game.pickups
  (:require [arcadia.core :refer :all]
            [arcadia.linear :refer :all]
            [game.common :as common])
  (:import [UnityEngine Color]))

(defn rand-uniform-int
  [scale]
  (rand-nth (range (- scale) (+ scale 1))))

(defn x-z-tuple
  [scale]
  (repeatedly 2 #(rand-uniform-int scale)))

(defn random-v3
  []
  (vec (repeatedly 3 rand)))

(defn to-2d-v3
  [pos]
  (apply v3 (list (first pos) 0.5 (last pos))))

(defn scaled-random-v3
  [scale]
  (-> scale
      x-z-tuple
      to-2d-v3))

(defn random-rgba-value
  []
  (conj (vec (random-v3)) 1))

(defn random-color
  []
  (let [[r g b a] (random-rgba-value)]
    (Color. r g b a)))

(defn color-cube
  [obj col]
  (set! (.. (cmpt obj "Renderer") material color) col)
  obj)

(defn create-random-cube
  "Creates n randomly placed cubes in the scene"
  []
  (->
    (create-primitive :cube)
    (common/move-obj (scaled-random-v3 common/field-scale))
    (color-cube (random-color))))

(defn random-cubes
  [n]
  (vec (repeatedly n create-random-cube)))