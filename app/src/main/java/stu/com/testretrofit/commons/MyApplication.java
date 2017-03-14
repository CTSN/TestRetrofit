package stu.com.testretrofit.commons;

import android.app.Application;

import stu.com.testretrofit.network.NetWorkClient;

/**
 * Created by xmg on 2016/12/12.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NetWorkClient netWorkClient = new NetWorkClient();
        netWorkClient.init();
    }
}
