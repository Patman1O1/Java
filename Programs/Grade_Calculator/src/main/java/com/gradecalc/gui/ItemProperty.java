package com.gradecalc.gui;

import com.gradecalc.Item;

import javafx.beans.property.*;
import javafx.scene.control.TreeItem;

public class ItemProperty {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    private Item item;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public ItemProperty(Item item) throws NullPointerException {
        this.set(item);
    }

    /* -------------------------------------------------Setters------------------------------------------------------ */
    public void set(Item item) throws NullPointerException {
        if (item == null) {
            throw new NullPointerException("\"item\" cannot be null");
        }

        this.item = item;
    }

    /* -------------------------------------------------Getters------------------------------------------------------ */
    public TreeItem<Object> get() {
        return new TreeItem<>(this.item);
    }

    /* -------------------------------------------------Methods------------------------------------------------------ */
    public StringProperty name() {
        return new SimpleStringProperty(this.item.getName());
    }

    public DoubleProperty grade() {
        return new SimpleDoubleProperty(this.item.calculateGrade() * 100);
    }


}
