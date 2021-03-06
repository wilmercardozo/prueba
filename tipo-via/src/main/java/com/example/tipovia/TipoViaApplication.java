package com.example.tipovia;
import com.example.tipovia.config.SwaggerConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories("com.example.tipovia")
@EnableJpaAuditing
@EnableDiscoveryClient
@Import(SwaggerConfiguration.class)
public class TipoViaApplication implements WebMvcConfigurer {
	public static void main(String[] args) {
		SpringApplication.run(TipoViaApplication.class, args);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");
	}

	@Bean
	public CommandLineRunner loadData(InitDataLoader loader) {
		return args->loader.loadData();
	}
}
