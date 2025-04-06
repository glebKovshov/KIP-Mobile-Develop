package model.animals;

import model.Herbivore;
import model.Animal;

public class Caterpillar extends Herbivore {

    public Caterpillar() {
        super("Гусеница", 2, 1, "🐛");
    }

    @Override
    protected Animal createOffspring() {
        return new Caterpillar();
    }
}
