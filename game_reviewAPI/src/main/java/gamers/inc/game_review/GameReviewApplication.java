package gamers.inc.game_review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class GameReviewApplication {

	public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
		SpringApplication.run(GameReviewApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override public void addCorsMappings(CorsRegistry registry) {
				//registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
				registry.addMapping("/**").allowedOrigins("http://localhost:8080").allowedMethods("*");
			}
		};
	}


}
