(ns clojure.examples.Exception
  (:import (java.io FileNotFoundException)))
; # Clojure 异常处理   https://www.w3cschool.cn/clojure/clojure_exception_handling.html
; > 在任何编程语言中都需要异常处理来处理运行时错误，从而可以保持应用程序的正常流程。
; > 异常通常会破坏应用程序的正常流程，这就是为什么我们需要在我们的应用程序中使用异常处理的原因。
;
; 异常大致分为以下几类:
; 1、检查异常 - 扩展Throwable类（除了RuntimeException和Error）的类称为检查异常。
;   例如。 IOException，SQLException等。检查的异常在编译时检查。
;   让我们考虑下面的程序对一个名为Example.txt的文件进行操作。 但是，可能总是有一种情况，其中文件Example.txt不存在
(defn Example []
  (def string1 (slurp "Example.txt"))
  ;(def string1 (slurp "Example1.txt"))
  (println string1))
(Example)
(println (str "-----------------------------------------------------------------"))

; 2、未选中的异常 - 扩展RuntimeException的类称为未检查异常。
; 例如，ArithmeticException，NullPointerException，ArrayIndexOutOfBoundsException 等。未检查的异常不在编译时检查，而是在运行时检查。
; 一个典型的情况是ArrayIndexOutOfBoundsException，当您尝试访问大于数组长度的数组的索引时，会发生这种情况。 以下是这种错误的典型例子。
(defn Example1 []
  (try
    (aget (int-array [1 2 3]) 5)
    (catch Exception e (println (str "caught exception: " (.toString e))))
    (finally (println "This is our final block")))
  (println "Let's move on"))
(Example1)
(println (str "-----------------------------------------------------------------"))


; ## 错误
; 错误是无法恢复的，比如： OutOfMemoryError，VirtualMachineError，AssertionError等。
; 这些是程序永远不能恢复的错误，并将导致程序崩溃。 我们现在需要一些机制来捕获这些异常，以便如果这些异常存在，程序可以继续运行。


; ## 捕捉异常
; > 就像其他编程语言一样，Clojure提供了正常的“try-catch”块来捕获异常。
; Clojure try-catch 语法:
;(try
;   (//Protected code)
;   catch Exception e1)
;(//Catch block)
;所有可能引发异常的代码都放在受保护的代码块中。
;在catch块中，您可以编写自定义代码来处理异常，以便应用程序可以从异常中恢复。
;让我们看看我们之前的例子，它生成了一个未找到文件的异常，看看我们如何使用try catch块来捕获程序引发的异常。

(defn Example2 []
  (try
    (def string1 (slurp "Example2.txt"))
    (println string1)
    (catch Exception e (println (str "caught exception: " (.getMessage e))))))
(Example2)
(println (str "-----------------------------------------------------------------"))


; ## 多个catch块
; > 可以有多个catch块来处理多种类型的异常。 对于每个catch块，根据引发的异常的类型，您将编写代码来相应地处理它。
; > 让我们修改我们早期的代码，以包含两个catch块，一个特定于我们的文件未找到异常，另一个是一个一般的异常块。
(defn Example3 []
  (try
    (def string1 (slurp "Example.txt"))
    (println string1)
    (catch FileNotFoundException e (println (str "caught file
         exception: " (.getMessage e))))

    (catch Exception e (println (str "caught exception: " (.getMessage e)))))
  (println "Let's move on"))
(Example3)
(println (str "-----------------------------------------------------------------"))


; ## finally块
; > finally块跟在try块或catch块之后。 代码的finally块总是执行，而不管异常的发生。
; 使用finally块可以运行任何你想要执行的清除类型语句，无论在受保护代码中发生什么。 以下是此块的语法。
;(try
;   (//Protected code)
;   catch Exception e1)
;(//Catch block)
;(finally
;   //Cleanup code)
(defn Example4 []
  (try
    (def string1 (slurp "Example.txt"))
    (println string1)

    (catch FileNotFoundException e (println (str "caught file
         exception: " (.getMessage e))))
    (catch Exception e (println (str "caught exception: " (.getMessage e))))
    (finally (println "This is our final block")))
  (println "Let's move on"))
(Example4)
(println (str "-----------------------------------------------------------------"))

;从上面的程序，你可以看到最后的块也实现后catch块捕获所需的异常。
;由于Clojure从Java中获取其异常处理，与Java类似，因此在Clojure中也可以使用以下方法来管理异常:
;public String getMessage() -返回有关已发生异常的详细消息。 此消息在Throwable构造函数中初始化。
;public Throwable getCause() -返回由Throwable对象表示的异常原因。
;public String toString() -返回与getMessage（）的结果连接的类的名称。
;public void printStackTrace() -将toString（）的结果与堆栈跟踪一起打印到System.err，错误输出流。
;public StackTraceElement [] getStackTrace() -返回包含堆栈跟踪上的每个元素的数组。 索引0处的元素表示调用堆栈的顶部，数组中的最后一个元素表示调用堆栈底部的方法。
;public Throwable fillInStackTrace() -使用当前堆栈跟踪填充此Throwable对象的堆栈跟踪，添加到堆栈跟踪中的任何以前的信息。
;以下是使用上面列出的一些方法的示例代码。
(defn Example5 []
  (try
    (def string1 (slurp "Example.txt"))
    (println string1)

    (catch java.io.FileNotFoundException e (println (str "caught file
         exception: " (.toString e))))

    (catch Exception e (println (str "caught exception: " (.toString e))))
    (finally (println "This is our final block")))
  (println "Let's move on"))
(Example5)