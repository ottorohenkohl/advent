package task_1;

import java.util.Arrays;
import java.util.List;

public class Set {
    
    private final List<Cubes> cubes;
    
    public Set(String line) {
        this.cubes = Arrays.stream(line.split(", ")).map(Cubes::new).toList();
    }
    
    public boolean isInvalid() {
        return cubes.stream().anyMatch(Cubes::isInvalid);
    }
    
}
