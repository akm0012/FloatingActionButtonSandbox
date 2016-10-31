package com.example.amarshall.floatingactionbuttonsandbox;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        final ViewGroup container = (ViewGroup) findViewById(R.id.container);


//        if (!FabTransform.setup(this, container)) {
//            MorphTransform.setup(this, container,
//                    ContextCompat.getColor(this, R.color.background_light),
//                    getResources().getDimensionPixelSize(R.dimen.dialog_corners));
//        }

    }
}
