(ns clojure.examples.DateAndTime
  (:import (java.util Date)
           (java.text SimpleDateFormat)))

; # Clojure 日期和时间  https://www.w3cschool.cn/clojure/clojure_date_and_time.html
; > 因为Clojure框架是从Java类派生的，所以可以使用Clojure中Java中可用的日期时间类。 类日期表示特定的时刻，具有毫秒精度。
;
; ## java.util.Date
; 这用于在Clojure中创建日期对象
;语法: java.util.Date.
;参数 -无。
;返回值 -分配一个Date对象并初始化它，以便它表示分配的时间，以最近的毫秒为单位。
;例
;下面是一个date-time使用的例子。
(defn Example []
  (def date (.toString (Date.)))
  (println date))
(Example)


; ## java.text.SimpleDateFormat中
;这用于格式化日期输出。
;语法
;(java.text.SimpleDateFormat. format dt)
;参数 - '格式'是格式化的时间时使用的格式。 “DT”是需要被格式化的日期。
;返回值 -格式化的日期输出。
(defn Example []
  (def date (.format (SimpleDateFormat. "MM/dd/yyyy") (new Date)))
  (println date))
(Example)

; ## getTime
; > 返回自此Date对象表示的1970年1月1日，00:00:00 GMT以来的毫秒数。
; 语法 (.getTime)
; 参数 -无。
; 返回值 -自此日期1970年1月1日 00:00:00 GMT以来的毫秒数。
(defn Example []
  (def date (.getTime (Date.)))
  (println date))
(Example)