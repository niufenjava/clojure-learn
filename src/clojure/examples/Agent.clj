(ns clojure.examples.Agent
  (:import (java.util Date)))
; # Clojure 代理  https://www.w3cschool.cn/clojure/clojure_agents.html
; > Clojure 中许多数据类型是不可变的，这意味着唯一可以更改变量值的方法是创建一个新变量并为其分配新值。
;   但是，Clojure 提供了一些元素，它们可以创建一个可变状态。
;   我们已经看到，这可以通过原子数据类型实现。 可以实现的另一种方式是通过代理。
;
; > 代理提供单独位置的独立，异步更改。 代理绑定到单个存储位置的一生，并且只允许该位置的突变（到新的状态）作为动作的结果发生。
; > 操作是异步应用于代理状态并且其返回值成为代理的新状态的函数（带可选的附加参数）。
;
; ## 有关代理的操作方法：
; 1. agent	使用agent命令创建代理。
; 2. send	此函数用于向代理发送一个值。
; 3. shutdown-agents	此功能用于关闭所有正在运行的代理。
; 4. send-off	存在这样的情况，其中给代理分配本质上是阻塞的功能。
; 5. await-for	由于代理的值被更新时存在延迟，因此Clojure提供了一个“await-for”函数，用于指定等待代理更新的时间（以毫秒为单位）。
; 6. await	阻塞当前线程（无限期！），直到从此线程或代理到目前为止所有分派到代理的动作发生。 将阻止失败的代理。
; 7. agent-error	返回在代理的异步操作期间抛出的异常（如果代理失败）。 如果代理不失败，则返回 nil。
(println (str "-----------------------------------------------------------------"))

; ## Clojure agent
; > 使用 agent 命令创建代理
;
; * 语法 (agent state)
;   参数 − “state”是应该分配给代理的初始状态。
;   返回值 − 返回具有当前状态和值的代理对象。
;
; * 例
(defn Example []
  (def counter (agent 0))
  (println counter)

  (shutdown-agents)
  )
(Example)
; * 输出
;#object[clojure.lang.Agent 0x371c02e5 {:status :ready, :val 0}]
(println (str "-----------------------------------------------------------------"))

; > 与原子数据类型一样，您可以看到代理还具有与其关联的状态和值。 要直接访问代理的值，您需要使用@symbol以及变量名称。
; * 例
(defn Example []
  (def counter (agent 0))
  (println @counter)
  (shutdown-agents)
  )
(Example)
; * 输出
;0
; > 你可以从上面的程序清楚地看到，如果你在@counter附加了@符号，你将获得代理变量的值。
(println (str "-----------------------------------------------------------------"))


; ## Clojure send
; > 此函数用于向代理发送一个值。
;
; * 语法 (send agentName function value)
;   参数 − 'agentName' 是发送功能被重定向到的代理。
;         'function' “函数”用于确定代理的值将更改的方式。 在我们的示例中，我们将使用加号+符号向代理的现有值中添加一个值。
;         'Value' 是传递给函数的值，它将相应地用于更新代理的值。
;   返回值 − 返回具有新值的代理对象。
;
; * 例
(defn Example []
  (def counter (agent 0))
  (println @counter)

  (send counter + 100)
  ;(println (send counter + 100))
  (println "Incrementing Counter")
  (println @counter)
  (shutdown-agents)
  )
(Example)
; * 输出
;0
;Incrementing Counter
;0

; * 请注意以下几点:
; 1. 由于发送函数是异步函数，因此当代理的值被更新时存在时间延迟。 这就是为什么我们为程序添加了一个额外的 'println' 语句。 这是为了给Clojure环境相应地更新代理值所需的时间。
; 2. 其次，当你运行上面的程序，程序不会立即终止。 这是因为Clojure环境不知道关闭代理是否安全。 我们将在下一个功能描述中看到如何关闭代理。
(println (str "-----------------------------------------------------------------"))


; ## Clojure shutdown-agents
; > 此功能用于关闭所有正在运行的代理。
;
; * 语法 (shutdown-agents)
;   参数 − 空。
;   返回值 − 空。
;
; * 例
(defn Example []
  (def counter (agent 0))
  (println @counter)

  (send counter + 100)
  (println "Incrementing Counter")
  (println @counter)
  (shutdown-agents))
