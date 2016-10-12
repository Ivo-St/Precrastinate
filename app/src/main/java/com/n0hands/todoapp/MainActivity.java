package com.n0hands.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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
                String currentText = (String) testView.getText();
                if (currentText.isEmpty()) {
                    testView.setText("Not empty");
                } else {
                    testView.setText("");
                }

                Toast.makeText(this, "Save Game", Toast.LENGTH_SHORT).show();
                break;
            case R.id.load_game:
                Toast.makeText(this, "Load Game", Toast.LENGTH_SHORT).show();
                setContentView(R.layout.activity_login);
                break;
            default:
                Toast.makeText(this, "Unsupported operation", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}
