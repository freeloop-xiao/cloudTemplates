package com.xiaok.common.log;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2019-01-18
 * Time: 20:07
 */
public class LogRecord<T> {

    /**
     * 日志记录时间
     */
    private Date dateTime;

    /**
     * 日志主题
     */
    private String topic;

    /**
     * 日志类型
     */
    private String type;

    /**
     * 日志数据
     */
    private T log;

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public T getLog() {
        return log;
    }

    public void setLog(T log) {
        this.log = log;
    }
}
