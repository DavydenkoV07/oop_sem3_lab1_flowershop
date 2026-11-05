
package ua.edu.flowershop.main;

import ua.edu.flowershop.model.Accessory;
import ua.edu.flowershop.model.Bouquet;
import ua.edu.flowershop.model.Flower;
import ua.edu.flowershop.model.Rose;
import ua.edu.flowershop.model.Tulip;
import ua.edu.flowershop.service.BouquetService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Створення об'єктів
        Flower rose1 = new Rose(50.0, 60.5, 9, true);
        Flower rose2 = new Rose(45.0, 50.0, 7, true);
        Flower tulip1 = new Tulip(30.0, 40.0, 10);
        
        Accessory wrapper = new Accessory("Паперова обгортка", 20.0);
        Accessory ribbon = new Accessory("Стрічка", 10.0);

        // 2. Збирання букета
        Bouquet bouquet = new Bouquet();
        bouquet.addFlower(rose1);
        bouquet.addFlower(rose2);
        bouquet.addFlower(tulip1);
        bouquet.addAccessory(wrapper);
        bouquet.addAccessory(ribbon);

        BouquetService service = new BouquetService();

        // 3. Вартість букета
        System.out.println("Загальна вартість букета: " + service.calculateTotalPrice(bouquet) + " грн");

        // 4. Сортування за свіжістю
        System.out.println("\nКвіти до сортування:");
        bouquet.getFlowers().forEach(System.out::println);

        service.sortFlowersByFreshness(bouquet);

        System.out.println("\nКвіти після сортування (за спаданням свіжості):");
        bouquet.getFlowers().forEach(System.out::println);

        // 5. Пошук квітки
        double min = 45.0;
        double max = 55.0;
        System.out.println("\nПошук квітів з довжиною стебла від " + min + " до " + max + " см:");
        List<Flower> foundFlowers = service.findFlowersByStemLengthRange(bouquet, min, max);
        foundFlowers.forEach(System.out::println);
    }
}