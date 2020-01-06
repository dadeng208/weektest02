package com.bawei.zhangyaojun106.app;

import android.app.Application;

import com.bawei.zhangyaojun106.dao.DaoMaster;
import com.bawei.zhangyaojun106.dao.DaoSession;


/**
 * @author 张耀军
 * @createTime 2020/1/6 10:43
 * @description
 */
public class MyApp extends Application {

    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        initGreenDao();
    }

    private void initGreenDao() {
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(this, "liu.db");
        DaoMaster daoMaster = new DaoMaster(openHelper.getWritableDatabase());
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }
}
