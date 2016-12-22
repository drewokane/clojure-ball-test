(ns game.player
  (:require [arcadia.core :refer :all]
            [arcadia.linear :refer :all]
            [game.common :as common])
  (:import [UnityEngine Rigidbody Input]))

(defn move-player
  [obj]
  (let [x (Input/GetAxis "Horizontal")
        y (Input/GetAxis "Vertical")]
    (.AddForce (cmpt obj "Rigidbody") (v3* (v3 x 0 y) common/velocity))))

(defn create-player
  []
  (->
   (create-primitive :sphere)
   (common/rename-obj "Player")
   (hook+ :fixed-update #'move-player)
   (common/move-obj (v3 0 0.5 0))
   (cmpt+ Rigidbody)))
