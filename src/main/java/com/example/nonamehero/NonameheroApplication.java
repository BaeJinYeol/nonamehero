package com.example.nonamehero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.nonamehero.model") // 엔티티 클래스가 있는 패키지 지정
@EnableJpaRepositories(basePackages = "com.example.nonamehero.repository") // 리포지토리 패키지 지정
public class NonameheroApplication {

	public static void main(String[] args) {
		SpringApplication.run(NonameheroApplication.class, args);
	}

}
