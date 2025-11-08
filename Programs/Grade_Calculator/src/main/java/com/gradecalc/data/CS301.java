package com.gradecalc.data;

import com.gradecalc.Item;
import com.gradecalc.Category;
import com.gradecalc.Course;

import java.util.Arrays;

public class CS301 {
    /* ----------------------------------------------Fields (Items)-------------------------------------------------- */
    public static final Item[] participationItems = {

    };

    public static final Item[] quizItems = {
            new Item("Quiz 1", 2.00, 4.00),
            new Item("Quiz 2", 4.00, 4.00),
            new Item("Quiz 3", 2.00, 4.00),
            new Item("Quiz 4", 2.00, 4.00),
            new Item("Quiz 5", 0.00, 4.00),
            new Item("Quiz 6", 4.00, 4.00),
            new Item("Quiz 7", 4.00, 4.00),
            new Item("Quiz 8", 2.00, 4.00)
    };

    public static final Item[] labItems = {
            new Item("Lab Assignment 1", 9.25, 10.0),
            new Item("Lab Assignment 2", 7.50, 10.0),
            new Item("Lab Assignment 3", 9.50, 10.0),
            new Item("Lab Assignment 4", 6.00, 10.0),
            new Item("Lab Assignment 5", 8.00, 10.0),
            new Item("Lab Assignment 6", 9.25, 10.0),
            new Item("Lab Assignment 7", 9.00, 10.0),
            new Item("Lab Assignment 8", 7.75, 10.0),
            new Item("Lab Assignment 8", 8.8, 10.0),
    };

    public static final Item[] homeworkItems = {
            new Item("Homework Assignment 1", 100.0, 100.0),
            new Item("Homework Assignment 2", 87.0, 100.0),
    };

    public static final Item[] midtermExamItems = {
        new Item("Exam 1", 55.50, 100.0)
    };

    public static final Item[] finalExamItems = {

    };

    public static final Item[] extraCreditItems = {

    };

    /* -------------------------------------------Fields (Categories)------------------------------------------------ */
    public static final Category participation = new Category("Participation", 0.05, Arrays.asList(participationItems));

    public static final Category quizzes = new Category("Quizzes", 0.10, Arrays.asList(quizItems));

    public static final Category labs = new Category("Labs", 0.10, Arrays.asList(labItems));

    public static final Category homework = new Category("Homework", 0.25, Arrays.asList(homeworkItems));

    public static final Category midtermExams = new Category("Midterm Exams", 0.30, Arrays.asList(midtermExamItems));

    public static final Category finalExam = new Category("Final Exam", 0.20, Arrays.asList(finalExamItems));

    public static final Category extraCredit = new Category("Extra Credit", 1.01, Arrays.asList(extraCreditItems));

    public static final Category[] categories = {
            participation,
            quizzes,
            labs,
            homework,
            midtermExams,
            finalExam,
            extraCredit
    };

    /* ---------------------------------------------Fields (Course)-------------------------------------------------- */
    public static final Course course = new Course("CS 301", Arrays.asList(categories));

    /* -------------------------------------------------Main--------------------------------------------------------- */
    public static void main(String[] args) {
        System.out.printf("Grade = %.5f", course.calculateGrade() * 100);
    }
}
