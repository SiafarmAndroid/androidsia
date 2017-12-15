package com.siafarm.splash;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.siafarm.R;
import com.siafarm.homeactivity.HomeActivity;
import com.siafarm.utils.Constants;


public class Splashscreenactivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreen);
        SharedPreferences mAppPref = getSharedPreferences(Constants.FirstTime, 0);
        boolean isFirstTime = mAppPref.getBoolean(Constants.FirstTime, true);


        if (isFirstTime) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    moveNextPage(HomeActivity.class);
                }
            }, 2000);
        }
    }

    private void moveNextPage(Class<? extends Activity> class1) {
        startActivity(new Intent(this, class1));
        finish();
    }

}


