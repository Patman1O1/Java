import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

public class CourseTests {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    private static final double EPSILON = 1.0e-10;

    private static final Category lectures = new Category("Lectures", 0.10, Arrays.asList(CategoryTests.lectureItems), 2);

    private static final Category groupProblems = new Category("Group Problems", 0.10, Arrays.asList(CategoryTests.groupProblemItems), 1);

    private static final Category onlineHW = new Category("Online HW", 0.075, Arrays.asList(CategoryTests.onlineHWItems), 1);

    private static final Category writtenHW = new Category("Written HW", 0.075, Arrays.asList(CategoryTests.writtenHWItems), 1);

    private static final Category quizzes = new Category("Quizzes", 0.10, Arrays.asList(CategoryTests.quizItems), 1);

    private static final Category prelabs = new Category("Prelabs", 0.02, Arrays.asList(CategoryTests.prelabItems), 1);

    private static final Category labs = new Category("Labs", 0.08, Arrays.asList(CategoryTests.labItems), 2);

    private static final Category exams = new Category("Exams", 0.45, Arrays.asList(CategoryTests.examItems), 0);

    private static final Category[] phys142Categories = {
            CourseTests.lectures,
            CourseTests.groupProblems,
            CourseTests.onlineHW,
            CourseTests.writtenHW,
            CourseTests.quizzes,
            CourseTests.prelabs,
            CourseTests.labs,
            CourseTests.exams
    };

    private static Course course;

    /* --------------------------------------------------Methods----------------------------------------------------- */
    private static Course createPhys142() {
        try {
            return new Course("PHYS 142", List.of(CourseTests.phys142Categories));
        } catch (Exception e) {
            return null;
        }
    }

    /* --------------------------------------------------SetUp------------------------------------------------------- */
    @BeforeEach
    protected void setUp() { CourseTests.course = new Course(); }

    /* ---------------------------------------------Constructor Tests------------------------------------------------ */
    @Test
    protected void constructors__defaultConstructor() {
        assertDoesNotThrow(() -> CourseTests.course = new Course());
        assertEquals("", CourseTests.course.getName());
        assertEquals(0, CourseTests.course.countCategories());
        assertEquals(0, CourseTests.course.countEmptyCategories());
    }

    @Test
    protected void constructors__nameConstructor__nonNullName() {
        assertDoesNotThrow(() -> CourseTests.course = new Course("Course"));
        assertEquals("Course", CourseTests.course.getName());
        assertEquals(0, CourseTests.course.countCategories());
        assertEquals(0, CourseTests.course.countEmptyCategories());
    }

    @Test
    protected void constructors__nameConstructor__nullName() {
        assertDoesNotThrow(() -> CourseTests.course = new Course(null));
        assertEquals("", CourseTests.course.getName());
        assertEquals(0, CourseTests.course.countCategories());
        assertEquals(0, CourseTests.course.countEmptyCategories());
    }

    @Test
    protected void constructors__nameAndCategoriesConstructor__phys142() {
        assertDoesNotThrow(() -> CourseTests.course = CourseTests.createPhys142());
        assertEquals("PHYS 142", CourseTests.course.getName());
        assertEquals(8, CourseTests.course.countCategories());
        assertEquals(0, CourseTests.course.countEmptyCategories());
    }

    @Test
    protected void constructors__nameAndCategoriesConstructor__nullName() {
        assertDoesNotThrow(() -> CourseTests.course = new Course(null, List.of(CourseTests.phys142Categories)));
        assertEquals("", CourseTests.course.getName());
        assertEquals(8, CourseTests.course.countCategories());
        assertEquals(0, CourseTests.course.countEmptyCategories());
    }

    @Test
    protected void constructors__nameAndCategoriesConstructor__nonNullName__nullCategories() {
        assertThrows(NullPointerException.class, () -> CourseTests.course = new Course("Course", null));
    }

    /* -----------------------------------------------Setter Tests--------------------------------------------------- */
    @Test
    protected void setters__setName__nullName() {
        CourseTests.course.setName(null);
        assertEquals("", CourseTests.course.getName());
    }

