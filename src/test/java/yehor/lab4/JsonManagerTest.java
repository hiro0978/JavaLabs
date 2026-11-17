package yehor.lab4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import yehor.lab4.controller.UniversityCreator;
import yehor.lab4.json.JsonManager;
import yehor.lab4.model.University;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JsonManagerTest {

    /** На кожному рівні по два підрозділи нижчого рівня. */
    private static final int TWO = 2;

    @TempDir
    Path tempDir;

    private JsonManager jsonManager;
    private University oldUniversity;

    @BeforeEach
    void setUp() {
        jsonManager = new JsonManager();
        oldUniversity = new UniversityCreator(TWO, TWO, TWO, TWO)
                .create("Тестовий університет");
    }

    @Test
    void restoredUniversityEqualsOriginal() throws IOException {
        File file = tempDir.resolve("university.json").toFile();

        jsonManager.writeToFile(oldUniversity, file);
        University newUniversity = jsonManager.readFromFile(file);

        assertTrue(file.length() > 0, "JSON-файл не повинен бути порожнім");
        assertNotSame(oldUniversity, newUniversity);
        assertEquals(oldUniversity, newUniversity);
        assertTrue(oldUniversity.equals(newUniversity));
    }
}
