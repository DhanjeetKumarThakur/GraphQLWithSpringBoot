package com.learning.graphQLWithSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;

@SpringBootApplication(exclude = {JdbcTemplateAutoConfiguration.class})
public class GraphQlWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphQlWithSpringBootApplication.class, args);
	}

}
