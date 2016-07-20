package com.noa_labs.electronics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Scott on 2016/7/15.
 */
public class SignInActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in: {
                Intent intent=new Intent(this,HomeActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.new_user: {
                Intent intent=new Intent(this,SignUpActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.forgot_pass: {
                Intent intent=new Intent(this,ForgotPassActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
