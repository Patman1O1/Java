import java.util.Map;
import java.util.HashMap;

public class Category {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    private static final double EPSILON = 1.0e-10;

    public String name;

    private double weight;

    private int precision;

    private double totalPoints;

    private Map<String, Double> items, drops;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public Category() {
        this.name = "";
        this.weight = this.totalPoints = 0.0;
        this.precision = 0;
        this.items = this.drops = new HashMap<>();
    }

    public Category(String name) {
        this.name = name;
        this.weight = this.totalPoints = 0.0;
        this.precision = 0;
        this.items = this.drops = new HashMap<>();
    }

    public Category(String name, double weight) throws IllegalArgumentException {
        this.name = name;
        this.setWeight(weight);
        this.totalPoints = 0.0;
        this.precision = 0;
        this.items = this.drops = new HashMap<>();
    }

    public Category(String name, double weight, int precision) throws IllegalArgumentException {
        this.name = name;
        this.setWeight(weight);
        this.totalPoints = 0.0;
        this.setPrecision(precision);
        this.items = this.drops = new HashMap<>();
    }

    /* -------------------------------------------------Setters------------------------------------------------------ */
    public void setWeight(double weight) throws IllegalArgumentException {
        if (weight < 0.0) {
            throw new IllegalArgumentException("\"weight\" cannot be negative");
        }
        this.weight = weight;
    }

    public void setPrecision(int precision) throws IllegalArgumentException {
        if (precision < 0) {
            throw new IllegalArgumentException("\"precision\" cannot be negative");
        }
        this.precision = precision;
    }

    /* -------------------------------------------------Getters------------------------------------------------------ */
    public double getWeight() { return this.weight; }

    public int getPrecision() { return this.precision; }

    /* -------------------------------------------------Methods------------------------------------------------------ */
    public void addItem(String itemName, double itemPoints) throws IllegalArgumentException {
        if (itemPoints < 0.0) {
            throw new IllegalArgumentException("\"itemPoints\" cannot be negative");
        }

        this.items.put(itemName, itemPoints);
    }

    public double itemGrade(String itemName) throws IllegalAccessError {
        if (!this.items.containsKey(itemName)) {
            throw new IllegalAccessError("\"itemName\" not found");
        }
        return this.items.get(itemName);
    }

}
