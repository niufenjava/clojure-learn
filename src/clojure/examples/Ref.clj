(ns clojure.examples.Ref)
; # Clojure 参考值 https://www.w3cschool.cn/clojure/clojure_reference_values.html
; > 参考值是另一种方式 Clojure 可以使用需求有可变变量。 Clojure 提供了可变的数据类型，例如 atoms，代理和引用类型。

; * 以下是可用于参考值操作的一些方法:
; 1. ref	这用于创建参考值。 创建引用值时，提供了一个选项来提供验证器函数，该函数将验证创建的值。
; 2. ref-set	此函数用于将引用的值设置为新值，而不管旧值。
; 3. alter	此函数用于更改引用类型的值，但以安全的方式。 这是在一个线程中运行的，它不能被另一个进程访问。
; 4. dosync	在包含表达式和任何嵌套调用的事务中运行表达式（在隐式do中）。
; 5. commute	Commute也用于改变引用类型的值，就像alter和ref-set一样。
(println (str "-----------------------------------------------------------------"))


; ## Clojure ref
; > 这用于创建参考值。 创建参考值时，提供了一个选项来提供验证器函数，该函数将验证创建的值。
;
; * 语法  (ref x options)
;   参数 − 'x'是需要提供给引用的值。 “选项”是可以提供的一组选项，例如validate命令。
;   返回值 − 引用及其对应的值。
;
; * 例
(defn Example []
  (def my-ref (ref 1 :validator pos?))
  (println @my-ref))
(Example)
; > 要访问参考值的值，可以使用@符号。
;
; * 输出
;1
(println (str "-----------------------------------------------------------------"))


; ## Clojure ref-set
; > 此函数用于将引用的值设置为新值，而不管旧值。
;
; * 语法 (ref-set refname newvalue)
;   参数 − 'refname'是保存引用值的变量的名称。 'newvalue'是需要与引用类型相关联的新值。
;   返回值 − 引用及其对应的新值。
;
; * 例
(defn Example []
  (def my-ref (ref 1 :validator pos?))
  (dosync
    (ref-set my-ref 2))
  (println @my-ref))
(Example)
;输出
;2
(println (str "-----------------------------------------------------------------"))


; ## Clojure alter
; > 此函数用于更改引用类型的值，但以安全的方式。 这是在一个线程中运行的，它不能被另一个进程访问。
;   这就是为什么命令需要与一个 'dosync' 方法总是相关联。 其次，要更改引用类型的值，需要调用函数以对该值进行必要的更改。
;
; * 语法 (alter refName fun)
;   参数 − 'refName' 是保存引用值的变量的名称。
;         'fun' 是用于更改引用类型的值的函数。
;   返回值 − 引用及其对应的新值。
;
; * 例
(defn Example []
  (def names (ref []))

  (defn change [newName]
    (dosync
      (alter names conj newName)))
  (change "John")
  (change "Mark"))
(Example)
;输出
;以上示例将输出以下结果:
;
;[John Mark]
(println (str "-----------------------------------------------------------------"))


; ## Clojure dosync
; > 在包含表达式和任何嵌套调用的事务中运行表达式（在隐式do中）。 如果此线程上没有运行，则启动事务。 任何未捕获的异常将中止事务并流出dosync。
;
; * 语法 (dosync expression)
;   参数 − 'expression' 是一组表达式，它们将在dosync块中。
;   返回值 − 无。
;
; * 例
(defn Example []
  (def names (ref []))

  (defn change [newname]
    (dosync
      (alter names conj newname)))
  (change "John")
  (change "Mark")
  (println @names))
(Example)
;输出
;[John Mark]
(println (str "-----------------------------------------------------------------"))


; ## Clojure commute
; > Commute也用于改变引用类型的值，就像alter和ref-set一样。
;   唯一的区别是，这也需要放在一个“dosync”块中。 然而，这可以在无需知道哪个调用进程实际改变了引用类型的值时使用。
;   Commute还使用一个函数来更改引用变量的值。
;
; * 语法  (commute refname fun)
;   参数 − 'refName' 是保存引用值的变量的名称。
;         'fun' 是用于更改引用类型的值的函数。
;   返回值 − 引用及其对应的新值。
;
; * 例
(defn Example []
  (def counter (ref 0))

  (defn change [counter]
    (dosync
      (commute counter inc)))
  (change counter)
  (println @counter)

  (change counter)
  (println @counter))
(Example)
;输出
;1
;2
