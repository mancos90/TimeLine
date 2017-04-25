package me.mancos.di.component;

import android.app.Activity;

import dagger.Component;
import me.mancos.di.ActivityScope;
import me.mancos.di.module.ActivityModule;
import me.mancos.ui.activity.MainActivity;
import me.mancos.ui.activity.TimeActivity;

/**
 * Created by mancos on 2017/3/18.
 * 上午9:51
 * TODO:
 */
@ActivityScope//自定义Scope来组织Component的作用域
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityCompontent {

    Activity getActivity();

    void inject(MainActivity mainActivity);

    void inject(TimeActivity timeActivity);
}
