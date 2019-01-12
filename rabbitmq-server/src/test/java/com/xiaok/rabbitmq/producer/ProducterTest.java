package com.xiaok.rabbitmq.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2019-01-03
 * Time: 13:56
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProducterTest {

    @Autowired
    private Producter producter;

    @Test
    public void sendMsg() {

        producter.sendMsg("queue.name","queue.name","1","test");
        try {
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}