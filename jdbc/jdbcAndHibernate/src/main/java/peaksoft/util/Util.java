package peaksoft.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import peaksoft.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util<currentSessionFactory> {
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


    //------------------------------------------'
    private static SessionFactory sessionFactory;

    public  static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory =  new Configuration()
                    .setProperty(Environment.DRIVER, "org.postgresql.Driver")
                    .setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect")
                    .setProperty(Environment.URL, "jdbc:postgresql://localhost:8080/postgres")
                    .setProperty(Environment.USER, "postgres")
                    .setProperty(Environment.PASS, "asanalieva48")
                    .setProperty(Environment.HBM2DDL_AUTO, "create")
                    .setProperty(Environment.SHOW_SQL, "true")
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        }
        return sessionFactory;
    }
}