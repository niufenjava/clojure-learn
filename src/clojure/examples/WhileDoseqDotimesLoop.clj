(ns clojure.examples.WhileDoseqDotimesLoop)

; While 语句
;; This program displays Hello World
(defn Example []
  ;首先将“x”变量的值初始化为1.注意，我们使用的是atom值，它是一个可以修改的值
  (def x (atom 1))
  ;while循环中的条件是我们计算表达式的条件，例如'x'应该小于5.直到'x'的值小于5，
  (while (< @x 5)
    (do
      ;打印'x' '然后增加其值
      (println @x)
      ;swap语句用于使用新的递增值填充'x'的atom变量。
      (swap! x inc))))
(Example)


; doseq 语句
; doseq语句类似于在许多其他编程语言中找到的 for each 语句。
; doseq语句基本上用于对序列进行迭代。
;; This program displays Hello World
(defn Example2 []
  ;doseq语句来迭代分配给变量n的值0,1和2的序列
  (doseq [n [0 1 2]]
    (println n)))
(Example2)

;Clojure Dotimes 循环
;dotimes 语句用于执行语句“x”次。
;; This program displays Hello World
(defn Example3 []
  (dotimes [n 5]
    ;使用dotimes语句来重复执行println语句的次数。 并且对于每次迭代它也增加变量n的值。
    (println n)))
(Example3)

;Clojure Loop 循环
;'Loop循环'特殊形式不像'for'循环。 循环的用法与let绑定相同。
; 但是，Loop循环设置了递归点。 递归点被设计为与递归一起使用，这意味着Loop循环总是与递归一起使用。
; 要使循环发生，为Loop循环指定的参数（arity）的数量必须与循环的绑定数量一致。 这样，recur回到循环。
;; This program displays Hello World
(defn Example []
  (loop [x 10]
    (when (> x 1)
      (println x)
      (recur (- x 2)))))
(Example)
;在上面的例子中，我们首先使用loop语句将'x'的值绑定到10。 然后我们使用when条件子句来查看'x'的值是否小于1.然后我们将'x'的值打印到控制台，并使用recur语句重复循环。 在“x”的值减少2之后重复循环。


;Clojure 递归
;我们已经在前面的主题中看到了recur语句，而'for'循环有点像一个循环，recur是Clojure中的一个真正的循环。
;这个循环特殊形式是实现尾递归的形式。
; 如“尾递归”一词所示，recur必须在尾部位置调用。 换句话说，recur必须是最后一个要评估的东西。
;recur语句的最简单的例子在'for'循环中使用。 在以下示例中，recur语句用于更改变量“i”的值，并将变量的值反馈回循环表达式。
;例
;; This program displays Hello World
(defn Example10 []
  (loop [i 0]
    (when (< i 5)
      (println i)
      (recur (inc i)))))
(Example10)





