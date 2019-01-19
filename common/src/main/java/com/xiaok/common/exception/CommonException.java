package com.xiaok.common.exception;

/**
 * Created with IntelliJ IDEA.
 * Description: 统一异常管理
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2018-09-06
 * Time: 11:31
 */
public class CommonException extends RuntimeException {

    private String code;

    private String msg;

    public CommonException() {
    }

    public CommonException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
