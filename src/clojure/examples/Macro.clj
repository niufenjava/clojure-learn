(ns clojure.examples.Macro)
; Clojure 宏  https://www.w3cschool.cn/clojure/clojure_macros.html
; > 在任何语言中，宏都用于生成内联代码。
;   宏用于编写代码生成例程，它为开发人员提供了一种强大的方法来根据开发人员的需要定制语言。
;
; ## defmacro
; > 此函数用于定义宏。 宏将具有宏名称，参数列表和宏的主体。
;
; * 语法  (defmacro name [params*] body)
;   参数 - 'name' 是宏的名称。
;         'params' 是分配给宏的参数。
;          “body” 是宏的主体。
;   返回值 -无。
;
; * 例
(defn Example []
  (defmacro Simple []
    (println "Hello"))
  (macroexpand '(Simple)))
(Example)
; * 输出
;Hello
; > 从上面的程序，你可以看到宏“简单”扩展到“println”“你好”。 宏类似于函数，唯一的区别是在宏的情况下，对表单的参数进行求值。
(println (str "-----------------------------------------------------------------"))


; ## 扩展宏
; > 这用于扩展宏并将代码放入程序中。
;
; * 语法 (macroexpand macroname)
;   参数 - 'macroname'是需要扩展的宏的名称。
;   返回值 -扩展的宏。
;
; * 例
(defn Example []
  (defmacro Simple []
    (println "Hello"))
  (macroexpand '(Simple)))
(Example)
;输出
;Hello
(println (str "-----------------------------------------------------------------"))



; ## 宏与参数
; > 宏也可以用于接受参数。 宏可以接受任意数量的参数。 下面的示例展示如何使用参数。
(defn Example []
  (defmacro Simple [arg]
    (list 2 arg))
  (println (macroexpand '(Simple 2))))
(Example)
; > 上面的示例在Simple宏中放置一个参数，然后使用参数将参数值添加到列表中。
;
; * 输出
;(2 2)