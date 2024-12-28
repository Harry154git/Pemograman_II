package PRAKTIKUM7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mysqlconnector {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1/inventarispenjualanbuku";
    static final String USER = "root";
    static final String PASS = "";


    public static Connection connectConnector() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL, USER, PASS);

    }
}
