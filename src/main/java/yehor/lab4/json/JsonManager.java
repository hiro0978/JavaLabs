package yehor.lab4.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import yehor.lab4.model.University;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * Перетворює університет у формат JSON і назад та працює з файлами.
 * Для серіалізації використовується бібліотека Gson.
 */
public class JsonManager {

    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .create();

    public String toJson(University university) {
        return gson.toJson(university);
    }

    public University fromJson(String json) {
        return gson.fromJson(json, University.class);
    }

    public void writeToFile(University university, File file) throws IOException {
        try (Writer writer = Files.newBufferedWriter(file.toPath(), StandardCharsets.UTF_8)) {
            gson.toJson(university, writer);
        }
    }

    public University readFromFile(File file) throws IOException {
        try (Reader reader = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8)) {
            return gson.fromJson(reader, University.class);
        }
    }
}
