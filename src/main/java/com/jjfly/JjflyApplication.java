package com.jjfly;

import com.jjfly.domain.*;
import com.jjfly.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JjflyApplication {

	public static void main(String[] args) {
		SpringApplication.run(JjflyApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner demo(ShowtimeRepository repository1) {
//		return (args) -> {
//			// save a couple of customers
//			repository1.save(new Showtime("08:30", "3D", 25, 1, 10, 10));
//            repository1.save(new Showtime("09:30", "3D", 25, 1, 10, 10));
//            repository1.save(new Showtime("10:30", "3D", 25, 1, 10, 10));
//            repository1.save(new Showtime("11:30", "3D", 25, 1, 10, 10));
//		};
//	}
}
