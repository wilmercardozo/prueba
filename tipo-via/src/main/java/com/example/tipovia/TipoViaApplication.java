package com.example.tipovia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories("com.example.tipovia")
@EnableJpaAuditing
@EnableDiscoveryClient
public class TipoViaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TipoViaApplication.class, args);
	}

}
