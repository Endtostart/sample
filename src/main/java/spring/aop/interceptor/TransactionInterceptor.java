package spring.aop.interceptor;

import com.mysql.cj.jdbc.ConnectionImpl;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component
public class TransactionInterceptor implements MethodInterceptor {

    ThreadLocal<Connection> local = new ThreadLocal<>();

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        //Connection connection = getConnection();

        try {
            // do something
            System.out.println("do target function");
            invocation.proceed();
            //connection.commit();

            System.out.println("connection commit");
        } catch (Exception e) {
            System.out.println("catch exception, connection rollbacdk");
            //connection.rollback();
        }finally {
            System.out.println("close connection");
            //connection.close();
        }
        return null;
    }


    public Connection getConnection() throws SQLException {
        Connection conn = local.get();
        if (conn == null) {
            conn = new MyConnection();
            conn.setAutoCommit(false);
            local.set(conn);
        }
        return conn;
    }

}

class MyConnection extends ConnectionImpl {
    public MyConnection() {
        super();
    }
}
