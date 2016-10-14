package com.n0hands.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView testView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_game:
                Toast.makeText(this, "Save Game", Toast.LENGTH_SHORT).show();
                Intent intentCategory = new Intent(this, CategoriesListActivity.class);
                startActivity(intentCategory);
                break;
            case R.id.load_game:
                Toast.makeText(this, "Load Game", Toast.LENGTH_SHORT).show();
                Intent intentLogin = new Intent(this, TodoItemsListActivity.class);
                startActivity(intentLogin);
                break;
            case R.id.test_game:
                Intent intentTest = new Intent(this, Test.class);
                startActivity(intentTest);
                break;
            default:
                Toast.makeText(this, "Unsupported operation", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}
