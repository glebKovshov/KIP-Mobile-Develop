package model.animals;

import model.Predator;
import model.Animal;

public class Eagle extends Predator {

    public Eagle() {
        super("Орёл", 7, 20, "🦅");
    }

    @Override
    protected Animal createOffspring() {
        return new Eagle();
    }
}
