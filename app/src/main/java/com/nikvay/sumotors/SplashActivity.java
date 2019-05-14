package com.nikvay.sumotors;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.nikvay.sumotors.ui.activity.LoginActivity;
import com.nikvay.sumotors.ui.activity.SlidingActivity;

public class SplashActivity extends AppCompatActivity {

    Animation shake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //=============== hide status bar ===============
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        ImageView iv_splash=findViewById(R.id.iv_splash);
        shake = AnimationUtils.loadAnimation(this, R.anim.shake);
//        shake = AnimationUtils.loadAnimation(this, R.anim.down_from_top);
        iv_splash.startAnimation(shake);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, SlidingActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                finish();
            }
        }, 3000);
    }
}
