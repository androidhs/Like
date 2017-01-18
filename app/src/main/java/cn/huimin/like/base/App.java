package cn.huimin.like.base;

import android.app.Application;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by it on 2017/1/17.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initLog();
    }

    private void initLog() {
        Logger.init("LIKE").logLevel(LogLevel.FULL);
//              .logLevel(LogLevel.NONE);
    }
}
