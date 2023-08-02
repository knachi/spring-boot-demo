package com.example.springdemo;

import com.example.springdemo.aopdemo.TestService;
import com.example.springdemo.cache.UserCache;
import com.example.springdemo.springbeanscope.PrototypeScopeComponent;
import com.example.springdemo.springbeanscope.SingletonScopeComponent;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringScopeTest {

    @Autowired
    private SingletonScopeComponent singletonScopeComponent1;

    @Autowired
    private SingletonScopeComponent singletonScopeComponent2;

    @Autowired
    private PrototypeScopeComponent prototypeScopeComponent1;

    @Autowired
    private PrototypeScopeComponent prototypeScopeComponent2;

    @Before
    public void setup() {
    }

    @Test
    public void singletonScopeTest() {
        assertEquals(singletonScopeComponent1.hashCode(),  singletonScopeComponent2.hashCode());
    }

    @Test
    public void prototypeScopeTest() {
        assertNotEquals(prototypeScopeComponent1.hashCode(),  prototypeScopeComponent2.hashCode());
    }
}
