(ns clojure.examples.String)

;Clojure 字符串   https://www.w3cschool.cn/clojure/clojure_strings.html
; 在Clojure中通过在引号中包含字符串文本来构造一个字符串文字。
; Clojure中的字符串需要使用双引号（例如“Hello World”）构建。
(defn hello-world []
  (println "Hello World")
  (println "This is a demo application"))
(hello-world)

;S.No.	方法和说明
;str	        字符串拼接
;format	      字符串的格式化可以通过简单的格式化函数来完成。 format函数使用java.lang.String.format格式化一个字符串。
;count	      如果number小于零，则返回true，否则返回false。
;subs	        返回从包含开始到结束（默认为字符串的长度）的“s”的子字符串“exclusive”。
;compare	    当'x'逻辑'小于'，'等于'或'大于''y'时，返回负数，零或正数。
;lower-case	  将所有字符串转换为小写。
;upper-case	  Ω将所有字符串转换为大写。
;join	        返回集合中所有元素的字符串，由（seq集合）返回，由可选分隔符分隔。
;split	      拆分正则表达式上的字符串。
;split-lines	拆分字符串基于转义字符\ n或\ r \ n。
;reverse	    反转字符串中的字符。
;replace	    将字符串中的匹配的所有实例替换为替换字符串。
;trim	        从字符串的两端删除空格。
;triml	      从字符串的左侧删除空格。
;trimr	      从字符串的右侧删除空格。


;1、Clojure Strings str 字符串拼接
;语法
;str stringvar1 stringvar2 stringvarn
;参数 −您可以输入任意数量的需要连接的字符串参数。
;返回值 −返回值是一个字符串。
(defn hello-world []
  (println (str "Hello" "World"))
  (println (str "Hello" "World" "Again")))
(hello-world)
(println (str "-----------------------------------------------------------------"))


;Clojure Strings format
;字符串的格式化可以通过简单的格式化函数来完成。 format函数使用java.lang.String.format格式化一个字符串。
; 语法:
; (format fmt args)
;参数− 'fmt' 是需要应用的格式。 'Args' 是需要应用格式化的参数。
;返回值 − 返回值是一个字符串。
(defn hello-world2 []
  (println (format "Hello , %s" "World"))
  (println (format "Pad with leading zeros %06d" 1234)))
(hello-world2)
(println (str "-----------------------------------------------------------------"))


;Clojure Strings count
;要查找字符串中的字符数，可以使用count函数。
;语法
;(count stringvariable)
;参数− 'Stringvariable，是需要确定字符数的字符串。
;返回值 − 字符串中的字符数。
(defn hello-world3 []
  (println (count "Hello")))
(hello-world3)
(println (str "-----------------------------------------------------------------"))


;Clojure Strings subs  字符串截取
;返回从包含开始到结束（默认为字符串的长度）的“s”的子字符串“exclusive”。
;语法
;(subs s start end)
;参数 − 'S'是输入字符串。 'Start'是从中开始子串的索引位置。 'End'是索引位置，用于结束子字符串。
;返回值 − 子字符串。
(defn hello-world4 []
  (println (subs "HelloWorld" 2 5))
  (println (subs "HelloWorld" 5 7)))
(hello-world4)
(println (str "-----------------------------------------------------------------"))


;Clojure Strings compare 字符串比较
;当'x'逻辑'小于'，'等于'或'大于''y'时，返回负数，零或正数。
; 它类似于Java x.compareTo（y），除了它也适用于nil，mpares数字和集合在一个类型无关的方式。
;语法
;(compare x y)
;参数 − 其中x和y是需要比较的2个字符串。
;返回值 − 当'x'逻辑'小于'，'等于'或'大于''y'时，返回负数，零或正数。
(defn hello-world5 []
  (println (compare "Hello" "hello"))
  (println (compare "Hello" "Hello")))
(hello-world5)
(println (str "-----------------------------------------------------------------"))


;Clojure Strings lower-case   将字符串转换为所有小写。
;语法
;(lower-case s)
;参数 − where's'是要转换的字符串。
;返回值 − 小写字符串。
(defn hello-world6 []
  (println (clojure.string/lower-case "HelloWorld"))
  (println (clojure.string/lower-case "HELLOWORLD")))
(hello-world6)
(println (str "-----------------------------------------------------------------"))


;Clojure Strings upper-case   ;将字符串转换为全大写。
;语法
;以下是upper-case的基本使用语法:
;(upper-case s)
;参数 − where's'是要转换的字符串。
;返回值 − 大写字符串。
(defn hello-world7 []
  (println (clojure.string/upper-case "HelloWorld"))
  (println (clojure.string/upper-case "helloworld")))
(hello-world7)
(println (str "-----------------------------------------------------------------"))


;Clojure Strings join
;返回集合中所有元素的字符串，由（seq集合）返回，由可选分隔符分隔。
;语法
;(join sep col)
;参数 − 'sep'是集合中每个元素的分隔符。 'col'是元素的集合。
;返回值 − 已连接的字符串。
(defn hello-world8 []
  (println (clojure.string/join ", " [1 2 3])))
(hello-world8)
(println (str "-----------------------------------------------------------------"))

;Clojure Strings split
;拆分正则表达式上的字符串。
;语法
;(split str reg)
;参数 − 'str'是需要拆分的字符串。 'reg'是字符串拆分需要发生的正则表达式。
;返回值 − 拆分后的字符串。
(defn hello-world9 []
  (println (clojure.string/split "Hello World" #" ")))
;注意在上面的输出中，字符串“Hello”和“World”是单独的字符串。
(hello-world9)
(println (str "-----------------------------------------------------------------"))


;Clojure Strings split-lines  拆分字符串基于转义字符\ n或\ r \ n。
;语法
;(split-lines str)
;参数− 'str'是需要拆分的字符串。
;返回值 − 拆分后的字符串。
(defn hello-world10 []
  (println (clojure.string/split-lines "Hello\nWorld")))
;注意在上面的输出中，字符串“Hello”和“World”是单独的字符串。
(hello-world10)
(println (str "-----------------------------------------------------------------"))


;Clojure Strings reverse
;反转字符串中的字符。
;语法
;(reverse str)
;参数− 'str'是需要反转的字符串。
;返回值 − 反转后的字符串。
(defn hello-world11 []
  (println (reverse "Hello World")))
(hello-world11)
(println (str "-----------------------------------------------------------------"))


;Clojure Strings replace   将字符串中的匹配的所有实例替换为替换字符串
;语法
;(replace str match replacement)
;参数− 'str'是输入字符串。 'match'是将用于匹配过程的模式。 'replacement'将是每个模式匹配将被替换的字符串。
;返回值 − 匹配替换后的字符串。
(defn hello-world12 []
  (println (clojure.string/replace "The tutorial is about Groovy" #"Groovy"
                                   "Clojure")))
(hello-world12)
(println (str "-----------------------------------------------------------------"))


;Clojure Strings trim   从字符串的两端删除空格
;Clojure Strings triml   从字符串的左侧删除空格。
;Clojure Strings trimr   从字符串的右侧删除空格。
;语法
;(trim str)
;参数− 'str'是输入字符串。
;返回值 − 删除空格的字符串。
(defn hello-world13 []
  (println (clojure.string/trim " White spaces ")))
(hello-world13)
(println (str "-----------------------------------------------------------------"))

