import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;


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
        assertEquals(0.0, ItemTests.item.getPointsEarned(), ItemTests.EPSILON);
        assertEquals(1.0, ItemTests.item.getTotalPoints(), ItemTests.EPSILON);
        assertEquals(0.0, ItemTests.item.grade(), ItemTests.EPSILON);
        assertEquals(0.0, ItemTests.item.gradeAsPercent(), ItemTests.EPSILON);
    }

    @Test
    protected void constructors__twoParameterConstructor__validArguments() {
        assertDoesNotThrow(() -> ItemTests.item = new Item("Item", 98.0));

        assertEquals("Item", ItemTests.item.name);
        assertEquals(98.0, ItemTests.item.getPointsEarned(), ItemTests.EPSILON);
        assertEquals(100.0, ItemTests.item.getTotalPoints(), ItemTests.EPSILON);
        assertEquals(0.98, ItemTests.item.grade(), ItemTests.EPSILON);
        assertEquals(98.0, ItemTests.item.gradeAsPercent(), ItemTests.EPSILON);
    }

    @Test
    protected void constructors__twoParameterConstructor__invalidArguments() {
        assertThrows(IllegalArgumentException.class, () -> ItemTests.item = new Item("Item", -1.0));
    }

    @Test
    protected void constructors__threeParameterConstructor__validArguments() {
        assertDoesNotThrow(() -> ItemTests.item = new Item("Item", 98.0, 100.0));

        assertEquals("Item", ItemTests.item.name);
        assertEquals(98.0, ItemTests.item.getPointsEarned(), ItemTests.EPSILON);
        assertEquals(100.0, ItemTests.item.getTotalPoints(), ItemTests.EPSILON);
        assertEquals(0.98, ItemTests.item.grade(), ItemTests.EPSILON);
        assertEquals(98.0, ItemTests.item.gradeAsPercent(), ItemTests.EPSILON);
    }

    @Test
    protected void constructors__threeParameterConstructor__invalidArguments() {
        assertThrows(IllegalArgumentException.class, () -> ItemTests.item = new Item("Item", -1.0, 100.0));
        assertThrows(IllegalArgumentException.class, () -> ItemTests.item = new Item("Item", 0.0, -1.0));
        assertThrows(IllegalArgumentException.class, () -> ItemTests.item = new Item("Item", 0.0, 0.0));
    }

    /* -----------------------------------------------Setter Tests--------------------------------------------------- */
    @Test
    protected void setters__setPointsEarned__validArguments() {
        assertDoesNotThrow(() -> ItemTests.item.setPointsEarned(100.0));
        assertDoesNotThrow(() -> ItemTests.item.setPointsEarned(0.0));
    }

    @Test
    protected void setters__setPointsEarned__invalidArguments() {
        assertThrows(IllegalArgumentException.class, () -> ItemTests.item.setTotalPoints(0.0));
        assertThrows(IllegalArgumentException.class, () -> ItemTests.item.setTotalPoints(-1.0));
    }

    @Test
    protected void setters__setTotalPoints__validArguments() {
        assertDoesNotThrow(() -> ItemTests.item.setTotalPoints(100.0));
        assertDoesNotThrow(() -> ItemTests.item.setTotalPoints(1.0));
    }

    @Test
    protected void setters__setTotalPoints__invalidArguments() {
        assertThrows(IllegalArgumentException.class, () -> ItemTests.item.setTotalPoints(0.0));
        assertThrows(IllegalArgumentException.class, () -> ItemTests.item.setTotalPoints(-1.0));
    }

    /* -----------------------------------------------Getter Tests--------------------------------------------------- */
    @Test
    protected void getters__getPointsEarned() {
        assertDoesNotThrow(() -> ItemTests.item = new Item("Item", 100.0, 100.0));
        assertEquals(100.0, ItemTests.item.getPointsEarned());
    }

    @Test
    protected void getters__getTotalPoints() {
        assertDoesNotThrow(() -> ItemTests.item = new Item("Item", 100.0, 100.0));
        assertEquals(100.0, ItemTests.item.getTotalPoints());
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
    protected void methods__compare__trueCase() {
        final Item[] items = new Item[2];
        assertDoesNotThrow(() -> items[0] = new Item("Item1", 100.0, 100.0));
        assertDoesNotThrow(() -> items[1] = new Item("Item2", 100.0, 100.0));
        assertTrue(items[0].compare(items[1]));
    }

    @Test
    protected void methods__compare__falseCase() {
        final Item[] items = new Item[2];
        assertDoesNotThrow(() -> items[0] = new Item("Item1", 99.0, 100.0));
        assertDoesNotThrow(() -> items[1] = new Item("Item2", 100.0, 100.0));
        assertFalse(items[0].compare(items[1]));
    }

    @Test
    protected void methods__grade() {
        assertDoesNotThrow(() -> ItemTests.item = new Item("Item", 98.33333, 100.0));
        assertEquals(0.9833333, ItemTests.item.grade(), ItemTests.EPSILON);
    }

    @Test
    protected void methods__gradeAsPercent() {
        assertDoesNotThrow(() -> ItemTests.item = new Item("Item", 98.33333, 100.0));
        assertEquals(98.33333, ItemTests.item.gradeAsPercent(), ItemTests.EPSILON);
    }
}
