package me.mancos.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.mancos.app.App;
import me.mancos.data.DataOpenHelper;
import me.mancos.di.ContextLife;

/**
 * Created by mancos on 2017/3/18.
 * 上午10:03
 * TODO:
 */
@Module
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    @ContextLife("Application")
    App provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    DataOpenHelper provideDBHelper(){
        return new DataOpenHelper(application);
    }
}
