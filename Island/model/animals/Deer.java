package model.animals;

import model.Herbivore;
import model.Animal;

public class Deer extends Herbivore {

    public Deer() {
        super("Олень", 10, 55, "🦌");
    }

    @Override
    protected Animal createOffspring() {
        return new Deer();
    }
}