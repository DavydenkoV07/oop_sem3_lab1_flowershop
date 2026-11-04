package ua.edu.flowershop.model;

public class Rose extends Flower{
    private boolean hasThorns;

    public Rose(double price, double stemLength, int freshnessLevel, boolean hasThorns) {
        super("Троянда", price, stemLength, freshnessLevel);
        this.hasThorns = hasThorns;
    }

    public boolean isHasThorns() { return hasThorns; }
}