(Example)
;输出
;0
;Incrementing Counter
;0
; > 上述程序的主要区别在于，由于所有代理都将正常关闭，程序现在将终止。
(println (str "-----------------------------------------------------------------"))

; ## Clojure send-off
; > 存在这样的情况，其中给代理分配本质上是阻塞的功能。
;   一个简单的例子是，考虑你正在从一个文件中读取内容，而文件本身是阻塞的。
;   所以发送功能将首先立即返回代理并继续文件操作。 当文件操作完成时，它将自动使用文件的内容更新代理。
;
; * 语法 (send-off agentName function value)
;   参数 − 'agentName' 是发送功能被重定向到的代理。
;          “函数”用于确定代理的值将更改的方式。 在我们的示例中，我们将使用加号+符号向代理的现有值中添加一个值。
;          'Value' 是传递给函数的值，它将相应地用于更新代理的值。
;   返回值 − 首先返回代理，如果有一个非阻塞函数。 最后，返回一个带有新值的代理对象。
;
; * 例
(defn Example []
  (def counter (agent 0))
  (println @counter)

  (send-off counter + 100)
  (println @counter)
  (println @counter)
  (shutdown-agents)
  )
(Example)
; > 我们正在查看同一个递增计数器值的示例，但是从以下输出中可以清楚发送功能的作用。
; * 输出
;0
;0
;0
; > 可以看出，即使我们已经发送代理一个函数将值设置为100，它不立即反映。
; 发送关闭函数首先返回代理的值。 一旦 Clojure 正确地设置了代理的值，代理的值就会被更新，我们可以看到代理的新值。
(println (str "-----------------------------------------------------------------"))


; ## Clojure await-for
; > 由于代理的值被更新时存在延迟，因此 Clojure 提供了一个 “await-for”函数，用于指定等待代理更新的时间（以毫秒为单位）。
;
; * 语法 (await-for time agentName)
;   参数 − 'agentName' 是 'await-for' 函数应该设置为的代理。
;         'time' 是等待的时间（以毫秒为单位）。
;   返回值 − 如果由于超时返回，返回逻辑假，否则返回逻辑true。
;
; * 例
(defn Example1 []
  (def counter1 (agent 0))
  (println @counter1)

  (send-off counter1 + 100)
  (println (await-for 100 counter))
  (println @counter1)

  (shutdown-agents)
  )
(Example1)
; * 输出
;0
;true
;100
; > 从上面的程序可以看到，代理的值立即打印到屏幕上，因为 'await-for' 函数包含了一个延迟，这允许 Clojure 更新代理的值。
(println (str "-----------------------------------------------------------------"))


; ## Clojure await
; > 阻塞当前线程（无限期！），直到从此线程或代理到目前为止所有分派到代理的动作发生。 将阻止失败的代理。
; * 语法 (await agentName)
;  参数 − 'agentName' 是应为其设置await函数的代理程序。
;  返回值 − 无.
;
; * 例
(defn Example9 []
   (def counter9 (agent 0))
   (println @counter9)

   (send-off counter9 + 100)
   (await counter9)
   (println @counter9)

   (shutdown-agents))
(Example9)
;输出
;0
;100
; > 从上面的程序可以看出，代理的值立即打印到屏幕上，因为await函数将等待Clojure首先更新函数的值，然后才会将控制返回给调用程序。
(println (str "-----------------------------------------------------------------"))



; ## Clojure agent-error
; > 返回在代理的异步操作期间抛出的异常（如果代理失败）。 如果代理不失败，则返回nil。
;
; * 语法 (agent-error agentname)
;   参数 − 'agentname'是代理错误功能应该设置为的代理。
;   返回值 − 返回在代理失败时在代理的异步操作期间抛出的异常。 如果代理不失败，则返回nil。
;
; * 例
(defn Example []
   (def my-date (agent (Date.)))
   (send my-date + 100)
   (await-for 100 my-date)
   (println (agent-error my-date)))
(Example)
; > 在上面的程序中，我们强制通过增加一个错误的日期变量的值来引发异常。 这将导致异常，并在'prinltn'语句的帮助下，将被发送到屏幕。