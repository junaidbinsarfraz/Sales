package com.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class FinalProjV1Application {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjV1Application.class, args);
	}
}
