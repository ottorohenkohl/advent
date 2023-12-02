package task_2;

import java.util.Arrays;
import java.util.List;

public class Set {
    
    private final List<Cubes> cubes;
    
    public Set(String line) {
        this.cubes = Arrays.stream(line.split(", ")).map(Cubes::new).toList();
    }
    
    public Integer getColor(Color color) {
        var existing = new java.util.ArrayList<>(cubes.stream()
                                                      .filter(c -> c.getColor() == color)
                                                      .map(Cubes::getAmount)
                                                      .toList());
        
        existing.add(0);
        
        return existing.getFirst();
    }
    
}
