package me.mancos.app;

import android.app.Application;

import me.mancos.di.component.AppComponent;
import me.mancos.di.component.DaggerAppComponent;
import me.mancos.di.module.AppModule;
import me.mancos.utils.ExceptionCrashHandler;
import me.mancos.utils.XLogger;

/**
 * Created by mancos on 2017/3/17.
 * 上午9:52
 * TODO:
 */

public class App extends Application {

    private static App instance;

    public static synchronized App getInstance() {
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        XLogger.isDebug = Constants.sDEBUG;
        ExceptionCrashHandler.getInstance();

    }

    public static AppComponent getAppComponent() {
        return DaggerAppComponent.builder().appModule(new AppModule(instance)).build();
    }
}
