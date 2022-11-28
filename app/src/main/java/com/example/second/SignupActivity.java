package com.example.second;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.bumptech.glide.load.resource.bitmap.Rotate;

public class SignupActivity extends AppCompatActivity {
    ImageView fondo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        fondo=findViewById(R.id.universe);

        girarFondo(fondo);
    }

    private void girarFondo(View view)
    {
        RotateAnimation animation=new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        animation.setDuration(50000);
        animation.setRepeatCount(Animation.INFINITE);
        view.startAnimation(animation);
    }
}