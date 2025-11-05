package com.gradecalc.tests;

import com.gradecalc.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemTests {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    private static final double EPSILON = 1.0e-10;

    private static Item item;

    /* --------------------------------------------------SetUp------------------------------------------------------- */
    @BeforeEach
    protected void setUp() { ItemTests.item = new Item(); }

    /* ---------------------------------------------Constructor Tests------------------------------------------------ */
    @Test
    protected void constructors__defaultConstructor() {
        item = new Item();

        assertEquals("", item.getName());
        assertEquals(0.0, item.getEarnedPoints(), EPSILON);
        assertEquals(1.0, item.getTotalPoints(), EPSILON);
    }

    @Test
    protected void constructors__twoParameterConstructor__validArguments() {
        assertDoesNotThrow(() -> item = new Item("Item", 98.0));

        assertEquals("Item", item.getName());
        assertEquals(98.0, item.getEarnedPoints(), EPSILON);
        assertEquals(100.0, item.getTotalPoints(), EPSILON);
    }

    @Test
    protected void constructors__twoParameterConstructor__invalidArguments() {
        assertThrows(IllegalArgumentException.class, () -> item = new Item("Item", -1.0));
    }

    @Test
    protected void constructors__threeParameterConstructor__validArguments() {
        assertDoesNotThrow(() -> item = new Item("Item", 98.0, 100.0));

        assertEquals("Item", item.getName());
        assertEquals(98.0, item.getEarnedPoints(), EPSILON);
        assertEquals(100.0, item.getTotalPoints(), EPSILON);
    }

    @Test
    protected void constructors__threeParameterConstructor__invalidArguments() {
        assertThrows(IllegalArgumentException.class, () -> ItemTests.item = new Item("Item", -1.0, 1.0));
        assertThrows(IllegalArgumentException.class, () -> ItemTests.item = new Item("Item", 0.0, -1.0));
        assertThrows(IllegalArgumentException.class, () -> ItemTests.item = new Item("Item", 1.0, 0.0));
    }

    /* -----------------------------------------------Setter Tests--------------------------------------------------- */
    @Test
    protected void setters__setName__nonNull() {
        item.setName("Item");
        assertEquals("Item", item.getName());
    }

    @Test
    protected void setters__setName__null() {
        item.setName(null);
        assertEquals("", item.getName());
    }

    @Test
    protected void setters__setEarnedPoints__validArguments() {
        assertDoesNotThrow(() -> item.setEarnedPoints(100.0));
        assertDoesNotThrow(() -> item.setEarnedPoints(0.0001));
    }

    @Test
    protected void setters__setEarnedPoints__invalidArguments() {
        assertThrows(IllegalArgumentException.class, () -> item.setEarnedPoints(-0.0001));
        assertThrows(IllegalArgumentException.class, () -> item.setEarnedPoints(-100.0));
    }

    @Test
    protected void setters__setTotalPoints__validArguments() {
        assertDoesNotThrow(() -> item.setTotalPoints(0.00001));
        assertDoesNotThrow(() -> item.setTotalPoints(100.0));
    }

    @Test
    protected void setters__setTotalPoints__invalidArguments() {
        assertThrows(IllegalArgumentException.class, () -> item.setTotalPoints(0.0));
        assertThrows(IllegalArgumentException.class, () -> item.setTotalPoints(-0.0001));
        assertThrows(IllegalArgumentException.class, () -> item.setTotalPoints(-100.0));
    }

    /* -----------------------------------------------Getter Tests--------------------------------------------------- */
    @Test
    protected void getters__getName__noNull() {
        item = new Item("Item", 100.0);
        assertEquals("Item", item.getName());
    }

    @Test
    protected void getters__getName__null() {
        item = new Item(null, 100.0);
        assertEquals("", item.getName());
    }

    @Test
    protected void getters__getEarnedPoints() {
        item = new Item("Item", 0.1 + 0.2);
        assertEquals(0.3, item.getEarnedPoints(), EPSILON);
    }

    @Test
    protected void getters__getTotalPoints() {
        item = new Item("Item", 0.1, 0.1 + 0.2);
        assertEquals(0.3, item.getTotalPoints(), EPSILON);
    }

    /* -----------------------------------------------Method Tests--------------------------------------------------- */
    @Test
    protected void methods__toString() {
        assertDoesNotThrow(() -> item = new Item("Item", 100.0, 100.0));
        assertEquals("Item", item.toString());
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
