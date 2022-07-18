package com.example.redisson;

import com.example.redisson.testutil.TestUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.redisson.api.RCountDownLatch;
import org.redisson.api.RedissonClient;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@EnableAsync
@Slf4j
class RedissonApplicationTests {



    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private TestUtil testUtil;

    @Test
    void contextLoads() throws InterruptedException {

        RCountDownLatch lock = redissonClient.getCountDownLatch("lock");

        lock.trySetCount(3);


        for (int i = 1; i <= 3 ; i++) {
            testUtil.waitFor(i);
        }

        if(lock.await(2500, TimeUnit.MILLISECONDS)){
            System.out.println("ok");
        }else {
            System.out.println("time_out "+lock.getCount());
        }


    }

}
