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
    boolean isEntryValid = false;

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
        addOperatorEventHandlers();

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

                    String first = firstOperand.getText().toString();
                    String second = secondOperand.getText().toString();

                    double a = 0.0;
                    double b = 0.0;
                    double c = 0.0;

                    if(!(first.isEmpty()) && !(second.isEmpty())){

                        a = Double.parseDouble(first);
                        b = Double.parseDouble(second);
                        isEntryValid = true;

                    }else{

                        isEntryValid = false;
                    }

                    switch(operatorBtns[tempI].getText().toString()){

                        case "+":

                            c = a+b;
                            break;

                        case "-":

                            c=a-b;
                            break;

                        case "*":
                            c=a*b;
                            break;

                        case "/":
                            c = (b == 0) ? Double.NaN : a/b;
                            break;

                        case "^":
                            c=Math.pow(a,b);
                            break;

                        case "sqrt":
                            c = Math.sqrt(a);
                            break;
                    }

                    if(isEntryValid) {
                        result.setText(String.valueOf(c));
                    }else{
                        result.setText("");
                    }
                }
            });

        }

    }

}
