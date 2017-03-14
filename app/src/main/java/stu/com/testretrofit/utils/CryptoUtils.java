package stu.com.testretrofit.utils;

import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * 加密处理类
 * Created by ming on 15/11/17.
 */
public class CryptoUtils {
    public static final String DEFAULT_CODING = "utf-8";

    /**
     * Aes加密
     * @param content
     * @param key
     * @return
     * @throws Exception
     */
    public static String AesEncrypt(String content, String key) throws Exception {
        byte[] rawKey = Base64.decode(key.getBytes(DEFAULT_CODING), Base64.DEFAULT);
        SecretKeySpec skc = new SecretKeySpec(rawKey, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(rawKey);// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skc,iv);

        byte[] encrypted = cipher.doFinal(content.getBytes());
        return Base64.encodeToString(encrypted, Base64.DEFAULT);
    }

    /**
     * Aes解密
     * @param content
     * @param key
     * @return
     * @throws Exception
     */
    public static String AesDecrypt(String content, String key) throws Exception {
        byte[] rawKey = Base64.decode(key.getBytes(DEFAULT_CODING), Base64.DEFAULT);
        SecretKeySpec skc = new SecretKeySpec(rawKey, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(rawKey);// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.DECRYPT_MODE, skc,iv);

        byte[] rawContent = Base64.decode(content.getBytes(DEFAULT_CODING), Base64.DEFAULT);
        byte[] encrypted = cipher.doFinal(rawContent);
        return new String(encrypted);
    }
}
