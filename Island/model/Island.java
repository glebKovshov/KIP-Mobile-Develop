package model;

import config.SimulationConfig;
import java.util.ArrayList;
import java.util.List;

public class Island {
    private int width;
    private int height;
    private Location[][] grid;
    
    public Island() {
        this.width = SimulationConfig.ISLAND_WIDTH;
        this.height = SimulationConfig.ISLAND_HEIGHT;
        grid = new Location[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = new Location(i, j);
            }
        }
    }
    
    public Location getLocation(int row, int col) {
        if (row >= 0 && row < height && col >= 0 && col < width) {
            return grid[row][col];
        }
        return null;
    }
    
    public List<Location> getAdjacentLocations(int row, int col) {
        List<Location> adj = new ArrayList<>();
        int[] d = {-1, 0, 1};
        for (int dr : d) {
            for (int dc : d) {
                if (dr == 0 && dc == 0) continue;
                Location loc = getLocation(row + dr, col + dc);
                if (loc != null) {
                    adj.add(loc);
                }
            }
        }
        return adj;
    }
    
    public Location[][] getGrid() {
        return grid;
    }
}
