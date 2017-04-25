package me.mancos.di.module;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import me.mancos.di.ActivityScope;

/**
 * Created by mancos on 2017/3/18.
 * 上午9:44
 * TODO:
 */

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }
}
