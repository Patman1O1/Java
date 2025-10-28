public class Item {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    private static final double EPSILON = 1.0e-10;

    public String name;

    private double grade;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public Item() {
        this.name = "";
        this.grade = 0.0;
    }

    public Item(String name, double grade) throws IllegalArgumentException {
        this.name = name;
        this.setGrade(grade);
    }

    public Item(String name, double pointsEarned, double totalPoints) throws IllegalArgumentException {
        this.name = name;
        this.setGrade(pointsEarned, totalPoints);
    }

    /* -------------------------------------------------Setters------------------------------------------------------ */
    public void setGrade(double grade) throws IllegalArgumentException {
        if (grade < 0.0) {
            throw new IllegalArgumentException("\"grade\" cannot be negative");
        }

        this.grade = grade;
    }

    public void setGrade(double pointsEarned, double totalPoints) throws IllegalArgumentException {
        if (pointsEarned < 0.0) {
            throw new IllegalArgumentException("\"pointsEarned\" cannot be negative");
        }

        if (totalPoints <= 0.0) {
            throw new IllegalArgumentException("\"totalPoints\" cannot be non-positive");
        }

        this.grade = pointsEarned / totalPoints;
    }

    /* -------------------------------------------------Getters------------------------------------------------------ */
    public double getGrade() { return this.grade; }

    /* -------------------------------------------------Methods------------------------------------------------------ */
    @Override
    public String toString() { return this.name; }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Item other)) {
            return false;
        }

        return this.name.equals(other.name) && Math.abs(this.grade - other.grade) < Item.EPSILON;
    }

    public int compareTo(Item other) throws NullPointerException {
        if (other == null) {
            throw new NullPointerException("\"other\" cannot be null");
        }

        if (Math.abs(this.grade - other.grade) < Item.EPSILON) {
            return 0;
        }

        if (this.grade > other.grade) {
            return 1;
        }

        return -1;
    }

}
