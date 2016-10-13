package com.n0hands.todoapp.model;

import com.orm.SugarRecord;

import java.util.List;

public class Category extends SugarRecord {
    private String name;
    private String description;

    public Category() {
    }

    public Category(String name, String description) {
        this.setName(name);
        this.setDescription(description);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TodoItem> getTodoItems() {
        return TodoItem.find(TodoItem.class, "category = ?", String.valueOf(this.getId()));
    }
}
