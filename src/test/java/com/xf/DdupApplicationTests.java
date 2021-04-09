package com.xf;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeoutException;

@SpringBootTest
class DdupApplicationTests {

    protected Logger log = LoggerFactory.getLogger(this.getClass());
    private Long time;

    @Autowired
    private MemcachedClient memcachedClient;

    @Test
    void contextLoads() {
    }

    @Test
    void run1() throws InterruptedException, MemcachedException, TimeoutException {
        // 放入缓存
//        boolean flag = memcachedClient.set("a", 0,  1);

        // 取出缓存
        Object a = memcachedClient.get("LX02_15956901871");
        log.warn("a is [{}]", a);
        System.out.println(a.toString());

        // 3s后过期
//        memcachedClient.set("b", 3, 2);
//        Object b = memcachedClient.get("b");
//        log.warn("b is [{}]", b);

//        Thread.sleep(3000);
//        b = memcachedClient.get("b");
//        log.warn("b is [{}]", b);
    }

}
