package HostelManagementApp.BackendServicesForHMA;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "Repo")
@EntityScan(basePackages = "ModelClasses")
@ComponentScan(
	basePackages = {
			"AppControllers",
			"AppServices",
			"Repo",
			"ModelClasses"
	}
)
@EnableScheduling
public class BackendServicesForHmaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendServicesForHmaApplication.class, args);
	}
	
	
	@Bean
	public CorsFilter corsFilter() {
	
	CorsConfiguration corsConfiguration = new CorsConfiguration();

	corsConfiguration.setAllowCredentials(true);

	corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));

	corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type", 
			
			"Accept", "Authorization", "Origin, Accept", "X-Requested-With",

			"Access-Control-Request-Method", "Access-Control-Request-Headers"));

	corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization", 
			
			"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));

	corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

	UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource(); 
	
	urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
	
	return new CorsFilter (urlBasedCorsConfigurationSource);
	
	}

}
