package com.jilaba.jwtsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
//@EnableJpaRepositories(basePackages = "com.jilaba.jwtsecurity.repository")
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.jilaba.jwtsecurity.repository")
@EntityScan(basePackages = "com.jilaba.jwtsecurity.entity") // Adjust as needed

public class JwtSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtSecurityApplication.class, args);
	}

}
