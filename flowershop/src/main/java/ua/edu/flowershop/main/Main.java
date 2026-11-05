
package ua.edu.flowershop.main;

import ua.edu.flowershop.gui.FlowerShopGUI;
import ua.edu.flowershop.model.*;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // 1. Ініціалізація базового букета
        Bouquet bouquet = createSampleBouquet();

        // 2. Запуск графічного інтерфейсу у правильному потоці (Event Dispatch Thread)
        SwingUtilities.invokeLater(() -> {
            FlowerShopGUI gui = new FlowerShopGUI(bouquet);
            gui.setVisible(true);
        });
    }

    // Метод для створення тестового букета
    private static Bouquet createSampleBouquet() {
        Bouquet bouquet = new Bouquet();
        bouquet.addFlower(new Rose(60.0, 70.0, 9, true)); // Ціни та параметри залишаємо як є
        bouquet.addFlower(new Tulip(35.0, 45.0, 10));
        bouquet.addFlower(new Carnation(25.0, 50.0, 6));
        bouquet.addFlower(new Chamomile(15.0, 40.0, 8));
        
        bouquet.addAccessory(new Accessory("Craft Paper", 30.0));
        bouquet.addAccessory(new Accessory("Satin Ribbon", 15.0));
        return bouquet;
    }
}