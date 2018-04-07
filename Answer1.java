package com.example.barat.plspls;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.res.Configuration;
import java.util.Locale;

public class Answer1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Locale locale = new Locale("hi_IN");
        Configuration config = getBaseContext().getResources().getConfiguration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        setContentView(R.layout.activity_answer1);

    }
}