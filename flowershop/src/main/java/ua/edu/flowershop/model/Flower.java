
package ua.edu.flowershop.model;

public abstract class Flower {
    private String name;
    private double price;
    private double stemLength; // в сантиметрах
    private int freshnessLevel; // 1-10, де 10 - найсвіжіша

    public Flower(String name, double price, double stemLength, int freshnessLevel) {
        this.name = name;
        this.price = price;
        this.stemLength = stemLength;
        this.freshnessLevel = freshnessLevel;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public double getStemLength() { return stemLength; }
    public int getFreshnessLevel() { return freshnessLevel; }

    @Override
    public String toString() {
        return name + " (Ціна: " + price + ", Довжина: " + stemLength + "см, Свіжість: " + freshnessLevel + ")";
    }
}