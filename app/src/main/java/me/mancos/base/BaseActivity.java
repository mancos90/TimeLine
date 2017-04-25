package me.mancos.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.mancos.app.App;
import me.mancos.di.component.ActivityCompontent;
import me.mancos.di.component.DaggerActivityCompontent;
import me.mancos.di.module.ActivityModule;
import me.mancos.presenter.BasePresenter;

/**
 * Created by mancos on 2017/3/18.
 * 上午9:11
 * TODO:
 */


public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity
        implements BaseView {

    @Inject
    protected T mPresenter;

    protected Activity mActivity;
    private Unbinder mUnbinder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        mActivity = this;
        mUnbinder = ButterKnife.bind(this);

        initInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        initEventAndData();
    }

    protected ActivityCompontent getActivityComponent() {
        return DaggerActivityCompontent.builder()
                .appComponent(App.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }


    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }

    protected abstract void initInject();

    protected abstract int setLayout();

    protected abstract void initEventAndData();

}
