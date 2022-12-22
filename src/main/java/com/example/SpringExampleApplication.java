package com.example; // 베이스 package이다.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})  // DB 설정 
public class SpringExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringExampleApplication.class, args);
	}

}
