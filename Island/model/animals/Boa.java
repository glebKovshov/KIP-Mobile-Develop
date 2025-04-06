package model.animals;

import model.Predator;
import model.Animal;

public class Boa extends Predator {

    public Boa() {
        super("Удав", 8, 40, "🐍");
    }

    @Override
    protected Animal createOffspring() {
        return new Boa();
    }
}