    @Test
    protected void setters__setName__nonNullName() {
        CourseTests.course.setName("Course");
        assertEquals("Course", CourseTests.course.getName());
    }

    @Test
    protected void setters__setCategories__nullCategories() {
        assertThrows(NullPointerException.class, () -> CourseTests.course.setCategories(null));
    }

    @Test
    protected void setters__setCategories__phys142() {
        assertDoesNotThrow(() -> CourseTests.course.setCategories(List.of(CourseTests.phys142Categories)));
        assertEquals(8, CourseTests.course.countCategories());
        assertEquals(0, CourseTests.course.countEmptyCategories());
    }

    /* -----------------------------------------------Getter Tests--------------------------------------------------- */
    @Test
    protected void getters__getName() {
        CourseTests.course.setName("Course");
        assertEquals("Course", CourseTests.course.getName());
    }

    @Test
    protected void getters__getCategory() {
        CourseTests.course = CourseTests.createPhys142();
        assertNotNull(CourseTests.course);

        assertEquals(CourseTests.phys142Categories[0], CourseTests.course.getCategory(CourseTests.phys142Categories[0].getName()));
        assertEquals(CourseTests.phys142Categories[1], CourseTests.course.getCategory(CourseTests.phys142Categories[1].getName()));
        assertEquals(CourseTests.phys142Categories[2], CourseTests.course.getCategory(CourseTests.phys142Categories[2].getName()));
        assertEquals(CourseTests.phys142Categories[3], CourseTests.course.getCategory(CourseTests.phys142Categories[3].getName()));
        assertEquals(CourseTests.phys142Categories[4], CourseTests.course.getCategory(CourseTests.phys142Categories[4].getName()));
        assertEquals(CourseTests.phys142Categories[5], CourseTests.course.getCategory(CourseTests.phys142Categories[5].getName()));
        assertEquals(CourseTests.phys142Categories[6], CourseTests.course.getCategory(CourseTests.phys142Categories[6].getName()));
        assertEquals(CourseTests.phys142Categories[7], CourseTests.course.getCategory(CourseTests.phys142Categories[7].getName()));
    }

    /* -----------------------------------------------Method Tests--------------------------------------------------- */
    @Test
    protected void methods__toString() {
        CourseTests.course.setName("Course");
        assertEquals("Course", CourseTests.course.toString());
    }

    @Test
    protected void methods__equals__trueCase() {
        Course instance1 = CourseTests.createPhys142();
        Course instance2 = CourseTests.createPhys142();

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
        assertThrows(NullPointerException.class, () -> CourseTests.course.addCategory(null));
    }

    @Test
    protected void methods__addCategory__phys142() {
        assertDoesNotThrow(() -> CourseTests.course.addCategory(CourseTests.phys142Categories[0]));
        assertEquals(CourseTests.phys142Categories[0], CourseTests.course.getCategory(CourseTests.phys142Categories[0].getName()));

        assertDoesNotThrow(() -> CourseTests.course.addCategory(CourseTests.phys142Categories[1]));
        assertEquals(CourseTests.phys142Categories[1], CourseTests.course.getCategory(CourseTests.phys142Categories[1].getName()));

        assertDoesNotThrow(() -> CourseTests.course.addCategory(CourseTests.phys142Categories[2]));
        assertEquals(CourseTests.phys142Categories[2], CourseTests.course.getCategory(CourseTests.phys142Categories[2].getName()));

        assertDoesNotThrow(() -> CourseTests.course.addCategory(CourseTests.phys142Categories[3]));
        assertEquals(CourseTests.phys142Categories[3], CourseTests.course.getCategory(CourseTests.phys142Categories[3].getName()));

        assertDoesNotThrow(() -> CourseTests.course.addCategory(CourseTests.phys142Categories[4]));
        assertEquals(CourseTests.phys142Categories[4], CourseTests.course.getCategory(CourseTests.phys142Categories[4].getName()));

        assertDoesNotThrow(() -> CourseTests.course.addCategory(CourseTests.phys142Categories[5]));
        assertEquals(CourseTests.phys142Categories[5], CourseTests.course.getCategory(CourseTests.phys142Categories[5].getName()));

        assertDoesNotThrow(() -> CourseTests.course.addCategory(CourseTests.phys142Categories[6]));
        assertEquals(CourseTests.phys142Categories[6], CourseTests.course.getCategory(CourseTests.phys142Categories[6].getName()));

        assertDoesNotThrow(() -> CourseTests.course.addCategory(CourseTests.phys142Categories[7]));
        assertEquals(CourseTests.phys142Categories[7], CourseTests.course.getCategory(CourseTests.phys142Categories[7].getName()));

    }

