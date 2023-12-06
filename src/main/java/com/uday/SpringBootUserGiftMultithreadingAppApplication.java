package com.uday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SpringBootUserGiftMultithreadingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUserGiftMultithreadingAppApplication.class, args);
	}

}
