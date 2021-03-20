;命名空间用于定义在 Clojure 中定义的模块之间的逻辑边界。
(ns clojure.examples.hello
  (:gen-class))

;'defn' 关键字用于定义一个函数
(defn hello-world []
  ;使用'println'语句将“hello world”打印到控制台输出。
  (println "hello world"))

;调用 hello-world 函数，它又运行 'println' 语句
(hello-world)

(defn example []
  ;'str'是用于连接两个字符串的运算符。 字符串“Hello”和“World”用作参数。
  (println (str "hello" " " "world"))

  ;+运算符就像Clojure中的一个函数，用于添加数字。 1和2的值称为函数的参数。
  (println (+ 1 2))
  )
(example)


;加载 Clojure 包
;Clojure 代码封装在库中。 每个 Clojure 库都属于一个命名空间，类似于 Java 包。 您可以使用 'Require' 语句加载 Clojure 库
;(require clojure.java.io)
;(require clojure.java.io)
;(defn Example []
;  (.exists (file "Example.txt")))
;(Example)


;空格
;空格可以在 Clojure 中用于拆分语句的不同组件，这样可以让代码更加的清晰。也可以和逗号 (,) 运算符一起使用。
;例如，以下两个语句是等效的，并且两个语句的输出将是 15。
;尽管 Clojure 忽略逗号，但逗号的使用让程序更便于阅读。
(println (+ 1 2 3 4 5))
(println (+ 1, 2, 3, 4, 5))