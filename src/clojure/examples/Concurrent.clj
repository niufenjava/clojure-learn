(ns clojure.examples.Concurrent)
; # Clojure 并发编程  https://www.w3cschool.cn/clojure/clojure_concurrent_programming.html
; > 在Clojure编程中，大多数数据类型是不可变的，因此当涉及并发编程时，使用这些数据类型的代码在多个处理器上运行时是相当安全的。
;   但是许多次，需要共享数据，并且当涉及多个处理器的共享数据时，有必要确保在使用多个处理器时保持数据的状态的完整性。
;   这被称为并发编程，Clojure提供对这种编程的支持。
;
; > 通过dosync，ref，set，alter等暴露的软件事务存储器系统（STM）支持以同步和协调的方式共享线程之间的变化状态。
;   代理系统支持以异步和独立的方式共享线程之间的变化状态。 原子系统支持以同步和独立的方式共享线程之间的变化状态。
;   而通过def，绑定等暴露的动态var系统支持隔离线程内的变化状态。
;
; ## 其他编程语言也遵循并行编程模型。
; 1. 它们直接引用可以更改的数据。
; 2. 如果需要共享访问，则对象被锁定，值被更改，并且进程继续下一次访问该值。
;
; > 在Clojure中没有锁，但是对不可变持久数据结构的间接引用。
;
; ## Clojure中有三种类型的引用
; 1. Vars -更改在线程中隔离。
; 2. Refs -更改在线程之间进行同步和协调。
; 3. Agents -涉及线程之间的异步独立变化。
;
; ## 事务
; > Clojure中的并发是基于事务。 引用只能在事务中更改。 在事务中应用以下规则。
; 1. 所有的变化都是atomic和孤立的。
; 2. 对引用的每个更改都发生在事务中。
; 3. 没有事务看到另一个事务所造成的影响。
; 4.所有事务都放在dosync块中。
;
; ## dosync
; > 在包含表达式和任何嵌套调用的事务中运行表达式（在隐式do中）。 如果此线程上没有运行，则启动事务。 任何未捕获的异常将中止事务并流出dosync。
;
; * 语法 (dosync expression)
;   参数 - 'expression' 是将在dosync块中出现的一组表达式。
;   返回值 -无。
;
; * 例
(defn Example []
  (def names (ref []))
  (alter names conj "Mark"))
;(Example)
;输出
;上述程序运行时出现以下错误。
;
;Caused by: java.lang.IllegalStateException: No transaction running
;   at clojure.lang.LockingTransaction.getEx(LockingTransaction.java:208)
;   at clojure.lang.Ref.alter(Ref.java:173)
;   at clojure.core$alter.doInvoke(core.clj:1866)
;   at clojure.lang.RestFn.invoke(RestFn.java:443)
;   at clojure.examples.example$Example.invoke(main.clj:5)
;   at clojure.examples.example$eval8.invoke(main.clj:7)
;   at clojure.lang.Compiler.eval(Compiler.java:5424)
;   ... 12 more
; 从错误中，您可以清楚地看到，您不能在不首先启动事务的情况下更改引用类型的值。
;
; 为了使上面的代码工作，我们必须把 alter 命令放置在 dosync 块中，如下面的程序所做。
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
;上述程序产生以下输出。
;输出
;[John Mark]

; * 例
(defn Example []
  (def var1 (ref 10))
  (def var2 (ref 20))
  (println @var1 @var2)

  (defn change-value [var1 var2 newvalue]
    (dosync
      (alter var1 - newvalue)
      (alter var2 + newvalue)))
  (change-value var1 var2 20)
  (println @var1 @var2))
(Example)
; > 在上面的例子中，我们有两个值在dosync块中被改变。 如果事务成功，则两个值都将改变，否则整个事务将失败。
;
;上述程序产生以下输出。
;
;输出
;10 20
;-10 40