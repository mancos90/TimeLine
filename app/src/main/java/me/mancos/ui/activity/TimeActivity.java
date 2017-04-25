package me.mancos.ui.activity;

import android.content.ContentValues;
import android.widget.Button;

import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;
import me.mancos.activity.R;
import me.mancos.base.BaseActivity;
import me.mancos.data.model.TimeModel;
import me.mancos.presenter.TimePresenter;
import me.mancos.utils.DateUtil;
import me.mancos.utils.XToast;

/**
 * Created by mancos on 2017/3/17.
 * 上午11:32
 * TODO:
 */

public class TimeActivity extends BaseActivity<TimePresenter> {

    @BindView(R.id.btn_add)
    Button mButton;


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_clock;
    }

    @Override
    protected void initEventAndData() {
    }

    @OnClick(R.id.btn_add)
    void add() {
        XToast.showToast("!!!");
        ContentValues values = new ContentValues();
        values.put(TimeModel.sCREATE_TIME, DateUtil.dateToString(new Date(),DateUtil.LONG_DATE_FORMAT2));
        values.put(TimeModel.sNAME, "测试");
        values.put(TimeModel.sKEEP_TIME, 0);
        values.put(TimeModel.sSTATE, 0);
        values.put(TimeModel.sUPDATE_TIME, DateUtil.dateToString(new Date(),DateUtil.FORMAT_TWO));
        mPresenter.setTime(values);
    }
}
