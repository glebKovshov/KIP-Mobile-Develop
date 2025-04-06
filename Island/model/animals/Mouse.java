package model.animals;

import model.Herbivore;
import model.Animal;

public class Mouse extends Herbivore {

    public Mouse() {
        super("Мышь", 3, 2, "🐁");
    }

    @Override
    protected Animal createOffspring() {
        return new Mouse();
    }
}
