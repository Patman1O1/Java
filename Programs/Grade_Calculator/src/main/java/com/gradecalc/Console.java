package com.gradecalc;

import com.gradecalc.data.CS362;

import java.io.IOException;

public class Console {
    /* -------------------------------------------------Fields------------------------------------------------------- */


    /* --------------------------------------------Methods (Course)-------------------------------------------------- */
    protected static void writeCourse(String pathname, Course course) {
        try {
            JsonFile<Course> file = new JsonFile<>(pathname);
            file.write(course);
        } catch (IOException e) {
            System.out.printf("IOException was thrown with message \"%s\"\n", e.getMessage());
        } catch (Exception e) {
            System.out.printf("Exception was thrown with message \"%s\"\n", e.getMessage());
        }
    }

    protected static Course readCourse(String pathname) {
        try {
            JsonFile<Course> file = new JsonFile<>(pathname);
            return file.read(Course.class);
        } catch (IOException e) {
            System.out.printf("IOException was thrown with message \"%s\"\n", e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            System.out.printf("Exception was thrown with message \"%s\"\n", e.getMessage());
            System.exit(1);
        }
        return null;
    }

    protected static void printCourse(Course course) {
        if (course == null) {
            System.out.println("Course is null");
            return;
        }

        System.out.printf("Name: %s\n", course.getName());
        System.out.printf("Grade: %.5f\n", course.calculateGrade());
        for (Category category : course.getCategories()) {
            System.out.printf("\tCategory Name: %s\n", category.getName());
            System.out.printf("\tCategory Grade: %.5f\n", category.getGrade());
            System.out.printf("\tCategory Weight: %.5f\n", category.getWeight());

            System.out.print("\tCategory Items\n");
            for (Item item : category.getItems()) {
                System.out.printf("\t\tItem Name: %s\n", item.getName());
                System.out.printf("\t\tItem Grade: %.5f\n", item.getGrade());
            }

            System.out.print("\tCategory Drops\n");
            for (Item drop : category.getDrops()) {
                System.out.printf("\t\tDrop Name: %s\n", drop.getName());
                System.out.printf("\t\tDrop Grade %.5f\n", drop.getGrade());
            }
        }
    }

    /* -------------------------------------------Methods (Category)------------------------------------------------- */
    protected static void writeCategory(String pathname, Category category) {
        try {
            JsonFile<Category> file = new JsonFile<>(pathname);
            file.write(category);
        } catch (IOException e) {
            System.out.printf("IOException was thrown with message \"%s\"\n", e.getMessage());
        } catch (Exception e) {
            System.out.printf("Exception was thrown with message \"%s\"\n", e.getMessage());
        }
    }

    protected static Category readCategory(String pathname) {
        try {
            JsonFile<Category> file = new JsonFile<>(pathname);
            return file.read(Category.class);
        } catch (IOException e) {
            System.out.printf("IOException was thrown with message \"%s\"\n", e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            System.out.printf("Exception was thrown with message \"%s\"\n", e.getMessage());
            System.exit(1);
        }
        return null;
    }

    protected static void printCategory(Category category) {
        if (category == null) {
            System.out.println("Category is null");
            return;
        }

        System.out.printf("Name: %s\n", category.getName());
        System.out.printf("Grade: %.5f\n", category.getGrade());
        System.out.printf("Weight: %.5f\n", category.getWeight());
        System.out.print("Items\n");

        for (Item item : category.getItems()) {
            System.out.printf("\tItem Name: %s\n", item.getName());
            System.out.printf("\tItem Grade: %.5f\n", item.getGrade());
        }

        System.out.print("Drops\n");

        for (Item drop : category.getDrops()) {
            System.out.printf("\tDrop Name: %s\n", drop.getName());
            System.out.printf("\tDrop Grade: %.5f\n", drop.getGrade());
        }
    }

    /* ---------------------------------------------Methods (Items)-------------------------------------------------- */
    protected static void writeItem(String pathname, Item item) {
        try {
            JsonFile<Item> file = new JsonFile<>(pathname);
            file.write(item);
        } catch (IOException e) {
            System.out.printf("IOException was thrown with message \"%s\"\n", e.getMessage());
        } catch (Exception e) {
            System.out.printf("Exception was thrown with message \"%s\"\n", e.getMessage());
        }
    }

    protected static Item readItem(String pathname) {
        try {
            JsonFile<Item> file = new JsonFile<>(pathname);
            return file.read(Item.class);
        } catch (IOException e) {
            System.out.printf("IOException was thrown with message \"%s\"\n", e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            System.out.printf("Exception was thrown with message \"%s\"\n", e.getMessage());
            System.exit(1);
        }
        return null;
    }

    protected static void printItem(Item item) {
        if (item == null) {
            System.out.print("Item is null\n");
            return;
        }

        System.out.printf("Name: %s\n", item.getName());
        System.out.printf("Grade: %.5f\n", item.getGrade());
    }

    /* --------------------------------------------------Main-------------------------------------------------------- */
    public static void main(String[] args) {
        writeCourse("courses/CS 362.json", CS362.course);
    }
}
