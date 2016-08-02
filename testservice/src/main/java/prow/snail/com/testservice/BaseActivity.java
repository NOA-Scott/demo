package prow.snail.com.testservice;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * Created by snail on 16/8/2.
 */
public abstract class BaseActivity extends Activity{
    UIHandler handler = new UIHandler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHandler();
    }

    class UIHandler extends Handler {
        private IHandler handler;//回调接口，消息传递给注册者

        public UIHandler(Looper looper) {
            super(looper);
        }

        public void setHandler(IHandler handler) {
            this.handler = handler;
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (handler != null) {
                handler.handleMessage(msg);//有消息，就传递
            }
        }
    }

    //让子类处理消息
    protected abstract void handler(Message msg);

    public interface IHandler {
        void handleMessage(Message msg);
    }

    private void setHandler() {
        handler.setHandler(new IHandler() {
            public void handleMessage(Message msg) {
                handler(msg);//有消息就提交给子类实现的方法
            }
        });
    }


    Handler msgHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);



            Message netmsgmobile = handler.obtainMessage();
            netmsgmobile.what =100;
            handler.sendMessage(netmsgmobile);
        }
    };
}
