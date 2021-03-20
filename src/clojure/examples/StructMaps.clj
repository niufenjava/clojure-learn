(ns clojure.examples.StructMaps)
; # Clojure StructMaps  https://www.w3cschool.cn/clojure/clojure_structmaps.html
; > StructMaps 用于在 Clojure 中创建结构。
;   例如，如果您想创建一个包含 EmployeeName 和 EmployeeId 的结构，可以使用 StructMaps 来完成。
;
; ## 有关 StructMaps 的方法
; 1. defstruct	  此函数用于定义所需的结构。
; 2. struct	      此函数用于定义由defstruct操作创建的类型的结构对象。
; 3. struct-map	  此函数用于通过明确定义哪些值分配给结构中的哪些键来为键值指定值。
; 4. Accessing Individual Fields	可以通过访问键和结构对象来访问结构的单个字段。
; 5. Immutable Nature	            默认情况下，结构也是不可变的，所以如果我们试图改变特定键的值，它不会改变。
; 6. Adding a New Key to the Structure	由于结构是不可变的，所以可以将另一个键添加到结构的唯一方式是通过创建新结构。 在以下程序中显示了如何实现这一点的示例。

; ## Clojure defstruct 此函数用于定义所需的结构
; * 语法 (defstruct structName keys)
;    参数 − 'structName' 是要给结构的名称。 'keys' 是需要作为结构一部分的键。
;    返回值 − 返回结构对象。
; * 例
(defn Example []
  (println (defstruct Employee :EmployeeName :EmployeeId)))
(Example)
; 注意上面的函数只是用来创建你的结构，我们将看到更多的函数可以用来处理结构。
(println (str "-----------------------------------------------------------------"))


; ## Clojure struct  https://www.w3cschool.cn/clojure/clojure_struct.html
; > 此函数用于定义由 defstruct 操作创建的类型的结构对象。
; * 语法 (struct structName values)
;     参数 − 'structName' 是要给结构的名称。
;           'values' 是需要分配给结构的键值的值。
;     返回值 − 返回一个结构对象，其值映射到结构的键。
;
; * 例
(defn Example []
  (defstruct Employee :EmployeeName :EmployeeId)
  (def emp (struct Employee "John" 1))
  (println emp))
(Example)
; * 输出
;{:EmployeeName John, :EmployeeId 1}
; > 可以清楚地看到，struct 函数中提供的值被分配给 Employee 对象的键。
(println (str "-----------------------------------------------------------------"))


; ## Clojure struct-map
; > 此函数用于通过明确定义哪些值分配给结构中的哪些键来为键值指定值。
;
; * 语法 (struct-map structName keyN valueN …. )
;   参数 − 'structName' 是要给结构的名称
;       - 'keyN' 和 'valueN' 是需要分配给结构的关键值。
;   返回值 − 返回一个结构对象，其值映射到结构的键。
;
; * 例
(defn Example []
  (defstruct Employee :EmployeeName :EmployeeId)
  (def emp (struct-map Employee :EmployeeName "John1" :EmployeeId 2))
  (println emp))
(Example)
; * 输出
;{:EmployeeName John, :Employeeid 1}
(println (str "-----------------------------------------------------------------"))


; ## Clojure Accessing Individual Fields
; > 可以通过访问键和结构对象来访问结构的单个字段。
; * 语法  :key structure-name
;   参数 − 'key'是结构中的键值。 'structure-name'是相应键的结构。
;   返回值 − 将返回与键相关联的值。 下面的程序显示了如何使用它的示例。
;
; * 例
(defn Example []
  (defstruct Employee :EmployeeName :EmployeeId)
  (def emp (struct-map Employee :EmployeeName "John" :EmployeeId 1))
  (println (:EmployeeId emp))
  (println (:EmployeeName emp)))
(Example)
; * 输出
;1
;John
(println (str "-----------------------------------------------------------------"))


; ## Clojure Immutable Nature
; > 默认情况下，结构也是不可变的，所以如果我们试图改变特定键的值，它不会改变。
;
; * 语法
(defn Example []
  (defstruct Employee :EmployeeName :EmployeeId)
  (def emp (struct-map Employee :EmployeeName "John" :EmployeeId 1))
  (println (:EmployeeName emp))

  (assoc emp :EmployeeName "Mark")
  (println (:EmployeeName emp)))
(Example)
; > 在上面的例子中，我们尝试使用'assoc'函数在结构中为Employee Name关联一个新值。
;
; * 输出
;John
;John
; > 这清楚地表明该结构是不可变的。 更改值的唯一方法是使用更改后的值创建一个新变量，如以下程序所示。
;
; * 例
(defn Example []
  (defstruct Employee :EmployeeName :EmployeeId)
  (def emp (struct-map Employee :EmployeeName "John" :EmployeeId 1))
  (def newemp (assoc emp :EmployeeName "Mark"))
  (println newemp))
(Example)
; * 输出
;{:EmployeeName Mark, :EmployeeId 1}
(println (str "-----------------------------------------------------------------"))



; ## Clojure Adding a New Key to the Structure
; > 由于结构是不可变的，所以可以将另一个键添加到结构的唯一方式是通过创建新结构。 在以下程序中显示了如何实现这一点的示例。
;
; * 语法
(defn Example []
  (defstruct Employee :EmployeeName :EmployeeId)
  (def emp (struct-map Employee :EmployeeName "John" :EmployeeId 1))
  (def newemp (assoc emp :EmployeeRank "A"))
  (println newemp))
(Example)
; > 在上面的例子中，我们将一个名为EmployeeRank的新关键字关联到结构，但是通过创建一个新的结构对象。
;
; * 输出
;{:EmployeeName John, :Employeeid 1, :EmployeeRank A}