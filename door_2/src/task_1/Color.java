package task_1;

public enum Color {
    
    red(12),
    green(13),
    blue(14);
    
    private final Integer maximum;
    
    Color(Integer maximum) {
        this.maximum = maximum;
    }
    
    public Integer getMaximum() {
        return maximum;
    }
}
