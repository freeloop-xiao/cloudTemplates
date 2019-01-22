package com.xiaok.user.common.realm;

import com.xiaok.user.common.auth.UserToken;
import com.xiaok.user.common.dao.TbUserMapper;
import com.xiaok.user.common.entity.TbUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2019-01-21
 * Time: 15:17
 */

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private TbUserMapper tbUserMapper;


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (authenticationToken instanceof UserToken) {
            UserToken token = (UserToken) authenticationToken;
            String account = token.getUsername();
            String appId = token.getAppId();
            TbUser tbUser = tbUserMapper.selectByPhoneAndAppId(account, appId);
            if (tbUser == null) {
                throw new UnknownAccountException();
            }
            String storedPassword = tbUser.getLoginPwd();
            ByteSource solt = ByteSource.Util.bytes(tbUser.getLoginSalt());
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(account, storedPassword, solt, "userRealm");
            return authenticationInfo;
        }
        throw new UnknownAccountException();
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


}
