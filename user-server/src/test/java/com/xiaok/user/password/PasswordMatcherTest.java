package com.xiaok.user.password;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2019-01-21
 * Time: 17:56
 */
public class PasswordMatcherTest {

    @Test
    public void md5Test(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));

    }

}
