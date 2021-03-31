(ns clojure.examples.Database
  (:require [clojure.java.jdbc :as sql])
  )

; # Clojure 数据库
; > 为了使用数据库的功能，请确保首先从以下网址下载JDBC文件 - https://codeload.github.com/clojure/java.jdbc/zip/master
;   你会发现一个zip文件，它有必要的驱动程序，Clojure 有能力连接到数据库。 提取zip文件后，请确保将解压缩的位置添加到类路径中。
;   数据库连接的主文件是位于 clojure / java中的名为jdbc.clj的文件。
;
; ## clojure jdbc连接器支持各种各样的数据库，其中一些如下:
; 1. H2Database
; 2. Oracle
; 3. Microsoft SQL Server
; 4. MySQL
; 5. PostgreSQL
;
; ## 数据库连接
; 在连接到MySQL数据库之前，请确保以下内容:
; 1. 您已创建数据库TESTDB。
; 2. 您在TESTDB中创建了一个表EMPLOYEE。
; 3. 此表格包含FIRST_NAME，LAST_NAME，AGE，SEX和INCOME字段。
; 4. 用户ID“testuser”和密码“test123”设置为访问TESTDB。
; 5. 确保已下载“mysql jar文件”，并将该文件添加到类路径。
;
; *语法
; (def connection_name {
;   :subprotocol “protocol_name”
;   :subname “Location of mysql DB”
;   :user “username” :password “password” })
;  参数 - 'connection_name'是要给连接的名称。
;       'subprotocol' 是用于连接的协议。 默认情况下我们将使用mysql协议。
;       'subname' 是连接到mysql数据库的URL以及数据库名称。
;       'user'是用于连接到数据库的用户名。
;       'password'是用于连接到数据库的密码。
;
;  返回值 -这将提供一个连接字符串，可以在后续的mysql操作中使用。
;
; > 以下示例显示如何连接到信息模式中的表并检索表中的所有数据。
;
; * 例
(defn -main []
  (def mysql-db {
                 :subprotocol "mysql"
                 :subname     "//127.0.0.1:3306/information_schema"
                 :user        "root"
                 :password    "2222"})
  (println (sql/query mysql-db
                      ["select table_name from tables"]
                      {:result-set-fn count})))


; ## 数据查询
; > 在任何数据库上查询数据意味着从数据库获取一些有用的信息。 一旦建立了数据库连接，就可以对该数据库进行查询。
;
; * 语法
; clojure.java.jdbc/query dbconn
; ["query"]
;   :row-fn :sequence
;   参数 -'dbconn'是用于连接到数据库的连接的名称。
;        'query'是用于从数据库提取数据的查询字符串。
;       '：sequence'默认情况下从数据库获取的所有数据行，并作为序列返回。 然后可以对序列执行必要的操作，以查看已提取了哪些数据。
;   返回值 -这将返回一个序列，它将具有来自查询操作的数据行。
;
;  以下示例显示如何连接到 employee 表并获取表中行的 first_name 列。
;
; * 例
(defn -main []
  (def mysql-db {
                 :subprotocol "mysql"
                 :subname     "//127.0.0.1:3306/jeecg-boot"
                 :user        "root"
                 :password    "2222"})
  (println (sql/query mysql-db
                      ["select username from sys_user"]
                      {:result 1})))
; > 从上面的代码，我们可以看到，
;   查询“select first_name from employee”作为查询字符串传递。
;   first_name是作为fetch操作结果返回的序列。
;   如果我们假设在我们的数据库中只有一行包含first_name值为John，则以下将是上述程序的输出。
;(John)

; ## 插入数据
; > 当您要将记录创建到数据库表中时需要。 以下是使用Clojure可以插入数据的语法。 这是通过使用 'insert！'函数完成的。
;
; * 语法
; clojure.java.jdbc/insert!
;   :table_name {:column_namen columnvalue}
; 参数 - '：table_name'是需要插入的表的名称。
;       '{：column_namen columnvalue}'是所有列名称和值的映射，需要在表中作为一行添加。
; 返回值 -如果插入成功，这将返回nil。
;
; > 以下示例显示如何将记录插入到testdb数据库中的employee表中。
;
; * 例
(defn -main []
   (def mysql-db {
      :subprotocol "mysql"
      :subname "//127.0.0.1:3306/jeecg-boot"
      :user "root"
      :password "2222"})
   (sql/insert! mysql-db
      :sys_user {:id 1 :username "John" :realname "Mark" }))
;如果现在检查MySQL数据库和employee表，您将看到上面的行将成功插入表中。
;
;
; ## 删除数据
; > 可以使用 'delete！'函数从表中删除行。 以下是如何执行此操作的语法。
;
; * 语法
; clojure.java.jdbc/delete!
;   :table_name [condition]
;  参数 -'：table_name'是需要插入的表的名称。 'condition'是用于确定需要从表中删除哪一行的条件。
;  返回值 -这将返回删除的行数。
;
; > 以下示例显示如何从testdb数据库中的employee表中删除记录。 示例根据年龄等于30的条件从表中删除一行。
;
; * 例
(defn -main []
   (def mysql-db {
      :subprotocol "mysql"
      :subname "//127.0.0.1:3306/jeecg-boot"
      :user "root"
      :password "2222"})
   (println (sql/delete! mysql-db
      :sys_user ["id = ? " "1"])))


; ## 更新数据
; 可以使用 'update！'函数从表中更新行。 以下是如何执行此操作的语法。
; * 语法
; clojure.java.jdbc/update!
;   :table_name
; {setcondition}
; [condition]
; 参数 - '：table_name'是需要插入的表的名称。 'setcondition'是需要根据映射提到的更新的列。 'condition'是用于确定需要从表中删除哪一行的条件。
; 返回值 -这将返回更新的行数。
;
; > 以下示例显示如何从testdb数据库中的employee表中删除记录。 该示例根据年龄等于30的条件更新表中的行，并将收入值更新为40。
;
(defn -main []
   (def mysql-db {
      :subprotocol "mysql"
      :subname "//127.0.0.1:3306/jeecg-boot"
      :user "root"
      :password "2222"})
   (println (sql/update! mysql-db
      :sys_user
      {:id "1260928527571730433"}
      ["username = ? " "30"])))

; ## 事务
; > 事务是确保数据一致性的机制。 事务具有以下四个属性
; 原子性 -事务完成或根本没有任何事情发生。
; 一致性 -事务必须以一致的状态开始，并使系统保持一致状态。
; 隔离性 -事务的中间结果在当前事务外部不可见。
; 耐用性 -一旦事务提交，即使在系统故障后，影响仍然是持久的。
;
; * 例
; 以下示例显示如何在Clojure中实现事务。 任何需要在事务中执行的操作都需要嵌入到'with-dbtransaction'子句中。
;
(defn -main []
   (def mysql-db {
      :subprotocol "mysql"
      :subname "//127.0.0.1:3306/jeecg-boot"
      :user "root"
      :password "2222"})
   (sql/with-db-transaction [t-con mysql-db]
      (sql/update! t-con
         :sys_user
         {:id "1260928527571730433"}
         ["username = ? " "301"])))