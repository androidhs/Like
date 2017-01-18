package cn.huimin.like.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BaseActivity extends AppCompatActivity {
    public Context context;
    //public sp
    private SharedPreferences sp ;
    public SharedPreferences.Editor editor;

    //
    public ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        App app = (App) getApplication();
        context = app;
        sp = getSharedPreferences("temp",Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    public void showToast(String msg){
        if(!TextUtils.isEmpty(msg)){
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
        }
    }
    //释放内存
    public void clear(){
//        editor.commit();
    }
}
