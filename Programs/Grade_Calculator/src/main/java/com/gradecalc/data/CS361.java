package com.gradecalc.data;

import com.gradecalc.Item;
import com.gradecalc.Category;
import com.gradecalc.Course;

import java.util.Arrays;

public class CS361 {
    /* ----------------------------------------------Fields (Items)-------------------------------------------------- */
    public static final Item[] attendanceItems = {
            new Item("Lec 00", 1.00, 1.00),
            new Item("Lec 01 Sync", 1.00, 1.00),
            //new Item("Lec 01 Async", 0.00, 1.00),
            new Item("Lec 01", 1.00, 1.00),
            new Item("Lec 02 Sync", 1.00, 1.00),
            new Item("Lec 02 Async", 1.00, 1.00),
            new Item("Lec 03 Sync", 1.00, 1.00),
            new Item("Lec 03 Async", 1.00, 1.00),
            new Item("Lec 03", 1.00, 1.00),
            new Item("Lec 04 Sync", 1.00, 1.00),
            new Item("Lec 04 Async", 0.00, 1.00),
            new Item("Lec 04", 1.00, 1.00),
            new Item("Lec 05 Sync", 1.00, 1.00),
            new Item("Lec 05 Async", 1.00, 1.00),
            new Item("Lec 05", 1.00, 1.00),
            new Item("Lec 06 Sync", 1.00, 1.00),
            //new Item("Lec 06 Async", 0.00, 1.00),
            new Item("Lec 06", 1.00, 1.00),
            new Item("Lec 07 Sync", 1.00, 1.00),
            //new Item("Lec 07 Async", 0.00, 1.00),
            new Item("Lec 07", 1.00, 1.00),
            new Item("Lec 08 Sync", 1.00, 1.00),
            //new Item("Lec 08 Async", 0.00, 1.00),
            new Item("Lec 08", 1.00, 1.00),
            new Item("Lec 09 Sync", 1.00, 1.00),
            //new Item("Lec 09 Async", 0.00, 1.00),
            new Item("Lec 09", 1.00, 1.00),
            new Item("Lec 10 Sync", 1.00, 1.00),
            //new Item("Lec 10 Async", 0.00, 1.00),
            new Item("Lec 10", 1.00, 1.00),
            //new Item("Lec 11 Sync", 0.00, 1.00),
            //new Item("Lec 11 Async", 0.00, 1.00),
            new Item("Lec 11", 0.00, 1.00),
            new Item("Lec 12 Sync", 1.00, 1.00),
            new Item("Lec 12 Async", 1.00, 1.00),
            new Item("Lec 12", 1.00, 1.00),
            //new Item("Lec 13 Sync", 0.00, 1.00),
            new Item("Lec 13 Async", 1.00, 1.00),
            new Item("Lec 13", 1.00, 1.00),
            new Item("Lec 14 Sync", 1.00, 1.00),
            new Item("Lec 14 Async", 1.00, 1.00),
            //new Item("Lec 15 Sync", 0.00, 1.00),
            new Item("Lec 15 Async", 1.00, 1.00),
            new Item("Lec 16 Sync", 1.00, 1.00),
            new Item("Lec 16 Async", 1.00, 1.00),
            new Item("Lec 16", 1.00, 1.00),
            //new Item("Lec 17 Sync", 0.00, 1.00),
            new Item("Lec 17 Async", 1.00, 1.00),
            new Item("Lec 17", 1.00, 1.00),
            new Item("Lec 18 Sync", 1.00, 1.00),
            new Item("Lec 18 Async", 1.00, 1.00),
            new Item("Lec 18", 1.00, 1.00),
            new Item("Lec 19 Sync", 1.00, 1.00),
            new Item("Lec 19 Async", 1.00, 1.00),
            new Item("Lec 19", 1.00, 1.00),
            new Item("Lec 20 Sync", 1.00, 1.00)
    };

    public static final Item[] programmingAssignmentItems = {
            new Item("Homework 1", 60.0, 100.0),
            new Item("Homework 2", 10.0, 100.0),
            new Item("Homework 3", 105.0, 100.0)
    };

    public static final Item[] writtenExamItems = {
            new Item("Midterm", 55.0, 100.0)
    };

    /* -------------------------------------------Fields (Categories)------------------------------------------------ */
    public static final Category attendance = new Category("Attendance", 0.15, Arrays.asList(attendanceItems));

    public static final Category programmingAssignments = new Category("Programming Assignments", 0.5, Arrays.asList(programmingAssignmentItems));

    public static final Category writtenExams = new Category("Written Exams", 0.35, Arrays.asList(writtenExamItems));

    public static final Category[] categories = {
            attendance,
            programmingAssignments,
            writtenExams
    };

    /* ---------------------------------------------Fields (Course)-------------------------------------------------- */
    public static final Course course = new Course("CS 361", Arrays.asList(categories));

    /* -------------------------------------------------Main--------------------------------------------------------- */
    public static void main(String[] args) {
        System.out.printf("Grade = %.5f\n", course.calculateGrade());
    }
}
