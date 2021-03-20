(ns clojure.examples.Watcher)
; # Clojure Watcher  https://www.w3cschool.cn/clojure/clojure_watchers.html
; > Watcher是添加到变量类型的函数，例如 atom 和引用变量，当变量类型的值改变时调用。
;   例如，如果调用程序更改 atom 变量的值，并且如果 Watcher 函数附加到atom变量，则一旦 atom 的值改变，该函数将被调用。
;
; ## 添加 Watcher
; > 向 agent / atom / var / ref 引用添加 watch 函数。
;   手表'fn'必须是4个参数的'fn'：一个键，引用，它的旧状态，它的新状态。
;   每当引用的状态可能已更改，任何注册的手表都将调用其函数。
;
; * 语法
;   (add-watch variable :watcher
;     (fn [key variable-type old-state new-state]))
;   参数 - 'variable' 是原子或引用变量的名称。
;         'variable-type' 是变量的类型，原子或引用变量。
;         '旧状态和新状态'是将自动保存变量的旧值和新值的参数。
;         'key' 对于每个引用必须是唯一的，并且可以用于删除带有remove-watch的手表。
;   返回值 -无。
;
; * 例
(defn Example []
  (def x (atom 0))
  (add-watch x :watcher
             (fn [key atom old-state new-state]
               (println "The value of the atom has been changed")
               (println "old-state" old-state)
               (println "new-state" new-state)))
  (reset! x 2))
(Example)
; * 输出
;The value of the atom has been changed
;old-state 0
;new-state 2


; ## 移除Watcher
; > 除去已附着在引用变量的手表。
;
; * 语法 (remove-watch variable watchName)
;   参数 - 'variable' 是atom或引用变量的名称。
;         'watchname' 是定义监视功能时给Watcher 的名称。
;   返回值 -无。
;
; * 例
(defn Example []
   (def x (atom 0))
   (add-watch x :watcher
      (fn [key atom old-state new-state]
         (println "The value of the atom has been changed")
         (println "old-state" old-state)
         (println "new-state" new-state)))
   (reset! x 2)
   (remove-watch x :watcher)
(reset! x 4))
(Example)
;输出
;The value of the atom has been changed
;old-state 0
;new-state 2
; > 从上面的程序可以清楚地看到，第二个重置命令不会触发观察者，因为它被从观察者的列表中删除。