package com.example.amarshall.floatingactionbuttonsandbox;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class Activity3 extends AppCompatActivity {

    View container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        if (getIntent().getBooleanExtra("fromFAB", false)) {

            if (!FabTransform.setup(this, container)) {
                MorphTransform.setup(this, container,
                        ContextCompat.getColor(this, R.color.background_light),
                        getResources().getDimensionPixelSize(R.dimen.dialog_corners));
            }

        }



        container = findViewById(R.id.container);

        findViewById(R.id.down).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float t = determineHeightOfScreen();

                container.animate()
                        .translationY(t)
                        .setDuration(300)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                finish();
                                overridePendingTransition(R.anim.fade_out, R.anim.fade_out);
                            }
                        });

            }
        });

        findViewById(R.id.exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float t = determineHeightOfScreen();

                container.animate()
                        .translationY(-t)
                        .setDuration(300)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                finish();
                                overridePendingTransition(R.anim.fade_out, R.anim.fade_out);
                            }
                        });

//                finish();
            }
        });

    }

    private float determineHeightOfScreen() {
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        Point size = new Point();
        display.getSize(size);
        return size.y;
    }

    @Override
    public void onBackPressed() {
//    super.onBackPressed();
        float t = determineHeightOfScreen();

        container.animate()
                .translationY(t)
                .setDuration(300)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        finish();
                        overridePendingTransition(R.anim.fade_out, R.anim.fade_out);
                    }
                });

    }

    public void dismiss(View view) {
        onBackPressed();
    }
}
