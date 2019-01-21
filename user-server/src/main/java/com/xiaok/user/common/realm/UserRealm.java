package com.xiaok.user.common.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2019-01-21
 * Time: 15:17
 */

public class UserRealm extends AuthorizingRealm{

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        return new SimpleAuthenticationInfo();
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


}
