package ua.edu.flowershop.model;

import java.util.ArrayList;
import java.util.List;

public class Bouquet {
    private List<Flower> flowers;
    private List<Accessory> accessories;

    public Bouquet() {
        this.flowers = new ArrayList<>();
        this.accessories = new ArrayList<>();
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public void addAccessory(Accessory accessory) {
        accessories.add(accessory);
    }

    public List<Flower> getFlowers() { return flowers; }
    public List<Accessory> getAccessories() { return accessories; }
}