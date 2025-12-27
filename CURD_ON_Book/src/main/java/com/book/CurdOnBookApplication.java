package com.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.book.Repo")
@EntityScan(basePackages = "com.book.entity")
public class CurdOnBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurdOnBookApplication.class, args);
	}

}
