package prow.snail.com.testservice;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.apkfuns.xprogressdialog.XProgressDialog;

import prow.snail.com.testservice.view.AlertDialog;
import prow.snail.com.testservice.view.MultiDirectionSlidingDrawer;


/**
 * Created by snail on 16/8/3.
 */
public class TestActivity extends BaseActivity {

    XProgressDialog dialog;
    MultiDirectionSlidingDrawer mDrawer;

    @Override
    protected void handler(Message msg) {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        dialog = new XProgressDialog(this, "正在加载..", XProgressDialog.THEME_CIRCLE_PROGRESS);
        mDrawer = (MultiDirectionSlidingDrawer) findViewById( R.id.drawer );
    }


    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog: {

                dialog.show();

                handler.postDelayed(runnable, 5000);

                mDrawer.animateClose();
                break;
            }
            case R.id.AlertDialog:{

                new AlertDialog(TestActivity.this).builder()
                        .setMsg("你现在无法接收到新消息提醒。请到系统-设置-通知中开启消息提醒")
                        .setNegativeButton("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }).show();

                if( !mDrawer.isOpened() )
                    mDrawer.animateOpen();

                break;
            }
            case R.id.AlertDialog1:{

                new AlertDialog(TestActivity.this).builder().setTitle("退出当前账号")
                        .setMsg("再连续登陆15天，就可变身为QQ达人。退出QQ可能会使你现有记录归零，确定退出？")
                        .setPositiveButton("确认退出", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }).setNegativeButton("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();

                break;
            }
        }
    }

    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            dialog.dismiss();
        }
    };

}
