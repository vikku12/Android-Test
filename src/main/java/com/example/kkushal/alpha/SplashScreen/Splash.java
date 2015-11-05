package com.example.kkushal.alpha.SplashScreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import com.example.kkushal.alpha.MainActivity;
import com.example.ui.R;

public class Splash extends Activity {

    private ProgressBar mProgressBar;
    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH =1800;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);
    mProgressBar=(ProgressBar)findViewById(R.id.progress_bar);
        mProgressBar.setVisibility(View.VISIBLE);
        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Splash.this,MainActivity.class);
                Splash.this.startActivity(mainIntent);
                Splash.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}