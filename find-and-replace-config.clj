;; gorilla-repl.fileformat = 1

;; **
;;; # Gorilla REPL
;;; 
;;; Welcome to gorilla :-)
;;; 
;;; Shift + enter evaluates code. Hit ctrl+g twice in quick succession or click the menu icon (upper-right corner) for more commands ...
;;; 
;;; It's a good habit to run each worksheet in its own namespace: feel free to use the declaration we've provided below if you'd like.
;; **

;; @@
(ns gentle-lagoon
  (:require [gorilla-plot.core :as plot]))

;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
;;; script to add config lines, which are just copy paste of already existing stuff

(def filename "/Users/dhineshns/Dropbox/UB/dev/python/sample_congig.xml")
(slurp filename)

;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;com.cerner.pophealth.analytics.pqi.batch.hdfs=pqi_batch_run\\ncom.cerner.pophealth.cost.util.batch.hdfs=costutil_batch_run\\ncom.cerner.pophealth.analytics.pqi.stream.hdfs=pqi_stream_run\\ncom.cerner.pophealth.hcc.hiv.batch.hdfs=hiv_batch_run\\ncom.cerner.pophealth.analytics.tcrrv.batch.hdfs=tcrrv_batch_run\\ncom.cerner.pophealth.analytics.pqi.batch.hdfs=pqi_continuous_run&quot;</span>","value":"\"com.cerner.pophealth.analytics.pqi.batch.hdfs=pqi_batch_run\\ncom.cerner.pophealth.cost.util.batch.hdfs=costutil_batch_run\\ncom.cerner.pophealth.analytics.pqi.stream.hdfs=pqi_stream_run\\ncom.cerner.pophealth.hcc.hiv.batch.hdfs=hiv_batch_run\\ncom.cerner.pophealth.analytics.tcrrv.batch.hdfs=tcrrv_batch_run\\ncom.cerner.pophealth.analytics.pqi.batch.hdfs=pqi_continuous_run\""}
;; <=

;; @@
(def input (slurp "/Users/dhineshns/Dropbox/UB/dev/python/sample_congig.xml"))
(def replace-with #(let [match-line (first  %1)
                         changed-line (clojure.string/replace 
                                        match-line 
                                        #"pqi" 
                                        "ahrq")
                         both-lines (str
                                      match-line
                                      "\n"
                                      changed-line)]
                     both-lines))


 
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;gentle-lagoon/replace-with</span>","value":"#'gentle-lagoon/replace-with"}
;; <=

;; @@
(def output (clojure.string/replace input #".*(pqi).*" replace-with))
 (print output)
;; @@
;; ->
;;; com.cerner.pophealth.analytics.pqi.batch.hdfs=pqi_batch_run
;;; com.cerner.pophealth.analytics.ahrq.batch.hdfs=ahrq_batch_run
;;; com.cerner.pophealth.cost.util.batch.hdfs=costutil_batch_run
;;; com.cerner.pophealth.analytics.pqi.stream.hdfs=pqi_stream_run
;;; com.cerner.pophealth.analytics.ahrq.stream.hdfs=ahrq_stream_run
;;; com.cerner.pophealth.hcc.hiv.batch.hdfs=hiv_batch_run
;;; com.cerner.pophealth.analytics.tcrrv.batch.hdfs=tcrrv_batch_run
;;; com.cerner.pophealth.analytics.pqi.batch.hdfs=pqi_continuous_run
;;; com.cerner.pophealth.analytics.ahrq.batch.hdfs=ahrq_continuous_run
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@

;; @@
