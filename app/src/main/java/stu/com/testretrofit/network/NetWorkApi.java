package stu.com.testretrofit.network;

import java.util.List;
import java.util.Map;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;
import stu.com.testretrofit.bean.Banner;
import stu.com.testretrofit.bean.LoginBean;
import stu.com.testretrofit.bean.Result;

/**
 * Created by xmg on 2016/12/12.
 */

public interface NetWorkApi {
    @POST("/login")
    Observable<Result<LoginBean>> login(@QueryMap Map<String, String> options);

    @POST("/login?")
    Observable<Result<LoginBean>> loginPostKey(  @Query("username") String key1,@Query("pwd") String key2);

    @FormUrlEncoded
    @POST("/login")
    Observable<Result<LoginBean>> loginPostForm(@Field("username") String name,@Field("pwd") String pwd);


    @GET("/banner")
    Observable<Result<List<Banner>>> getBanner(@Query("adKind") int kind); //相当于 http://mall.520it.com/banner?adKind=1
}
