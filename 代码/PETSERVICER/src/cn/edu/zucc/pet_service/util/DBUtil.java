package cn.edu.zucc.util;

import java.sql.Connection;

/**
 * @Author JiangLR
 * @Time 2018-08-31 15:49
 */
public class DBUtil {
    private static final String jdbcUrl="jdbc:mysql://localhost:3306/pet_service";
    private static final String dbUser="root";
    private static final String dbPwd="19980102";
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws java.sql.SQLException{
        return java.sql.DriverManager.getConnection(jdbcUrl, dbUser, dbPwd);
    }
}
