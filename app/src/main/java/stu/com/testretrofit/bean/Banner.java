package stu.com.testretrofit.bean;

import java.io.Serializable;

/**
 * Created by xmg on 2016/12/12.
 */

public class Banner implements Serializable{

    /**
     * id : 广告id
     * type : 跳转类型（1跳转到网页，2跳转到商品详情，3跳转到分类去）
     * adUrl : 图片路径
     * webUrl : 如果是跳转网页类型，则返回网页地址
     * adKind : 广告类型（1为导航banner，2为广告banner）
     */

    private String id;
    private String type;
    private String adUrl;
    private String webUrl;
    private String adKind;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getAdKind() {
        return adKind;
    }

    public void setAdKind(String adKind) {
        this.adKind = adKind;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", adUrl='" + adUrl + '\'' +
                ", webUrl='" + webUrl + '\'' +
                ", adKind='" + adKind + '\'' +
                '}';
    }
}
