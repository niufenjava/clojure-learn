(ns clojure.examples.Predicates)
; # Clojure Predicates https://www.w3cschool.cn/clojure/clojure_predicates.html
; > Predicates是评估条件并提供true或false值的函数。
;   我们已经在数字一章的例子中看到了Predicates函数。
;   我们已经看到像“even?”这样的函数，用于测试数字是否为偶数，或者“neg？”，用于测试数字是否大于零。 所有这些函数返回true或false值。
;
; ## 下面是 Clojure中Predicates的使用示例:
;; This program displays Hello World
(defn Example []
  (def x (even? 0))
  (println x)

  (def x (neg? 2))
  (println x)

  (def x (odd? 3))
  (println x)

  (def x (pos? 3))
  (println x))
(Example)


;## 除了正常的Predicates函数，Clojure还为Predicates提供了更多的函数。
; 以下方法可用于Predicates:
; 1. every-pred	采用一组Predicates，并返回一个函数'f'，如果所有的组合Predicates对其所有参数返回一个逻辑真值，则返回true，否则返回false。
; 2. every	如果Predicates对于每个值为true，则返回true，否则返回false。
; 3. some	返回值集合中任何Predicates值x的第一个逻辑真值。
; 4. not-any	如果集合中的值的任何Predicates在逻辑上为真，则返回false，否则为true。