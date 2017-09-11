package com.example.emon.animationbutton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;


public class MainActivity extends Activity {

    static String KEY_ANIM = "TARGET_ANIM";
    static String Target_Translate = "Translate";
    static String Target_Alpha = "Alpha";
    static String Target_Scale = "Scale";
    static String Target_Rotate = "Rotate";
    String target_op = Target_Translate; //dummy default

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Animation animTranslate = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        final Animation animScale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        final Animation animRotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);

        Button btnTranslate = (Button)findViewById(R.id.translate);
        Button btnAlpha = (Button)findViewById(R.id.alpha);
        Button btnScale = (Button)findViewById(R.id.scale);
        Button btnRotate = (Button)findViewById(R.id.rotate);

        btnTranslate.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                target_op = Target_Translate;
                arg0.startAnimation(animTranslate);
            }});

        btnAlpha.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                target_op = Target_Alpha;
                arg0.startAnimation(animAlpha);
            }});

        btnScale.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                target_op = Target_Scale;
                arg0.startAnimation(animScale);
            }});

        btnRotate.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                target_op = Target_Rotate;
                arg0.startAnimation(animRotate);
            }});

        animTranslate.setAnimationListener(animationListener);
        animAlpha.setAnimationListener(animationListener);
        animScale.setAnimationListener(animationListener);
        animRotate.setAnimationListener(animationListener);
    }

    AnimationListener animationListener = new AnimationListener(){

        @Override
        public void onAnimationStart(Animation animation) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            Intent intent = new Intent(
                    MainActivity.this,
                    SecondActivity.class);
            intent.putExtra(KEY_ANIM, target_op);
            startActivity(intent);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
            // TODO Auto-generated method stub

        }};
}
