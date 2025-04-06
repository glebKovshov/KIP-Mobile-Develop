package model;

import simulation.SimulationRunner;
import util.FoodChainProbability;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import config.SimulationConfig;

public abstract class Herbivore extends Animal {

    public Herbivore(String name, int maxHunger, int weight, String symbol) {
        super(name, maxHunger, weight, symbol);
    }
    
    @Override
    public void eat() {
        // Утка может съесть гусеницу
        if (this.name.equalsIgnoreCase("Утка")) {
            List<Animal> animals = location.getAnimals();
            for (Animal a : animals) {
                if (a.getName().equalsIgnoreCase("Гусеница")) {
                    int chance = FoodChainProbability.getProbability(this.name, a.getName());
                    int random = ThreadLocalRandom.current().nextInt(100);
                    if (random < chance) {
                        a.die();
                        resetHunger();
                        System.out.println(this.name + " съел " + a.getName() +
                                " в клетке (" + location.getRow() + "," + location.getCol() + ")");
                        return;
                    }
                }
            }
        }
        // Если гусеницы нет – едим растения
        if (!location.getPlants().isEmpty()) {
            Plant plant = location.getPlants().get(0);
            location.removePlant(plant);
            resetHunger();
            System.out.println(this.name + " съел растение в клетке (" +
                    location.getRow() + "," + location.getCol() + ")");
        } else {
            increaseHunger();
        }
    }
    
    @Override
    public void move() {
        Island island = SimulationRunner.getIsland();
        List<Location> adj = island.getAdjacentLocations(location.getRow(), location.getCol());
        if (!adj.isEmpty()) {
            Location newLoc = adj.get(ThreadLocalRandom.current().nextInt(adj.size()));
            setLocation(newLoc);
        }
    }
    
    @Override
    public Animal reproduce() {
        // Если в клетке есть другой представитель того же вида
        List<Animal> animals = location.getAnimals();

        // Ограничиваем общее число животных в клетке
        if (animals.size() >= SimulationConfig.MAX_ANIMALS_PER_CELL) {
            return null;
        }
        
        for (Animal a : animals) {
            if (a != this && a.getClass() == this.getClass()) {
                // Шанс на размножение
                int randomChance = ThreadLocalRandom.current().nextInt(100);
                if (randomChance < SimulationConfig.REPRODUCTION_CHANCE) {
                    Animal offspring = createOffspring();
                    location.addAnimal(offspring);
                    offspring.setLocation(location);
                    System.out.println(this.name + " размножился в клетке (" +
                            location.getRow() + "," + location.getCol() + ")");
                    return offspring;
                }
            }
        }
        return null;
    }
    
    protected abstract Animal createOffspring();
}
