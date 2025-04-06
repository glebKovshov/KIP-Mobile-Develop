package simulation;

import config.SimulationConfig;
import model.Island;
import model.Location;
import model.Plant;
import model.Animal;
import model.animals.*;
import util.Statistics;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadLocalRandom;

public class SimulationRunner {
    private static Island island;
    private static ScheduledExecutorService scheduledExecutor;
    private static ExecutorService animalExecutor;
    private static boolean simulationRunning = true;
    
    public static Island getIsland() {
        return island;
    }
    
    public static void main(String[] args) {
        island = new Island();
        scheduledExecutor = Executors.newScheduledThreadPool(3);
        animalExecutor = Executors.newFixedThreadPool(10);
        
        // Инициализация острова: размещаем животных и растения
        initializeSimulation();
        
        // Задача роста растений (добавляем вероятность появления нового растения)
        scheduledExecutor.scheduleAtFixedRate(() -> {
            for (int i = 0; i < SimulationConfig.ISLAND_HEIGHT; i++) {
                for (int j = 0; j < SimulationConfig.ISLAND_WIDTH; j++) {
                    Location loc = island.getLocation(i, j);
                    // Случайный шанс вырастить новое растение
                    int chance = ThreadLocalRandom.current().nextInt(100);
                    if (chance < SimulationConfig.PLANT_GROWTH_CHANCE &&
                            loc.getPlants().size() < SimulationConfig.MAX_PLANTS_PER_CELL) {
                        loc.addPlant(new Plant());
                    }
                }
            }
        }, 0, SimulationConfig.TICK_DURATION_MS, TimeUnit.MILLISECONDS);
        
        // Задача жизненного цикла животных
        scheduledExecutor.scheduleAtFixedRate(() -> {
            for (int i = 0; i < SimulationConfig.ISLAND_HEIGHT; i++) {
                for (int j = 0; j < SimulationConfig.ISLAND_WIDTH; j++) {
                    Location loc = island.getLocation(i, j);
                    List<Animal> animals = loc.getAnimals();
                    for (Animal animal : animals) {
                        animalExecutor.submit(() -> {
                            animal.eat();
                            animal.move();
                            animal.reproduce();
                        });
                    }
                }
            }
        }, 0, SimulationConfig.TICK_DURATION_MS, TimeUnit.MILLISECONDS);
        
        // Задача вывода статистики
        scheduledExecutor.scheduleAtFixedRate(() -> {
            Statistics.printStatistics(island);
        }, 0, SimulationConfig.TICK_DURATION_MS, TimeUnit.MILLISECONDS);
        
        // Основной цикл симуляции: останавливаем, если на острове не осталось животных
        while (simulationRunning) {
            int totalAnimals = 0;
            for (int i = 0; i < SimulationConfig.ISLAND_HEIGHT; i++) {
                for (int j = 0; j < SimulationConfig.ISLAND_WIDTH; j++) {
                    totalAnimals += island.getLocation(i, j).getAnimals().size();
                }
            }
            if (totalAnimals == 0) {
                simulationRunning = false;
            }
            try {
                Thread.sleep(SimulationConfig.TICK_DURATION_MS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        shutdown();
    }
    
    private static void initializeSimulation() {
        // Размещаем животных случайным образом
        for (int i = 0; i < SimulationConfig.INITIAL_WOLF_COUNT; i++) {
            addAnimalToRandomLocation(new Wolf());
        }
        for (int i = 0; i < SimulationConfig.INITIAL_BOA_COUNT; i++) {
            addAnimalToRandomLocation(new Boa());
        }
        for (int i = 0; i < SimulationConfig.INITIAL_FOX_COUNT; i++) {
            addAnimalToRandomLocation(new Fox());
        }
        for (int i = 0; i < SimulationConfig.INITIAL_BEAR_COUNT; i++) {
            addAnimalToRandomLocation(new Bear());
        }
        for (int i = 0; i < SimulationConfig.INITIAL_EAGLE_COUNT; i++) {
            addAnimalToRandomLocation(new Eagle());
        }
        for (int i = 0; i < SimulationConfig.INITIAL_HORSE_COUNT; i++) {
            addAnimalToRandomLocation(new Horse());
        }
        for (int i = 0; i < SimulationConfig.INITIAL_DEER_COUNT; i++) {
            addAnimalToRandomLocation(new Deer());
        }
        for (int i = 0; i < SimulationConfig.INITIAL_RABBIT_COUNT; i++) {
            addAnimalToRandomLocation(new Rabbit());
        }
        for (int i = 0; i < SimulationConfig.INITIAL_MOUSE_COUNT; i++) {
            addAnimalToRandomLocation(new Mouse());
        }
        for (int i = 0; i < SimulationConfig.INITIAL_GOAT_COUNT; i++) {
            addAnimalToRandomLocation(new Goat());
        }
        for (int i = 0; i < SimulationConfig.INITIAL_SHEEP_COUNT; i++) {
            addAnimalToRandomLocation(new Sheep());
        }
        for (int i = 0; i < SimulationConfig.INITIAL_BOAR_COUNT; i++) {
            addAnimalToRandomLocation(new Boar());
        }
        for (int i = 0; i < SimulationConfig.INITIAL_BUFFALO_COUNT; i++) {
            addAnimalToRandomLocation(new Buffalo());
        }
        for (int i = 0; i < SimulationConfig.INITIAL_DUCK_COUNT; i++) {
            addAnimalToRandomLocation(new Duck());
        }
        for (int i = 0; i < SimulationConfig.INITIAL_CATERPILLAR_COUNT; i++) {
            addAnimalToRandomLocation(new Caterpillar());
        }
    }
    
    private static void addAnimalToRandomLocation(Animal animal) {
        int row = (int) (Math.random() * SimulationConfig.ISLAND_HEIGHT);
        int col = (int) (Math.random() * SimulationConfig.ISLAND_WIDTH);
        Location loc = island.getLocation(row, col);
        animal.setLocation(loc);
    }
    
    private static void shutdown() {
        scheduledExecutor.shutdown();
        animalExecutor.shutdown();
        System.out.println("Симуляция завершена.");
    }
}
