package model;

import simulation.SimulationRunner;
import util.FoodChainProbability;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import config.SimulationConfig;

public abstract class Predator extends Animal {

    public Predator(String name, int maxHunger, int weight, String symbol) {
        super(name, maxHunger, weight, symbol);
    }
    
    @Override
    public void eat() {
        // Хищники ищут в локации травоядных
        List<Animal> animals = location.getAnimals();
        for (Animal prey : animals) {
            if (prey instanceof Herbivore) {
                int chance = FoodChainProbability.getProbability(this.name, prey.getName());
                int random = ThreadLocalRandom.current().nextInt(100);
                if (random < chance) {
                    prey.die();
                    resetHunger();
                    System.out.println(this.name + " съел " + prey.getName() +
                            " в клетке (" + location.getRow() + "," + location.getCol() + ")");
                    return;
                }
            }
        }
        // Если пищи нет – увеличиваем голод
        increaseHunger();
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
        // Если в клетке есть другой представитель того же вида – пробуем размножиться
        List<Animal> animals = location.getAnimals();

        // Проверка лимита животных в клетке
        if (animals.size() >= SimulationConfig.MAX_ANIMALS_PER_CELL) {
            return null;
        }

        for (Animal a : animals) {
            if (a != this && a.getClass() == this.getClass()) {
                // Случайный шанс размножения
                int randomChance = ThreadLocalRandom.current().nextInt(100);
                if (randomChance < SimulationConfig.REPRODUCTION_CHANCE) {
                    Animal offspring = createOffspring();
                    // Добавляем потомка
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
    
    // Метод для создания потомка конкретного вида
    protected abstract Animal createOffspring();
}
