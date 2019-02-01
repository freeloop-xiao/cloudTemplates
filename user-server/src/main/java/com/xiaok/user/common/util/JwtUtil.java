package com.xiaok.user.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:  jwt认证和解析工具类
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2019-01-24
 * Time: 17:51
 */
public class JwtUtil {

    private static final String TOKEN_KEY = "0d3b515e527fd0c148dce9dc884";

    private static final String ALG = "alg";

    private static final String TYP = "typ";

    private static final String ISS = "iss";

    public static final String AUD = "aud";

    public static final String TYPE = "type";

    public static final String USER_ID = "userId";

    public static final String AUTH = "auth";

    public static final String REFRESH = "refresh";

    public static final String APPLY_ID = "applyId";

    public static final String EXPIRE = "24";

    /**
     * 创建token
     *
     * @param userId:用户id
     * @param appId:应用id
     * @param appType:应用类型
     * @param type:token类型(token 和refreshToken)
     * @return
     */
    public static String createToken(String userId, String appId, String type,String applyId) {
        Calendar nowTime = Calendar.getInstance();
        if (AUTH.equals(type)) {
            nowTime.add(Calendar.DATE, 1);
        }else {
            nowTime.add(Calendar.DATE, 3);
        }
        Date expiresDate = nowTime.getTime();

        Map<String, Object> map = new HashMap();
        map.put(ALG, "HS256");
        map.put(TYP, "JWT");
        String token = null;
        try {
            token = JWT.create().withHeader(map)
                    .withClaim(ISS, "Service")
                    .withClaim(AUD, appId)
                    .withClaim(TYPE, type)
                    .withClaim(USER_ID, userId)
                    .withClaim(APPLY_ID, applyId)
                    .withIssuedAt(new Date())
                    .withExpiresAt(expiresDate)
                    .sign(Algorithm.HMAC256(TOKEN_KEY));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }


    /**
     * 验证token
     *
     * @param token
     * @return
     */
    public static DecodedJWT verifyToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_KEY)).build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt;
    }

    /**
     * 获取token属性
     *
     * @param key:属性
     * @param jwt:解密后的token
     * @return
     */
    public static String getJwtParam(String key, DecodedJWT jwt) {
        return (jwt.getClaims().get(key)).asString();
    }

}
