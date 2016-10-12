package com.n0hands.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.load_game:
                Toast.makeText(this,"Load Game",Toast.LENGTH_SHORT).show();
                setContentView(R.layout.activity_login);
                break;
            case R.id.save_game:
                Toast.makeText(this,"Save Game",Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Unsupported operation", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
