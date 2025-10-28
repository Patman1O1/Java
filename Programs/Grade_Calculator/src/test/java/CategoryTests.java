import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CategoryTests {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    private static final double EPSILON = 1.0e-10;

    private static Category category;

    private static final Item[] lectureItems = {
            new Item("Lecture 1.2", 2.25, 4.00),
            new Item("Lecture 2.2", 2.75, 3.00),
            new Item("Lecture 3.1", 1.50, 3.00),
            new Item("Lecture 3.2", 2.25, 3.00),
            new Item("Lecture 4.1", 2.50, 4.00),
            new Item("Lecture 4.2", 2.50, 3.00),
            new Item("Lecture 5.1", 0.00, 3.00),
            new Item("Lecture 5.2", 3.75, 4.00),
            new Item("Lecture 6.1", 1.00, 3.00),
            new Item("Lecture 6.2", 3.00, 4.00),
            new Item("Lecture 7.1", 3.00, 4.00),
            new Item("Lecture 7.2", 1.75, 3.00),
            new Item("Lecture 8.1", 2.50, 3.00),
            new Item("Lecture 8.2", 3.75, 4.00),
            new Item("Lecture 9.1", 0.75, 3.00),
            new Item("Lecture 9.2", 3.75, 4.00),
            new Item("Lecture 10.1", 2.25, 3.00),
            new Item("Lecture 10.2", 2.75, 4.00),
            new Item("Lecture 11.1", 2.25, 3.00),
            new Item("Lecture 11.2", 1.75, 3.00),
            new Item("Lecture 12.1", 3.00, 4.00),
            new Item("Lecture 12.2", 1.75, 3.00),
            new Item("Lecture 13.1", 2.50, 3.00),
            new Item("Lecture 13.2", 3.50, 4.00),
            new Item("Lecture 14.1", 2.50, 3.00),
            new Item("Lecture 14.2", 1.0, 1.0),
            new Item("Lecture 15.1", 2.25, 3.00),
            new Item("Lecture 15.2", 1.50, 3.00)
    };

    private static final Item[] groupProblemItems = {
            new Item("Group Problems 1", 2.00, 4.00),
            new Item("Group Problems 2", 2.00, 3.00),
            new Item("Group Problems 3", 3.00, 5.00),
            new Item("Group Problems 4", 1.0, 1.0),
            new Item("Group Problems 5", 4.00, 5.00),
            new Item("Group Problems 6", 4.00, 5.00),
            new Item("Group Problems 7", 1.0, 1.0),
            new Item("Group Problems 8", 3.00, 5.00),
            new Item("Group Problems 9", 1.0, 1.0),
            new Item("Group Problems 10", 1.0, 1.0),
            new Item("Group Problems 11", 4.00, 5.00),
            new Item("Group Problems 12", 2.00, 4.00),
            new Item("Group Problems 13", 4.00, 6.00),
            new Item("Group Problems 14", 3.00, 4.00),
            new Item("Group Problems 15", 2.00, 4.00)
    };

    private static final Item[] onlineHWItems = {
            new Item("Online HW 1", 0.0),
            new Item("Online HW 2", 0.95),
            new Item("Online HW 3", 0.90),
            new Item("Online HW 4", 0.9333),
            new Item("Online HW 5", 0.6889),
            new Item("Online HW 6", 0.9445),
            new Item("Online HW 7", 0.8333),
            new Item("Online HW 8", 0.9667),
            new Item("Online HW 9", 0.0),
            new Item("Online HW 10", 0.6133),
            new Item("Online HW 11", 0.7614),
            new Item("Online HW 12", 1.0),
            new Item("Online HW 13", 0.9167),
            new Item("Online HW 14", 0.9953),
            new Item("Online HW 15", 0.0),
    };

    private static final Item[] writtenHWItems = {
            new Item("Written HW 0", 14.0, 20.0),
            new Item("Written HW 1", 17.0, 20.0),
            new Item("Written HW 2", 18.0, 20.0),
            new Item("Written HW 3", 16.50, 20.0),
            new Item("Written HW 4", 19.0, 20.0),
            new Item("Written HW 5", 0.0, 20.0),
            new Item("Written HW 6", 15.0, 20.0),
            new Item("Written HW 7", 1.0),
            new Item("Written HW 8", 19.0, 20.0),
            new Item("Written HW 9", 0.0, 20.0),
            new Item("Written HW 10", 1.0),
            new Item("Written HW 11", 0.0, 20.0),
            new Item("Written HW 12", 18.0, 20.0),
            new Item("Written HW 13", 1.0),
            new Item("Written HW 14", 18.0, 20.0)
    };

    private static final Item[] quizzesItems = {
            new Item("Quiz 1", 6.0, 20.0),
            new Item("Quiz 2", 13.0, 20.0),
            new Item("Quiz 3", 14.0, 20.0),
            new Item("Quiz 4", 5.0, 20.0),
            new Item("Quiz 5", 17.0, 20.0),
            new Item("Quiz 6", 8.0, 20.0),
            new Item("Quiz 7", 0.0, 20.0),
            new Item("Quiz 8", 5.0, 20.0),
            new Item("Quiz 9", 9.0, 20.0),
            new Item("Quiz 10", 10.0, 20.0),
            new Item("Quiz 11", 3.0, 20.0),
            new Item("Quiz 12", 4.0, 20.0)
    };

    private static final Item[] prelabsItems = {
            new Item("Prelab 1", 1.0),
            new Item("Prelab 2", 1.5, 4.0),
            new Item("Prelab 3", 3.25, 4.0),
            new Item("Prelab 4", 3.5, 4.0),
            new Item("Prelab 5", 0.0, 4.0),
            new Item("Prelab 6", 3.25, 4.0),
            new Item("Prelab 7", 3.8, 4.0),
            new Item("Prelab 8", 0.0, 4.0),
            new Item("Prelab 9", 3.5, 4.0),
            new Item("Prelab 10", 1.0)
    };

    private static final Item[] labsItems = {
            new Item("Lab 1", 14.25, 16.0),
            new Item("Lab 2", 0.0, 16.0),
            new Item("Lab 3", 14.95, 16.0),
            new Item("Lab 4", 14.0, 16.0),
            new Item("Lab 5", 15.0, 16.0),
            new Item("Lab 6", 14.0, 16.0),
            new Item("Lab 7", 0.0, 16.0),
            new Item("Lab 8", 0.0, 16.0),
            new Item("Lab 9", 13.55, 16.0),
            new Item("Lab 10", 0.0, 16.0)
    };

    private static final Item[] examsItems = {
            new Item("Exam 1", 61.0, 100.0),
            new Item("Exam 2", 54.5, 100.0),
            new Item("Exam 3", 0.0, 100.0)
    };

    /* --------------------------------------------------SetUp------------------------------------------------------- */
    @BeforeEach
    protected void setUp() { CategoryTests.category = new Category(); }

    /* ---------------------------------------------Constructor Tests------------------------------------------------ */
    @Test
    protected void constructors__defaultConstructor() {
        CategoryTests.category = new Category();

        assertEquals("", CategoryTests.category.name);
        assertEquals(0.0, CategoryTests.category.getWeight(), CategoryTests.EPSILON);
    }

    @Test
    protected void constructors__singleParameterConstructor() {
        CategoryTests.category = new Category("Category");

        assertEquals("Category", CategoryTests.category.name);
        assertEquals(0.0, CategoryTests.category.getWeight(), CategoryTests.EPSILON);
    }

    @Test
    protected void constructors__twoParameterConstructor__validArguments() {
        assertDoesNotThrow(() -> CategoryTests.category = new Category("Category", 30.0));

        assertEquals("Category", CategoryTests.category.name);
        assertEquals(30.0, CategoryTests.category.getWeight(), CategoryTests.EPSILON);
    }

    @Test
    protected void constructors__twoParameterConstructor__invalidArguments() {
        assertThrows(IllegalArgumentException.class, () -> CategoryTests.category = new Category("Category", -1.0));
    }

    /* -----------------------------------------------Setter Tests--------------------------------------------------- */
    @Test
    protected void setters__setWeight__validArgument() {
        assertDoesNotThrow(() -> CategoryTests.category.setWeight(30.0));
        assertEquals(30.0, CategoryTests.category.getWeight(), CategoryTests.EPSILON);
    }

    @Test
    protected void setters__setWeight__invalidArgument() {
        assertThrows(IllegalArgumentException.class, () -> CategoryTests.category.setWeight(-1.0));
    }

    @Test
    protected void setters__setItem__validArgument() {
        Item item = new Item("Item", 98.333);
        assertDoesNotThrow(() -> CategoryTests.category.addItem(item));

        Item newItem = new Item("Item", 99.333);
        assertDoesNotThrow(() -> CategoryTests.category.setItem(newItem));
        assertEquals(newItem, CategoryTests.category.getItem(newItem.name));
    }

    @Test
    protected void setters__setItem__nullArgument() {
        assertThrows(NullPointerException.class, () -> CategoryTests.category.setItem(null));
    }

    @Test
    protected void setters__setItem__invalidArgument() {
        Item item = new Item("Item", 99.333);
        assertThrows(IllegalAccessError.class, () -> CategoryTests.category.setItem(item));
    }

    /* -----------------------------------------------Getter Tests--------------------------------------------------- */
    @Test
    protected void getters__getWeight() {
        CategoryTests.category.setWeight(30.0);
        assertEquals(30.0, CategoryTests.category.getWeight(), CategoryTests.EPSILON);
    }

    @Test
    protected void getters__getItem__nullItem() { assertNull(CategoryTests.category.getItem(null)); }

    @Test
    protected void getters__getItem__noItems() {
        Item item = new Item("Item", 98.3432);
        assertNull(CategoryTests.category.getItem(item.name));
    }

    @Test
    protected void getters__getItem__doesNotContainItem() {
        Item item = new Item("Item", 98.3432);
        assertDoesNotThrow(() -> CategoryTests.category.addItem(item));

        Item otherItem = new Item("Other Item", 34.3332);
        assertNull(CategoryTests.category.getItem(otherItem.name));
    }

    @Test
    protected void getters__getWorstItem() {
        Item item1 = new Item("Item", 3.567);
        Item item2 = new Item("Item", 13.433);
        Item item3 = new Item("Item", 98.453);

        assertDoesNotThrow(() -> CategoryTests.category.addItem(item1));
        assertDoesNotThrow(() -> CategoryTests.category.addItem(item2));
        assertDoesNotThrow(() -> CategoryTests.category.addItem(item3));

        assertDoesNotThrow(() -> CategoryTests.category.drop());
        assertEquals(item1, CategoryTests.category.getWorstItem());
    }

    /* -----------------------------------------------Method Tests--------------------------------------------------- */
    @Test
    protected void methods__toString() {
        CategoryTests.category.name = "Category";
        assertEquals("Category", CategoryTests.category.toString());
    }

    @Test
    protected void methods__equals__trueCase() {
        CategoryTests.category = new Category("Category");
        Category other = new Category("Category");

        Item item = new Item("Item", 99.33332);
        CategoryTests.category.addItem(item);
        other.addItem(item);

        assertEquals(CategoryTests.category, other);
    }

    @Test
    protected void methods__equals__falseCase__differentValues() {
        CategoryTests.category = new Category("Category");
        Category other = new Category("Category");

        CategoryTests.category.addItem(new Item("Item", 99.33332));
        other.addItem(new Item("Other Item", 99.33));

        assertNotEquals(CategoryTests.category, other);
    }

    @Test
    protected void methods__equals__falseCase__differentTypes() {
        Integer integer = 101;

        assertNotEquals(integer, CategoryTests.category);
    }

    @Test
    protected void methods__addItem__validArgument() {
        Item item = new Item("Item", 84.433);

        assertDoesNotThrow(() -> CategoryTests.category.addItem(item));

        assertTrue(CategoryTests.category.containsItem(item.name));
    }

    @Test
    protected void methods__addItem__nullArgument() {
        assertThrows(NullPointerException.class, () -> CategoryTests.category.addItem(null));
    }

    @Test
    protected void methods__removeItem__validArgument() {
        Item item = new Item("Item", 93.9383);
        assertDoesNotThrow(() -> CategoryTests.category.addItem(item));
        assertEquals(item, CategoryTests.category.removeItem(item));
        assertEquals(0, CategoryTests.category.countItems());
    }

    @Test
    protected void methods__removeItem__invalidArgument() {
        Item item = new Item("Item", 93.9383);
        Item otherItem = new Item("Other Item", 93.211);

        assertDoesNotThrow(() -> CategoryTests.category.addItem(item));
        assertNull(CategoryTests.category.removeItem(otherItem));
        assertEquals(1, CategoryTests.category.countItems());
    }

    @Test
    protected void methods__removeItem__nullArgument() { assertNull(CategoryTests.category.removeItem(null)); }

    @Test
    protected void methods__containsItem__trueCase() {
        Item item = new Item("Item", 29.333);
        assertDoesNotThrow(() -> CategoryTests.category.addItem(item));

        assertTrue(CategoryTests.category.containsItem(item.name));
    }

    @Test
    protected void methods__containsItem__falseCase() {
        Item item = new Item("Item", 29.333);
        assertDoesNotThrow(() -> CategoryTests.category.addItem(item));

        assertFalse(CategoryTests.category.containsItem("Other Item"));
    }

    @Test
    protected void methods__containsItem__falseCase__nullItemName() {
        assertFalse(CategoryTests.category.containsItem(null));
    }

    @Test
    protected void methods__countItems() {
        assertEquals(0, CategoryTests.category.countItems());

        Item item1 = new Item("Item 1", 92.3332);
        assertDoesNotThrow(() -> CategoryTests.category.addItem(item1));
        assertEquals(1, CategoryTests.category.countItems());

        Item item2 = new Item("Item 2", 87.366452);
        assertDoesNotThrow(() -> CategoryTests.category.addItem(item2));
        assertEquals(2, CategoryTests.category.countItems());
    }

    @Test
    protected void methods__drop() {
        Item item1 = new Item("Item 1", 13.3321);
        assertDoesNotThrow(() -> CategoryTests.category.addItem(item1));

        Item item2 = new Item("Item 2", 99.3268);
        assertDoesNotThrow(() -> CategoryTests.category.addItem(item2));

        assertEquals(2, CategoryTests.category.countItems());

        assertDoesNotThrow(() -> CategoryTests.category.drop());

        assertEquals(1, CategoryTests.category.countDrops());
        assertEquals(1, CategoryTests.category.countItems());
        assertFalse(CategoryTests.category.containsItem(item1.name));
        assertEquals(item1, CategoryTests.category.getWorstItem());
    }

    @Test
    protected void methods__undrop__nonNullCase() {
        Item item = new Item("Item", 3.567);

        assertDoesNotThrow(() -> CategoryTests.category.addItem(item));
        assertDoesNotThrow(() -> CategoryTests.category.drop());
        assertEquals(item, CategoryTests.category.undrop());
    }

    @Test
    protected void methods__undrop__nullCase() { assertNull(CategoryTests.category.undrop()); }

    @Test
    protected void methods__countDrops() {
        Item item = new Item("Item", 3.567);
        Item otherItem = new Item("Other Item", 0.999921);

        assertDoesNotThrow(() -> CategoryTests.category.addItem(item));
        assertDoesNotThrow(() -> CategoryTests.category.drop());

        assertDoesNotThrow(() -> CategoryTests.category.addItem(otherItem));
        assertDoesNotThrow(() -> CategoryTests.category.drop());

        assertEquals(2, CategoryTests.category.countDrops());
    }



}
