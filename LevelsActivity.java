package com.example.barat.plspls;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelsActivity extends AppCompatActivity {
    Button b;
    Button b2;
    Button b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        init();
    }
    void init()
    {

        Button b= (Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LevelsActivity.this,SearchActivity.class);
                startActivity(i);
            }
        });
        Button b2=(Button)findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii=new Intent(LevelsActivity.this,SearchActivity.class);
                startActivity(ii);
            }
        });
        Button b3=(Button)findViewById(R.id.button3);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iii=new Intent(LevelsActivity.this,SearchActivity.class);
                startActivity(iii);
            }
        });


    }
}
