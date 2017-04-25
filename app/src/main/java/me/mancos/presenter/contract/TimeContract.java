package me.mancos.presenter.contract;

import android.content.ContentValues;

import java.util.List;

import me.mancos.base.BaseView;
import me.mancos.data.model.TimeModel;
import me.mancos.presenter.BasePresenter;

/**
 * Created by mancos on 2017/3/24.
 * 下午2:46
 * TODO:
 */

public interface TimeContract {

    interface View extends BaseView {
        void showTimeList(List<TimeModel> models);
    }

    interface Presenter extends BasePresenter<TimeContract.View> {
        void setTime(ContentValues values);

        void getTime();
    }
}
