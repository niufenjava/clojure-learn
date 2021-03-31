(ns clojure.examples.JavaInterface)
; # Clojure Java接口   https://www.w3cschool.cn/clojure/clojure_java_interface.html
; > 正如我们已经知道的，Clojure 代码最终在 Java虚拟环境上运行。 因此，只有 Clojure 能够利用Java中的所有功能才有意义。
;
; ## 调用Java方法
; > 可以使用点表示法调用Java方法。
;   一个例子是字符串。 因为Clojure中的所有字符串都是Java字符串，所以你可以在字符串上调用普通的Java方法。
;
; *例
(defn Example []
  (println (.toUpperCase "Hello World")))
(Example)


; ## 调用带有参数的Java方法
; * 例
(defn Example []
  (println (.indexOf "Hello World", "e")))
(Example)
;输出
;1

; ## 创建Java对象
; > 对象可以在Clojure中通过使用'new'关键字来创建，类似于在Java中所做的。
; * 例
(defn Example []
  (def str1 (new String "Hello"))
  (println str1))
(Example)
; > 上述程序产生以下输出。 你可以从上面的代码中看到，我们可以使用'new'关键字从现有的Java类中创建一个新的对象。
;   我们可以在创建对象时传递值，就像我们在Java中一样。 上述程序产生以下输出。
;输出
;Hello

; > 下面是另一个例子，显示了如何创建一个Integer类的对象，并在正常的Clojure命令中使用它们。
; * 例
(defn Example []
  (def my-int (new Integer 1))
  (println (+ 2 my-int)))
(Example)

; ## Import 命令
; > 我们还可以使用import命令将Java库包含在命名空间中，以便可以轻松地访问类和方法。
;
; > 以下示例显示如何使用import命令。 在示例中，我们使用import命令从java.util.stack库中导入类。 然后我们可以使用stack类的push和pop方法。
;
; * 例
(import java.util.Stack)
(defn Example []
  (let [stack (Stack.)]
    (.push stack "First Element")
    (.push stack "Second Element")
    (println (first stack))))
(Example)

; ## 运行代码使用java命令
; > Clojure代码可以使用Java命令运行。 下面是如何做到这一点的语法。
;
; java -jar clojure-1.2.0.jar -i main.clj
;你必须提到Clojure jar文件，以便所有基于Clojure的类都将在JVM中加载。 'main.clj'文件是需要执行的Clojure代码文件。


; ## Java的内置函数
; Clojure可以使用Java的许多内置函数。
;
; > 数学PI函数 - Clojure可以使用Math方法来获取PI的值。 下面是一个示例代码。
;
; * 例
(defn Example []
  (println (. Math PI)))
(Example)


; ## 系统属性 - Clojure也可以查询系统属性。
;
; * 例
(defn Example []
   (println (.. System getProperties (get "java.version"))))
(Example)
;根据系统上Java的版本，将显示相应的值。 下面是一个示例输出。
;
;输出
;1.8.0_45