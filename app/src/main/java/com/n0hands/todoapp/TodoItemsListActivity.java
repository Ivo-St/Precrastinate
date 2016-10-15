package com.n0hands.todoapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;

import com.n0hands.todoapp.model.Category;
import com.n0hands.todoapp.model.TodoItem;

import java.util.List;

public class TodoItemsListActivity extends AppCompatActivity {
    private RecyclerView todoList;
    private TodoItemsAdapter todoItemsAdapter;
    private FloatingActionButton createTodoItemButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_items_list);

        setTitle(R.string.default_title);

        this.todoList = (RecyclerView) this.findViewById(R.id.todo_items_list);
        this.createTodoItemButton = (FloatingActionButton) this.findViewById(R.id.todo_item_create);

        Intent intent = getIntent();
        Category category = intent.getParcelableExtra("CATEGORY");

        List<TodoItem> todoItems;
        if (category == null) {
            todoItems = TodoItem.listAll(TodoItem.class);
        } else {
            setTitle("Category: " + category.getName());
            todoItems = TodoItem.find(TodoItem.class, "category = ?", String.valueOf(category.getId()));
        }

        todoItemsAdapter = new TodoItemsAdapter(todoItems);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        todoList.setLayoutManager(mLayoutManager);
        todoList.setItemAnimator(new DefaultItemAnimator());
        todoList.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        todoList.setAdapter(todoItemsAdapter);

        this.createTodoItemButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CreateCategory.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
