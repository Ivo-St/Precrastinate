package com.n0hands.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.n0hands.todoapp.model.Category;

public class EditCategoryActivity extends AppCompatActivity {
    private EditText setNameView,
            setDescriptionView;
    private FloatingActionButton denyButton,
            acceptButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_create_category);

        this.setTitle(R.string.category_edit_title);

        this.setNameView = (EditText) this.findViewById(R.id.category_create_name_input);
        this.setDescriptionView = (EditText) this.findViewById(R.id.category_create_description_input);
        this.denyButton = (FloatingActionButton) this.findViewById(R.id.category_create_deny);
        this.acceptButton = (FloatingActionButton) this.findViewById(R.id.category_create_accept);

        Intent intent = getIntent();
        final Category category = intent.getParcelableExtra("CATEGORY");

        this.setNameView.setText(category.getName());
        this.setDescriptionView.setText(category.getDescription());

        this.acceptButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String categoryName = setNameView.getText().toString();
                String categoryDescription = setDescriptionView.getText().toString();

                if(categoryName.isEmpty()){
                    setNameView.setError("Category name is required");
                    return;
                }

                category.setName(categoryName);
                category.setDescription(categoryDescription);
                category.save();

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