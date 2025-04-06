package config;

public class SimulationConfig {
    public static final int ISLAND_WIDTH = 100;
    public static final int ISLAND_HEIGHT = 20;
    public static final int TICK_DURATION_MS = 1000;

    // Начальное количество животных каждого вида
    public static final int INITIAL_WOLF_COUNT = 5;
    public static final int INITIAL_BOA_COUNT = 5;
    public static final int INITIAL_FOX_COUNT = 5;
    public static final int INITIAL_BEAR_COUNT = 2;
    public static final int INITIAL_EAGLE_COUNT = 3;
    
    public static final int INITIAL_HORSE_COUNT = 10;
    public static final int INITIAL_DEER_COUNT = 10;
    public static final int INITIAL_RABBIT_COUNT = 20;
    public static final int INITIAL_MOUSE_COUNT = 30;
    public static final int INITIAL_GOAT_COUNT = 10;
    public static final int INITIAL_SHEEP_COUNT = 10;
    public static final int INITIAL_BOAR_COUNT = 10;
    public static final int INITIAL_BUFFALO_COUNT = 5;
    public static final int INITIAL_DUCK_COUNT = 10;
    public static final int INITIAL_CATERPILLAR_COUNT = 20;
    
    // Максимальное количество животных/растений в одной клетке
    public static final int MAX_ANIMALS_PER_CELL = 10;
    public static final int MAX_PLANTS_PER_CELL = 50;

    // Новые параметры
    public static final int REPRODUCTION_CHANCE = 20;     // 20% шанс, что животное действительно размножится
    public static final int PLANT_GROWTH_CHANCE = 30;     // 30% шанс, что в клетке вырастет новое растение при каждом такте
}
