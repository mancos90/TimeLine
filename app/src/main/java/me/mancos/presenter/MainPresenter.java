package me.mancos.presenter;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import me.mancos.base.rx.RxPresenter;
import me.mancos.data.DataManager;
import me.mancos.data.model.TimeModel;
import me.mancos.presenter.contract.MainContract;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by mancos on 2017/3/18.
 * 上午10:56
 * TODO:
 */

public class MainPresenter extends RxPresenter<MainContract.View>
        implements MainContract.Presenter {

    private DataManager mDataManager;

    @Inject
    public MainPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void getTimeList() {
        mDataManager.queryTimes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<TimeModel>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("timeModels", e.toString());
                    }

                    @Override
                    public void onNext(List<TimeModel> timeModels) {
                        Log.e("timeModels", timeModels.toString());
                    }
                });

    }
}
