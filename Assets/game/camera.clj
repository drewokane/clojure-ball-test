(ns game.camera
  (:require [arcadia.core :refer :all]
            [arcadia.linear :refer :all]
            [game.common :as common])
  (:import [UnityEngine Quaternion]))

(defn get-player-pos
  [player-obj]
  (.. player-obj transform position))

(defn player-offset
  [player-obj]
  (v3- (get-player-pos player-obj) (v3 0 -10 10)))

(defn move-camera
  [obj]
  (let [player (object-named "Player")]
    (common/move-obj obj (player-offset player))))

(defn rotate-camera
  [obj]
  (set! (.. obj transform rotation) (Quaternion. 0.3826834 0.0 0.0 0.9238796))
  obj)

(defn initialize-camera
  []
  (let [main-camera (object-named "Main Camera")]
    (hook+ main-camera :start #'rotate-camera)
    (hook+ main-camera :late-update #'move-camera)))
