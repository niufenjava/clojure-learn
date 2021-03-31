(ns clojure.examples.Map
  (:require [clojure.set :as set])
  (:gen-class))

;Clojure Maps   https://www.w3cschool.cn/clojure/clojure_maps.html
;映射是将键映射到值的集合。提供了两种不同的映射类型 - 哈希和排序。
; HashMaps 需要正确支持hashCode和equals的键。 SortedMaps 需要实现可比较的键或比较器的实例。
;
;可以通过两种方式创建映射，第一种是通过哈希映射方法。
;
;1、创建 - HashMaps
;HashMaps具有典型的键值关系，并通过使用哈希映射函数创建。
(defn example []
  (def demoKeys (hash-map "z" "1" "b" "2" "a" "3"))
  (println demoKeys))
(example)
(println (str "-----------------------------------------------------------------"))


;2、创建 - SortedMaps
;SortedMaps 具有根据关键元素对元素进行排序的独特特性。以下的示例显示如何使用sorted-map函数创建排序的映射。
(defn example2 []
  (def demoKeys (sorted-map "z" "1" "b" "2" "a" "3"))
  (println demoKeys))
(example2)
(println (str "-----------------------------------------------------------------"))

;Map 的方法。
; get         返回映射到键的值, 如果键不存在, 则为未找到或零。
; contains    查看映射是否包含必需的键。
; find        返回键的映射项。
; keys        返回映射中的键列表。
; vals        返回该图的值的列表。
; dissoc      从映射中分离键值项。
; merge       将两个映射项合并为一个单独的映射项。
; merge-with  返回一个映射，其中包含第一个映射的其余映射。
; select-keys 返回仅包含映射中的键的项的映射。
; rename-keys 将当前HashMap中的键重命名为新定义的。
; map-invert  反转映射, 使这些值成为键, 反之亦然。


;3、Clojure Maps get   返回映射到键的值, 如果键不存在, 则为未找到或零。
;语法
;(get hmap key)
;参数 - 'hmap'是哈希键和值的映射。'key'是需要返回值的键。
;返回值 - 返回传递给get函数的键的值。
(defn example3 []
  (def demoKeys (hash-map "z" "1" "b" "2" "a" "3"))
  (println demoKeys)
  (println (get demoKeys "b")))
(example3)
(println (str "-----------------------------------------------------------------"))


;4、Clojure Maps contains    查看映射是否包含必需的键
;语法
;(contains hmap key)
;参数 - 'hmap'是哈希键和值的映射。‘key’是需要在映射中搜索的键。
;返回值 - 如果键存在，则返回true，否则返回false。
(defn example4 []
  (def demoKeys (hash-map "z" "1" "b" "2" "a" "3"))
  (println (contains? demoKeys "b"))
  (println (contains? demoKeys "x")))
(example4)
(println (str "-----------------------------------------------------------------"))


;5、Clojure Maps find   返回键的映射项。
;语法
;(find hmap key)
;参数 - 'hmap'是哈希键和值的映射。'key'是需要在映射中搜索的键。
;返回值 - 返回所需键的键值对，否则返回零。
(defn example5 []
  (def demoKeys (hash-map "z" "1" "b" "2" "a" "3"))
  (println demoKeys)
  (println (find demoKeys "b"))
  (println (find demoKeys "x")))
(example5)
(println (str "-----------------------------------------------------------------"))

;6、Clojure Maps keys  返回映射中的键列表
;语法
;(keys hmap)
;参数 - 'hmap'是哈希键和值的映射。
;返回值 - 返回映射中的键列表。
(defn example6 []
  (def demoKeys (hash-map "z" "1" "b" "2" "a" "3"))
  (println (keys demoKeys)))
(example6)
(println (str "-----------------------------------------------------------------"))


