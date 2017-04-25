package me.mancos.data;

import android.content.ContentValues;

import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import me.mancos.data.model.TimeModel;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by mancos on 2017/3/22.
 * 下午3:15
 * TODO:
 */
@Singleton
public class DataManager {

    private static BriteDatabase mBriteDatabase;

    @Inject
    public DataManager(DataOpenHelper dbHelper) {
        getInstance(dbHelper);
    }

    private static BriteDatabase getInstance(DataOpenHelper helper) {
        if (mBriteDatabase == null) {
            mBriteDatabase = new SqlBrite
                    .Builder()
                    .build()
                    .wrapDatabaseHelper(helper, Schedulers.io());
            mBriteDatabase.setLoggingEnabled(true);
        }
        return mBriteDatabase;
    }


    public Observable<List<TimeModel>> queryTimes() {
        return mBriteDatabase
                .createQuery(TimeDb.TimeTable.sTABLE_NAME, "SELECT * FROM "
                        + TimeDb.TimeTable.sTABLE_NAME
                        + " ORDER BY "
                        + TimeDb.TimeTable.sID
                        + " DESC")
                .mapToList(TimeDb.TimeTable.TIME_MAPPER);
    }


    public void setTime(final ContentValues values) {
        BriteDatabase.Transaction transaction = mBriteDatabase.newTransaction();
        try {
            mBriteDatabase.insert(TimeDb.TimeTable.sTABLE_NAME, values);
            transaction.markSuccessful();
        } finally {
            transaction.end();
        }

    }
}
