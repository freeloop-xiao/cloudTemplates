package com.xiaok.user.common.util;

import com.xiaok.common.util.IdWorker;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2019-01-23
 * Time: 16:02
 */
public class IdUtil {
    protected static final IdWorker idWorker = new IdWorker(1);

    public static String generate() {
        try {
            long id = idWorker.nextId();
            return String.valueOf(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
