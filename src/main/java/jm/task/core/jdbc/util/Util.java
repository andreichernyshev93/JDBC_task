package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static final String HOST = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static Connection connection;

    private static SessionFactory sessionFactory;

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties properties = new Properties();
                properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                properties.put(Environment.URL,
                        "jdbc:mysql://localhost:3306/mydbtest?useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow");
                properties.put(Environment.USER, "root");
                properties.put(Environment.PASS, "root");

                properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                properties.put(Environment.SHOW_SQL, "true");
                properties.put(Environment.HBM2DDL_AUTO, "create-drop");
                properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL57Dialect");

                configuration.setProperties(properties);

                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
