package util;

import java.util.HashMap;
import java.util.Map;

public class FoodChainProbability {
    private static Map<String, Map<String, Integer>> probabilityMatrix = new HashMap<>();
    
    static {
        // Пример заполнения матрицы вероятностей (значения взяты из Таблицы к Острову)
        Map<String, Integer> wolfMap = new HashMap<>();
        wolfMap.put("Кролик", 60);
        wolfMap.put("Олень", 30);
        wolfMap.put("Мышь", 80);
        wolfMap.put("Коза", 50);
        probabilityMatrix.put("Волк", wolfMap);
        
        Map<String, Integer> boaMap = new HashMap<>();
        boaMap.put("Мышь", 70);
        boaMap.put("Кролик", 40);
        probabilityMatrix.put("Удав", boaMap);
        
        Map<String, Integer> foxMap = new HashMap<>();
        foxMap.put("Кролик", 70);
        foxMap.put("Мышь", 90);
        probabilityMatrix.put("Лиса", foxMap);
        
        Map<String, Integer> bearMap = new HashMap<>();
        bearMap.put("Кролик", 40);
        bearMap.put("Олень", 50);
        bearMap.put("Мышь", 60);
        probabilityMatrix.put("Медведь", bearMap);
        
        Map<String, Integer> eagleMap = new HashMap<>();
        eagleMap.put("Кролик", 80);
        eagleMap.put("Мышь", 85);
        probabilityMatrix.put("Орёл", eagleMap);
        
        // Для утки – вероятность съесть гусеницу
        Map<String, Integer> duckMap = new HashMap<>();
        duckMap.put("Гусеница", 50);
        probabilityMatrix.put("Утка", duckMap);
    }
    
    public static int getProbability(String predator, String prey) {
        if (probabilityMatrix.containsKey(predator)) {
            Map<String, Integer> preyMap = probabilityMatrix.get(predator);
            if (preyMap.containsKey(prey)) {
                return preyMap.get(prey);
            }
        }
        return 0;
    }
}
