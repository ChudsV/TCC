package com.tcc.springAppEcommerceTcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.tcc")
public class SpringAppEcommerceTcc {
	public static void main(String[] args) {
		SpringApplication.run(SpringAppEcommerceTcc.class, args);
	}
}
