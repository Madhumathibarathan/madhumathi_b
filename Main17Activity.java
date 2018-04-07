package com.example.barat.plspls;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;

import ai.api.AIListener;
import ai.api.android.AIConfiguration;
import ai.api.android.AIService;
import ai.api.model.AIError;
import ai.api.model.AIResponse;
import ai.api.model.Result;

public class Main17Activity extends AppCompatActivity implements AIListener, TextToSpeech.OnInitListener {
    AIService aiService;
    TextView t;
    TextToSpeech tts;
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main17);
        tts = new TextToSpeech(this, Main17Activity.this);
        tts.setLanguage(Locale.US);
        t = (TextView) findViewById(R.id.textView);
        ll = (LinearLayout) findViewById(R.id.linear2);
        t.setText("Hello");
        int permission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECORD_AUDIO);

        if (permission != PackageManager.PERMISSION_GRANTED) {

            makeRequest();
        }
        final AIConfiguration config = new AIConfiguration("7d025a9b7a004ca183fdffd3347c269c",
                AIConfiguration.SupportedLanguages.English,
                AIConfiguration.RecognitionEngine.System);
        aiService = AIService.getService(this, config);
        aiService.setListener(this);
    }

    protected void makeRequest() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.RECORD_AUDIO},
                101);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 101: {

                if (grantResults.length == 0
                        || grantResults[0] !=
                        PackageManager.PERMISSION_GRANTED) {


                } else {

                }
                return;
            }
        }
    }


    public void buttonClicked(View view) {
        aiService.startListening();
    }

    @Override
    public void onResult(AIResponse result) {

        Log.d("anu", result.toString());
        Result result1 = result.getResult();
        t.setText(result1.getAction().toString());
        String text = result1.getAction().toString();
        tts.speak(text, TextToSpeech.QUEUE_ADD, null);

    }

    @Override
    public void onError(AIError error) {
        t.setText(error.toString());

    }

    @Override
    public void onAudioLevel(float level) {

    }

    @Override
    public void onListeningStarted() {

    }

    @Override
    public void onListeningCanceled() {

    }

    @Override
    public void onListeningFinished() {

    }

    @Override
    public void onInit(int status) {

    }
}
