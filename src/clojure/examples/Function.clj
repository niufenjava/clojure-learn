(ns clojure.examples.Function)
; Clojure 函数

;1、Clojure 定义函数
; 函数通过使用 defn 宏来定义。 以下是函数定义的一般语法。
; 语法
;(defn functionname
;   “optional documentation string”
;   [arguments]
;   (code block))

;; This program displays Hello World
(defn Example []
  (def x 1)
  (def y 1.25)
  (def str1 "Hello")
  (println x)
  (println y)
  (println str1))
(Example)

;2、Clojure 匿名函数
;匿名函数是没有与其相关联的名称的函数。 以下是匿名函数的示例。
;; This program displays Hello World
(defn Example2 []
  ((fn [x] (* 2 x)) 2))
(Example2)


;3、Clojure 多参函数
;Clojure函数可以用零个或多个参数定义。 传递给函数的值称为参数，参数可以是任何类型。
; 参数的数量是函数的arity。 本章讨论了具有不同arity的一些函数定义。
;在以下示例中，函数demo使用每个函数定义的多个参数定义。
(defn demo [] (* 2 2))
(defn demo1 [x] (* 2 x))
(defn demo2 [x y] (* 2 x y))
;在上面的例子中，第一个函数定义是一个0元函数，因为它有0个争论，一个参数是1-arity，两个参数是2-arity等等。
(println (demo2 1 2))


;4、Clojure 可变函数
;变量函数是采用不同数量参数的函数（一些参数是可选的）。 函数还可以指定“＆”符号符号以接受任意数量的参数。
;下面的例子显示了如何实现这一点。
(defn demo3
  [message & others]
  ;'clojure.string / join'用于组合每个单独的字符串参数，它被传递给函数。
  (str message (clojure.string/join " " others)))
;上面的函数声明在参数other的旁边有'＆'符号，这意味着它可以接受任意数量的参数。
;如果你调用上面的函数as
(println (demo3 "Hello" "This" "is" "the" "message"))


;5、Clojure 高阶函数
;高阶函数（HOF）是将其他函数作为参数的函数。
; HOF的一个示例是接受函数和集合并返回满足条件（谓词）的元素的集合的函数。 在Clojure中，这个函数称为clojure.core / filter
(println (filter even? (range 0 10)))

