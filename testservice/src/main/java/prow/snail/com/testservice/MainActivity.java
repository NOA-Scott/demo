package prow.snail.com.testservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

public class MainActivity extends BaseActivity {

    public final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void handler(Message msg) {

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.binding: {
                Intent intent = new Intent(this, RemoteService.class);
                startService(intent);

                bindService(intent, conn, Context.BIND_AUTO_CREATE);


                Log.e(TAG, "  onClick   ");
                break;
            }
            case R.id.test1: {
                Intent intent = new Intent(this, TestActivity.class);
                startActivity(intent);
                break;
            }
        }
    }

    IMyAidlInterface myAidlInterface;

    private ServiceConnection conn = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myAidlInterface = IMyAidlInterface.Stub.asInterface(service);


            try {
                Log.e(TAG, "number:  " + myAidlInterface.getFileCnt("aaa"));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


}
