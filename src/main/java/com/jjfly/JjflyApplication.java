package com.jjfly;

import com.jjfly.domain.Movie;
import com.jjfly.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JjflyApplication {

	public static void main(String[] args) {
		SpringApplication.run(JjflyApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(MovieRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Movie(
					"imgUrl", "name", "premiereTime",
					"duration", "type", "region",
					0, "description"));
		};
	}
}
