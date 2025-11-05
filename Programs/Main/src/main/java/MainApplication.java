import javafx.application.Application;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

import java.util.List;

public class MainApplication extends Application {

    // ===== Data Model =====
    public static class Item {
        private final StringProperty name = new SimpleStringProperty();
        private final DoubleProperty grade = new SimpleDoubleProperty();

        public Item(String name, double grade) {
            this.name.set(name);
            this.grade.set(grade);
        }

        public StringProperty nameProperty() { return name; }
        public DoubleProperty gradeProperty() { return grade; }

        @Override
        public String toString() {
            return name.get() + " (" + grade.get() + ")";
        }
    }

    public static class Category {
        private final StringProperty name = new SimpleStringProperty();
        private final DoubleProperty grade = new SimpleDoubleProperty();
        private final DoubleProperty weight = new SimpleDoubleProperty();
        private final ObservableList<Item> items = FXCollections.observableArrayList();
        private final ObservableList<Item> drops = FXCollections.observableArrayList();

        public Category(String name, double grade, double weight, List<Item> items, List<Item> drops) {
            this.name.set(name);
            this.grade.set(grade);
            this.weight.set(weight);
            this.items.addAll(items);
            this.drops.addAll(drops);
        }

        public StringProperty nameProperty() { return name; }
        public DoubleProperty gradeProperty() { return grade; }
        public DoubleProperty weightProperty() { return weight; }
        public ObservableList<Item> getItems() { return items; }
        public ObservableList<Item> getDrops() { return drops; }

        @Override
        public String toString() {
            return name.get() + " (" + grade.get() + ")";
        }
    }

    public static class Course {
        private final StringProperty name = new SimpleStringProperty();
        private final DoubleProperty grade = new SimpleDoubleProperty();
        private final ObservableList<Category> categories = FXCollections.observableArrayList();

        public Course(String name, double grade, List<Category> categories) {
            this.name.set(name);
            this.grade.set(grade);
            this.categories.addAll(categories);
        }

        public StringProperty nameProperty() { return name; }
        public DoubleProperty gradeProperty() { return grade; }
        public ObservableList<Category> getCategories() { return categories; }

        @Override
        public String toString() {
            return name.get() + " (" + grade.get() + ")";
        }
    }

    // ===== App Start =====
    @Override
    public void start(Stage stage) {
        // Example data
        Course course = new Course("CS 362", 0.5117, List.of(
                new Category("Exams", 0.37, 0.15,
                        List.of(new Item("Midterm 1", 0.37)), List.of()),
                new Category("Group Project", 1.0, 0.25,
                        List.of(new Item("Milestone 6", 1.0)), List.of()),
                new Category("Homeworks", 0.4967, 0.18,
                        List.of(new Item("Homework 1", 0.64),
                                new Item("Homework 2", 0.85),
                                new Item("Homework 3", 0.0)), List.of()),
                new Category("Lab Assignments", 0.73, 0.16,
                        List.of(new Item("Lab 1", 1.0),
                                new Item("Lab 3", 0.0),
                                new Item("Lab 4", 0.9),
                                new Item("Lab 5", 0.75),
                                new Item("Lab 6", 1.0)),
                        List.of(new Item("Lab 2", 0.0)))
        ));

        // ===== Tree Table Setup =====
        TreeItem<Object> root = new TreeItem<>(course);
        root.setExpanded(true);

        // Add categories and items
        for (Category cat : course.getCategories()) {
            TreeItem<Object> catItem = new TreeItem<>(cat);
            catItem.setExpanded(true);

            TreeItem<Object> itemsNode = new TreeItem<>("Items");
            for (Item i : cat.getItems()) {
                itemsNode.getChildren().add(new TreeItem<>(i));
            }

            TreeItem<Object> dropsNode = new TreeItem<>("Drops");
            for (Item i : cat.getDrops()) {
                dropsNode.getChildren().add(new TreeItem<>(i));
            }

            catItem.getChildren().addAll(itemsNode, dropsNode);
            root.getChildren().add(catItem);
        }

        TreeTableView<Object> treeTable = new TreeTableView<>(root);
        treeTable.setShowRoot(true);
        treeTable.setEditable(true);

        // ===== Columns =====
        TreeTableColumn<Object, String> nameCol = new TreeTableColumn<>("Name");
        nameCol.setPrefWidth(250);
        nameCol.setCellValueFactory(param -> {
            Object value = param.getValue().getValue();
            if (value instanceof Course c) return c.nameProperty();
            if (value instanceof Category cat) return cat.nameProperty();
            if (value instanceof Item i) return i.nameProperty();
            return new SimpleStringProperty(value.toString());
        });
        nameCol.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
        nameCol.setOnEditCommit(evt -> {
            Object obj = evt.getRowValue().getValue();
            if (obj instanceof Course c) c.nameProperty().set(evt.getNewValue());
            if (obj instanceof Category cat) cat.nameProperty().set(evt.getNewValue());
            if (obj instanceof Item i) i.nameProperty().set(evt.getNewValue());
        });

        TreeTableColumn<Object, String> gradeCol = new TreeTableColumn<>("Grade");
        gradeCol.setPrefWidth(100);
        gradeCol.setCellValueFactory(param -> {
            Object value = param.getValue().getValue();
            if (value instanceof Course c) return new SimpleStringProperty(String.valueOf(c.gradeProperty().get()));
            if (value instanceof Category cat) return new SimpleStringProperty(String.valueOf(cat.gradeProperty().get()));
            if (value instanceof Item i) return new SimpleStringProperty(String.valueOf(i.gradeProperty().get()));
            return new SimpleStringProperty("");
        });

        gradeCol.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
        gradeCol.setOnEditCommit(evt -> {
            Object obj = evt.getRowValue().getValue();
            try {
                double newVal = Double.parseDouble(evt.getNewValue());
                if (obj instanceof Course c) c.gradeProperty().set(newVal);
                if (obj instanceof Category cat) cat.gradeProperty().set(newVal);
                if (obj instanceof Item i) i.gradeProperty().set(newVal);
            } catch (NumberFormatException ignored) {}
        });

        treeTable.getColumns().addAll(nameCol, gradeCol);

        // ===== Layout =====
        BorderPane layout = new BorderPane(treeTable);
        stage.setScene(new Scene(layout, 600, 400));
        stage.setTitle("Editable JSON Grade Viewer");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
