package task_1;

public class Cubes {
    
    private final Color color;
    
    private final Integer amount;
    
    public Cubes(String line) {
        this.color = Color.valueOf(line.split(" ")[1]);
        this.amount = Integer.parseInt(line.split(" ")[0]);
    }
    
    public boolean isInvalid() {
        return amount > color.getMaximum();
    }
    
}
