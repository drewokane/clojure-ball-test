(ns game.core
  (:require [arcadia.core :refer :all]
            [arcadia.linear :refer :all]
            [game.field :as field]
            [game.pickups :as pickups]
            [game.player :as player]
            [game.common :as common]
            [game.camera :as camera]))

(defn start
  [obj]
  (let [cubes (pickups/random-cubes common/num-cubes)
        field (field/create-playing-field)
        protagonist (player/create-player)
        main-cam (camera/initialize-camera)]
    main-cam))

(comment
 (def start-object (object-named "StartObject"))
 (hook+ start-object :start #'start)

 (println (.. (objects-named "Sphere") transform position)))
