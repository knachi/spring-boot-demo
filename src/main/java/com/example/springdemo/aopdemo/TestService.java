package com.example.springdemo.aopdemo;

import com.example.springdemo.cache.UserCache;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class TestService {

    private final UserCache userCache;

    @LogExecutionTime
    public void printFibonacci() {
        int n1 = 0, n2 = 1, n3, i, count = 10;
        System.out.print(n1 + " " + n2);//printing 0 and 1

        for (i = 2; i < count; ++i)//loop starts from 2 because 0 and 1 are already printed
        {
            n3 = n1 + n2;
            System.out.print(" " + n3);
            n1 = n2;
            n2 = n3;
        }
    }

    @EnableCache
    public String getUser(final String key) {
        final var user = userCache.get(key);
        if (Objects.isNull(user)) {
            log.info("cache miss");
            userCache.put(key, key);
            return key + "Put success";
        } else {
            return user;
        }

    }
}
