;(ns namespace-name)
;用于创建一个新的命名空间并将其与正在运行的程序相关联。
(ns clojure.examples.Namespace
  (:require [clojure.set :as set])
  (:gen-class))
;Clojure 命名空间
;Clojure中的命名空间用于将类区分为单独的逻辑空间，就像在Java中一样。 考虑下面的语句。
; (:require [clojure.set :as set])
; 在上面的语句中，“clojure.set”是一个命名空间，它包含了在程序中使用的各种类和方法。
; 例如，上述命名空间包含称为map-invert的函数，用于反转键值映射。 我们不能使用这个函数，除非我们明确告诉我们的程序包含这个命名空间。
;
;用于命名空间的不同方法:
;*ns*	    这用于查看当前的命名空间。
;ns	      这用于创建一个新的命名空间并将其与正在运行的程序相关联。
;alias	  这用于创建一个新的命名空间并将其与正在运行的程序相关联。
;all-ns	  返回所有命名空间的列表。
;find-ns	查找并返回特定的命名空间。
;ns-name	返回特定命名空间的名称。
;ns-aliases	返回与任何命名空间关联的别名。
;ns-map	  返回命名空间的所有映射的映射。
;un-alias	返回仅包含键在键中的地图中的条目的地图。


;1、Clojure *ns*   查看当前的命名空间。
;语法
;(*ns*)
;参数 − 无。
;返回值 − 返回当前正在执行的程序的命名空间。
(defn example1 []
  (println *ns*)
  )
(example1)
(println (str "-----------------------1------------------------------------------"))



;2、Clojure alias
;将当前命名空间中的别名添加到另一个命名空间。 参数有两个符号：要使用的别名和目标命名空间的符号名称。
;语法
;(alias aliasname namespace-name)
;参数− 'aliasname'是需要与命名空间相关联的别名。 'namespace-name'是与正在运行的程序相关联的命名空间。
;返回值 − 无。
(defn example2 []
  (alias 'string 'clojure.examples.Namespace))
(println 'string)
(example2)
(println (str "-------------------------2----------------------------------------"))


;3、Clojure all-ns   返回所有命名空间的列表
;语法
;(all-ns)
;参数− 无
;返回值 − 所有命名空间的列表。
(defn example3 []
  (println (all-ns)))
(example3)
(println (str "--------------------------3---------------------------------------"))


;4、Clojure find-ns   查找并返回特定的命名空间
;语法
;(find-ns namespace-name)
;参数− 'namespace-name'是需要找到的命名空间。
;返回值 − 命名空间（如果存在）。
(defn example4 []
  (println (find-ns 'clojure.string)))
(example4)
(println (str "---------------------4--------------------------------------------"))


;5、Clojure ns-aliases
;返回与任何命名空间关联的别名。
;语法
;以下是 ns-aliases 的基本使用语法:
;(ns-aliases namespace-name)
;参数− 'namespace-name'是需要找到的命名空间。
;返回值 − 返回与任何命名空间关联的别名。
(defn example5 []
  (println (ns-aliases 'clojure.core)))
(example5)
(println (str "-------------------------5----------------------------------------"))



;6、Clojure ns-map    返回命名空间的所有映射的映射
;语法
;(ns-map namespace-name)
;参数− 'namespace-name'是需要找到的命名空间。
;返回值 − 返回命名空间的所有映射的映射。
(defn example6 []
  ;count方法用于提供返回的映射的总数。
  (println (count (ns-map 'clojure.core))))
(example6)
(println (str "-----------------------------------------------------------------"))

;7、Clojure un-alias   从命名空间中删除符号的别名
;语法
;下面是 *ns* 的使用示例:
;(un-alias namespace-name aliasname)
;参数− 'namespace-name'是附加到别名的命名空间。 'aliasname'是映射到命名空间的别名。
;返回值 − 从命名空间中删除别名。
(defn example7 []
  (alias 'string2 'clojure.core)
  (ns-unalias 'clojure.core 'string2))
(example7)