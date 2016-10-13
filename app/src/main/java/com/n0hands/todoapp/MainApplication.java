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
        this.dummyFillDatabase();
        Log.d("Test-",TodoItem.findById(TodoItem.class,1).getTitle());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    private void createDatabase() {
        SugarContext.init(this.getApplicationContext());
        if (!this.doesDatabaseExist(this, "precrastinate_database.db")) {
            Log.d("test","test");
            Category.findById(Category.class, 1);
            TodoItem.findById(TodoItem.class, 1);
        }
    }

    private boolean doesDatabaseExist(Context context, String dbLocation) {
        File dbFile = new File(dbLocation);

        return dbFile.exists();
    }

    private void dummyFillDatabase(){
        Category todo = new Category("ToDo","Things todo");
        todo.save();

        TodoItem todoItem = new TodoItem("Test","Test item","This is test todo item",todo);
        todoItem.save();
    }
}
