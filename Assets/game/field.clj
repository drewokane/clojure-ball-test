(ns game.field
  (:require [arcadia.core :refer :all]
            [arcadia.linear :refer :all]
            [game.common :as common]))

(defn scale-plane
  "Scale the plane primitive by a fixed amount"
  [obj scale]
  (set! (.. obj transform localScale) (v3 scale))
  obj)

(defn create-playing-field
  "Create field for player to roam in"
  []
  (->
   (create-primitive :plane)
   (scale-plane common/field-scale)))
