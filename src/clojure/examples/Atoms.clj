(ns clojure.examples.Atoms)
; # Clojure Atoms  https://www.w3cschool.cn/clojure/clojure_atoms.html
; > Atoms 是 Clojure 中的一种数据类型，它提供了一种管理共享，同步，独立状态的方法。
; > Atoms 就像任何其他编程语言中的任何引用类型。
; > Atoms 的主要用途是保存 Clojure 的不可变数据结构。 Atoms 保持的值随 swap! 方法改变而改变。
;
; 内部，swap!读取当前值，对其应用函数，并尝试对其进行比较和设置。
; 由于另一个线程可能在中间时间中更改了值，因此可能必须重试，并在自旋循环中执行。
; 净效果是该值将始终是将所提供的函数应用于当前值的Atoms结果。
;
; ## 例
; > Atoms是在 atom 方法的帮助下创建的。 以下程序中显示了相同的示例。
(defn example []
  (def myatom (atom 1))
  (println @myatom))
(example)

; ## atom 的值通过使用@符号访问。 Clojure有一些可以对原子执行的操作。 以下是操作。
; 1. reset!	将atom的值设置为新值，而不考虑当前值。
; 2. compare-and-set!	当且仅当原子的当前值与原子保持的旧值相同时，以原子方式将atom的值设置为新值。 返回true如果设置发生，否则返回false。
; 3. swap!	根据特定的函数，用一个新的Atoms交换原值。