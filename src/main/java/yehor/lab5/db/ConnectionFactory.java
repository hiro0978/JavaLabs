package yehor.lab5.db;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Видає JDBC-з'єднання з базою даних. Параметри підключення зберігаються
 * у файлі resources/db.properties.
 */
public class ConnectionFactory {

    private static final String CONFIG = "db.properties";

    private final Properties settings = new Properties();

    public ConnectionFactory() {
        try (InputStream in = ConnectionFactory.class.getClassLoader()
                .getResourceAsStream(CONFIG)) {
            if (in == null) {
                throw new IllegalStateException("Відсутній файл " + CONFIG);
            }
            settings.load(in);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public Connection open() throws SQLException {
        return DriverManager.getConnection(settings.getProperty("db.url"),
                settings.getProperty("db.user"), settings.getProperty("db.password"));
    }

    public String getUrl() {
        return settings.getProperty("db.url");
    }

    public String getInitScript() {
        return settings.getProperty("db.init-script");
    }
}
