package com.example.barat.plspls;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MmActivity extends AppCompatActivity {

    public Button b;
    public Button bb;
    public Button bbb;
    public Button ved;



    public void init() {
        b = (Button)findViewById(R.id.buttonp);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy = new Intent(MmActivity.this,MmmActivity.class);
                startActivity(toy);
            }
        });
        bb = (Button)findViewById(R.id.button3);

        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy = new Intent(MmActivity.this,Main17Activity.class);
                startActivity(toy);
            }
        });
        bbb = (Button)findViewById(R.id.button7);

        bbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy = new Intent(MmActivity.this,LevelsActivity.class);
                startActivity(toy);
            }
        });
        ved = (Button)findViewById(R.id.button4);
        ved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy = new Intent(MmActivity.this,Main7Activity.class);
                startActivity(toy);
            }
        });

            }



    /*public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button4:
                Intent toy = new Intent(MainActivity.this,MmActivity.class);
                startActivity(toy);
                break;


            case R.id.sign_in_button:
                signIn();
                break;
            case R.id.signOutButton:
                signOut();
                break;

        }
    }*/




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mm);

        init();
    }
}

