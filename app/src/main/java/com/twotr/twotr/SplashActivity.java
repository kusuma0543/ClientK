package com.twotr.twotr;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

public class SplashActivity extends AppCompatActivity {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        videoView = findViewById(R.id.splash_video);

        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splash_anim);
        videoView.setVideoURI(video);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                startNextActivity();
            }
        });

        videoView.start();

    }

    private void startNextActivity() {
        if (isFinishing())
            return;
        this.startActivity(new Intent(SplashActivity.this, MainActivity.class));
        this.overridePendingTransition(0, 0);
        finish();
    }



}
