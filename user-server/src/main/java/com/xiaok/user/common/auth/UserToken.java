package com.xiaok.user.common.auth;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2019-01-22
 * Time: 14:48
 */
public class UserToken extends UsernamePasswordToken {
    /**
     * 应用id
     */
    private String appId;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public UserToken(String username, String password, String appId) {
        super(username, password);
        this.appId = appId;
    }


}
