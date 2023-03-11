package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.mapper")
public class Test2JavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Test2JavaApplication.class, args);
	}

}
