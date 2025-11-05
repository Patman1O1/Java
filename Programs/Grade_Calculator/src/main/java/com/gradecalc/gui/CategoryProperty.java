package com.gradecalc.gui;

import com.gradecalc.Category;
import com.gradecalc.Item;

import javafx.beans.property.*;
import javafx.scene.control.TreeItem;

public class CategoryProperty {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    private Category category;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public CategoryProperty(Category category) throws NullPointerException { this.set(category); }

    /* -------------------------------------------------Setters------------------------------------------------------ */
    public void set(Category category) throws NullPointerException {
        if (category == null) {
            throw new NullPointerException("\"category\" cannot be null");
        }

        this.category = category;
    }

    /* -------------------------------------------------Getters------------------------------------------------------ */


    /* -------------------------------------------------Methods------------------------------------------------------ */
    public StringProperty name() { return new SimpleStringProperty(this.category.getName()); }

    public DoubleProperty grade() { return new SimpleDoubleProperty(this.category.calculateGrade() * 100); }


}
