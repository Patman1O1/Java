package com.gradecalc.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gradecalc.Category;
import com.gradecalc.Course;
import com.gradecalc.data.PHYS142;

import java.util.*;

public class CourseTests {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    private static final double EPSILON = 1.0e-10;

    private static Course course;

    /* --------------------------------------------------SetUp------------------------------------------------------- */
    @BeforeEach
    protected void setUp() { course = new Course(); }

    /* ---------------------------------------------Constructor Tests------------------------------------------------ */
    @Test
    protected void constructors__defaultConstructor() {
        assertDoesNotThrow(() -> course = new Course());
        assertEquals("", course.getName());
        assertEquals(0, course.countCategories());
        assertEquals(0, course.countEmptyCategories());
    }

    @Test
    protected void constructors__nameConstructor__nonNullName() {
        assertDoesNotThrow(() -> course = new Course("Course"));
        assertEquals("Course", course.getName());
        assertEquals(0, course.countCategories());
        assertEquals(0, course.countEmptyCategories());
    }

    @Test
    protected void constructors__nameConstructor__nullName() {
        assertDoesNotThrow(() -> course = new Course(null));
        assertEquals("", course.getName());
        assertEquals(0, course.countCategories());
        assertEquals(0, course.countEmptyCategories());
    }

    @Test
    protected void constructors__nameAndCategoriesConstructor__nullName() {
        assertDoesNotThrow(() -> course = new Course(null, List.of(PHYS142.categories)));
        assertEquals("", course.getName());
        assertEquals(8, course.countCategories());
        assertEquals(0, course.countEmptyCategories());
    }

    @Test
    protected void constructors__nameAndCategoriesConstructor__nonNullName__nullCategories() {
        assertThrows(NullPointerException.class, () -> course = new Course("Course", null));
    }

    /* -----------------------------------------------Setter Tests--------------------------------------------------- */
    @Test
    protected void setters__setName__nullName() {
        course.setName(null);
        assertEquals("", course.getName());
    }

    @Test
    protected void setters__setName__nonNullName() {
        course.setName("Course");
        assertEquals("Course", course.getName());
    }

    @Test
    protected void setters__setCategories__nullCategories() {
        assertThrows(NullPointerException.class, () -> course.setCategories(null));
    }

    @Test
    protected void setters__setCategories__phys142() {
        assertDoesNotThrow(() -> course.setCategories(List.of(PHYS142.categories)));
        assertEquals(8, course.countCategories());
        assertEquals(0, course.countEmptyCategories());
    }

    /* -----------------------------------------------Getter Tests--------------------------------------------------- */
    @Test
    protected void getters__getName() {
        assertDoesNotThrow(() -> course.setName("Course"));
        assertEquals("Course", course.getName());
    }

    @Test
    protected void getters__getCategory__phys142() {
        assertEquals(PHYS142.categories[0], PHYS142.course.getCategory(PHYS142.categories[0].getName()));
        assertEquals(PHYS142.categories[1], PHYS142.course.getCategory(PHYS142.categories[1].getName()));
        assertEquals(PHYS142.categories[2], PHYS142.course.getCategory(PHYS142.categories[2].getName()));
        assertEquals(PHYS142.categories[3], PHYS142.course.getCategory(PHYS142.categories[3].getName()));
        assertEquals(PHYS142.categories[4], PHYS142.course.getCategory(PHYS142.categories[4].getName()));
        assertEquals(PHYS142.categories[5], PHYS142.course.getCategory(PHYS142.categories[5].getName()));
        assertEquals(PHYS142.categories[6], PHYS142.course.getCategory(PHYS142.categories[6].getName()));
        assertEquals(PHYS142.categories[7], PHYS142.course.getCategory(PHYS142.categories[7].getName()));
    }

    /* -----------------------------------------------Method Tests--------------------------------------------------- */
    @Test
    protected void methods__toString() {
        course.setName("Course");
        assertEquals("Course", course.toString());
    }

    @Test
    protected void methods__equals__trueCase() {
        Course instance1 = new Course();
        Course instance2 = new Course();

        assertNotNull(instance1);
        assertNotNull(instance2);

        assertEquals(instance1, instance2);
    }

    @Test
    protected void methods__equals__falseCase() {
        Course lhs = new Course("Course 1");
        Course rhs = new Course("Course 2");

        assertNotEquals(lhs, rhs);
    }

    @Test
    protected void methods__addCategory__null() {
        assertThrows(NullPointerException.class, () -> course.addCategory(null));
    }

