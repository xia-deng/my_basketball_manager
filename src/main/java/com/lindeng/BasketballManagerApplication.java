package com.lindeng;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.lindeng"})
@EntityScan(basePackages = {"com.lindeng"})
public class BasketballManagerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BasketballManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Thread.currentThread().join();
	}
}
