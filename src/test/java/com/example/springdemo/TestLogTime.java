package com.example.springdemo;

import com.example.springdemo.aopdemo.TestService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestLogTime {

    private TestService testService;

    @Before
    public void setup() {
        testService = new TestService();
    }

    @Test
    public void test_aop_logExecutionTime() {
        testService.printFibonacci();
    }
}
