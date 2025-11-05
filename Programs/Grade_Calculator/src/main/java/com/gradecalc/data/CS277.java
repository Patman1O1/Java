package com.gradecalc.data;

import com.gradecalc.Category;
import com.gradecalc.Course;
import com.gradecalc.Item;

import java.util.Arrays;

public class CS277 {
    /* ----------------------------------------------Fields (Items)-------------------------------------------------- */
    public static Item[] administrativeCheckItems = {
            new Item("Required Course Policies Check", 0.0),
            new Item("Required Mid-Semester Check-In", 0.0),
            //new Item("Final Student Evaluation", 100.0) // what-if
    };

    public static Item[] labItems = {
            new Item("W2 Lab", 100.0),
            new Item("W3 Lab", 100.0),
            new Item("W4 Lab", 0.0),
            new Item("W5 Lab", 80.0),
            new Item("W7 Lab", 100.0),
            new Item("W8 Lab", 100.0),
            new Item("W9 Lab", 0.0),
            //new Item("W10 Lab", 100.0), // what-if
            //new Item("W11 Lab", 100.0), // what-if
            //new Item("W12 Lab", 100.0), // what-if
            //new Item("W13 Lab", 100.0) // what-if
    };

    public static Item[] quizItems = {
            new Item("W2 Quiz", 0.0),
            new Item("W3 Quiz", 40.0),
            new Item("W5 Quiz", 100.0),
            new Item("W4 Quiz", 0.0),
            new Item("W7 Quiz", 100.0),
            new Item("W8 Quiz", 0.0),
            new Item("W9 Quiz", 0.0),
            //new Item("W11 Quiz", 100.0), // what-if
            //new Item("W12 Quiz", 100.0), // what-if
            //new Item("W13 Quiz", 100.0) // what-if
    };

    public static Item[] homeworkItems = {
            new Item("Homework 1", 0.0),
            new Item("Homework 2", 70.0),
            //new Item("Homework 3", 100.0), // what-if
            //new Item("Homework 4", 100.0), // what-if
            //new Item("Homework 5", 100.0) // what-if
    };

    public static Item[] lectureItems = {

    };

    /* -------------------------------------------Fields (Categories)------------------------------------------------ */
    public static Category administrativeChecks = new Category("Administrative Checks", 0.05, Arrays.asList(administrativeCheckItems));

    public static Category labs = new Category("Labs", 0.45, Arrays.asList(labItems), 2);

    public static Category quizzes = new Category("Quizzes", 0.15, Arrays.asList(quizItems), 2);

    public static Category homework = new Category("Homework", 0.35, Arrays.asList(homeworkItems));

    public static Category lectures = new Category("Lectures", 1.05, Arrays.asList(lectureItems));

    public static Category[] categories = {
            administrativeChecks,
            labs,
            quizzes,
            homework,
            lectures
    };

    /* ---------------------------------------------Fields (Course)-------------------------------------------------- */
    public static Course course = new Course("CS 277", Arrays.asList(categories));

    /* -------------------------------------------------Main--------------------------------------------------------- */
    public static void main(String[] args) {
        System.out.printf("Grade: %.5f\n", course.calculateGrade());
    }
}
