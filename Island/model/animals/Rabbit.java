package model.animals;

import model.Herbivore;
import model.Animal;

public class Rabbit extends Herbivore {

    public Rabbit() {
        super("Кролик", 5, 5, "🐇");
    }

    @Override
    protected Animal createOffspring() {
        return new Rabbit();
    }
}
