public class Item {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    public String name;

    private double pointsEarned, totalPoints;

    private static final double EPSILON = 1.0e-10;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public Item() {
        this.name = "";
        this.pointsEarned = 0.0;
        this.totalPoints = 1.0;
    }

    public Item(String name, double pointsEarned, double totalPoints) throws IllegalArgumentException {
        this.name = name;
        this.setPointsEarned(pointsEarned);
        this.setTotalPoints(totalPoints);
    }

    /* -------------------------------------------------Setters------------------------------------------------------ */
    public void setPointsEarned(double pointsEarned) throws IllegalArgumentException {
        if (pointsEarned < 0.0) {
            throw new IllegalArgumentException("\"pointsEarned\" cannot be negative");
        }
        this.pointsEarned = pointsEarned;
    }

    public void setTotalPoints(double totalPoints) throws IllegalArgumentException {
        if (totalPoints <= 0.0) {
            throw new IllegalArgumentException("\"totalPoints\" cannot non-positive");
        }
        this.totalPoints = totalPoints;
    }

    /* -------------------------------------------------Getters------------------------------------------------------ */
    public double getPointsEarned() { return this.pointsEarned; }

    public double getTotalPoints() { return this.totalPoints; }

    /* -------------------------------------------------Methods------------------------------------------------------ */
    @Override
    public String toString() { return this.name; }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Item other)) {
            return false;
        }
        return this.name.equals(other.name) &&
                Math.abs(this.pointsEarned / this.totalPoints - other.pointsEarned / other.totalPoints) < Item.EPSILON;
    }

    public boolean compare(Item other) {
        if (other == null) {
            return false;
        }
        return Math.abs(this.pointsEarned / this.totalPoints - other.pointsEarned / other.totalPoints) < Item.EPSILON;
    }

    public double grade() { return this.pointsEarned / this.totalPoints; }

    public double gradeAsPercent() { return this.pointsEarned / this.totalPoints * 100; }

}
