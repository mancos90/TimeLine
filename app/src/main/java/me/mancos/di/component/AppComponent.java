package me.mancos.di.component;

import javax.inject.Singleton;

import dagger.Component;
import me.mancos.app.App;
import me.mancos.data.DataOpenHelper;
import me.mancos.data.DataManager;
import me.mancos.di.ContextLife;
import me.mancos.di.module.AppModule;

/**
 * Created by mancos on 2017/3/18.
 * 上午10:05
 * TODO:
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    @ContextLife("Application")
    App getContext();

    DataOpenHelper dbHelper();

    DataManager dataManager();
}