    @Test
    protected void methods__removeCategory__categoryOverload__validCategories() {
        CourseTests.course = CourseTests.createPhys142();
        assertNotNull(CourseTests.course);

        for (int i = 0; i < CourseTests.phys142Categories.length; ++i) {
            assertTrue(CourseTests.course.containsCategory(CourseTests.phys142Categories[i]));
            assertTrue(CourseTests.course.removeCategory(CourseTests.phys142Categories[i]));
            assertFalse(CourseTests.course.containsCategory(CourseTests.phys142Categories[i]));
        }
    }

    @Test
    protected void methods__removeCategory__categoryOverload__invalidCategories() {
        assertFalse(CourseTests.course.removeCategory(CourseTests.phys142Categories[0]));
        assertFalse(CourseTests.course.removeCategory(CourseTests.phys142Categories[1]));
        assertFalse(CourseTests.course.removeCategory(CourseTests.phys142Categories[2]));
    }

    @Test
    protected void methods__removeCategory__stringOverload__validCategories() {
        CourseTests.course = CourseTests.createPhys142();
        assertNotNull(CourseTests.course);

        for (int i = 0; i < CourseTests.phys142Categories.length; ++i) {
            assertTrue(CourseTests.course.containsCategory(CourseTests.phys142Categories[i]));
            assertTrue(CourseTests.course.removeCategory(CourseTests.phys142Categories[i].getName()));
            assertFalse(CourseTests.course.containsCategory(CourseTests.phys142Categories[i]));
        }
    }

    @Test
    protected void methods__removeCategory__stringOverload__invalidCategories() {
        assertFalse(CourseTests.course.removeCategory(CourseTests.phys142Categories[0].getName()));
        assertFalse(CourseTests.course.removeCategory(CourseTests.phys142Categories[1].getName()));
        assertFalse(CourseTests.course.removeCategory(CourseTests.phys142Categories[2].getName()));
    }

    @Test
    protected void methods__containsCategory__categoryOverload__validCategories() {
        CourseTests.course = CourseTests.createPhys142();
        assertNotNull(CourseTests.course);

        for (int i = 0; i < CourseTests.phys142Categories.length; ++i) {
            assertTrue(CourseTests.course.containsCategory(CourseTests.phys142Categories[i]));
        }
    }

    @Test
    protected void methods__containsCategory__categoryOverload__invalidCategories() {
        assertFalse(CourseTests.course.containsCategory(new Category("Some Category")));
        assertFalse(CourseTests.course.containsCategory(new Category("Some Other Category")));
        assertFalse(CourseTests.course.containsCategory(new Category(null)));
    }

    @Test
    protected void methods__containsCategory__stringOverload__validCategories() {
        CourseTests.course = CourseTests.createPhys142();
        assertNotNull(CourseTests.course);

        for (int i = 0; i < CourseTests.phys142Categories.length; ++i) {
            assertTrue(CourseTests.course.containsCategory(CourseTests.phys142Categories[i].getName()));
        }
    }

    @Test
    protected void methods__containsCategory__stringOverload__invalidCategories() {
        assertFalse(CourseTests.course.containsCategory("Some Category"));
        assertFalse(CourseTests.course.containsCategory("Some Other Category"));
    }

    @Test
    protected void methods__countCategories() {
        CourseTests.course = CourseTests.createPhys142();
        assertNotNull(CourseTests.course);

        assertEquals(CourseTests.phys142Categories.length, CourseTests.course.countCategories());
    }

    @Test
    protected void methods__countEmptyCategories() {
        CourseTests.course = CourseTests.createPhys142();
        assertNotNull(CourseTests.course);

        assertEquals(0, CourseTests.course.countEmptyCategories());
    }

}
