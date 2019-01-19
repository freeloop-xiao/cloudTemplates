package com.xiaok.common.exception;

import com.xiaok.common.vo.ResultMessage;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created with IntelliJ IDEA.
 * Description: 全局异常捕获
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2018-09-06
 * Time: 11:34
 */
@RestControllerAdvice
public class CommonExceptionConfig {

    @ResponseBody
    @ExceptionHandler(value = CommonException.class)
    public ResultMessage<String> repayExceptionHandler(CommonException e) {
        ResultMessage<String> result = new ResultMessage<>();
        result.setCode(e.getCode());
        result.setMsg(e.getMsg());
        return result;
    }
}
