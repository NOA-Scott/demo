package prow.snail.com.testservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

/**
 * Created by snail on 16/8/2.
 */
public class RemoteService extends Service {

    public final static String TAG="RemoteService";

    //定义内部类MyRemoteServiceImpl,继承我们的AIDL文件自动生成的内部类，
    //并且实现我们AIDL文件定义的接口方法
    private class MyRemoteServiceImpl extends IMyAidlInterface.Stub {

        @Override
        public int getFileCnt(String path) throws RemoteException {
            Log.e(TAG,path+"      "+10);
            return 10;
        }

        @Override
        public String getData() throws RemoteException {
            return null;
        }
    }

    private MyRemoteServiceImpl remoteService=new MyRemoteServiceImpl();

    @Override
    public IBinder onBind(Intent intent) {
        //返回AIDL实现
        return remoteService;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "  onCreate   ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "  onStartCommand   ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.e(TAG, "  onStart   ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "  onStartCommand   ");
    }
}
