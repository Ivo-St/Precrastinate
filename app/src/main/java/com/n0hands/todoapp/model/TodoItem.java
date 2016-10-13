package com.n0hands.todoapp.model;

import com.orm.SugarRecord;

public class TodoItem extends SugarRecord {
    private String title;
    private String subTitle;
    private String description;
    private Category category;

    public TodoItem() {
    }

    public TodoItem(String title, String subTitle, String description, Category category) {
        this.setTitle(title);
        this.setSubTitle(subTitle);
        this.setDescription(description);
        this.setCategory(category);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
