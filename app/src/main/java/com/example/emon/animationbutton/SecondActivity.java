package com.example.emon.animationbutton;


        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.view.ViewTreeObserver.OnGlobalLayoutListener;
        import android.view.animation.Animation;
        import android.view.animation.AnimationUtils;
        import android.widget.Button;

public class SecondActivity extends Activity {

    Animation anim;
    Button anButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String op = intent.getStringExtra(MainActivity.KEY_ANIM);
        if (op.equals(MainActivity.Target_Translate)){
            anim = AnimationUtils.loadAnimation(SecondActivity.this, R.anim.anim_translate);
        }else if (op.equals(MainActivity.Target_Alpha)){
            anim = AnimationUtils.loadAnimation(SecondActivity.this, R.anim.anim_alpha);
        }else if (op.equals(MainActivity.Target_Scale)){
            anim = AnimationUtils.loadAnimation(SecondActivity.this, R.anim.anim_scale);
        }else if (op.equals(MainActivity.Target_Rotate)){
            anim = AnimationUtils.loadAnimation(SecondActivity.this, R.anim.anim_rotate);
        }

        anButton = (Button)findViewById(R.id.anbutton);
        anButton.setText(op);

        anButton.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(){

            @Override
            public void onGlobalLayout() {

                anButton.startAnimation(anim);

                //deprecated in API level 16
                anButton.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                //for API Level >= 16
                //anImage.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }});

        anButton.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                anButton.startAnimation(anim);
            }});
    }

}