(ns clojure.examples.Set
  (:require [clojure.set :as set])
  (:gen-class))
;Clojure 集合
;Clojure中的集合是一组唯一值。在Clojure中借助set命令创建集合。
;例
;下面是在Clojure中创建集合的一个例子。
(defn example []
  (println (set '(1 1 2 2))))
(example)
(println (str "-----------------------------------------------------------------"))

;以下是Clojure的可套的方法。
;sorted-set	  返回一组有序的元素。
;get	        返回索引位置处的元素。
;contains 	  找出集合是否包含某个元素。
;conj	        将一个元素附加到集合并返回新的元素集。
;disj	        分离集合中的元素。
;union	      分离集合中的元素。
;difference	  返回一个没有剩余集合的元素的第一个集合。
;intersection 	返回一组是输入集的交集。
;sunset	      set1是set2的一个子集吗？
;superset 	  set1是set2的一个超集吗？


;2、Clojure sorted-set   返回一组有序的元素。
;语法
;(sorted-set setofelements)
;参数− 'setofelements'是需要排序的元素的集合。
;返回值 − 排序的元素集。
((defn example2
   "参数说明"
   []
   (println (sorted-set 3 2 1))
   ))
(println (str "-----------------------------------------------------------------"))

;3、Clojure get 返回索引位置处的元素
;语法
;(get setofelements index)
;参数− 'setofelements'是元素的集合。 'index'是索引位置的元素，需要返回。
;返回值 − 索引位置处的元素的值。
(defn example3 []
  (println (get (set '(3 2 1)) 2))
  (println (get (set '(3 2 1)) 1)))
(example3)
(println (str "-----------------------------------------------------------------"))

;4、Clojure contains  找出集合是否包含某个元素。
;语法
;(contains? setofelements searchelement)
;参数 − 'setofelements'是元素的集合。 'Searchelement'是需要在列表中搜索的元素。
;返回值 − 如果元素存在于集合中则返回true，如果元素不存在则返回false。
(defn example4 []
  (println (contains? (set '(3 2 1)) 2))
  (println (contains? (set '(3 2 1)) 5)))
(example4)
(println (str "-----------------------------------------------------------------"))

;5、Clojure conj  将一个元素附加到集合并返回新的元素集。
;语法
;(conj setofelements x)
;参数− 'setofelements'是元素的集合。 'x'是需要附加到元素集合的元素。
;返回值 − 返回带有附加元素的新集合。
(defn example5 []
  (println (conj (set '(3 2 1)) 5))
  )
(example5)
(println (str "-----------------------------------------------------------------"))


;6、Clojure disj   分离集合中的元素。
;语法
;以下是disj的基本使用语法:
;(disj setofelements x)
;参数− 'setofelements'是元素的集合。 'x'是需要从集合中删除的元素。
;返回值 − 返回具有已删除元素的新集合。
(defn example6 []
  (println (disj (set '(3 2 1)) 2))
  )
(example6)
(println (str "-----------------------------------------------------------------"))


;7、Clojure union  合并集合中的元素。
;语法
;(union set1 set2)
;参数− 'set1'是第一组元素。 'set2'是第二组元素。
;返回值 − 连接的元素集。
;在上面的示例中，您必须使用require语句来包含包含union方法的clojure.set类。
(defn example7 []
  (println (set/union #{1 2} #{3 4})))
(example7)
(println (str "-----------------------------------------------------------------"))

;8、Clojure difference
;返回一个没有剩余集合的元素的第一个集合。
;语法
;(difference set1 set2)
;参数− 'set1'是第一组元素。 'set2'是第二组元素。
;返回值 − 元素集之间的差异。
(defn example8 []
  (println (set/difference #{1 2} #{2 3})))
(example8)
(println (str "-----------------------------------------------------------------"))


;9、Clojure intersection
;返回一组是输入集的交集。
;语法
;(intersection set1 set2)
;参数− 'set1'是第一组元素。 'set2'是第二组元素。
;返回值 − 不同的元素集之间的交集。
(defn example9 []
  (println (set/intersection #{1 2} #{2 3})))
(example9)
(println (str "-----------------------------------------------------------------"))

;10、Clojure subset?
;判断set1是否为set2的一个子集
;语法
;以下是subset的基本使用语法:
;(subset? set1 set2)
;参数− 'set1'是第一组元素。 'set2'是第二组元素。
;返回值 − 如果set1是set2的子集，则为True，否则为false。
(defn example10 []
  (println (set/subset? #{1 2} #{2 3}))
  (println (set/subset? #{1 2} #{1 2 3})))
(example10)
(println (str "-----------------------------------------------------------------"))

;11、Clojure superset?
;判断set1是否为set2的超集
;语法
;以下是superset的基本使用语法:
;(superset? set1 set2)
;参数− 'set1'是第一组元素。 'set2'是第二组元素。
;返回值 − 如果set1是set2的超集，则为true，否则为false。
(defn example11 []
  (println (set/superset? #{1 2} #{1 2 3}))
  (println (set/superset? #{1 2 3} #{1 2})))
(example11)
(println (str "-----------------------------------------------------------------"))