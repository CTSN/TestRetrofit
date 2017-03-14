package stu.com.testretrofit.bean;

import java.io.Serializable;

/**
 * Created by xmg on 2016/12/12.
 */
public class LoginBean implements Serializable{

    private String id;
    private String userName;
    private String userIcon;
    private String waitPayCount;
    private String waitReceiveCount;
    private String userLevel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getWaitPayCount() {
        return waitPayCount;
    }

    public void setWaitPayCount(String waitPayCount) {
        this.waitPayCount = waitPayCount;
    }

    public String getWaitReceiveCount() {
        return waitReceiveCount;
    }

    public void setWaitReceiveCount(String waitReceiveCount) {
        this.waitReceiveCount = waitReceiveCount;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", userIcon='" + userIcon + '\'' +
                ", waitPayCount='" + waitPayCount + '\'' +
                ", waitReceiveCount='" + waitReceiveCount + '\'' +
                ", userLevel='" + userLevel + '\'' +
                '}';
    }
}
