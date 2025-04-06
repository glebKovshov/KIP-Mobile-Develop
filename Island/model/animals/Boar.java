package model.animals;

import model.Herbivore;
import model.Animal;

public class Boar extends Herbivore {

    public Boar() {
        super("Кабан", 8, 45, "🐗");
    }

    @Override
    protected Animal createOffspring() {
        return new Boar();
    }
}
