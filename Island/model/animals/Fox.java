package model.animals;

import model.Predator;
import model.Animal;

public class Fox extends Predator {

    public Fox() {
        super("Лиса", 9, 30, "🦊");
    }

    @Override
    protected Animal createOffspring() {
        return new Fox();
    }
}