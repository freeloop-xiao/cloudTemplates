package com.xiaok.user.common.session;

import java.util.Date;
import java.util.Map;

/**
 * author: xiao
 * date:   2019/1/31
 * desc:
 */
public class UserSession {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 主机ip
     */
    private String host;

    /**
     * 认证tokenId
     */
    private String tokenId;

    /**
     * 刷新tokenId
     */
    private String refreshTokenId;

    /**
     * 签发时间
     */
    private Date generateTime;

    /**
     * 有效期单位小时
     */
    private Long expire;

    public UserSession() {
    }

    public UserSession(String userId, String tokenId, String refreshTokenId, Date generateTime, long expire) {
        this.userId = userId;
        this.tokenId = tokenId;
        this.refreshTokenId = refreshTokenId;
        this.generateTime = generateTime;
        this.expire = expire;
    }

    private Map<Object, Object> attributes;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getRefreshTokenId() {
        return refreshTokenId;
    }

    public void setRefreshTokenId(String refreshTokenId) {
        this.refreshTokenId = refreshTokenId;
    }

    public void setExpire(Long expire) {
        this.expire = expire;
    }

    public Date getGenerateTime() {
        return generateTime;
    }

    public void setGenerateTime(Date generateTime) {
        this.generateTime = generateTime;
    }

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    public Map<Object, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<Object, Object> attributes) {
        this.attributes = attributes;
    }
}
