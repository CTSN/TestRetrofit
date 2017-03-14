package stu.com.testretrofit.network;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;
import stu.com.testretrofit.bean.Banner;
import stu.com.testretrofit.bean.LoginBean;
import stu.com.testretrofit.bean.Result;

/**
 * Created by xmg on 2016/12/12.
 */

public class NetWorkFactory {

    public static Observable<Result<LoginBean>> login(String username,String pwd)throws Exception{
        Map<String,String> map = new HashMap<>();
        map.put("username",username);
        map.put("pwd",pwd);
        return NetWorkClient.getSnackApi().login(map);
    }
    public static Observable<Result<LoginBean>> loginPostKey(String username,String pwd)throws Exception{
        return NetWorkClient.getSnackApi().loginPostKey(username,pwd);
    }

    public static Observable<Result<LoginBean>> loginPostForm(String username,String pwd)throws Exception{
        return NetWorkClient.getSnackApi().loginPostForm(username,pwd);
    }

    public static Observable<Result<List<Banner>>> getBanner(int kind)throws Exception{
        return NetWorkClient.getSnackApi().getBanner(kind);
    }
}
