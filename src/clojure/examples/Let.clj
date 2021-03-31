(ns clojure.examples.Let)
; # Clojure 解构 https://www.w3cschool.cn/clojure/clojure_destructuring.html
; > 解构是Clojure中的一个功能，它允许从数据结构（如向量）中提取值，并将它们绑定到符号，而不必显式地遍历数据结构。
;
;让我们看一个例子，说明Destructuring是什么意思，以及它是如何发生的。
(defn Example []
  (def my-vector [1 2 3 4])
  (let [[a b c d] my-vector]
    (println a b c d)))
(Example)
;在上面的例子中，需要注意以下几点：
; 1. 我们定义一个整数的向量为1，2，3和4。
; 2. 然后我们使用 'let' 语句直接将4个变量（a，b，c和d）分配给my-vector变量。
; 3. 如果我们对四个变量运行 'println' 语句，我们可以看到它们已经被分配给向量中的值。
;所以clojure解构了my-vector变量，当使用 'let' 语句赋值时，它有四个值。 然后将解构的四个值相应地分配给四个参数。
(println (str "----------------------- Example END ------------------------------------------"))

; ## 如果有过多的变量没有可以分配给它们的对应值，那么它们将被赋值为nil。
; 以下示例说明了这一点。
(defn Example2 []
  (def my-vector [1 2 3 4])
  (let [[a b c d e] my-vector]
    (println a b c d e)))
(Example2)
;上述程序产生以下输出。 你可以从输出中看到，因为最后一个变量'e'在向量中没有对应的值，它占了nil。
(println (str "----------------------- Example2 End ------------------------------------------"))



; ## 其余的部分
; > 'the-rest' 变量用于存储剩余的值，不能分配给任何变量。
;下面的程序显示了如何使用它的示例。
;例
(defn Example3 []
  (def my-vector [1 2 3 4])
  (let [[a b & the-rest] my-vector]
    (println a b the-rest)))
(Example3)
;上述程序产生以下输出。 从输出中，可以清楚地看到3和4的值不能分配给任何变量，因此它们被分配给'-rest'变量。
(println (str "----------------------- Example3 END ------------------------------------------"))

; ## 解构 map
; > 就像矢量一样，mao也可以被解构。
;
; * 例
(defn Example4 []
   (def myMap {"a" 1 "b" 2})
   (let [{a "a" b "b"} myMap]
   (println a b)))
(Example4)
;上述程序产生以下输出。 从程序中可以清楚地看到“a”和“b”的映射值被分配给a和b的变量。
(println (str "----------------------- Example4 END ------------------------------------------"))


;类似地，在向量的情况下，如果在解构发生时在映射中没有对应的值，则变量将被赋值为nil。
;下面是一个例子。
;例
(defn Example5 []
   (def my-map {"a" 1 "b" 2})
   (let [{a "a" b "b" c "c"} my-map]
   (println a b c)))
(Example5)
(println (str "----------------------- Example5 END ------------------------------------------"))