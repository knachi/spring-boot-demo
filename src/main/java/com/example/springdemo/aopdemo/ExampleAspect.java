package com.example.springdemo.aopdemo;

import com.example.springdemo.cache.UserCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Aspect
@Component
public class ExampleAspect {

    @Autowired
    UserCache userCache;

    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }

    @Around("@annotation(EnableCache)")
    public Object getFromCache(ProceedingJoinPoint joinPoint) throws Throwable {
        final String key = (String) (joinPoint.getArgs()[0]);
        if (Objects.nonNull(userCache.get(key))) {
            return userCache.get(key);
        }

        Object proceed = joinPoint.proceed();
        userCache.put(key, proceed.toString());
        return proceed;
    }

}