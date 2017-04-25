package me.mancos.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import javax.inject.Inject;

/**
 * Created by mancos on 2017/3/17.
 * 下午2:11
 * TODO:
 */

public class DataOpenHelper extends SQLiteOpenHelper {

    private static final String sDBNAME = "time.db";
    private static final int CURRENTVERSION = 1;




    @Inject
    public DataOpenHelper(Context context) {
        super(context, sDBNAME, null, CURRENTVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TimeDb.TimeTable.sCREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
