package model.animals;

import model.Herbivore;
import model.Animal;

public class Sheep extends Herbivore {

    public Sheep() {
        super("Овца", 7, 25, "🐑");
    }

    @Override
    protected Animal createOffspring() {
        return new Sheep();
    }
}
