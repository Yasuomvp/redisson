package com.example.redisson.testutil;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RCountDownLatch;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;


@Component
@Slf4j
public class TestUtil {

    @Autowired
    private RedissonClient redissonClient;

    @Async
    public Future waitFor(int val) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "start");
        Thread.sleep(val*1000);
        redissonClient.getCountDownLatch("lock").countDown();
        System.out.println(Thread.currentThread().getName() + "end");
        return new AsyncResult(null);
    }

}
