import java.util.*;

public class Category {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    private static final double EPSILON = 1.0e-10;

    public String name;

    private double weight, grade;

    private final Map<String, Item> items;

    private final Stack<Item> drops;

    private final Queue<Item> worstItems;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public Category() {
        this.name = "";
        this.weight = this.grade = 0.0;
        this.items = new HashMap<>();
        this.worstItems = new PriorityQueue<>(Comparator.comparingDouble(Item::getGrade));
        this.drops = new Stack<>();
    }

    public Category(String name) {
        this.name = name;
        this.weight = this.grade = 0.0;
        this.items = new HashMap<>();
        this.worstItems = new PriorityQueue<>(Comparator.comparingDouble(Item::getGrade));
        this.drops = new Stack<>();
    }

    public Category(String name, double weight) throws IllegalArgumentException {
        this.name = name;
        this.setWeight(weight);
        this.grade = 0.0;
        this.items = new HashMap<>();
        this.worstItems = new PriorityQueue<>(Comparator.comparingDouble(Item::getGrade));
        this.drops = new Stack<>();
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

        Item oldItem = this.items.get(item.name);
        this.worstItems.remove(oldItem);
        this.items.replace(item.name, oldItem, item);
        this.worstItems.add(item);
    }

    /* -------------------------------------------------Getters------------------------------------------------------ */
    public double getWeight() { return this.weight; }

    public Item getItem(String itemName) {
        if (itemName == null || this.items.isEmpty() || !this.items.containsKey(itemName)) {
            return null;
        }

        return this.items.get(itemName);
    }

    public Item getWorstItem() { return this.worstItems.peek(); }

    /* -------------------------------------------------Methods------------------------------------------------------ */
    protected static boolean doubleCompare(double lhs, double rhs) { return Math.abs(lhs - rhs) < Category.EPSILON; }

    @Override
    public String toString() { return this.name; }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Category other)) {
            return false;
        }

        return this.name.equals(other.name) && Category.doubleCompare(this.grade, other.grade);
    }

    public void addItem(Item item) throws NullPointerException {
        if (item == null) {
            throw new NullPointerException("\"item\" cannot be null");
        }

        this.items.put(item.name, item);
        this.worstItems.add(item);
        this.grade += item.getGrade();
    }

    public Item removeItem(Item item) {
        if (item == null || !this.items.containsValue(item)) {
            return null;
        }

        this.grade -= item.getGrade();
        this.worstItems.remove(item);
        return this.items.remove(item.name);
    }

    public boolean containsItem(String itemName) {
        if (itemName == null || !this.items.containsKey(itemName)) {
            return false;
        }
        return this.items.containsKey(itemName);
    }

    public int countItems() { return this.items.size(); }

    public void drop() {
        if (this.worstItems.isEmpty()) {
            return;
        }

        Item worstItem = this.worstItems.peek();

        this.grade -= worstItem.getGrade();
        this.drops.push(worstItem);
        this.items.remove(worstItem.name);
    }

    public Item undrop() {
        if (this.drops.empty()) {
            return null;
        }

        Item drop = this.drops.peek();

        this.grade += drop.getGrade();
        this.items.put(drop.name, drop);
        return this.drops.pop();
    }

    public int countDrops() { return this.drops.size(); }

}
