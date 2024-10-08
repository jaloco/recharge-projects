package com.recharge.recharge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.repository")
@EntityScan("com.model")
@ComponentScan(basePackages = {"com.controller", "com.service", "com.repository", "com.model"})
public class RechargeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RechargeApplication.class, args);
	}

}
