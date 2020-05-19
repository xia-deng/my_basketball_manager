package com.lindeng;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasketballManagerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BasketballManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Thread.currentThread().join();
	}
}
