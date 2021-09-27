package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String url =
            "jdbc:postgresql://localhost:8080/postgres";
    private static final String user = "postgres";
    private static final String password = "asanalieva48";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server suc...");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
