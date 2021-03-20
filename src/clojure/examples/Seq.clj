(ns clojure.examples.Seq
  (:gen-class))
;# Clojure 序列  https://www.w3cschool.cn/clojure/clojure_sequences.html
; > 在“seq”命令的帮助下创建序列。 以下是序列创建的一个简单示例。

;; This program displays Hello World
(defn Example []
  (println (seq [1 2 3])))
(Example)

; ## 可用于序列的各种方法:
;cons	返回一个新序列，其中'x'是第一个元素，'seq'是其余的。
;conj	返回一个新序列，其中“x”是添加到序列末尾的元素。
;concat	这用于将两个序列连接在一起。
;distinct	用于仅确保将不同的元素添加到序列。
;reverse	反转序列中的元素。
;first	返回序列的第一个元素。
;last	返回序列的最后一个元素。
;rest	返回除第一个元素之外的整个序列。
;sort	返回元素的排序序列。
;drop	从基于需要删除的元素数量的序列中删除元素。
;take-last	从序列中获取元素的最后一个列表。
;take	从序列中获取元素的第一个列表。
;split-at	将项目序列拆分为两部分。 指定拆分应发生的位置。