package com.rakib.nfplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        Handler handler = new Handler();
        final Handler handler1 = new Handler();

        findViewById(R.id.imgViewText2)
                .setAlpha(0);
        findViewById(R.id.imgViewLogo)
                .setAlpha(0);
        findViewById(R.id.imgViewText1)
                .setAlpha(0);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                //startActivity(intent);
                //finish();

                YoYo.with(Techniques.RotateIn)
                        .duration(1500)
                        .playOn(findViewById(R.id.imgViewText2));

                YoYo.with(Techniques.FadeInRight)
                        .duration(1500)
                        .playOn(findViewById(R.id.imgViewText2));

                YoYo.with(Techniques.FadeInDown)
                        .duration(1500)
                        .playOn(findViewById(R.id.imgViewLogo));

                YoYo.with(Techniques.FadeInLeft)
                        .duration(1500)
                        .playOn(findViewById(R.id.imgViewText1));
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }, 1500);
            }
        }, 100);


    }
}
