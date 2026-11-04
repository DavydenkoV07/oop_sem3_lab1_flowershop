
package ua.edu.flowershop.service;

import ua.edu.flowershop.model.Accessory;
import ua.edu.flowershop.model.Bouquet;
import ua.edu.flowershop.model.Flower;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BouquetService {

    // Визначення вартості букета
    public double calculateTotalPrice(Bouquet bouquet) {
        double totalFlowersPrice = bouquet.getFlowers().stream()
                .mapToDouble(Flower::getPrice)
                .sum();
                
        double totalAccessoriesPrice = bouquet.getAccessories().stream()
                .mapToDouble(Accessory::getPrice)
                .sum();
                
        return totalFlowersPrice + totalAccessoriesPrice;
    }

    // Сортування квітів у букеті за рівнем свіжості
    public void sortFlowersByFreshness(Bouquet bouquet) {
        bouquet.getFlowers().sort(Comparator.comparingInt(Flower::getFreshnessLevel).reversed());
    }

    // Пошук квітів за діапазоном довжини стебла
    public List<Flower> findFlowersByStemLengthRange(Bouquet bouquet, double minLength, double maxLength) {
        List<Flower> result = new ArrayList<>();
        for (Flower flower : bouquet.getFlowers()) {
            if (flower.getStemLength() >= minLength && flower.getStemLength() <= maxLength) {
                result.add(flower);
            }
        }
        return result;
    }
}