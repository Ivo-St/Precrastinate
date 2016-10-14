package com.n0hands.todoapp;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.n0hands.todoapp.model.Category;
import com.n0hands.todoapp.model.TodoItem;
import com.orm.SugarContext;

import java.io.File;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        this.createDatabase();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    private void createDatabase() {
        SugarContext.init(this.getApplicationContext());
        if (!this.doesDatabaseExist(this, "precrastinator_database.db")) {
            Category.findById(Category.class, 1);
            TodoItem.findById(TodoItem.class, 1);
            this.dummyFillDatabase();
        }
    }

    private boolean doesDatabaseExist(Context context, String dbLocation) {
        File dbFile = context.getDatabasePath(dbLocation);
        return dbFile.exists();
    }

    private void dummyFillDatabase() {
        Category todo = new Category("ToDo", "Things todo");
        Category todo2 = new Category("ToDo2", "Things todo2");

        todo.save();
        todo2.save();

        TodoItem todoItem = new TodoItem("Test", "Test item", "This is test todo item", todo);
        TodoItem todoItem2 = new TodoItem("Test2", "Test item2", "This is test todo item2", todo2);

        todoItem.save();
        todoItem2.save();
    }
}
