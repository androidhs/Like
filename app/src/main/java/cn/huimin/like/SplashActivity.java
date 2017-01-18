package cn.huimin.like;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import com.orhanobut.logger.Logger;

import cn.huimin.like.base.BaseActivity;
import cn.huimin.like.login.LoginView;


public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        init();

    }

    private void init() {
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        int screenWidth = display.getWidth();
        int screenHeigh = display.getHeight();
        Logger.i("屏幕分辨率为:" + screenWidth + "*" + screenHeigh);

        cachedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    //初始化数据
                    Thread.sleep(3000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //开启登录窗体
                            startActivity(new Intent(context, LoginView.class));
                            finish();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        this.finish();
    }
}
