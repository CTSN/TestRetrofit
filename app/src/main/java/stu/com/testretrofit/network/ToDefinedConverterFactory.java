package stu.com.testretrofit.network;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import stu.com.testretrofit.bean.Content;
import stu.com.testretrofit.bean.Result;
import stu.com.testretrofit.commons.Constans;
import stu.com.testretrofit.utils.CryptoUtils;
import stu.com.testretrofit.utils.JsonUtils;


/**
 * Created by xmg on 2016/12/12.
 */
public class ToDefinedConverterFactory extends Converter.Factory {

    public static ToDefinedConverterFactory create() {
        return new ToDefinedConverterFactory();
    }

    //    private static final MediaType MEDIA_TYPE = MediaType.parse("text/plain");
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    /**
     * 获取
     *
     * @param type
     * @param annotations
     * @return
     */
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(final Type type, Annotation[] annotations, Retrofit retrofit) {
        return new Converter<ResponseBody, Result<?>>() {
            @Override
            public Result<?> convert(ResponseBody value) throws IOException {
                Result<?> result = JsonUtils.decryptToBean(value.string(), type);
                return result;
            }
        };
    }

    /**
     * 加密发送
     *
     * @param type
     * @param parameterAnnotations
     * @return
     */
    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        if (Content.class.equals(type)) {
            return new Converter<Content, RequestBody>() {
                @Override
                public RequestBody convert(Content value) throws IOException {
                    String cryptoContent = "";
                    try {
                        cryptoContent = CryptoUtils.AesEncrypt(value.getContent(), Constans.SECRET_KEY);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    value.setContent(cryptoContent);
                    String json = JsonUtils.toJson(value);
                    return RequestBody.create(JSON, json);
                }
            };
        }
        return null;
    }
}
