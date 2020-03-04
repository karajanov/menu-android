package com.example.androidmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout mainlayout;
    boolean isDark = false;
    TextView t;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainlayout = findViewById(R.id.mainlayout);
        b = findViewById(R.id.button_add);
        t= findViewById(R.id.textViewResult);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                t.setText("changed");

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu m) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, m);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){

            case R.id.item_darkmode:

                if(isDark){
                    mainlayout.setBackgroundColor(Color.WHITE);
                    isDark = false;
                }else{
                    mainlayout.setBackgroundColor(Color.LTGRAY);
                    isDark = true;
                }

                break;

        }

        return true;
    }
}
