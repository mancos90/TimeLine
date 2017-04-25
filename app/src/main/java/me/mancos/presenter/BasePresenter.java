package me.mancos.presenter;

import me.mancos.base.BaseView;

/**
 * Created by mancos on 2017/3/18.
 * 上午9:12
 * TODO:
 */

public interface BasePresenter<T extends BaseView> {
    void attachView(T view);
    void detachView();
}
