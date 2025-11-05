package com.gradecalc.tests;

import static org.junit.jupiter.api.Assertions.*;

import com.gradecalc.Category;
import com.gradecalc.Item;
import com.gradecalc.data.PHYS142;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CategoryTests {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    private static final double EPSILON = 1.0e-10;

    private static Category category;

    /* --------------------------------------------------SetUp------------------------------------------------------- */
    @BeforeEach
    protected void setUp() { category = new Category(); }

    /* ---------------------------------------------Constructor Tests------------------------------------------------ */
    @Test
    protected void constructors__defaultConstructor() {
        category = new Category();

        assertEquals("", category.getName());
        assertEquals(0.0, category.getWeight(), EPSILON);
    }

    @Test
    protected void constructors__nameConstructor__nonNullName() {
        category = new Category("Category");

        assertEquals("Category", category.getName());
        assertEquals(0.0, category.getWeight(), EPSILON);
    }

    @Test
    protected void constructors__nameConstructor__nullName() {
        category = new Category(null);

        assertEquals("", category.getName());
        assertEquals(0.0, category.getWeight(), EPSILON);
    }

    @Test
    protected void constructors__nameAndWeightConstructor__nonNullName__validWeight() {
        assertDoesNotThrow(() -> category = new Category("Category", 30.0));

        assertEquals("Category", category.getName());
        assertEquals(30.0, category.getWeight(), EPSILON);
    }

    @Test
    protected void constructors__nameAndWeightConstructor__invalidArguments() {
        assertThrows(IllegalArgumentException.class, () -> new Category("Category", -1.0));
    }

    @Test
    protected void constructors__nameWeightAndItemsConstructor__phys142LectureItems() {
        assertDoesNotThrow(() -> category = new Category("Lectures", 0.10, Arrays.asList(PHYS142.lectureItems)));

        assertEquals("Lectures", category.getName());
        assertEquals(0.10, category.getWeight(), EPSILON);

        List<Item> lectureList = Arrays.asList(PHYS142.lectureItems);

        for (Item lecture : category.getItems()) {
            assertTrue(lectureList.contains(lecture));
        }
    }

    @Test
    protected void constructors__nameWeightAndItemsConstructor__phys142GroupProblemItems() {
        assertDoesNotThrow(() -> new Category("Group Problems", 0.10, Arrays.asList(PHYS142.groupProblemItems)));

        assertEquals("Group Problems", PHYS142.groupProblems.getName());
        assertEquals(0.10, PHYS142.groupProblems.getWeight(), EPSILON);

        List<Item> groupProblemList = Arrays.asList(PHYS142.groupProblemItems);

        for (Item groupProblem : category.getItems()) {
            assertTrue(groupProblemList.contains(groupProblem));
        }
    }

    @Test
    protected void constructors__nameWeightAndItemsConstructor__phys142OnlineHWItems() {
        assertDoesNotThrow(() -> category = new Category("Online HW", 0.075, Arrays.asList(PHYS142.onlineHWItems)));

        assertEquals("Online HW", category.getName());
        assertEquals(0.075, category.getWeight(), EPSILON);

        List<Item> onlineHWList = Arrays.asList(PHYS142.onlineHWItems);

        for (Item hw : category.getItems()) {
            assertTrue(onlineHWList.contains(hw));
        }
    }

    @Test
    protected void constructors__nameWeightAndItemsConstructor__phys142WrittenHWItems() {
        assertDoesNotThrow(() -> category = new Category("Written HW", 0.075, Arrays.asList(PHYS142.writtenHWItems)));

        assertEquals("Written HW", category.getName());
        assertEquals(0.075, category.getWeight(), EPSILON);

        List<Item> writtenHWList = Arrays.asList(PHYS142.writtenHWItems);

        for (Item hw : category.getItems()) {
            assertTrue(writtenHWList.contains(hw));
        }
    }

    @Test
    protected void constructors__nameWeightAndItemsConstructor__phys142QuizItems() {
        assertDoesNotThrow(() -> category = new Category("Quizzes", 0.10, Arrays.asList(PHYS142.quizItems)));

        assertEquals("Quizzes", category.getName());
        assertEquals(0.10, category.getWeight(), EPSILON);

        List<Item> quizList = Arrays.asList(PHYS142.quizItems);

        for (Item quiz : category.getItems()) {
            assertTrue(quizList.contains(quiz));
        }
    }

    @Test
    protected void constructors__nameWeightAndItemsConstructor__phys142PrelabItems() {
        assertDoesNotThrow(() -> category = new Category("Prelabs", 0.02, Arrays.asList(PHYS142.prelabItems)));

        assertEquals("Prelabs", category.getName());
        assertEquals(0.02, category.getWeight(), EPSILON);

        List<Item> prelabList = Arrays.asList(PHYS142.prelabItems);

        for (Item prelab : category.getItems()) {
            assertTrue(prelabList.contains(prelab));
        }
    }

    @Test
    protected void constructors__nameWeightAndItemsConstructor__phys142LabItems() {
        assertDoesNotThrow(() -> category = new Category("Labs", 0.08, Arrays.asList(PHYS142.labItems)));

        assertEquals("Labs", category.getName());
        assertEquals(0.08, category.getWeight(), EPSILON);

        List<Item> labList = Arrays.asList(PHYS142.labItems);

        for (Item lab : category.getItems()) {
            assertTrue(labList.contains(lab));
        }
    }

    @Test
    protected void constructors__nameWeightAndItemsConstructor__phys142ExamItems() {
        assertDoesNotThrow(() -> new Category("Exams", 0.45, Arrays.asList(PHYS142.examItems)));

        assertEquals("Exams", PHYS142.exams.getName());
        assertEquals(0.45, PHYS142.exams.getWeight(), EPSILON);

        for (Item exam : PHYS142.examItems) {
            assertTrue(PHYS142.exams.containsItem(exam.getName()));
        }
    }

    @Test
    protected void constructors__nameWeightAndItemsConstructor__nullItems() {
        assertThrows(NullPointerException.class, () -> new Category("Category", 0.10, null));
    }

    @Test
    protected void constructors__nameWeightAndItemsWithDropsConstructor__phys142LectureItems() {
        assertDoesNotThrow(() -> new Category("Lectures", 0.10, Arrays.asList(PHYS142.lectureItems), 2));

        assertEquals("Lectures", PHYS142.lectures.getName());
        assertEquals(0.10, PHYS142.lectures.getWeight(), EPSILON);
        assertEquals(2, PHYS142.lectures.countDrops());
    }

    @Test
    protected void constructors__nameWeightAndItemsWithDropsConstructor__phys142GroupProblemItems() {
        assertDoesNotThrow(() -> new Category("Group Problems", 0.10, Arrays.asList(PHYS142.groupProblemItems), 1));

        assertEquals("Group Problems", PHYS142.groupProblems.getName());
        assertEquals(0.10, PHYS142.groupProblems.getWeight(), EPSILON);
        assertEquals(1, PHYS142.groupProblems.countDrops());
    }

    @Test
    protected void constructors__nameWeightAndItemsWithDropsConstructor__phys142OnlineHWItems() {
        assertDoesNotThrow(() -> new Category("Online HW", 0.075, Arrays.asList(PHYS142.onlineHWItems), 1));

        assertEquals("Online HW", PHYS142.onlineHW.getName());
        assertEquals(0.075, PHYS142.onlineHW.getWeight(), EPSILON);
        assertEquals(1, PHYS142.onlineHW.countDrops());
    }

    @Test
    protected void constructors__nameWeightAndItemsWithDropsConstructor__phys142WrittenHWItems() {
        assertDoesNotThrow(() -> new Category("Written HW", 0.075, Arrays.asList(PHYS142.writtenHWItems), 1));

        assertEquals("Written HW", PHYS142.writtenHW.getName());
        assertEquals(0.075, PHYS142.writtenHW.getWeight(), EPSILON);
        assertEquals(1, PHYS142.writtenHW.countDrops());
    }

    @Test
    protected void constructors__nameWeightAndItemsWithDropsConstructor__phys142QuizItems() {
        assertDoesNotThrow(() -> new Category("Quizzes", 0.10, Arrays.asList(PHYS142.quizItems), 1));

        assertEquals("Quizzes", PHYS142.quizzes.getName());
        assertEquals(0.10, PHYS142.quizzes.getWeight(), EPSILON);
        assertEquals(1, PHYS142.quizzes.countDrops());
    }

    @Test
    protected void constructors__nameWeightAndItemsWithDropsConstructor__phys142PrelabItems() {
        assertDoesNotThrow(() -> new Category("Prelabs", 0.02, Arrays.asList(PHYS142.prelabItems), 1));

        assertEquals("Prelabs", PHYS142.prelabs.getName());
        assertEquals(0.02, PHYS142.prelabs.getWeight(), EPSILON);
        assertEquals(1, PHYS142.prelabs.countDrops());
    }

    @Test
    protected void constructors__nameWeightAndItemsWithDropsConstructor__phys142LabItems() {
        assertDoesNotThrow(() -> new Category("Labs", 0.08, Arrays.asList(PHYS142.labItems), 2));

        assertEquals("Labs", PHYS142.labs.getName());
        assertEquals(0.08, PHYS142.labs.getWeight(), EPSILON);
        assertEquals(2, PHYS142.labs.countDrops());
    }

    @Test
    protected void constructors__nameWeightAndItemsWithDropsConstructor__phys142ExamItems() {
        assertDoesNotThrow(() -> new Category("Exams", 0.45, Arrays.asList(PHYS142.examItems), 0));

        assertEquals("Exams", PHYS142.exams.getName());
        assertEquals(0.45, PHYS142.exams.getWeight(), EPSILON);
        assertEquals(0, PHYS142.exams.countDrops());
    }

    /* -----------------------------------------------Setter Tests--------------------------------------------------- */
    @Test
    protected void setters__setName__nonNullName() {
        category.setName("Category");
        assertEquals("Category", category.getName());
    }

    @Test
    protected void setters__setName__nullName() {
        CategoryTests.category.setName(null);
        assertEquals("", category.getName());
    }

    @Test
    protected void setters__setWeight__validArgument() {
        assertDoesNotThrow(() -> category.setWeight(30.0));
        assertEquals(30.0, category.getWeight(), EPSILON);
    }

    @Test
    protected void setters__setWeight__invalidArgument() {
        assertThrows(IllegalArgumentException.class, () -> category.setWeight(-1.0));
    }

    @Test
    protected void setters__setItems__phys142LectureItems() {
        assertDoesNotThrow(() -> category.setItems(Arrays.asList(PHYS142.lectureItems)));
        for (Item lecture : PHYS142.lectureItems) {
            assertTrue(category.containsItem(lecture.getName()));
        }
    }

    @Test
    protected void setters__setItems__phys142GroupProblemItems() {
        assertDoesNotThrow(() -> category.setItems(Arrays.asList(PHYS142.groupProblemItems)));
        for (Item groupProblem : PHYS142.groupProblemItems) {
            assertTrue(CategoryTests.category.containsItem(groupProblem.getName()));
        }
    }

    @Test
    protected void setters__setItems__phys142OnlineHWItems() {
        assertDoesNotThrow(() -> category.setItems(Arrays.asList(PHYS142.onlineHWItems)));
        for (Item onlineHW : PHYS142.onlineHWItems) {
            assertTrue(category.containsItem(onlineHW.getName()));
        }
    }

    @Test
    protected void setters__setItems__phys142WrittenHWItems() {
        assertDoesNotThrow(() -> category.setItems(Arrays.asList(PHYS142.writtenHWItems)));
        for (Item writtenHW : PHYS142.writtenHWItems) {
            assertTrue(category.containsItem(writtenHW.getName()));
        }
    }

    @Test
    protected void setters__setItems__phys142QuizItems() {
        assertDoesNotThrow(() -> category.setItems(Arrays.asList(PHYS142.quizItems)));
        for (Item quiz : PHYS142.quizItems) {
            assertTrue(category.containsItem(quiz.getName()));
        }
    }

    @Test
    protected void setters__setItems__prelabItems() {
        assertDoesNotThrow(() -> category.setItems(Arrays.asList(PHYS142.prelabItems)));
        for (Item prelab : PHYS142.prelabItems) {
            assertTrue(category.containsItem(prelab.getName()));
        }
    }

    @Test
    protected void setters__setItems__labItems() {
        assertDoesNotThrow(() -> category.setItems(Arrays.asList(PHYS142.labItems)));
        for (Item lab : PHYS142.labItems) {
            assertTrue(category.containsItem(lab.getName()));
        }
    }

    @Test
    protected void setters__setItems__examItems() {
        assertDoesNotThrow(() -> category.setItems(Arrays.asList(PHYS142.examItems)));
        for (Item exam : PHYS142.examItems) {
            assertTrue(category.containsItem(exam.getName()));
        }
    }

    @Test
    protected void setters__setItems__null() {
        assertThrows(NullPointerException.class, () -> category.setItems(null));
    }

    /* -----------------------------------------------Getter Tests--------------------------------------------------- */
    @Test
    protected void getters__getName() {
        category.setName("Category");
        assertEquals("Category", category.getName());
    }

    @Test
    protected void getters__getWeight() {
        category.setWeight(30.0);
        assertEquals(30.0, category.getWeight(), EPSILON);
    }

    @Test
    protected void getters__getItem__nullItem() { assertNull(category.getItem(null)); }

    @Test
    protected void getters__getItem__noItems() {
        Item item = new Item("Item", 98.3432);
        assertNull(category.getItem(item.getName()));
    }

    @Test
    protected void getters__getItem__doesNotContainItem() {
        Item item = new Item("Item", 98.3432);
        assertDoesNotThrow(() -> category.addItem(item));

        Item otherItem = new Item("Other Item", 34.3332);
        assertNull(category.getItem(otherItem.getName()));
    }

    @Test
    protected void getters__getWorstItem() {
        Item item1 = new Item("Item", 3.567);
        Item item2 = new Item("Item", 13.433);
        Item item3 = new Item("Item", 98.453);

        assertDoesNotThrow(() -> category.addItem(item1));
        assertDoesNotThrow(() -> category.addItem(item2));
        assertDoesNotThrow(() -> category.addItem(item3));

        assertDoesNotThrow(() -> category.drop());
        assertEquals(item2, category.getWorstItem());
    }

    /* -----------------------------------------------Method Tests--------------------------------------------------- */
    @Test
    protected void methods__toString() {
        category.setName("Category");
        assertEquals("Category", category.toString());
    }

    @Test
    protected void methods__equals__trueCase() {
        category = new Category("Category");
        Category other = new Category("Category");

        Item item = new Item("Item", 99.33332);
        category.addItem(item);
        other.addItem(item);

        assertEquals(category, other);
    }

    @Test
    protected void methods__equals__falseCase__differentValues() {
        category = new Category("Category");
        Category other = new Category("Category");

        category.addItem(new Item("Item", 99.33332));
        other.addItem(new Item("Other Item", 99.33));

        assertNotEquals(category, other);
    }

    @Test
    protected void methods__calculateGrade__phys142Lectures() {
        assertEquals(73.63782051282051, PHYS142.lectures.calculateGrade() * 100, EPSILON);
    }

    @Test
    protected void methods__calculateGrade__phys142GroupProblems() {
        assertEquals(76.3095238095238, PHYS142.groupProblems.calculateGrade() * 100, EPSILON);
    }

    @Test
    protected void methods__calculateGrade__phys142OnlineHW() {
        assertEquals(75.02428571428572, PHYS142.onlineHW.calculateGrade() * 100, EPSILON);
    }

    @Test
    protected void methods__calculateGrade__phys142WrittenHW() {
        assertEquals(76.60714285714285, PHYS142.writtenHW.calculateGrade() * 100, EPSILON);
    }

    @Test
    protected void methods__calculateGrade__phys142Quizzes() {
        assertEquals(42.727272727272734, PHYS142.quizzes.calculateGrade() * 100, EPSILON);
    }

    @Test
    protected void methods__calculateGrade__phys142Prelabs() {
        assertEquals(74.44444444444444, PHYS142.prelabs.calculateGrade() * 100, EPSILON);
    }

    @Test
    protected void methods__calculateGrade__phys142Labs() {
        assertEquals(66.9921875, PHYS142.labs.calculateGrade() * 100, EPSILON);
    }

    @Test
    protected void methods__calculateGrade__phys142Exams() {
        assertEquals(38.5, PHYS142.exams.calculateGrade() * 100, EPSILON);
    }

    @Test
    protected void methods__addItem__validArgument() {
        Item item = new Item("Item", 84.433);

        assertDoesNotThrow(() -> category.addItem(item));

        assertTrue(category.containsItem(item.getName()));
    }

    @Test
    protected void methods__addItem__nullArgument() {
        assertThrows(NullPointerException.class, () -> category.addItem(null));
    }

    @Test
    protected void methods__removeItem__validArgument() {
        Item item = new Item("Item", 93.9383);
        assertDoesNotThrow(() -> category.addItem(item));
        assertEquals(item, category.removeItem(item));
        assertEquals(0, category.countItems());
    }

    @Test
    protected void methods__removeItem__invalidArgument() {
        Item item = new Item("Item", 93.9383);
        Item otherItem = new Item("Other Item", 93.211);

        assertDoesNotThrow(() -> category.addItem(item));
        assertNull(category.removeItem(otherItem));
        assertEquals(1, category.countItems());
    }

    @Test
    protected void methods__removeItem__nullArgument() { assertNull(category.removeItem(null)); }

    @Test
    protected void methods__updateItem__validArgument() {
        Item item = new Item("Item", 98.333);
        assertDoesNotThrow(() -> category.addItem(item));

        Item newItem = new Item("Item", 99.333);
        assertDoesNotThrow(() -> category.updateItem(newItem));
        assertEquals(newItem, category.getItem(newItem.getName()));
    }

    @Test
    protected void methods__updateItem__nullArgument() {
        assertThrows(NullPointerException.class, () -> category.updateItem(null));
    }

    @Test
    protected void methods__updateItem__invalidArgument() {
        assertThrows(IllegalAccessError.class, () -> category.updateItem(new Item("Item", 99.333)));
    }

    @Test
    protected void methods__containsItem__trueCase() {
        Item item = new Item("Item", 29.333);
        assertDoesNotThrow(() -> category.addItem(item));

        assertTrue(category.containsItem(item.getName()));
    }

    @Test
    protected void methods__containsItem__falseCase() {
        Item item = new Item("Item", 29.333);
        assertDoesNotThrow(() -> category.addItem(item));

        assertFalse(category.containsItem("Other Item"));
    }

    @Test
    protected void methods__containsItem__falseCase__nullItemName() { assertFalse(category.containsItem(null)); }

    @Test
    protected void methods__countItems() {
        assertEquals(0, category.countItems());

        Item item1 = new Item("Item 1", 92.3332);
        assertDoesNotThrow(() -> category.addItem(item1));
        assertEquals(1, category.countItems());

        Item item2 = new Item("Item 2", 87.366452);
        assertDoesNotThrow(() -> category.addItem(item2));
        assertEquals(2, category.countItems());
    }

    @Test
    protected void methods__drop() {
        Item item1 = new Item("Item 1", 13.3321);
        assertDoesNotThrow(() -> category.addItem(item1));

        Item item2 = new Item("Item 2", 99.3268);
        assertDoesNotThrow(() -> category.addItem(item2));

        assertEquals(2, category.countItems());

        assertDoesNotThrow(() -> category.drop());

        assertEquals(1, category.countDrops());
        assertEquals(1, category.countItems());
        assertFalse(category.containsItem(item1.getName()));
        assertEquals(item2, category.getWorstItem());
    }

    @Test
    protected void methods__undrop__nonNullCase() {
        Item item = new Item("Item", 3.567);

        assertDoesNotThrow(() -> category.addItem(item));
        assertDoesNotThrow(() -> category.drop());
        assertEquals(item, category.undrop());
    }

    @Test
    protected void methods__undrop__nullCase() { assertNull(category.undrop()); }

    @Test
    protected void methods__countDrops() {
        Item item = new Item("Item", 3.567);
        Item otherItem = new Item("Other Item", 0.999921);

        assertDoesNotThrow(() -> category.addItem(item));
        assertDoesNotThrow(() -> category.drop());

        assertDoesNotThrow(() -> category.addItem(otherItem));
        assertDoesNotThrow(() -> category.drop());

        assertEquals(2, category.countDrops());
    }

}
