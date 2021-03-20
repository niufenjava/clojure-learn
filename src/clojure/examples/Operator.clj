(ns clojure.examples.Operator)
;; This program displays Hello World
;https://www.w3cschool.cn/clojure/clojure_operators.html
;算术运算符
(defn Example []
  (def x (+ 2 2))
  ;4
  (println x)

  (def x (- 2 1))
  ;1
  (println x)

  ;4
  (def x (* 2 2))
  (println x)

  ;2.0
  (def x (float (/ 2 1)))
  (println x)

  ;3
  (def x (inc 2))
  (println x)

  ;1
  (def x (dec 2))
  (println x)

  ;3
  (def x (max 1 2 3))
  (println x)

  ;1
  (def x (min 1 2 3))
  (println x)

  ;
  (def x (rem 3 2))
  (println x))
(Example)


;关系运算符
;; This program displays Hello World
(defn Example []
  (def x (= 2 2))
  (println x)

  (def x (not= 3 2))
  (println x)

  (def x (< 2 3))
  (println x)

  (def x (<= 2 3))
  (println x)

  (def x (> 3 2))
  (println x)

  (def x (>= 3 2))
  (println x))
(Example)

;逻辑运算符
;; This program displays Hello World
(defn Example []
  (def x (or true true))
  (println x)

  (def x (and true false))
  (println x)

  (def x (not true))
  (println x))
(Example)

;位运算符
;; This program displays Hello World
(defn Example []
  (def x (bit-and 00111100 00001101))
  (println x)

  (def x (bit-or 00111100 00001101))
  (println x)

  (def x (bit-xor 00111100 00001101))
  (println x))
(Example)
;与LISP一般情况一样，没有必要担心运算符优先级。 这是S表达式和前缀符号的好处之一。 所有函数从左到右和从内到外。 Clojure中的运算符只是函数，并且一切都完全括起来。