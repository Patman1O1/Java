import java.util.Map;
import java.util.HashMap;

public class Category {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    private static final double EPSILON = 1.0e-10;

    public String name;

    private double weight;

    private double pointsEarned, totalPoints;

    private final Map<String, Item> items, drops;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public Category() {
        this.name = "";
        this.weight = this.pointsEarned = this.totalPoints = 0.0;
        this.items = new HashMap<>();
        this.drops = new HashMap<>();
    }

    public Category(String name) {
        this.name = name;
        this.weight = this.pointsEarned = this.totalPoints = 0.0;
        this.items = new HashMap<>();
        this.drops = new HashMap<>();
    }

    public Category(String name, double weight) throws IllegalArgumentException {
        this.name = name;
        this.setWeight(weight);
        this.pointsEarned = this.totalPoints = 0.0;
        this.items = new HashMap<>();
        this.drops = new HashMap<>();
    }

    /* -------------------------------------------------Setters------------------------------------------------------ */
    public void setWeight(double weight) throws IllegalArgumentException {
        if (weight < 0.0) {
            throw new IllegalArgumentException("\"weight\" cannot be negative");
        }
        this.weight = weight;
    }

    public void setItem(Item item) throws NullPointerException, IllegalAccessError {
        if (item == null) {
            throw new NullPointerException("\"item\" cannot be null");
        }

        if (!this.items.containsKey(item.name)) {
            throw new IllegalAccessError("could not set \"item\" because it was not found");
        }

        this.items.replace(item.name, this.items.get(item.name), item);
    }

    /* -------------------------------------------------Getters------------------------------------------------------ */
    public double getWeight() { return this.weight; }

    public Item getItem(String itemName) {
        if (itemName == null || this.items.isEmpty() || !this.items.containsKey(itemName)) {
            return null;
        }

        return this.items.get(itemName);
    }

    /* -------------------------------------------------Methods------------------------------------------------------ */
    protected static boolean doubleCompare(double lhs, double rhs) { return Math.abs(lhs - rhs) < Category.EPSILON; }

    @Override
    public String toString() { return this.name; }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Category other)) {
            return false;
        }

        return this.name.equals(other.name) && Category.doubleCompare(this.grade(), other.grade());
    }

    public void addItem(Item item) throws NullPointerException {
        if (item == null) {
            throw new NullPointerException("\"item\" cannot be null");
        }

        this.items.put(item.name, item);
        this.pointsEarned += item.getPointsEarned();
        this.totalPoints += item.getTotalPoints();
    }

    public Item removeItem(Item item) {
        if (item == null || !this.items.containsValue(item)) {
            return null;
        }

        this.pointsEarned -= item.getPointsEarned();
        this.totalPoints -= item.getTotalPoints();

        return this.items.remove(item.name);
    }

    public boolean containsItem(String itemName) {
        if (itemName == null || !this.items.containsKey(itemName)) {
            return false;
        }
        return this.items.containsKey(itemName);
    }

    public int countItems() { return this.items.size(); }

    public void drop(Item item) throws NullPointerException, IllegalArgumentException {
        if (item == null) {
            throw new NullPointerException("\"item\" cannot be null");
        }

        if (!this.items.containsKey(item.name) && !this.drops.containsKey(item.name)) {
            throw new IllegalArgumentException("\"item\" must be added as an item before it can be dropped");
        }

        if (this.drops.containsKey(item.name)) {
            Item oldDrop = this.drops.get(item.name);
            this.pointsEarned += Math.abs(oldDrop.getPointsEarned() - item.getPointsEarned());
            this.totalPoints += Math.abs(oldDrop.getTotalPoints() - item.getTotalPoints());

            this.drops.replace(item.name, oldDrop, item);
            return;
        }

        this.pointsEarned -= item.getPointsEarned();
        this.totalPoints -= item.getTotalPoints();
        this.drops.put(item.name, item);
        this.items.remove(item.name);
    }

    public Item undrop(Item drop) {
        if (drop == null || !this.drops.containsKey(drop.name)) {
            return null;
        }
        this.pointsEarned += drop.getPointsEarned();
        this.totalPoints += drop.getTotalPoints();

        this.items.put(drop.name, drop);
        return this.drops.remove(drop.name);
    }

    public int countDrops() { return this.drops.size(); }

    public boolean isDropped(String dropName) {
        if (dropName == null || this.drops.isEmpty()) {
            return false;
        }
        return this.drops.containsKey(dropName);
    }

    public double grade() {
        return Category.doubleCompare(this.totalPoints, 0.0) ? 0.0 :  this.pointsEarned / this.totalPoints;
    }

    public double gradeAsPercent() {
        return Category.doubleCompare(this.totalPoints, 0.0) ? 0.0 : this.pointsEarned / this.totalPoints * 100;
    }
}
