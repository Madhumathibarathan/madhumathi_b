package com.example.barat.plspls;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity {
    public Button but;
void init() {
    but = (Button) findViewById(R.id.button5);
    but.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent toy = new Intent(Main4Activity.this, MmActivity.class);
            startActivity(toy);
        }
    });
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        init();
    }
}
