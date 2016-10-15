package com.n0hands.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.n0hands.todoapp.model.Category;
import com.n0hands.todoapp.model.TodoItem;

public class EditTodoItemActivity extends AppCompatActivity {
    private EditText setTitleView,
            setSubtitleView,
            setDescriptionView;
    private FloatingActionButton denyButtonView,
            acceptButtonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_todo_item);

        this.setTitleView = (EditText) this.findViewById(R.id.todo_item_create_title_input);
        this.setSubtitleView = (EditText) this.findViewById(R.id.todo_item_create_subtitle_input);
        this.setDescriptionView = (EditText) this.findViewById(R.id.todo_item_create_description_input);
        this.denyButtonView = (FloatingActionButton) this.findViewById(R.id.todo_item_create_deny);
        this.acceptButtonView = (FloatingActionButton) this.findViewById(R.id.todo_item_create_accept);

        Intent intent = getIntent();
        final Category category = intent.getParcelableExtra("CATEGORY");
        final TodoItem todo = intent.getParcelableExtra("TODO_ITEM");

        this.setTitleView.setText(todo.getTitle());
        this.setSubtitleView.setText(todo.getSubTitle());
        this.setDescriptionView.setText(todo.getDescription());

        this.acceptButtonView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String todoTitle = setTitleView.getText().toString();
                String todoSubtitle = setSubtitleView.getText().toString();
                String todoDescription = setDescriptionView.getText().toString();

                if (todoTitle.isEmpty()) {
                    setTitleView.setError("Todo Item title is required");
                    return;
                }

                todo.setTitle(todoTitle);
                todo.setSubTitle(todoSubtitle);
                todo.setDescription(todoDescription);
                todo.save();

                Intent intent = new Intent(getApplicationContext(), TodoItemsListActivity.class);
                intent.putExtra("CATEGORY", category);
                startActivity(intent);
            }
        });

        this.denyButtonView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TodoItemsListActivity.class);
                startActivity(intent);
            }
        });
    }
}
