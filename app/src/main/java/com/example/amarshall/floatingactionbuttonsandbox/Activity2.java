package com.example.amarshall.floatingactionbuttonsandbox;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class Activity2 extends AppCompatActivity {

    private static final int RC_NEW_DESIGNER_NEWS_LOGIN = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        final ViewGroup container = (ViewGroup) findViewById(R.id.container);

        if (!FabTransform.setup(this, container)) {
            MorphTransform.setup(this, container,
                    ContextCompat.getColor(this, R.color.background_light),
                    getResources().getDimensionPixelSize(R.dimen.dialog_corners));
        }

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity2.this, Activity3.class);

                FabTransform.addExtras(intent,
                        ContextCompat.getColor(Activity2.this, R.color.colorAccent), R.drawable.ic_add_dark);

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Activity2.this, container,
                        getString(R.string.transition_designer_news_login));

                startActivityForResult(intent, RC_NEW_DESIGNER_NEWS_LOGIN, options.toBundle());
            }
        });
    }

    public void dismiss(View view) {
        onBackPressed();
    }
}
