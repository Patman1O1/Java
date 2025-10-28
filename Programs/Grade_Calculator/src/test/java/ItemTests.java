import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemTests {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    private static Item item;

    private static final double EPSILON = 1.0e-10;

    /* --------------------------------------------------SetUp------------------------------------------------------- */
    @BeforeEach
    protected void setUp() { ItemTests.item = new Item(); }

    /* ---------------------------------------------Constructor Tests------------------------------------------------ */
    @Test
    protected void constructors__defaultConstructor() {
        ItemTests.item = new Item();

        assertEquals("", ItemTests.item.name);
        assertEquals(0.0, ItemTests.item.getGrade(), ItemTests.EPSILON);
    }

    @Test
    protected void constructors__twoParameterConstructor__validArguments() {
        assertDoesNotThrow(() -> ItemTests.item = new Item("Item", 98.0, 100.0));

        assertEquals("Item", ItemTests.item.name);
        assertEquals(0.98, ItemTests.item.getGrade(), ItemTests.EPSILON);
    }

    @Test
    protected void constructors__twoParameterConstructor__invalidArguments() {
        assertThrows(IllegalArgumentException.class, () -> ItemTests.item = new Item("Item", -1.0));
    }

    @Test
    protected void constructors__threeParameterConstructor__validArguments() {
        assertDoesNotThrow(() -> ItemTests.item = new Item("Item", 98.0, 100.0));

        assertEquals("Item", ItemTests.item.name);
        assertEquals(0.98, ItemTests.item.getGrade(), ItemTests.EPSILON);
    }

    @Test
    protected void constructors__threeParameterConstructor__invalidArguments() {
        assertThrows(IllegalArgumentException.class, () -> ItemTests.item = new Item("Item", -1.0, 100.0));
        assertThrows(IllegalArgumentException.class, () -> ItemTests.item = new Item("Item", 0.0, -1.0));
        assertThrows(IllegalArgumentException.class, () -> ItemTests.item = new Item("Item", 0.0, 0.0));
    }

    /* -----------------------------------------------Setter Tests--------------------------------------------------- */
    @Test
    protected void setters__setGrade__singleParameter__validArguments() {
        assertDoesNotThrow(() -> ItemTests.item.setGrade(1.0));
        assertDoesNotThrow(() -> ItemTests.item.setGrade(0.0));
    }

    @Test
    protected void setters__setGrade__singleParameter__invalidArgument() {
        assertThrows(IllegalArgumentException.class, () -> ItemTests.item.setGrade(-1.0));
    }

    @Test
    protected void setters__setGrade__twoParameters__validArguments() {
        assertDoesNotThrow(() -> ItemTests.item.setGrade(90.93, 100.0));
        assertDoesNotThrow(() -> ItemTests.item.setGrade(0.44444, 1.0));
    }

    @Test
    protected void setters__setGrade__twoParameters__invalidArguments() {
        assertThrows(IllegalArgumentException.class, () -> ItemTests.item.setGrade(0.0, 0.0));
        assertThrows(IllegalArgumentException.class, () -> ItemTests.item.setGrade(0.0, -1.0));
    }

    /* -----------------------------------------------Getter Tests--------------------------------------------------- */
    @Test
    protected void getters__getGrade() {
        assertDoesNotThrow(() -> ItemTests.item = new Item("Item", 0.99994));
        assertEquals(0.99994, ItemTests.item.getGrade(), ItemTests.EPSILON);
    }

    /* -----------------------------------------------Method Tests--------------------------------------------------- */
    @Test
    protected void methods__toString() {
        assertDoesNotThrow(() -> ItemTests.item = new Item("Item", 100.0, 100.0));
        assertEquals("Item", ItemTests.item.toString());
    }

    @Test
    protected void methods__equals__trueCase() {
        final Item[] items = new Item[2];
        assertDoesNotThrow(() -> items[0] = new Item("Item", 100.0, 100.0));
        assertDoesNotThrow(() -> items[1] = new Item("Item", 100.0, 100.0));
        assertEquals(items[0], items[1]);
    }

    @Test
    protected void methods__equals__falseCase() {
        final Item[] items = new Item[2];
        assertDoesNotThrow(() -> items[0] = new Item("Item", 99.0, 100.0));
        assertDoesNotThrow(() -> items[1] = new Item("Item", 100.0, 100.0));
        assertNotEquals(items[0], items[1]);
    }

    @Test
    protected void methods__compareTo__equals() {
        final Item[] items = new Item[2];
        assertDoesNotThrow(() -> items[0] = new Item("Item1", 100.0, 100.0));
        assertDoesNotThrow(() -> items[1] = new Item("Item2", 100.0, 100.0));
        assertEquals(0, items[0].compareTo(items[1]));
    }

    @Test
    protected void methods__compareTo__greater() {
        final Item[] items = new Item[2];
        assertDoesNotThrow(() -> items[0] = new Item("Item1", 100.0, 100.0));
        assertDoesNotThrow(() -> items[1] = new Item("Item2", 30.5, 100.0));
        assertEquals(1, items[0].compareTo(items[1]));
    }

    @Test
    protected void methods__compareTo__less() {
        final Item[] items = new Item[2];
        assertDoesNotThrow(() -> items[0] = new Item("Item1", 30.5, 100.0));
        assertDoesNotThrow(() -> items[1] = new Item("Item2", 100.0, 100.0));
        assertEquals(-1, items[0].compareTo(items[1]));
    }

}
