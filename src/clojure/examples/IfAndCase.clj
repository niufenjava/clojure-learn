(ns clojure.examples.IfAndCase)
;Clojure 决策
;https://www.w3cschool.cn/clojure/clojure_decision_making.html

;1、Clojure If 声明
;语法 if (condition) statement#1 statement #2
; 在Clojure中，条件是一个表达式，它将其计算为true或false。
; 如果条件为真，则语句＃1将被执行，否则语句＃2将被执行。
; 这个语句的一般工作是首先在'if'语句中计算一个条件。 如果条件为真，它然后执行语句。 下图显示了“if”语句的流程。
;; This program displays Hello World
(defn Example [] (
                   if (= 2 2)
                   (println "Values are equal")
                   (println "Values are not equal")
                   )
  ;上述程序的输出将是“Values are equal”。 在上面的代码示例中，'if'条件用于评估2和2的值是否相等。 如果它们是，则它将打印“值相等”的值，否则它将打印“值不相等”的值。
  )
(Example)

;2、Clojure - If/do 表达式
;Clojure中的'if-do'表达式用于允许为'if'语句的每个分支执行多个表达式。
; 我们已经在Clojure的经典的“if”语句中看到，你可以只有两个语句，一个是真正的部分，另一个是真的部分。
; 但是'if-do'表达式允许你使用多个表达式。 下面是'if-do'表达式的一般形式。
;; This program displays Hello World
(defn Example2 [] (
                    if (= 2 2)
                    (do (println "Both the values are equal")
                        (println "true"))
                    (do (println "Both the values are not equal")
                        (println "false"))))
(Example2)
;在上述示例中，'if'条件用于评估2和2的值是否相等。
; 如果它们是，则它将打印“值相等”的值，此外，我们正在打印值“true”，否则将打印“值不相等”的值和“假”的值。


;3、Clojure If 嵌套
;有时需要有多个“if”语句嵌入在彼此之内，这在其他编程语言中是可能的。
; ，在评估多个表达式时，可以使用逻辑“and”。
;语法：if(and condition1 condition2) statement #1 statement #2
;; This program displays Hello World
(defn Example3 [] (
                    if (and (= 2 2) (= 3 3))
                    (println "Values are equal")
                    (println "Values are not equal")))
(Example3)

;4、Clojure Case 声明
;Clojure提供了类似于Java编程语言中可用的“switch”语句的“case”语句。 下面是case语句的一般形式。
;case expression
;value1 statement #1
;value2 statement #2
;valueN statement #N
;statement #Default
;; This program displays Hello World
(defn Example4 []
  (def x 5)
  (case x 5 (println "x is 5")
          10 (println "x is 10")
          (println "x is neither 5 nor 10")))
(Example4)
;在上面的例子中，我们首先将一个变量'x'初始化为一个值5.然后我们有一个'case'语句来评估变量'x'的值。
; 基于变量的值，它将执行相关语句集的语句。 如果没有执行前面的语句，则最后一个语句是默认语句。

;5、Clojure Cond 声明
;Clojure提供了另一个评估语句，称为“cond”语句。 此语句接受一组测试/表达式对。 它一次评估每个测试。
; 如果测试返回逻辑true，“cond”将计算并返回相应表达式的值，并且不会评估任何其他测试或表达式。 'cond'返回nil。
;; This program displays Hello World
(defn Example5 []
  (def x 5)
  (cond
    (= x 5) (println "x is 5")
    (= x 5) (println "x is 5")
    (= x 10) (println "x is 10")
    :else (println "x is not defined")))
(Example5)