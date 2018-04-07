package com.example.barat.plspls;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MmmActivity extends AppCompatActivity {
    public Button b1;
    public Button b2;
    public Button b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mmm);
        init();


    }
    public void init() {
        b1 = (Button)findViewById(R.id.button1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy = new Intent(MmmActivity.this,Answer1.class);
                startActivity(toy);
            }
        });

        b2 = (Button)findViewById(R.id.button2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy = new Intent(MmmActivity.this,Answer2.class);
                startActivity(toy);
            }
        });

        b3 = (Button)findViewById(R.id.button3);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy = new Intent(MmmActivity.this,Answer3.class);
                startActivity(toy);
            }
        });


    }




}