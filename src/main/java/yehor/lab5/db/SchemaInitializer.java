package yehor.lab5.db;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Collectors;

/**
 * Виконує SQL-скрипт database.sql: створює таблицю student і заповнює її даними.
 */
public class SchemaInitializer {

    private final ConnectionFactory connectionFactory;

    public SchemaInitializer(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public void run() throws SQLException {
        String script = loadScript(connectionFactory.getInitScript());
        try (Connection connection = connectionFactory.open();
             Statement statement = connection.createStatement()) {
            for (String command : script.split(";")) {
                if (!command.isBlank()) {
                    statement.execute(command);
                }
            }
        }
    }

    private String loadScript(String resource) {
        try (InputStream in = SchemaInitializer.class.getClassLoader()
                .getResourceAsStream(resource)) {
            if (in == null) {
                throw new IllegalStateException("Відсутній файл " + resource);
            }
            return new String(in.readAllBytes(), StandardCharsets.UTF_8).lines()
                    .filter(line -> !line.strip().startsWith("--"))
                    .collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
