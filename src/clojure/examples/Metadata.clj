(ns clojure.examples.Metadata)

; # Clojure 元数据
; > 在 Clojure 中，元数据用于注释集合中的数据或存储在符号中的数据。
; > 这通常用于向底层编译器注释类型的数据，但也可以用于开发人员。 元数据不被视为对象值的一部分。 同时，元数据是不可变的。
;
; ## 在Clojure中有以下一些关元数据的操作。
; 1. meta-with	此函数用于定义任何对象的元数据映射。
; 2. meta	此函数用于查看是否有任何元数据与对象相关联。
; 3. vary-meta	返回与原始对象具有相同类型和值的对象，但使用组合的元数据。


; ## Clojure meta-with
; > 此函数用于定义任何对象的元数据映射。
;
; 语法
; (with-meta obj mapentry)
;参数 − 'obj'是元数据需要与之相关联的对象。 'mapentry'是需要与对象相关联的元数据。
;返回值 − 返回与obj相同类型和值的对象，并使用mapentry作为其元数据。
(defn Example []
  (def my-map (with-meta [1 2 3] {:prop "values"}))
  (println (meta my-map)))
(Example)

; ## Clojure meta
; > 此函数用于查看是否有任何元数据与对象相关联。
;
; 语法
; (meta obj)
; 参数 − 'obj'是需要检查的对象，如果任何元数据与它相关联。
; 返回值 − 返回obj的元数据，如果没有元数据，则返回nil。
(defn Example []
  (def my-map (with-meta [1 2 3] {:prop "values"}))
  (println (meta my-map)))
(Example)


; ## Clojure vary-meta
; > 返回与原始对象具有相同类型和值的对象，但使用组合的元数据。
; 语法
; (vary-meta obj new-meta)
; 参数 −'obj'是需要检查的对象，如果任何元数据与它相关联。 'new-meta'是需要与对象相关联的元数据值。
; 返回值 − 返回与原始对象具有相同类型和值的对象，但使用组合的元数据。
;
; ### 例
; 下面的程序显示了如何使用它的示例。
(defn Example []
  (def my-map (with-meta [1 2 3] {:prop "values"}))
  (println (meta my-map))
  (def new-map (vary-meta my-map assoc :newprop "new values"))
  (println (meta new-map)))
(Example)