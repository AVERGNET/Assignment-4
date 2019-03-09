package com.example.extstudent.assignment4;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button firstButton = null;
    private int buttonCount = 0;
    LinearLayout scrollViewLayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollViewLayout = (LinearLayout)findViewById(R.id.scrollViewLayout);
        firstButton = (Button)findViewById(R.id.buttonSubmit);
        firstButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                generateNewButton();
                firstButton.setEnabled(false);
            }
        });
    }
    private void generateNewButton() {
        final Button newButton = new Button(MainActivity.this);

        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, height);
        newButton.setLayoutParams(layoutParams);

        newButton.setText("PRESS ME: " + Integer.toString(++buttonCount));
        newButton.setTextColor(getRandomColor());
        scrollViewLayout.addView(newButton);
        newButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                generateNewButton();
                newButton.setEnabled(false);
            }
        });

    }

    private int getRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}
