package memento;

public class Item {

    private String name;
    private double value;

    public Item(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public double getValue() {
        return value;
    }

    public Item setValue(double value) {
        this.value = value;
        return this;
    }
}
