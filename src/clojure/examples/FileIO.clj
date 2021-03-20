(ns clojure.examples.FileIO)
;Clojure 文件 I/O  https://www.w3cschool.cn/clojure/clojure_file_io.html
;Clojure在使用 I/O 时提供了许多辅助方法,它能帮助我们更方便的操作文件:
; 读取文件
; 写入文件
; 查看文件是文件还是目录


;1、作为整个字符串读取文件的内容
; 如果要以文件的形式获取文件的全部内容，可以使用clojure.core.slurp方法。
; slurp命令打开文件上的读取器并读取其所有内容，返回一个字符串。
(defn Example []
  (def string1 (slurp "/etc/hosts"))
  (println string1))
(Example)


;2、一次读取一行文件的内容
;如果想要以字符串的形式获得文件的整个内容，一次一行，可以使用clojure.java.io/reader方法。 c
; lojure.java.io/reader类创建一个阅读器缓冲区，用于读取文件的每一行。

(defn Example2 []
  (with-open [rdr (clojure.java.io/reader "/etc/hosts")]
    (reduce conj [] (line-seq rdr))))
(Example2)



;3、写入"文件"
;如果要写入“到”文件，可以使用clojure.core.spit命令将整个字符串打入文件。
; spit命令与slurp方法相反。 此方法以作者身份打开文件，写入内容，然后关闭文件。
(defn Example3 []
  (spit "Example.txt"
        "This is a string"))
(Example3)

;4、一次写入一行文件
;如果你想一次写一行文件，你可以使用clojure.java.io.writer类。
; clojure.java.io.writer类用于创建写入器流，其中数据的字节被馈送到流中并且随后被馈送到文件中。
(defn Example4 []
  (with-open [w (clojure.java.io/writer "Example.txt" :append true)]
    (.write w (str "hello" "world"))))
(Example4)
;当执行上面的代码时，“hello world”行将出现在Example.txt文件中。 append：true选项是将数据附加到文件。 如果未指定此选项，则每当将数据写入文件时，文件将被覆盖。



;5、检查文件是否存在
;要检查文件是否存在，可以使用clojure.java.io.file类来检查文件是否存在。 下面是一个例子，说明如何完成这个:
(defn Example5 []
  (println (.exists (clojure.java.io/file "Example.txt"))))
(Example5)
;如果文件Example.txt存在，输出将为true。


;6、从控制台读取
;要从控制台读取数据，可以使用read-line语句。
;如果在REPL窗口中输入（read-line）命令，您将有机会在控制台窗口中输入一些输入。
;user->(read-line)
;Hello World