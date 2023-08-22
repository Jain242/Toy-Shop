/**
 * Toy
 */
public class Toy{
    private static int nextId = 1;
    private int id;
    private String name;
    private int quantity;
    private double choice;

    public Toy(String name, int quantity, double choice) {
        this.id = nextId++;
        this.name = name;
        this.quantity = quantity;
        this.choice = choice;

    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getChoice() {
        return choice;
    }

    public void setChoice(double choice) {
        this.choice = choice;
    }

    
}