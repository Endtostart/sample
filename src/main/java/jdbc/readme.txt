===================
  jdbc相关
===================
jdbc
    > 链接步骤
        加载数据库驱动 Class.forName("com.mysql.jdbc.Driver");
        获得连接 con = DriverManager.getConnection(url,userName,passWd);

        创建声明
            Statement	        适用于运行静态 SQL 语句。 Statement 接口不接受参数。
            PreparedStatement	计划多次使用 SQL 语句， PreparedStatement 接口运行时接受输入的参数。
            CallableStatement	适用于当你要访问数据库存储过程的时候， CallableStatement 接口运行时也接受输入的参数。

        Statement statement = con.createStatement();

        执行sql
            statement.executeUpdate()
            statement.executeQuery()

        如果Connection 设置自动commit 为 false , 即 con.setAutoCommit(false);
        那么, 执行完 sql 之后 需要执行 con.commit() 提交 或者 con.rollback() 回滚
        这也是保证 事务的方法

        spring 通过 代理。当方法执行成功后，执行代理后置方法 con.commit() 提交。
           当执行异常时，执行con.rollback() 回滚。来保证事务的一致性.


1 > transation
    简单的jdbc链接步骤，简单的事务
