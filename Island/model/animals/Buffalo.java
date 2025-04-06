package model.animals;

import model.Herbivore;
import model.Animal;

public class Buffalo extends Herbivore {

    public Buffalo() {
        super("Буйвол", 12, 90, "🐃");
    }

    @Override
    protected Animal createOffspring() {
        return new Buffalo();
    }
}
