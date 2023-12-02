package task_2;

public class Cubes {
    
    private final Color color;
    
    private final Integer amount;
    
    public Cubes(String line) {
        this.color = Color.valueOf(line.split(" ")[1]);
        this.amount = Integer.parseInt(line.split(" ")[0]);
    }
    
    public Color getColor() {
        return color;
    }
    
    public Integer getAmount() {
        return amount;
    }
    
}
