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
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout mainlayout;
    boolean isDark = false;
    Button[] operatorBtns = new Button[6];
    EditText firstOperand, secondOperand;
    TextView result;
    boolean isScientific = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialization
        mainlayout = findViewById(R.id.mainlayout);
        firstOperand = findViewById(R.id.editTextOne);
        secondOperand = findViewById(R.id.editTextTwo);
        result = findViewById(R.id.textViewResult);
        initializeOperatorBtns();

        //Hide additional buttons
         hideAdditionalBtns();

        //Event listeners

    }

    @Override
    public boolean onCreateOptionsMenu(Menu m) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, m);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.item_darkmode:

                if (isDark) {
                    mainlayout.setBackgroundColor(Color.WHITE);
                    isDark = false;
                } else {
                    mainlayout.setBackgroundColor(Color.LTGRAY);
                    isDark = true;
                }

                break;

            case R.id.item_scientific:

                if (isScientific) {

                    item.setTitle("Scientific Mode");
                    hideAdditionalBtns();
                    isScientific = false;

                } else {

                    item.setTitle("Regular Mode");
                    displayAdditionalBtns();
                    isScientific = true;

                }

                break;

        }

        return true;
    }

    private int getOperatorBtnId(int index) {

        int opId = getResources()
                .getIdentifier("button" + index, "id", getPackageName());

        return opId;

    }

    private void initializeOperatorBtns() {

        for (int i = 0; i < operatorBtns.length; ++i) {
            int opId = getOperatorBtnId(i);
            operatorBtns[i] = findViewById(opId);
        }
    }

    private void hideAdditionalBtns() {
        operatorBtns[4].setVisibility(View.GONE);
        operatorBtns[5].setVisibility(View.GONE);
    }

    private void displayAdditionalBtns() {
        operatorBtns[4].setVisibility(View.VISIBLE);
        operatorBtns[5].setVisibility(View.VISIBLE);
    }

    private void addOperatorEventHandlers(){

        for(int i = 0; i < operatorBtns.length; ++i){

            final int tempI = i;

            operatorBtns[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    switch(operatorBtns[tempI].getText().toString()){

                        case "+":
                            break;

                        case "-":
                            break;

                        case "*":
                            break;

                        case "/":
                            break;

                        case "^":
                            break;

                        case "sqrt":
                            break;
                    }
                }
            });

        }

    }

}
