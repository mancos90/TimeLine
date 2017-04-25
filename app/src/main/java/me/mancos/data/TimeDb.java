package me.mancos.data;

import android.database.Cursor;

import me.mancos.data.model.TimeModel;
import rx.functions.Func1;

/**
 * Created by mancos on 2017/3/24.
 * 下午5:08
 * TODO:
 */

public class TimeDb {
    public TimeDb() {

    }

    public static abstract class TimeTable {
        //表名


        public static final String sTABLE_NAME = "time";
        public static final String sID = "_id";
        public static final String sNAME = "NAME";
        public static final String sCREATE_TIME = "CREATE_TIME";
        public static final String sUPDATE_TIME = "UPDATE_TIME";
        public static final String sSTATE = "STATE";
        public static final String sKEEP_TIME = "KEEP_TIME";

        public static final String sCREATE =
                "CREATE TABLE IF NOT EXISTS " +
                        sTABLE_NAME + "(" +
                        sID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        sNAME + "," +
                        sUPDATE_TIME + "," +
                        sCREATE_TIME + "," +
                        sKEEP_TIME + "," +
                        sSTATE + " )";

        public static TimeModel parseCursor(Cursor cursor) {
            TimeModel model = new TimeModel();
            model.setId(cursor.getLong(cursor.getColumnIndexOrThrow(sID)));
            model.setCrateTime(cursor.getString(cursor.getColumnIndexOrThrow(sCREATE_TIME)));
            model.setKeepTime(cursor.getInt(cursor.getColumnIndexOrThrow(sKEEP_TIME)));
            model.setName(cursor.getString(cursor.getColumnIndexOrThrow(sNAME)));
            model.setState(cursor.getInt(cursor.getColumnIndexOrThrow(sSTATE)));
            model.setUpdateTime(cursor.getString(cursor.getColumnIndexOrThrow(sUPDATE_TIME)));
            return model;
        }

        static Func1<Cursor, TimeModel> TIME_MAPPER = new Func1<Cursor, TimeModel>() {
            @Override
            public TimeModel call(Cursor cursor) {
                return parseCursor(cursor);
            }
        };




    }
}
