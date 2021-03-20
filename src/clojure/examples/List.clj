(ns clojure.examples.List)

;Clojure 列表 List   https://www.w3cschool.cn/clojure/clojure_lists.html
;List是用于存储数据项集合的结构。
; 在Clojure中，List实现了ISeq接口。 使用list函数在Clojure中创建列表。

;以下是在Clojure中创建Numbers列表的示例:
(defn example []
  (println (list 1 2 3 4)))
(example)
(println (str "-----------------------------------------------------------------"))

;以下在Clojure中创建字符型列表的示例:
(defn example2 []
  (println (list 'a 'b 'c 'd)))
(example2)
(println (str "-----------------------------------------------------------------"))


;以下是Clojure中列表几个方法:
;list*	创建一个新列表，其中包含其他项目，其中最后一个将被视为序列。
;first	此函数返回列表中的第一项。
;nth	此函数返回列表中“第n”位置的项目。
;cons	返回一个新列表，其中元素被添加到列表的开头。
;conj	返回一个新列表，其中列表在开头，要追加的元素放在末尾。
;rest	返回列表中第一个项目之后的剩余项目。


;1、Clojure list  创建一个新列表，其中包含其他项目，其中最后一个将被视为序列。
;语法
;(list* listitems [lst])
;参数− 'listitems'是需要附加的新列表项。 'lst'是项目需要附加到的列表。
;返回值 − 带有附加列表项的新列表。
(defn example3 []
  (println (list* 1 [2, 3])))
(example3)
(println (str "-----------------------------------------------------------------"))


;2、Clojure Lists first   此函数返回列表中的第一项。
;语法
;(first lst)
;参数− 'lst'是项目列表。
;返回值 − 列表中的第一个值。
(defn example4 []
  (println (first (list 1 2, 3))))
(example4)
(println (str "-----------------------------------------------------------------"))


;3、Clojure Lists nth   此函数返回列表中“第n”位置的项目。
;语法
;(nth lst index)
;参数− 'lst'是项目列表。 'index'是元素的索引位置，需要返回。
;返回值 − 列表中索引位置的值。
(defn example5 []
  (println (nth (list 1 2, 3) 0))
  (println (nth (list 1 2, 3) 2)))
(example5)
(println (str "-----------------------------------------------------------------"))


;4、Clojure Lists cons   返回一个新列表，其中元素被添加到列表的开头。
;   Clojure Lists conj   返回一个新列表，其中列表在开头，要追加的元素放在末尾。
;语法
;(cons element lst)
;参数− 'element'是需要添加到列表的元素。 'lst'是项目列表。
;返回值 − 带有附加值的列表。
(defn example6 []
  (println (cons 0 (list 1 2,3))))
(example6)


;5、Clojure Lists rest   返回列表中第一个项目之后的剩余项目。
;语法
;(rest lst)
;参数− 'lst'是项目列表。
;返回值 − 删除第一个项目后的项目列表。
(defn example7 []
  (println (rest (list 1 2,3))))
(example7)