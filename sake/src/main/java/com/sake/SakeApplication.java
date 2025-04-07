package com.sake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SakeApplication.class, args);
	}

}
// spring security 가 들어가는 순간 filter가 기본적으로 적용된다는 말. intercepter와 다름(여기는 따로 적용해야함).
// (exclude = SecurityAutoConfiguration.class) 이걸 방지하는 역할.
