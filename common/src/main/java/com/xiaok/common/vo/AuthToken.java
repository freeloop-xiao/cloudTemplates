package com.xiaok.common.vo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2019-01-19
 * Time: 15:22
 */
public class AuthToken {

    /**
     * 令牌
     */
    private String token;

    /**
     * 有效期
     */
    private String expire;

    /**
     * 刷新token
     */
    private String refreshToken;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
