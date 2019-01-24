package com.xiaok.user.common.util;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2019-01-23
 * Time: 14:50
 */
public class PasswordUtil {


    public static String generateSalt(){
        return String.valueOf((int)((Math.random()*9+1)*100000));
    }
}