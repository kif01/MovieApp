package home.movieapp;

import android.app.Application;
import android.content.Context;

/**
 * Created by Khalil on 6/12/2016.
 */
public class MyApplication extends Application {

    private static MyApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance=this;
    }


    public static MyApplication getsInstance(){
        return sInstance;

    }

    public static Context getAppContext(){
        return sInstance.getApplicationContext();
    }
}
