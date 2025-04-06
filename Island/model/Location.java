package model;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private int row;
    private int col;
    private List<Animal> animals;
    private List<Plant> plants;
    
    public Location(int row, int col) {
        this.row = row;
        this.col = col;
        animals = new ArrayList<>();
        plants = new ArrayList<>();
    }
    
    public synchronized void addAnimal(Animal animal) {
        animals.add(animal);
    }
    
    public synchronized void removeAnimal(Animal animal) {
        animals.remove(animal);
    }
    
    public synchronized List<Animal> getAnimals() {
        return new ArrayList<>(animals);
    }
    
    public synchronized void addPlant(Plant plant) {
        plants.add(plant);
    }
    
    public synchronized void removePlant(Plant plant) {
        plants.remove(plant);
    }
    
    public synchronized List<Plant> getPlants() {
        return new ArrayList<>(plants);
    }
    
    public int getRow() {
        return row;
    }
    
    public int getCol() {
        return col;
    }
}
