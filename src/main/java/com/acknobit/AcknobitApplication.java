package com.acknobit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.acknobit.entity")
@EnableJpaRepositories(basePackages = "com.acknobit.repository")
public class AcknobitApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcknobitApplication.class, args);
	}

}
