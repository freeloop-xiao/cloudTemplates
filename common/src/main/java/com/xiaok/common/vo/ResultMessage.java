package com.xiaok.common.vo;

/**
 * Created with IntelliJ IDEA.
 * Description: controller 返回消息
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2018-09-03
 * Time: 16:18
 */
public class ResultMessage<T> {


    private String code;



    private String msg;

    private T data;

    public ResultMessage(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultMessage() {
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}