package me.mancos.ui.adapter;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.HashMap;
import java.util.List;

import me.mancos.activity.R;
import me.mancos.data.model.TimeModel;

/**
 * Created by mancos on 2017/4/7.
 * 下午2:15
 * TODO:
 */

public class TimeAdapter extends CommonAdapter<TimeModel> {
    private HashMap<Integer, String> date = new HashMap<>();

    public TimeAdapter(Context context, int layoutId, List<TimeModel> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, TimeModel timeModel, int position) {

        if (timeModel != null) {
            Logger.d(position);

            if (putDate(position, timeModel.getCrateTime())) {
                holder.setBackgroundRes(R.id.point, R.drawable.ic_point);
                holder.setVisible(R.id.ll_date_layout,true);
                holder.setText(R.id.year,timeModel.getCrateTime().substring(0,4));
                holder.setText(R.id.date,timeModel.getCrateTime().substring(5,10));
            }else {
                holder.setBackgroundRes(R.id.point, R.drawable.ic_point1);
                holder.setVisible(R.id.ll_date_layout,false);
            }

            holder.setText(R.id.tv_item_name, timeModel.getUpdateTime() + " " + timeModel.getName());
        }
    }

    /**
     * @param key
     * @param value
     * @return 保证同一天只有一个是实心点，有比较好的方式么？
     */
    private boolean putDate(Integer key, String value) {
        if (date.containsKey(key) && date.containsValue(value)) {
            return true;
        } else {
            if (date.containsValue(value)) {
                return false;
            }
            date.put(key, value);
            return true;
        }
    }

}