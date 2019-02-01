package com.xiaok.user.common.session;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;

/**
 * author: xiao
 * date:   2019/2/1
 * desc:
 */
public class UserDefaultSubjectFactory extends DefaultWebSubjectFactory {
    public Subject createSubject(SubjectContext context) {
        //不创建session
        context.setSessionCreationEnabled(false);
        return super.createSubject(context);
    }
}
