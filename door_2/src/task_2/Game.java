package task_2;

import java.util.Arrays;
import java.util.List;

public class Game {
    
    private final List<Set> sets;
    
    public Game(String line) {
        this.sets = Arrays.stream(line.split(": ")[1].split("; ")).map(Set::new).toList();
    }
    
    public Integer getMinimum(Color color) {
        return sets.stream().map(m -> m.getColor(color)).max(Integer::compare).orElse(1);
    }
    
    public Integer powerMinimum() {
        return getMinimum(Color.red) * getMinimum(Color.green) * getMinimum(Color.blue);
    }
    
}
