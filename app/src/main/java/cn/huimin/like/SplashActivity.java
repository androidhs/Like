package cn.huimin.like;

import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import com.orhanobut.logger.Logger;

import cn.huimin.like.base.BaseActivity;


public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
//        Logger.init()
        init();
    }

    private void init() {
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        int screenWidth = display.getWidth();
        int screenHeigh = display.getHeight();
        Logger.i("屏幕分辨率为:" + screenWidth + "*" + screenHeigh);
    }
}
