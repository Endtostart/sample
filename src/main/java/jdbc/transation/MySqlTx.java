package jdbc.transation;

import java.sql.*;

public class MySqlTx {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/guns?useUnicode=yes&characterEncoding=utf8&serverTimezone=UTC";
        String userName = "root";
        String passWd = "123123";
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(url,userName,passWd);
            con.setAutoCommit(false);
            stmt = con.createStatement();
            System.out.println("connected");
            int res0 = stmt.executeUpdate("UPDATE sys_user SET name = 'trojan' WHERE id = '47'");
            int res  = stmt.executeUpdate("UPDATE sys_user SET sex = 2 WHERE id = '47'");
            System.out.println("execute sql : set sex = 2");

            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
