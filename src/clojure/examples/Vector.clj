(ns clojure.examples.Vector
  (:require [clojure.set :as set])
  (:gen-class))

;Clojure 栈
;载体是通过使用Clojure中的栈方法创建的。
(defn example []
  (println (vector 1 2 3)))
(example)
(println (str "-----------------------------------------------------------------"))

;以下是Clojure中载体的可用方法。
;vector-of	创建一个单一基本类型't'的新载体，其中't'是下列类型之一：int：long：float：double：byte：short：char或：boolean。
;nth	此函数返回载体中第n个位置的项目。
;get	返回载体中索引位置处的元素。
;conj	向该载体追加一个元素，并返回一组新的载体元素。
;pop	对于列表或队列，返回没有第一个项目的新列表/队列，对于载体，返回一个没有最后一个项目的新载体。
;subvec	从开始和结束索引返回子载体。

;1、Clojure vector-of
;创建一个单一基本类型't'的新向量，其中't'是下列之一：int：long：float：double：byte：short：char或：boolean。
; 所得到的向量通常与向量的接口一致，但是存储内部未装箱的值。
;语法
;(vector-of t setofelements)
;参数− 't'是向量元素应该是的类型。 'Setofelements'是向量中包含的元素集。
;返回值 − 所需类型的元素的结果集。
(defn example2 []
  (println (vector-of :int 1 2 3)))
(example2)
(println (str "-----------------------------------------------------------------"))


;2、Clojure Vectors nth
;此函数返回载体中第n个位置的项目。
;语法
;(nth vec index)
;参数− 'vec'是项目的载体。 'index'是需要返回的元素的索引位置。
;返回值 − 载体索引位置的值。
(defn example3 []
  (println (nth (vector 1 2,3) 0))
  (println (nth (vector 1 2,3) 2)))
(example3)
(println (str "-----------------------------------------------------------------"))


;3、Clojure Vectors get
;返回向量中索引位置处的元素。
;语法
;(get vec index)
;参数− 'vec'是向量中的元素集。 'index'是需要返回的索引位置的元素。
;返回值 − 索引位置处的元素值。
(defn example4 []
  (println (get (vector 3 2 1) 2))
  (println (get (vector 3 2 1) 1)))
(example4)
(println (str "-----------------------------------------------------------------"))

;4、Clojure Vectors conj
;向该载体追加一个元素，并返回一组新的载体元素。
;语法
;(conj vec x)
;参数− 'vec'是元素的载体集。 'x'是需要附加到向量中的一组元素的元素。
;返回值 − 返回带有附加元素的新载体。
(defn example5 []
  (println (conj (vector 3 2 1) 5)))
(example5)


;5、Clojure Vectors pop
;对于列表或队列，返回没有第一个项目的新列表/队列，对于载体，返回一个没有最后一个项目的新载体。
;语法
;(pop vec)
;参数− 'vec'是元素的向量集。
;返回值 − 返回没有最后一个项的新载体。
(defn example6 []
  (println (pop (vector 3 2 1))))
(example6)


;6、Clojure Vectors subvec
;从开始和结束索引返回子载体。
;语法
;(subvec vec start end)
;参数− 'vec'是元素的载体集。 'start'是起始索引。 'end'是结束索引。
;返回值 − 返回从开始到结束索引的新载体。
(defn example7 []
  (println (subvec (vector 1 2 3 4 5 6 7) 2 5)))
(example7)