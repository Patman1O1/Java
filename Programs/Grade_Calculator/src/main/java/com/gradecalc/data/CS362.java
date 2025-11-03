package com.gradecalc.data;

import com.gradecalc.Category;
import com.gradecalc.Course;
import com.gradecalc.Item;
import java.util.Arrays;

public class CS362 {
    /* ----------------------------------------------Fields (Items)-------------------------------------------------- */
    public static final Item[] homeworkItems = {
            new Item("Homework 1", 32.00, 50.00),
            new Item("Homework 2", 34.00, 40.00),
    };

    public static final Item[] labAssignmentItems = {
            new Item("Lab 1",100.0, 100.0),
    };

    public static final Item[] labReportItems = {
    };

    public static final Item[] groupProjectItems = {
            new Item("Milestone 1", 10.0, 10.0),
            new Item("Milestone 6", 100.0, 100.0)
    };

    public static final Item[] examsItems = {
            new Item("Midterm", 37.0, 100.0),
            new Item("Lab Exam", 30.0, 70.0),
            new Item("Code from Lab Exam", 30.0, 30.0)
    };

    public static final Item[] finalExamItem = {
            //new Item("Final E")
    };

    public static final Item[] classParticipationItems = {

    };

    /* -------------------------------------------Fields (Categories)------------------------------------------------ */
    public static final Category homeworks = new Category("Homeworks", 0.18, Arrays.asList(homeworkItems));

    public static final Category labAssignments = new Category("Lab Assignments", 0.16, Arrays.asList(labAssignmentItems), 1);

    public static final Category labReports = new Category("Lab Reports", 0.06, Arrays.asList(labReportItems));

    public static final Category groupProject = new Category("Group Project", 0.25, Arrays.asList(groupProjectItems));

    public static final Category exams = new Category("Exams", 0.15, Arrays.asList(examsItems));

    public static final Category finalExam = new Category("Final Exam", 0.15, Arrays.asList(finalExamItem));

    public static final Category classParticipation = new Category("Class Participation", 0.05, Arrays.asList(classParticipationItems));

    public static final Category[] categories = {
            homeworks,
            labAssignments,
            labReports,
            groupProject,
            exams,
            finalExam,
            classParticipation
    };

    /* ---------------------------------------------Fields (Course)-------------------------------------------------- */
    public static final Course course = new Course("CS 362", Arrays.asList(categories));

    /* -------------------------------------------------Main--------------------------------------------------------- */
    public static void main(String[] args) {
        System.out.printf("Grade %.5f\n", course.calculateGrade());
    }

}
