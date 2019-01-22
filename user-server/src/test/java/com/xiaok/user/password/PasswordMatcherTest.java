package com.xiaok.user.password;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
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
    public void matcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));
        UsernamePasswordToken token = new UsernamePasswordToken("xiaok", "123456");
        // token返回的是一个数组,将char类型转化为String类型
        //这个是web前台传递过来的值
        //这个密码的比对是通过Shiro自己给我们完成的
        //密码是通过AuthenticatingRealm.getCredentialsMatcher 的方式来进行比对的
        String pswDate = new String(token.getPassword());
        //第一个参数：用户名/用户对象
        String username =token.getUsername();
        //第二个参数：用户的密码
        String password = new String(token.getPassword());
        //第三个参数：盐值(这个盐是 username)
        ByteSource solt = ByteSource.Util.bytes(username);
        //第四个参数：获取这个Realm的信息
        String realmName = token.getUsername();
        String storePass = Hex.encodeToString(Base64.decode("Y816HOAez65gB/GydPxQqg=="));
        System.out.println("storePass:" + storePass);
        //他们拿到密码web的密码，同数据库获取到的密码进行比对操作
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, storePass, solt,realmName);
        boolean flag = hashedCredentialsMatcher.doCredentialsMatch(token, authenticationInfo);
        System.out.println("结果：" + flag);
    }

    @Test
    public void md5Test() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));
    }

    @Test
    public void center() {
        String hashAlgorithmName = "MD5";//加密方式
        Object crdentials = "123456";//密码原值
        Object salt = "xiaok";//盐值
        int hashIterations = 2;//加密1024次
        SimpleHash result = new SimpleHash(hashAlgorithmName, crdentials, salt, hashIterations);
        System.out.println(result);
        SimpleHash result1 = new SimpleHash(hashAlgorithmName, crdentials, salt, hashIterations);
        System.out.println(result1.toBase64());
        SimpleHash result2 = new SimpleHash(hashAlgorithmName, crdentials, salt, hashIterations);
        byte[] deocdes = Base64.decode("Y816HOAez65gB/GydPxQqg==");
        System.out.println(Hex.encodeToString(deocdes));
    }


}
