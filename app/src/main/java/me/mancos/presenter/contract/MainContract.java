package me.mancos.presenter.contract;

import me.mancos.base.BaseView;
import me.mancos.presenter.BasePresenter;

/**
 * Created by mancos on 2017/3/18.
 * 上午10:43
 * TODO:
 */

public interface MainContract {
    interface View extends BaseView {
        void showTimeList();
    }

    interface Presenter extends BasePresenter<View> {
        void getTimeList();
    }
}
