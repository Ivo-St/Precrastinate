package com.n0hands.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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

        categoryList.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), categoryList, new IClickListener() {
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

                Intent intent = new Intent(getApplicationContext(), EditCategoryActivity.class);
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
                Intent intent = new Intent(getApplicationContext(), CreateCategoryActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }
}
