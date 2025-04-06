package model;

public class Plant {
    private int energy; // Энергетическая ценность растения
    private String symbol = "🌱"; // Юникод-символ растения
    
    public Plant() {
        this.energy = 5; // Примерное значение
    }
    
    public int getEnergy() {
        return energy;
    }
    
    public String getSymbol() {
        return symbol;
    }
}
