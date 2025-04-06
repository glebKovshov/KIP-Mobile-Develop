package model.animals;

import model.Herbivore;
import model.Animal;

public class Duck extends Herbivore {

    public Duck() {
        super("Утка", 6, 10, "🦆");
    }

    @Override
    protected Animal createOffspring() {
        return new Duck();
    }
}