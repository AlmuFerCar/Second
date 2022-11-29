package com.example.second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class LoginActivity extends AppCompatActivity {
//animaciones en al anim
//glide para cargar imagenes de fondo y el logo
//iniciar sign up y main con el onclick del xml de cada boton
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //implements and starts animation
        //objeto thunder sobre el cual aplicaremos la animacion
        ImageView thunder=findViewById(R.id.reloj);
        // creamos un objeto animacion que incorpora la animacion descrita en el xml y con el método
        //startAnimation lo aplicamos al imageView del logo
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.fadein_rotate);
        thunder.startAnimation(myanim);
        /* textosingup = findViewById(R.id.signup);*/

      /*  Intent intent = getIntent();
       textosingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {iniciarSignUp();}
        });*/

        //  Glide for loading girls
        ImageView mPlanet = findViewById(R.id.planet);
        ImageView mlogo = findViewById(R.id.reloj);

        Glide.with(this)
//              .load("https://images.unsplash.com/photo-1565214975484-3cfa9e56f914?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1482&q=80")
//                .placeholder(R.drawable.girl)
//                firebase para cargar imagenes desde la nube con glide
                .load(R.drawable.planet)

                .transition(DrawableTransitionOptions.withCrossFade(1000))
//                .centerCrop()
//                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.purple_200)))
//                .circleCrop()
                .into(mPlanet);

        Glide.with(this)
                //.load("https://images.unsplash.com/photo-1512849934327-1cf5bf8a5ccc?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80")
                .load(R.drawable.reloj)
                // .circleCrop()
                .into(mlogo);
    }

    public void iniciarSignup(View v) {
        Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); /*PARA QUE NO SE PUEDA IR HACIA ATRAS*/
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK); /*PARA QUE NO SE PUEDA IR HACIA ATRAS*/
        startActivity(intent);}

    public void iniciarMain(View v)
    {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); /*PARA QUE NO SE PUEDA IR HACIA ATRAS*/
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK); /*PARA QUE NO SE PUEDA IR HACIA ATRAS*/
        startActivity(intent);
    }


}

