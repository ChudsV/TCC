package com.tcc.springAppTcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.tcc")
public class SpringAppTccApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringAppTccApplication.class, args);
	}
}
