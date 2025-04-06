package model.animals;

import model.Herbivore;
import model.Animal;

public class Goat extends Herbivore {

    public Goat() {
        super("Коза", 7, 20, "🐐");
    }

    @Override
    protected Animal createOffspring() {
        return new Goat();
    }
}
