package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    MediaPlayer mediaPlayer;
    private Button button;
    ImageView jaenImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Image View
        jaenImg = findViewById(R.id.imageView);
        //Button Jaen Pogi
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMedia();
                jaenPogi();
            }
        });
        //Button Jaen Happy
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMedia();
                jaenHappy();
            }
        });
        //Button Jaen Mad
        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMedia();
                jaenMad();
            }
        });
    }

    private void openMedia() {
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(this, R.raw.vineboom);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stopPlayer();
                }
            });
        mediaPlayer.start();
    }
    private void jaenPogi() {
        jaenImg.setImageResource(R.drawable.jaenpogi);
        Toast.makeText(this, "POGI MO SIZT", Toast.LENGTH_SHORT).show();
    }
    private void jaenHappy() {
        jaenImg.setImageResource(R.drawable.jaenhappy);
        Toast.makeText(this, "JAEN HAPPY OMYY", Toast.LENGTH_SHORT).show();
    }
    private void jaenMad() {
        jaenImg.setImageResource(R.drawable.jaenmad);
        Toast.makeText(this, "WAG KA MADZZ DZAE", Toast.LENGTH_SHORT).show();
    }
    private void stopPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}

