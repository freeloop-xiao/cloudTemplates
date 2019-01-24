package com.xiaok.common.util;

import com.xiaok.common.exception.CommonException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2019-01-22
 * Time: 16:48
 */
public class ParamUtil {

    /**
     *
     * @param args
     * @param <T>
     * @throws CommonException
     */
    public static <T> void checkParams(T... args) throws CommonException {
        for (T t : args) {
            if (t == null) {
                throw new CommonException("0001", "参数为空!");
            }
        }
    }

}
