package com.n0hands.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.n0hands.todoapp.model.Category;
import com.n0hands.todoapp.model.TodoItem;

public class ViewTodoItemActivity extends AppCompatActivity {
    private TextView titleView,
            subtitleView,
            descriptionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_todo_item);

        this.setTitle("Todo Item Preview");

        this.titleView = (TextView) this.findViewById(R.id.todo_item_view_title);
        this.subtitleView = (TextView) this.findViewById(R.id.todo_item_view_subtitle);
        this.descriptionView = (TextView) this.findViewById(R.id.todo_item_view_description);

        Intent intent = getIntent();
        final Category category = intent.getParcelableExtra("CATEGORY");
        final TodoItem todo = intent.getParcelableExtra("TODO_ITEM");

        this.titleView.setText(todo.getTitle());
        this.subtitleView.setText(todo.getSubTitle());
        this.descriptionView.setText(todo.getDescription());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.todo_item_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent initialIntent = this.getIntent();
        switch (item.getItemId()) {
            case R.id.todo_item_menu_edit:
                Intent intent = new Intent(this, EditTodoItemActivity.class);
                intent.putExtra("CATEGORY", initialIntent.getParcelableExtra("CATEGORY"));
                intent.putExtra("TODO_ITEM", initialIntent.getParcelableExtra("TODO_ITEM"));
                startActivity(intent);
                break;
            case R.id.todo_item_menu_delete:
                final TodoItem todo = initialIntent.getParcelableExtra("TODO_ITEM");
                boolean result = todo.delete();
                if(result){
                    Toast.makeText(this, "Successfuly deleted Todo Item", Toast.LENGTH_SHORT).show();
                    Intent intentTodoList = new Intent(this, TodoItemsListActivity.class);
                    intentTodoList.putExtra("CATEGORY", initialIntent.getParcelableExtra("CATEGORY"));
                    intentTodoList.putExtra("TODO_ITEM", initialIntent.getParcelableExtra("TODO_ITEM"));
                    startActivity(intentTodoList);
                } else {
                    Toast.makeText(this, "Could not deleted Todo Item", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                Toast.makeText(this, "Unsupported operation", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}
