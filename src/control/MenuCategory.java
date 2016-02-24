package control;

public enum MenuCategory {
    DEFAULT("DEFAULT"),
    DIFFICULTY("DIFFICULTY");
    private final String name;
    private MenuCategory(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
}