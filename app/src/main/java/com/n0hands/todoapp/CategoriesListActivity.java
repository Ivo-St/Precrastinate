package com.n0hands.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.n0hands.todoapp.model.Category;

import java.util.List;

public class CategoriesListActivity extends AppCompatActivity {
    private RecyclerView categoryList;
    private CategoriesAdapter categoriesAdapter;
    private FloatingActionButton createCategoryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_list);

        setTitle(R.string.category_list_title);

        this.categoryList = (RecyclerView) this.findViewById(R.id.category_list);
        this.createCategoryButton = (FloatingActionButton) this.findViewById(R.id.category_create);

        final List<Category> categories = Category.listAll(Category.class);

        categoriesAdapter = new CategoriesAdapter(categories);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        categoryList.setLayoutManager(mLayoutManager);
        categoryList.setItemAnimator(new DefaultItemAnimator());
        categoryList.setAdapter(categoriesAdapter);

        categoryList.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), categoryList, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Category category = categories.get(position);

                Intent intent = new Intent(getApplicationContext(), TodoItemsListActivity.class);
                intent.putExtra("CATEGORY", category);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
                Category category = categories.get(position);

                Intent intent = new Intent(getApplicationContext(), EditCategory.class);
                intent.putExtra("CATEGORY", category);
                startActivity(intent);
            }

            @Override
            public void onFling(View view, int position) {
                Category category = categories.get(position);

                view.clearAnimation();

                category.delete();

                categories.remove(position);
                categoryList.getAdapter().notifyItemRemoved(position);
                categoryList.getAdapter().notifyItemRangeChanged(position,categoryList.getAdapter().getItemCount());
            }
        }));

        this.createCategoryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CreateCategory.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        this.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
