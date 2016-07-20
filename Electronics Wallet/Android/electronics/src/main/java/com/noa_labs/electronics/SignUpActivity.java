package com.noa_labs.electronics;

import android.os.Bundle;
import android.view.View;

/**
 * Created by Scott on 2016/7/19.
 */
public class SignUpActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.protocol:{
                finish();
                break;
            }
            case R.id.register:{
                finish();
                break;
            }
        }
    }
}
