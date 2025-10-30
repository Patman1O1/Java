import java.util.Arrays;

public class Phys142 {
    /* ----------------------------------------------Fields (Items)-------------------------------------------------- */
    public static final Item[] lectureItems = {
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

    public static final Item[] groupProblemItems = {
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

    public static final Item[] onlineHWItems = {
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

    public static final Item[] writtenHWItems = {
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

    public static final Item[] quizItems = {
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

    public static final Item[] prelabItems = {
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

    public static final Item[] labItems = {
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

    public static final Item[] examItems = {
            new Item("Exam 1", 61.0, 100.0),
            new Item("Exam 2", 54.5, 100.0),
            new Item("Exam 3", 0.0, 100.0)
    };

    /* -------------------------------------------Fields (Categories)------------------------------------------------ */
    public static final Category lectures = new Category("Lectures", 0.10, Arrays.asList(Phys142.lectureItems), 2);

    public static final Category groupProblems = new Category("Group Problems", 0.10, Arrays.asList(Phys142.groupProblemItems), 1);

    public static final Category onlineHW = new Category("Online HW", 0.075, Arrays.asList(Phys142.onlineHWItems), 1);

    public static final Category writtenHW = new Category("Written HW", 0.075, Arrays.asList(Phys142.writtenHWItems), 1);

    public static final Category quizzes = new Category("Quizzes", 0.10, Arrays.asList(Phys142.quizItems), 1);

    public static final Category prelabs = new Category("Prelabs", 0.02, Arrays.asList(Phys142.prelabItems), 1);

    public static final Category labs = new Category("Labs", 0.08, Arrays.asList(Phys142.labItems), 2);

    public static final Category exams = new Category("Exams", 0.45, Arrays.asList(Phys142.examItems), 0);

    public static final Category[] categories = {
            Phys142.lectures,
            Phys142.groupProblems,
            Phys142.onlineHW,
            Phys142.writtenHW,
            Phys142.quizzes,
            Phys142.prelabs,
            Phys142.labs,
            Phys142.exams
    };

    /* ---------------------------------------------Fields (Course)-------------------------------------------------- */
    public static final Course course = new Course("PHYS 142", Arrays.asList(Phys142.categories));

}
