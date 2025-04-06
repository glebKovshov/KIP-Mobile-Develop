package util;

import model.Island;
import model.Location;
import model.Animal;

import java.util.List;

public class Statistics {
    public static void printStatistics(Island island) {
        int totalAnimals = 0;
        int totalPlants = 0;
        
        for (int i = 0; i < island.getGrid().length; i++) {
            for (int j = 0; j < island.getGrid()[0].length; j++) {
                Location loc = island.getGrid()[i][j];
                List<Animal> animals = loc.getAnimals();
                totalAnimals += animals.size();
                totalPlants += loc.getPlants().size();
            }
        }
        
        System.out.println("Статистика по острову:");
        System.out.println("Всего животных: " + totalAnimals);
        System.out.println("Всего растений: " + totalPlants);
    }
}
