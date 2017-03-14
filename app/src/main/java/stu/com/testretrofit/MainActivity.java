package stu.com.testretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import stu.com.testretrofit.bean.Banner;
import stu.com.testretrofit.bean.LoginBean;
import stu.com.testretrofit.bean.Result;
import stu.com.testretrofit.network.NetWorkFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_show;
    private Button btn_retrofit,btn_get,btn_post_key,btn_post_form,btn_post_body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_retrofit = (Button) findViewById(R.id.btn_test);
        btn_get = (Button) findViewById(R.id.btn_get);
        btn_post_key = (Button) findViewById(R.id.btn_post_key);
        btn_post_form = (Button) findViewById(R.id.btn_post_form);
        tv_show = (TextView) findViewById(R.id.tv_show);

        btn_retrofit.setOnClickListener(this);
        btn_get.setOnClickListener(this);
        btn_post_key.setOnClickListener(this);
        btn_post_form.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_test:
                postTest();
                break;
            case R.id.btn_get:
                getTest();
                break;
            case R.id.btn_post_key:
                postTestKey();
                break;
            case R.id.btn_post_form:
                postTestForm();
                break;
        }

    }

    private void postTestForm() {
        try {
            NetWorkFactory.loginPostForm("2", "123456")
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<Result<LoginBean>>() {
                        @Override
                        public void call(Result<LoginBean> loginBeanResult) {
                            tv_show.setText("post请求表单形式\n"+loginBeanResult.toString());
                        }
                    }, new Action1<Throwable>() {
                        @Override
                        public void call(Throwable throwable) {
                            Log.i("TAG", "---->" + throwable.getMessage());
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("TAG", "---->" + e.getMessage());
        }
    }

    private void postTestKey() {
        try {
            NetWorkFactory.loginPostKey("2", "123456")
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<Result<LoginBean>>() {
                        @Override
                        public void call(Result<LoginBean> loginBeanResult) {
                            tv_show.setText("post请求key-value形式\n"+loginBeanResult.toString());
                        }
                    }, new Action1<Throwable>() {
                        @Override
                        public void call(Throwable throwable) {
                            Log.i("TAG", "---->" + throwable.getMessage());
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("TAG", "---->" + e.getMessage());
        }
    }

    private void postTest() {
        try {
            NetWorkFactory.login("2", "123456")
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<Result<LoginBean>>() {
                        @Override
                        public void call(Result<LoginBean> loginBeanResult) {
                            tv_show.setText("post请求Map形式\n"+loginBeanResult.toString());
                        }
                    }, new Action1<Throwable>() {
                        @Override
                        public void call(Throwable throwable) {
                            Log.i("TAG", "---->" + throwable.getMessage());
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("TAG", "---->" + e.getMessage());
        }
    }

    public void getTest() {
        try {
            NetWorkFactory.getBanner(1)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<Result<List<Banner>>>() {
                        @Override
                        public void call(Result<List<Banner>> loginBeanResult) {
                            tv_show.setText("get请求\n"+loginBeanResult.toString());
                        }
                    }, new Action1<Throwable>() {
                        @Override
                        public void call(Throwable throwable) {

                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
