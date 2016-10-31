package com.example.amarshall.floatingactionbuttonsandbox;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.gordonwong.materialsheetfab.MaterialSheetFab;

public class MainActivity extends AppCompatActivity {

    public static int RC_NEW_DESIGNER_NEWS_LOGIN = 5;

    MaterialSheetFab materialSheetFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final MyFAB fab = (MyFAB) findViewById(R.id.fab);

        View sheetView = findViewById(R.id.fab_sheet);
        View overlay = findViewById(R.id.overlay);
        int sheetColor = getResources().getColor(R.color.colorAccent);
        int fabColor = getResources().getColor(R.color.colorAccent);

        // Initialize material sheet FAB
        materialSheetFab = new MaterialSheetFab<>(fab, sheetView, overlay,
                sheetColor, fabColor);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (materialSheetFab.isSheetVisible()) {
//                    materialSheetFab.hideSheet();
//                } else {
//                    materialSheetFab.showSheet();
//                }
                Intent intent = new Intent(MainActivity.this, Activity2.class);

                FabTransform.addExtras(intent,
                        ContextCompat.getColor(MainActivity.this, R.color.colorAccent), R.drawable.ic_add_dark);

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, fab,
                        getString(R.string.transition_designer_news_login));

                startActivityForResult(intent, RC_NEW_DESIGNER_NEWS_LOGIN, options.toBundle());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
