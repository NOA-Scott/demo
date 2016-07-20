package com.noa_labs.electronics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Scott on 2016/7/15.
 */
public class HomeActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.find_wallet: {
                Intent intent = new Intent(this, FindWalletActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
