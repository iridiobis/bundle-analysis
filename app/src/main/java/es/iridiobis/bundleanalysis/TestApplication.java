package es.iridiobis.bundleanalysis;

import android.app.Application;
import android.util.Log;


public class TestApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.wtf("Application", "App created");
    }
}
