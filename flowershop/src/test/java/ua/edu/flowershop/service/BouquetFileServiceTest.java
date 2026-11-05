
package ua.edu.flowershop.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import ua.edu.flowershop.model.Bouquet;
import ua.edu.flowershop.model.Rose;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BouquetFileServiceTest {

    @TempDir
    Path tempDir; // JUnit 5 автоматично створить і видалить цю папку

    @Test
    void testSaveBouquetToFile() throws Exception {
        BouquetFileService fileService = new BouquetFileService();
        BouquetService bouquetService = new BouquetService();
        Bouquet bouquet = new Bouquet();
        bouquet.addFlower(new Rose(50.0, 60.0, 9, true));

        // Створюємо шлях до тимчасового файлу
        File tempFile = tempDir.resolve("test_bouquet.txt").toFile();

        // Виконуємо збереження
        fileService.saveBouquetToFile(bouquet, bouquetService, tempFile.getAbsolutePath());

        // Перевіряємо, чи файл існує
        assertTrue(tempFile.exists(), "The file must be created");

        // Перевіряємо, чи файл не порожній (читаємо його вміст)
        String content = Files.readString(tempFile.toPath());
        assertTrue(content.contains("====== YOUR BOUQUET ======"), "The file must contain a header");
        assertTrue(content.contains("Total Bouquet Price"), "The file must contain the final price");
    }
}