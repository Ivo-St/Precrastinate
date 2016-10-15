package com.n0hands.todoapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.n0hands.todoapp.model.Category;

public class CreateCategoryActivity extends AppCompatActivity {
    private EditText setNameView,
            setDescriptionView;
    private FloatingActionButton denyButton,
            acceptButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_create_category);

        this.setTitle(R.string.category_create_title);

        this.setNameView = (EditText) this.findViewById(R.id.category_create_name_input);
        this.setDescriptionView = (EditText) this.findViewById(R.id.category_create_description_input);
        this.denyButton = (FloatingActionButton) this.findViewById(R.id.category_create_deny);
        this.acceptButton = (FloatingActionButton) this.findViewById(R.id.category_create_accept);

        this.acceptButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String categoryName = setNameView.getText().toString();
                String categoryDescription = setDescriptionView.getText().toString();

                if(categoryName.isEmpty()){
                    setNameView.setError("Category name is required");
                    return;
                }

                Category newCategory = new Category(categoryName, categoryDescription);
                newCategory.save();

                Intent intent = new Intent(getApplicationContext(), CategoriesListActivity.class);
                startActivity(intent);
            }
        });

        this.denyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CategoriesListActivity.class);
                startActivity(intent);
            }
        });
    }
}
