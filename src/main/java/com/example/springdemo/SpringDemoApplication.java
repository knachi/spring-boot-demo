package com.example.springdemo;

import com.example.springdemo.aopdemo.TestService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDemoApplication {

	private final TestService testService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	@PostConstruct
	public void test() {
		testService.printFibonacci();
	}

}
