
package ua.edu.flowershop.gui;

import ua.edu.flowershop.model.Bouquet;
import ua.edu.flowershop.model.Flower;
import ua.edu.flowershop.service.BouquetFileService;
import ua.edu.flowershop.service.BouquetService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FlowerShopGUI extends JFrame {
    private Bouquet bouquet;
    private BouquetService bouquetService;
    private BouquetFileService fileService;
    private JTextArea displayArea;

    public FlowerShopGUI(Bouquet bouquet) {
        this.bouquet = bouquet;
        this.bouquetService = new BouquetService();
        this.fileService = new BouquetFileService();

        // Налаштування головного вікна
        setTitle("Flower Shop");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Центрування вікна на екрані
        setLayout(new BorderLayout(10, 10));

        // Текстова область для виводу інформації
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        displayArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane, BorderLayout.CENTER);

        // Панель для кнопок (розташуємо зліва)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 1, 5, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton btnShow = new JButton("Show Bouquet");
        JButton btnPrice = new JButton("Calculate Total Price");
        JButton btnSort = new JButton("Sort by Freshness");
        JButton btnFind = new JButton("Find by Stem Length");
        JButton btnSave = new JButton("Save to File");
        JButton btnExit = new JButton("Exit");

        buttonPanel.add(btnShow);
        buttonPanel.add(btnPrice);
        buttonPanel.add(btnSort);
        buttonPanel.add(btnFind);
        buttonPanel.add(btnSave);
        buttonPanel.add(btnExit);

        add(buttonPanel, BorderLayout.WEST);

        // Додавання обробників подій для кнопок
        btnShow.addActionListener(e -> showBouquet());
        btnPrice.addActionListener(e -> showTotalPrice());
        btnSort.addActionListener(e -> sortBouquet());
        btnFind.addActionListener(e -> findFlowers());
        btnSave.addActionListener(e -> saveBouquet());
        btnExit.addActionListener(e -> System.exit(0));

        // Початковий вивід
        displayArea.setText("Welcome to the Flower Shop!\nPlease select an action from the menu on the left.");
    }

    private void showBouquet() {
        displayArea.setText("--- Bouquet Composition ---\n");
        for (Flower f : bouquet.getFlowers()) {
            displayArea.append(f.toString() + "\n");
        }
    }

    private void showTotalPrice() {
        double price = bouquetService.calculateTotalPrice(bouquet);
        displayArea.append("\nTotal Bouquet Price: $" + price + "\n");
    }

    private void sortBouquet() {
        bouquetService.sortFlowersByFreshness(bouquet);
        displayArea.setText("--- Flowers Sorted by Freshness ---\n");
        showBouquet();
    }

    private void findFlowers() {
        try {
            String minStr = JOptionPane.showInputDialog(this, "Enter minimum stem length (cm):");
            if (minStr == null) return; // Якщо користувач натиснув "Скасувати"
            double min = Double.parseDouble(minStr.trim().replace(",", "."));

            String maxStr = JOptionPane.showInputDialog(this, "Enter maximum stem length (cm):");
            if (maxStr == null) return;
            double max = Double.parseDouble(maxStr.trim().replace(",", "."));

            List<Flower> found = bouquetService.findFlowersByStemLengthRange(bouquet, min, max);
            displayArea.setText("--- Search Results (" + min + " - " + max + " cm) ---\n");
            
            if (found.isEmpty()) {
                displayArea.append("No flowers found in this range.\n");
            } else {
                for (Flower f : found) {
                    displayArea.append(f.toString() + "\n");
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error! Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveBouquet() {
        String fileName = "my_bouquet.txt";
        fileService.saveBouquetToFile(bouquet, bouquetService, fileName);
        JOptionPane.showMessageDialog(this, "Bouquet successfully saved to file:\n" + fileName, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}