;7、Clojure Maps vals   从映射中分离键值项。
;语法
;(vals hmap)
;参数 - 'hmap'是哈希键和值的映射。'key'是需要与HashMap分离的键。
;返回值 - 返回具有分离键的映射。
(defn example7 []
  (def demoKeys (hash-map "z" "1" "b" "2" "a" "3"))
  (println (vals demoKeys)))
(example7)
(println (str "-----------------------------------------------------------------"))



;8、Clojure Maps dissoc   从映射中分离键值项。
;语法
;(dissoc hmap key)
;参数 - 'hmap'是哈希键和值的映射。'key'是需要与HashMap分离的键。
;返回值 - 返回具有解离键的地图。
(defn example8 []
  (def demoKeys (hash-map "z" "1" "b" "2" "a" "3"))
  (println (dissoc demoKeys "b")))
(example8)
(println (str "-----------------------------------------------------------------"))


;9、Clojure Maps merge   将两个映射项合并为一个单独的映射项。
;语法
;(merge hmap1 hmap2)
;参数 - 'hmap1'是哈希键和值的映射。'hmap2'是哈希键和值的映射，需要使用第一个HashMap进行映射。
;返回值 - 返回hasmap1和hasmap2的组合HashMap。
(defn example9 []
  (def demoKeys (hash-map "z" 1 "b" 2 "a" 3))
  (def demoKeys1 (hash-map "a" 2 "h" 5 "i" 7))
  (println (merge-with + demoKeys demoKeys1)))
(example9)
(println (str "-----------------------------------------------------------------"))


;10、Clojure Maps merge-with
;返回一个映射，其中包含第一个映射的其余映射。如果一个键出现在多个映射中, 则后者的映射 (从左向右) 将与结果中的映射组合在一起。
;语法
;(merge-with f hmap1 hmap2)
;参数 - 'f'是需要应用于哈希映射的运算符。'hmap1'是哈希键和值的映射。'hmap2'是哈希键和值的映射，需要使用第一个HashMap进行映射。
;返回值 - 返回由第一个映射结合的其余映射组成的映射。
(defn example10 []
  (def demokeys (hash-map "z" 1 "b" 2 "a" 3))
  (def demokeys1 (hash-map "a" 2 "h" 5 "i" 7))
  (println (merge-with + demokeys demokeys1)))
;请注意，在输出中，由于键“a”出现两次，所以根据运算符+从HashMaps添加该值。
(example10)
(println (str "-----------------------------------------------------------------"))


;11、Clojure Maps select-keys   返回仅包含映射中的键的项的映射
;语法
;(select-keys hmap keys)
;参数 - 'hmap'是哈希键和值的映射。'keys'是需要从HashMap中选择的键列表。
;返回值 - 根据键的select子句从映射返回键。
(defn example12 []
  (def demokeys (hash-map "z" 1 "b" 2 "a" 3))
  (def demokeys2 (select-keys demokeys ["z" "a"]))
  (println demokeys2))
(example12)
(println (str "example12-----------------------------------------------------------------"))


;12、Clojure Maps rename-keys
;将当前HashMap中的键重命名为新定义的。
;语法
;(rename-keys hmap keys)
;参数 - 'hmap'是哈希键和值的映射。'key'是需要在映射中替换的新的键列表。
;返回值 - 返回带有新的键列表的映射。
(defn example13 []
  (def demoKeys (hash-map "z" 1 "b" 2 "a" 3))
  (def demoNew (set/rename-keys demoKeys {"z" "newz" "b" "newb" "a" "newa"}))
  (println demoNew))
(example13)


;13、Clojure map-invert
;反转映射, 使这些值成为键, 反之亦然。
;语法
;(map-invert hmap)
;参数 - 'hmap'是哈希键和值的映射。
;返回值 - 返回一个映射，其值被转换为键并将键反转为值。
(defn example14 []
  (def demoKeys (hash-map "z" 1 "b" 2 "a" 3))
  (def demonew (set/map-invert demoKeys))
  (println demonew))
(example14)