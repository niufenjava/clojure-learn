(ns clojure.ring.WebApp)
; # Web应用程序 - 简介
; > 要在Clojure中创建Web应用程序，您需要使用 Ring 应用程序库，该应用程序库在以下链接中提供 https://github.com/ring-clojure/ring
;
; > 您需要确保从网站下载必要的jar，并确保将其添加为Clojure应用程序的依赖关系。
;
; ## Ring框架提供以下功能：
; 1. 设置事情，使得 http 请求作为常规的 Clojure HashMap 进入您的Web应用程序，同样使得您可以返回作为HashMap的响应。
; 2. 提供一个规范，描述那些请求和响应映射应该是什么样子。
; 3. 沿着Web服务器（Jetty）启动，并将您的Web应用程序连接到它。
;
; > Ring框架可以自动启动Web服务器，并确保Clojure应用程序在此服务器上工作。 然后还可以使用Compojure框架。 这允许创建路线，现在是大多数现代web应用程序的开发。
;
; > 创建您的第一个Clojure应用程序 -以下示例显示如何在Clojure中创建第一个Web应用程序。
;
(
 (:require [compojure.core :refer :all]
   [compojure.route :as route]
   [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))
(defroutes app-routes
           (GET "/" [] "Hello World")
           (route/not-found "Not Found"))
(def app
  (wrap-defaults app-routes site-defaults))
;让我们来看看程序的以下方面:
; 1. 'defroutes' 用于创建路由，以便对Web应用程序对不同路由的请求可以指向您的Clojure应用程序中的不同函数。
; 2. 在上面的示例中，“/”被称为默认路由，因此当您浏览到Web应用程序的基础时，字符串“Hello World”将被发送到Web浏览器。
; 3. 如果用户命中任何无法由Clojure应用程序处理的URL，那么它将显示字符串“未找到”。
;
; > 当运行Clojure应用程序时，默认情况下，应用程序将作为localhost：3000加载，因此如果浏览到此位置，您将收到以下输出。
;
;
; ## Web应用程序 - 为您的Web应用程序添加更多路由
; > 您还可以向您的Web应用程序添加更多路由。 以下示例显示如何实现此。
;
(
 (:require [compojure.core :refer :all]
   [compojure.route :as route]
   [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))
(defroutes app-routes
           (GET "/" [] "Hello World")
           (GET "/Tutorial" [] "This is a tutorial on Clojure")
           (route/not-found "Not Found"))
(def app
  (wrap-defaults app-routes site-defaults))
; > 你可以看到，在应用程序中添加一个路由就像添加另一个GET函数一样简单。 （GET“/ Tutorial”[]“这是一个关于Clojure的教程”）
;
; > 如果浏览到位置http：// localhost：3000 / Tutorial，您将收到以下输出。