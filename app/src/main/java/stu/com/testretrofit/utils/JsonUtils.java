package stu.com.testretrofit.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.lang.reflect.Type;
import java.util.List;

import stu.com.testretrofit.commons.Constans;

/**
 * json数据处理类
 * Created by ming on 15/8/25.
 */
public class JsonUtils {


    /**
     * 解密数据转化成类对象
     *
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T decryptToBean(byte[] json, Type type) {
        T obj = null;
        try {
            String data = new String(json, "UTF-8");
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(data).getAsJsonObject();
            if (jsonObject.has("content")) {
                String EncContent = jsonObject.get("content").toString();
                String decContent = CryptoUtils.AesDecrypt(EncContent, Constans.SECRET_KEY);
                JsonElement element = parser.parse(decContent);
                jsonObject.add("content", element);
            }
            Gson gson = new Gson();
            obj = gson.fromJson(jsonObject.toString(), type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * 解密数据转化成类对象
     *
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T decryptToBean(String json, Type type) {
        T obj = null;
        try {
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(json).getAsJsonObject();
            if (jsonObject.has("content")) {
                String EncContent = jsonObject.get("content").toString();
                String decContent = CryptoUtils.AesDecrypt(EncContent, Constans.SECRET_KEY);
                JsonElement element = parser.parse(decContent);
                jsonObject.add("content", element);
            }
            Gson gson = new Gson();
            obj = gson.fromJson(jsonObject.toString(), type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static <T> T toBean(byte[] json, Class<T> type) {
        T obj = null;
        try {
            String info = new String(json, "UTF-8");

            Gson gson = new Gson();
            obj = gson.fromJson(info, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static <T> T toBean(byte[] json, Type type) {
        T obj = null;
        try {
            String info = new String(json, "UTF-8");
            Gson gson = new Gson();
            obj = gson.fromJson(info, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static <T> T toBean(String json, Type type) {
        T obj = null;
        Gson gson = new Gson();
        obj = gson.fromJson(json, type);
        return obj;
    }

    public static String toJson(Object object) {
        Gson gson = new Gson();
        String result = gson.toJson(object);
        return result;
    }

    /**
     * 通用Json转为List
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> List<T> toList(String json, Type type){
        Gson gson = new Gson();
        List<T> list = gson.fromJson(json, type);
        return list;
    }
}
