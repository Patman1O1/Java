import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryTests {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    private static Category category;

    private static final double EPSILON = 1e-10;

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
    protected void getters_getWeight() {
        CategoryTests.category.setWeight(30.0);
        assertEquals(30.0, CategoryTests.category.getWeight(), CategoryTests.EPSILON);
    }

    @Test
    protected void getters_getItem__nullItem() { assertNull(CategoryTests.category.getItem(null)); }

    @Test
    protected void getters_getItem__noItems() {
        Item item = new Item("Item", 98.3432);
        assertNull(CategoryTests.category.getItem(item.name));
    }

    @Test
    protected void getters_getItem__doesNotContainItem() {
        Item item = new Item("Item", 98.3432);
        assertDoesNotThrow(() -> CategoryTests.category.addItem(item));

        Item otherItem = new Item("Other Item", 34.3332);
        assertNull(CategoryTests.category.getItem(otherItem.name));
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
    protected void methods__removeItem__nullArgument() {
        assertNull(CategoryTests.category.removeItem(null));
    }

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
    protected void methods__drop__validArgument__emptyDropList() {
        Item item1 = new Item("Item 1", 13.3321);
        assertDoesNotThrow(() -> CategoryTests.category.addItem(item1));

        Item item2 = new Item("Item 2", 99.3268);
        assertDoesNotThrow(() -> CategoryTests.category.addItem(item2));

        assertEquals(2, CategoryTests.category.countItems());

        assertDoesNotThrow(() -> CategoryTests.category.drop(item1));

        assertEquals(1, CategoryTests.category.countDrops());
        assertEquals(1, CategoryTests.category.countItems());
        assertFalse(CategoryTests.category.containsItem(item1.name));
        assertTrue(CategoryTests.category.isDropped(item1.name));
    }

    @Test
    protected void methods__drop__validArgument__itemAlreadyDropped() {
        Item item1 = new Item("Item 1", 13.3321);
        assertDoesNotThrow(() -> CategoryTests.category.addItem(item1));

        Item item2 = new Item("Item 2", 99.3268);
        assertDoesNotThrow(() -> CategoryTests.category.addItem(item2));

        assertEquals(2, CategoryTests.category.countItems());

        assertDoesNotThrow(() -> CategoryTests.category.drop(item1));

        assertEquals(1, CategoryTests.category.countDrops());
        assertEquals(1, CategoryTests.category.countItems());
        assertFalse(CategoryTests.category.containsItem(item1.name));
        assertTrue(CategoryTests.category.isDropped(item1.name));

        assertDoesNotThrow(() -> item1.setPointsEarned(32.04));
        assertDoesNotThrow(() -> CategoryTests.category.drop(item1));
        assertEquals(1, CategoryTests.category.countDrops());
        assertEquals(1, CategoryTests.category.countItems());
        assertFalse(CategoryTests.category.containsItem(item1.name));
        assertTrue(CategoryTests.category.isDropped(item1.name));
    }

    @Test
    protected void methods__drop__invalidArgument__nullArgument() {
        assertThrows(NullPointerException.class, () -> CategoryTests.category.drop(null));
    }

    @Test
    protected void methods__drop__invalidArgument__itemNotAdded() {
        Item item = new Item("Item", 89.3242);
        assertThrows(IllegalArgumentException.class, () -> CategoryTests.category.drop(item));
    }

    @Test
    protected void methods__undrop__itemIsDropped() {
        Item item = new Item("Item", 3.567);

        assertDoesNotThrow(() -> CategoryTests.category.addItem(item));
        assertDoesNotThrow(() -> CategoryTests.category.drop(item));
        assertEquals(item, CategoryTests.category.undrop(item));
    }

    @Test
    protected void methods__undrop__itemIsNotDropped() {
        Item item = new Item("Item", 23.3246);
        assertNull(CategoryTests.category.undrop(item));
    }

    @Test
    protected void methods__undrop__nullItem() { assertNull(CategoryTests.category.undrop(null)); }

    @Test
    protected void methods__countDrops() {
        Item item = new Item("Item", 3.567);
        Item otherItem = new Item("Other Item", 0.999921);

        assertDoesNotThrow(() -> CategoryTests.category.addItem(item));
        assertDoesNotThrow(() -> CategoryTests.category.drop(item));

        assertDoesNotThrow(() -> CategoryTests.category.addItem(otherItem));
        assertDoesNotThrow(() -> CategoryTests.category.drop(otherItem));

        assertEquals(2, CategoryTests.category.countDrops());
    }

    @Test
    protected void methods__isDropped__trueCase() {
        Item item = new Item("Item", 3.567);

        assertDoesNotThrow(() -> CategoryTests.category.addItem(item));
        assertDoesNotThrow(() -> CategoryTests.category.drop(item));
        assertTrue(CategoryTests.category.isDropped(item.name));
    }

    @Test
    protected void methods__isDropped__falseCase() {
        Item item = new Item("Item", 3.567);

        assertDoesNotThrow(() -> CategoryTests.category.addItem(item));
        assertDoesNotThrow(() -> CategoryTests.category.drop(item));
        assertFalse(CategoryTests.category.isDropped("Other Item"));
    }

}
