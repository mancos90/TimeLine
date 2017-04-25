package me.mancos.presenter;

import android.content.ContentValues;

import java.util.List;

import javax.inject.Inject;

import me.mancos.base.rx.RxPresenter;
import me.mancos.data.DataManager;
import me.mancos.data.model.TimeModel;
import me.mancos.presenter.contract.TimeContract;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by mancos on 2017/3/24.
 * 下午2:45
 * TODO:
 */

public class TimePresenter extends RxPresenter<TimeContract.View>
        implements TimeContract.Presenter {

    private DataManager mDataManager;

    @Inject
    public TimePresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void setTime(ContentValues values) {
        mDataManager.setTime(values);
    }


    @Override
    public void getTime() {
        Subscription subscription = mDataManager.queryTimes()
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<TimeModel>>() {
                    @Override
                    public void call(List<TimeModel> timeModels) {

                        mView.showTimeList(timeModels);





                    }
                });
        addSubscrebe(subscription);

    }


}
