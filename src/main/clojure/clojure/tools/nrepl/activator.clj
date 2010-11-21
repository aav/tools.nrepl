(ns clojure.tools.nrepl.activator
  (:use clojure.tools.nrepl)
)

(def ^{:private true} *socket* (atom nil))

(defn- bundle-start [context]
  (when-let [port (System/getProperty "clojure.tools.nrepl.port")]
	  (reset! *socket*
	    (first (start-server (Integer/parseInt port))))
  )
)

(defn- bundle-stop [context]
  (when-let [socket @*socket*]
    (.close socket))
)