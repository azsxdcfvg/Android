package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.button_open);
        final TextView tv1 = findViewById(R.id.tv1);
        final TextView tv2 = findViewById(R.id.tv2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("         :)                          (:");
            }
        });

        Button swi1 = findViewById(R.id.switchcolor);
        final int color = tv1.getCurrentTextColor();

        swi1.setOnClickListener(new View.OnClickListener() {
            private int count = 0;
            @Override

            public void onClick(View v) {
                Log.d("MainActivity", "click button to change color");
                if(count == 0){
                    tv1.setTextColor(Color.BLUE);
                    tv2.setTextColor(Color.BLUE);
                    count = 1 - count;
                }
                else{
                    tv1.setTextColor(color);
                    tv2.setTextColor(color);
                    count = 1 - count;
                }
            }
        });
    }
}
