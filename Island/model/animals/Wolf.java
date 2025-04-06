package model.animals;

import model.Predator;
import model.Animal;

public class Wolf extends Predator {

    public Wolf() {
        super("Волк", 10, 50, "🐺");
    }

    @Override
    protected Animal createOffspring() {
        return new Wolf();
    }
}
