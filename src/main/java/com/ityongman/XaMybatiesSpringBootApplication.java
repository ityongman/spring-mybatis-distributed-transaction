package com.ityongman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass=true)
public class XaMybatiesSpringBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(XaMybatiesSpringBootApplication.class, args);
	}
}
