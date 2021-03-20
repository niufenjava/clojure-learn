(ns clojure.examples.basic)
; 基本数据类型
;; This program displays Hello World
(defn Example []
  ;; The below code declares a integer variable
  (def x 1)

  ;; The below code declares a float variable
  (def y 1.25)

  ;; The below code declares a string variable
  (def str1 "Hello")
  (println x)
  (println y)
  (println str1))
(Example)

;变量
;; This program displays Hello World
(defn Example2 []
  ;; The below code declares a integer variable
  (def x 1)

  ;; The below code declares a float variable
  (def y 1.25)

  ;; The below code declares a string variable
  (def str1 "Hello")

  ;; The below code declares a boolean variable
  (def status true))
(Example2)

;变量命名的例子
;; This program displays Hello World
(defn Example3 []
  ;; the below code declares a boolean variable with the name of status
  (def status true)

  ;; The below code declares a Boolean variable with the name of STATUS
  (def STATUS false)

  ;; The below code declares a variable with an underscore character.
  (def _num1 2))
(Example3)


;打印变量
;; This program displays Hello World
(defn Example4 []
  ;; The below code declares a integer variable
  (def x 1)

  ;; The below code declares a float variable
  (def y 1.25)

  ;; The below code declares a string variable
  (def str1 "Hello")
  (println x)
  (println y)
  (println str1))
(Example4)



;Clojure Numbers  https://www.w3cschool.cn/clojure/clojure_numbers.html
;Clojure中的 Numbers 数据类型派生自Java类。
;Clojure的Numbers类型支持整型和浮点型。
;整型是不包含分数的值。
;浮点型是包含小数部分的十进制值。
(def x 5)
(def y 5.25)
;其中“x”的类型为整型，“y”为浮点型。
;; This program displays Hello World
(defn Example5 []
  (def x 5)
  (def y 5.25)
  (println (type x))
  (println (type y)))
(Example5)
;'type'命令用于输出与分配给变量的值相关联的类。


;Clojure zero  https://www.w3cschool.cn/clojure/clojure_zero.html
;如果数字为零，则返回true，否则返回false。
;语法： (zero? number)
;; This program displays Hello World
(defn Example6 []
  (def x (zero? 0))
  (println x)

  (def x (zero? 0.0))
  (println x)

  (def x (zero? 1))
  (println x))
(Example6)



;Clojure pos  https://www.w3cschool.cn/clojure/clojure_pos.html
;如果number大于零，则返回true，否则返回false。
;语法：(pos? number)
;; This program displays Hello World
(defn Example7 []
  (def x (pos? 0))
  (println x)

  (def x (pos? -1))
  (println x)

  (def x (pos? 1))
  (println x))
(Example7)


;Clojure neg
;如果number小于零，则返回true，否则返回false。
;语法:
;(neg? number)
;; This program displays Hello World
(defn Example8 []
  (def x (neg? -1))
  (println x)

  (def x (neg? 0))
  (println x)

  (def x (neg? 1))
  (println x))
(Example8)


;Clojure even
;如果数字是偶数，则返回true，如果数字不是整数，则抛出异常。
;语法: (even? number)
;例:
(defn Example9 []
  (def x (even? 0))
  (println x)

  (def x (even? 2))
  (println x)

  (def x (even? 3))
  (println x))
(Example9)


;Clojure odd
;如果数字为奇数，则返回true，如果数字不是整数，则抛出异常。
;语法
;(odd? number)
;; This program displays Hello World
(defn Example10 []
  (def x (odd? 0))
  (println x)

  (def x (odd? 2))
  (println x)

  (def x (odd? 3))
  (println x))
(Example10)



;Clojure number
;如果数字真的是一个数字，返回true。
;语法:
;(number? number)
;例
;; This program displays Hello World
(defn Example11 []
  (def x (number? 0))
  (println x)

  (def x (number? 0.0))
  (println x)

  (def x (number? :a))
  (println x))
(Example11)


;Clojure integer \  Clojure float
;如果数字是整数，则返回true。
;
;语法: (integer? number)
;; This program displays Hello World
(defn Example12 []
  (def x (integer? 0))
  (println x)

  (def x (integer? 0.0))
  (println x))
(Example12)