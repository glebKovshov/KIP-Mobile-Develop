package model.animals;

import model.Predator;
import model.Animal;

public class Bear extends Predator {

    public Bear() {
        super("Медведь", 12, 100, "🐻");
    }

    @Override
    protected Animal createOffspring() {
        return new Bear();
    }
}
