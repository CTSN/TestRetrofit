package stu.com.testretrofit.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import stu.com.testretrofit.commons.Constans;

/**
 * Created by xmg on 2016/12/12.
 */

public class NetWorkClient {
    private static NetWorkApi netWorkApi;

    public NetWorkClient(){

    }

    public void init(){
        if (netWorkApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    //添加基地址
                    .baseUrl(Constans.BASE_URL)
                    //添加RxJava回调方式
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    //添加一个Gson转换工厂
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            netWorkApi = retrofit.create(NetWorkApi.class);
        }
    }


    public static NetWorkApi getSnackApi() {
        return netWorkApi;
    }
}
