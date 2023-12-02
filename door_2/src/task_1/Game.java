package task_1;

import java.util.Arrays;
import java.util.List;

public class Game {
    
    private final Integer id;
    
    private final List<Set> sets;
    
    public Game(String line) {
        this.id = Integer.parseInt(line.split(":")[0].split(" ")[1]);
        this.sets = Arrays.stream(line.split(": ")[1].split("; ")).map(Set::new).toList();
    }
    
    public boolean isValid() {
        return sets.stream().noneMatch(Set::isInvalid);
    }
    
    public Integer getId() {
        return id;
    }
    
}
