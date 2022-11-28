package com.example.second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        openApp();
        ImageView clock = findViewById(R.id.logosplash);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.rotate_1);
        Animation myanim2 = AnimationUtils.loadAnimation(this, R.anim.rotate_2);
        Animation myanim3 = AnimationUtils.loadAnimation(this, R.anim.rotate_3);
        clock.startAnimation(myanim);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                clock.startAnimation(myanim2);
            }
        }, 1000);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                clock.startAnimation(myanim3);
            }
        }, 2100);

        ImageView mUniverse = findViewById(R.id.backView);

        Glide.with(this)
                .load("https://images.unsplash.com/photo-1516339901601-2e1b62dc0c45?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=371&q=80")
//                .load("https://images.unsplash.com/photo-1594723413117-a07053dd8fe8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80")
//                .load(R.drawable.hojas)
                .transition(DrawableTransitionOptions.withCrossFade(100))
                .centerCrop()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_200)))
//                .circleCrop()
                .into(mUniverse);
}


    private void openApp() {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash
                        .this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        }, 5000);
    }
}
