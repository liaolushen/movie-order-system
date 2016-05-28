package com.jjfly;

import com.jjfly.domain.Movie;
import com.jjfly.domain.MovieActor;
import com.jjfly.repository.MovieActorRepository;
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
	public CommandLineRunner demo(MovieRepository repository1,
								  MovieActorRepository repository2) {
		return (args) -> {
			// save a couple of customers
			Movie m = repository1.save(new Movie(
					"肖申克的救赎",
					"https://img3.doubanio.com/view/photo/photo/public/p480770143.jpg",
					"1994-10-14",
					"142分",
					"剧情/犯罪",
					"欧美",
					9,
					"20世纪40年代末，小有成就的青年银行家安迪（蒂姆·罗宾斯 Tim Robbins 饰）因涉嫌杀害妻子及她的情人而锒铛入狱。在这座名为肖申克的监狱内，希望似乎虚无缥缈，终身监禁的惩罚无疑注定了安迪接下来灰暗绝望的人生。"
			));

			repository2.save(new MovieActor(
					"弗兰克·德拉邦特",
					"Frank Darabont",
					"https://img3.doubanio.com/img/celebrity/medium/230.jpg",
					"导演",
					m.getId()
			));

			repository2.save(new MovieActor(
					"蒂姆·罗宾斯",
					"Tim Robbins",
					"https://img3.doubanio.com/img/celebrity/large/17525.jpg",
					"主演",
					m.getId()
			));


		};
	}
}
