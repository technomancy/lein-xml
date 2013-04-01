(ns lein-xml.plugin
  (:require [clojure.data.xml :as xml]
            [clojure.java.io :as io]))

(defn find-tag [parsed tag]
  (:content (first (filter #(= (:tag %) tag) (:content parsed)))))

(def find-ftag (comp first find-tag))

(defn artifact [parsed]
  [(symbol (find-ftag parsed :groupId) (find-ftag parsed :artifactId))
   (find-ftag parsed :version)])

(defn dependencies [parsed]
  [:dependencies (vec (for [dep (find-tag parsed :dependencies)]
                        [(symbol (find-ftag dep :groupId)
                                 (find-ftag dep :artifactId))
                         (find-ftag dep :version)]))])

(defn description [parsed]
  [:description (find-ftag parsed :description)])

(defn url [parsed]
  [:url (find-ftag parsed :url)])

(def fields [artifact dependencies description url])

(defn middleware [project]
  (with-open [rdr (io/reader (io/file (:root project) "project.xml"))]
    (assoc @(eval (cons 'leiningen.core.project/defproject
                        (apply concat ((apply juxt fields) (xml/parse rdr)))))
      :root (:root project))))