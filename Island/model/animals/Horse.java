package model.animals;

import model.Herbivore;
import model.Animal;

public class Horse extends Herbivore {

    public Horse() {
        super("Лошадь", 10, 60, "🐎");
    }

    @Override
    protected Animal createOffspring() {
        return new Horse();
    }
}
