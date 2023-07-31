package com.example.springdemo;

import com.example.springdemo.aopdemo.TestService;
import com.example.springdemo.cache.UserCache;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestLogTime {

    private TestService testService;
    private UserCache userCache;

    @Before
    public void setup() {
        userCache = new UserCache();
        testService = new TestService(userCache);
        setupData();
    }

    private void setupData() {
        userCache.put("sachin", "Sachin Tendulkar");
        userCache.put("virat", "Virat Kohli");
    }

    @Test
    public void test_aop_logExecutionTime() {
        testService.printFibonacci();
    }

    @Test
    public void test_aop_getCache_hit() {
        log.info(testService.getUser("virat"));
    }

    @Test
    public void test_aop_getCache_miss() {
        log.info(testService.getUser("virat1"));
        log.info(testService.getUser("virat1"));
    }
}
