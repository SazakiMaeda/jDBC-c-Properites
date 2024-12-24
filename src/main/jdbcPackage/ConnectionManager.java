package main.jdbcPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class ConnectionManager {
    // Создаем переменные, куда помещаем данные с проперти файла
    private static final String URL_KEY = "db.url";
    private static final String USER_KEY = "db.user";
    private static final String PASSWORD_KEY = "db.password";
    // Создаем пустой ПРИВАТ конструктор
    private ConnectionManager() {
    }
    // Запускается при старте 1 раз
    static {
        loadDriver();
    }
    // Загружается драйвер.
    // Вроде как не обязательно сейчас указывать Class.name,
    // Но в случае чего перестраховаться.
    public static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    // Открываем соединение
    public static Connection open() {
        try {
            return DriverManager.getConnection(
                    PropertiesFile.getProperty(URL_KEY),
                    PropertiesFile.getProperty(USER_KEY),
                    PropertiesFile.getProperty(PASSWORD_KEY));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
