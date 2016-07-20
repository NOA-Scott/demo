package com.noa_labs.electronics;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by Scott on 2016/7/15.
 */
public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,FindWalletActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }
        },3*1000);
    }
}