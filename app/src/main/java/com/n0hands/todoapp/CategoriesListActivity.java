package com.n0hands.todoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

import com.n0hands.todoapp.model.Category;
import com.n0hands.todoapp.model.TodoItem;

import java.util.List;

public class CategoriesListActivity extends AppCompatActivity {
    private RecyclerView categoryList;
    private CategoriesAdapter categoriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_list);
        setTitle(R.string.default_title);

        List<Category> categories = Category.listAll(Category.class);

        this.categoryList = (RecyclerView) this.findViewById(R.id.category_list);

        categoriesAdapter = new CategoriesAdapter(categories);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        categoryList.setLayoutManager(mLayoutManager);
        categoryList.setItemAnimator(new DefaultItemAnimator());
        categoryList.setAdapter(categoriesAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