    @Test
    protected void methods__addCategory__phys142() {
        assertDoesNotThrow(() -> course.addCategory(PHYS142.categories[0]));
        assertEquals(PHYS142.categories[0], course.getCategory(PHYS142.categories[0].getName()));

        assertDoesNotThrow(() -> course.addCategory(PHYS142.categories[1]));
        assertEquals(PHYS142.categories[1], course.getCategory(PHYS142.categories[1].getName()));

        assertDoesNotThrow(() -> course.addCategory(PHYS142.categories[2]));
        assertEquals(PHYS142.categories[2], course.getCategory(PHYS142.categories[2].getName()));

        assertDoesNotThrow(() -> course.addCategory(PHYS142.categories[3]));
        assertEquals(PHYS142.categories[3], course.getCategory(PHYS142.categories[3].getName()));

        assertDoesNotThrow(() -> course.addCategory(PHYS142.categories[4]));
        assertEquals(PHYS142.categories[4], course.getCategory(PHYS142.categories[4].getName()));

        assertDoesNotThrow(() -> course.addCategory(PHYS142.categories[5]));
        assertEquals(PHYS142.categories[5], course.getCategory(PHYS142.categories[5].getName()));

        assertDoesNotThrow(() -> course.addCategory(PHYS142.categories[6]));
        assertEquals(PHYS142.categories[6], course.getCategory(PHYS142.categories[6].getName()));

        assertDoesNotThrow(() -> course.addCategory(PHYS142.categories[7]));
        assertEquals(PHYS142.categories[7], course.getCategory(PHYS142.categories[7].getName()));

    }

    @Test
    protected void methods__removeCategory__categoryOverload__validCategories__phys142() {
        course = new Course("PHYS 142", Arrays.asList(PHYS142.categories));
        assertNotNull(course);

        for (int i = 0; i < PHYS142.categories.length; ++i) {
            assertTrue(course.containsCategory(PHYS142.categories[i]));
            assertTrue(course.removeCategory(PHYS142.categories[i]));
            assertFalse(course.containsCategory(PHYS142.categories[i]));
        }
    }

    @Test
    protected void methods__removeCategory__categoryOverload__invalidCategories__phys142() {
        assertFalse(course.removeCategory(PHYS142.categories[0]));
        assertFalse(course.removeCategory(PHYS142.categories[1]));
        assertFalse(course.removeCategory(PHYS142.categories[2]));
    }

    @Test
    protected void methods__removeCategory__stringOverload__validCategories__phys142() {
        course = new Course("PHYS 142", Arrays.asList(PHYS142.categories));
        assertNotNull(course);

        for (int i = 0; i < PHYS142.categories.length; ++i) {
            assertTrue(course.containsCategory(PHYS142.categories[i]));
            assertTrue(course.removeCategory(PHYS142.categories[i].getName()));
            assertFalse(course.containsCategory(PHYS142.categories[i]));
        }
    }

    @Test
    protected void methods__removeCategory__stringOverload__invalidCategories__phys142() {
        assertFalse(course.removeCategory(PHYS142.categories[0].getName()));
        assertFalse(course.removeCategory(PHYS142.categories[1].getName()));
        assertFalse(course.removeCategory(PHYS142.categories[2].getName()));
    }

    @Test
    protected void methods__containsCategory__categoryOverload__validCategories__phys142() {
        course = new Course("PHYS 142", Arrays.asList(PHYS142.categories));
        assertNotNull(course);

        for (int i = 0; i < PHYS142.categories.length; ++i) {
            assertTrue(CourseTests.course.containsCategory(PHYS142.categories[i]));
        }
    }

    @Test
    protected void methods__containsCategory__categoryOverload__invalidCategories() {
        assertFalse(course.containsCategory(new Category("Some Category")));
        assertFalse(course.containsCategory(new Category("Some Other Category")));
        assertFalse(course.containsCategory(new Category(null)));
    }

    @Test
    protected void methods__containsCategory__stringOverload__validCategories__phys142() {
        course = new Course("PHYS 142", Arrays.asList(PHYS142.categories));
        assertNotNull(course);

        for (int i = 0; i < PHYS142.categories.length; ++i) {
            assertTrue(course.containsCategory(PHYS142.categories[i].getName()));
        }
    }

    @Test
    protected void methods__containsCategory__stringOverload__invalidCategories() {
        assertFalse(course.containsCategory("Some Category"));
        assertFalse(course.containsCategory("Some Other Category"));
    }

    @Test
    protected void methods__countCategories__phys142() {
        course = new Course("PHYS 142", Arrays.asList(PHYS142.categories));
        assertNotNull(course);

        assertEquals(PHYS142.categories.length, course.countCategories());
    }

    @Test
    protected void methods__countEmptyCategories__phys142() {
        course = new Course("PHYS 142", Arrays.asList(PHYS142.categories));
        assertNotNull(course);

        assertEquals(0, course.countEmptyCategories());
    }

    @Test
    protected void methods__calculateGrade__phys142() {
        course = new Course("PHYS 142", Arrays.asList(PHYS142.categories));
        assertNotNull(course);

        assertEquals(54.81308273670773, course.calculateGrade() * 100, EPSILON);
    }

}
