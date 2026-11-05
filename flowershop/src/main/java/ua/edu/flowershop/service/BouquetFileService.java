
package ua.edu.flowershop.service;

import ua.edu.flowershop.model.Accessory;
import ua.edu.flowershop.model.Bouquet;
import ua.edu.flowershop.model.Flower;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BouquetFileService {

    public void saveBouquetToFile(Bouquet bouquet, BouquetService bouquetService, String filePath) {
        // Використовуємо try-with-resources для автоматичного закриття файлу
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("====== YOUR BOUQUET ======\n");
            
            writer.write("\n-- Flowers:\n");
            for (Flower flower : bouquet.getFlowers()) {
                writer.write("- " + flower.toString() + "\n");
            }
            
            writer.write("\n-- Accessories:\n");
            for (Accessory accessory : bouquet.getAccessories()) {
                writer.write("- " + accessory.getName() + " (Price: $" + accessory.getPrice() + ")\n");
            }
            
            double totalPrice = bouquetService.calculateTotalPrice(bouquet);
            writer.write("\nTotal Bouquet Price: $" + totalPrice + "\n");
            writer.write("==========================\n");
            
            System.out.println("Bouquet successfully saved to file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error saving to file: " + e.getMessage());
        }
    }
}