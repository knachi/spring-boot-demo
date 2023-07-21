package com.example.springdemo;

import aopdemo.TestService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

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
