package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView logo;
    private TextView title;

    Animation top,bottom;
    public static int SPLASH_SCREEN = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        logo=findViewById(R.id.logo);
        title=findViewById(R.id.title);


        top= AnimationUtils.loadAnimation(this, R.anim.top);
        bottom= AnimationUtils.loadAnimation(this, R.anim.bottom);

        logo.setAnimation(top);
        title.setAnimation(bottom);


        //int splash_screen=4300;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}