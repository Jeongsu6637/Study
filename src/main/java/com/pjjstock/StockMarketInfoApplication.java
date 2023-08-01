package com.pjjstock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StockMarketInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockMarketInfoApplication.class, args);
	}

}
