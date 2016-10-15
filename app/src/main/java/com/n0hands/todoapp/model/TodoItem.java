package com.n0hands.todoapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.orm.SugarRecord;

public class TodoItem extends SugarRecord implements Parcelable {
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

    protected TodoItem(Parcel in) {
        setId(in.readLong());
        title = in.readString();
        subTitle = in.readString();
        description = in.readString();
        category = (Category) in.readValue(Category.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.getId());
        dest.writeString(title);
        dest.writeString(subTitle);
        dest.writeString(description);
        dest.writeValue(category);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<TodoItem> CREATOR = new Parcelable.Creator<TodoItem>() {
        @Override
        public TodoItem createFromParcel(Parcel in) {
            return new TodoItem(in);
        }

        @Override
        public TodoItem[] newArray(int size) {
            return new TodoItem[size];
        }
    };
}
