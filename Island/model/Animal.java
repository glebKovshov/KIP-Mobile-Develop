package model;

public abstract class Animal {
    protected String name;
    protected int maxHunger;
    protected int currentHunger;
    protected int weight;
    protected Location location;
    protected String symbol;
    
    public Animal(String name, int maxHunger, int weight, String symbol) {
        this.name = name;
        this.maxHunger = maxHunger;
        this.currentHunger = 0;
        this.weight = weight;
        this.symbol = symbol;
    }
    
    // Абстрактные методы для поведения
    public abstract void eat();
    public abstract void move();
    public abstract Animal reproduce();
    
    public void increaseHunger() {
        currentHunger++;
        if (currentHunger > maxHunger) {
            die();
        }
    }
    
    public void resetHunger() {
        currentHunger = 0;
    }
    
    public void die() {
        // Удаляем животное из текущей локации
        if (location != null) {
            location.removeAnimal(this);
        }
        // Дополнительно можно пометить животное как мёртвое
    }
    
    public Location getLocation() {
        return location;
    }
    
    public void setLocation(Location loc) {
        if(this.location != null) {
            this.location.removeAnimal(this);
        }
        this.location = loc;
        loc.addAnimal(this);
    }
    
    public String getSymbol() {
        return symbol;
    }
    
    public String getName() {
        return name;
    }
}
