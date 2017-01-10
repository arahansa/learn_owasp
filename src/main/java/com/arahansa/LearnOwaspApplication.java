package com.arahansa;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LearnOwaspApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnOwaspApplication.class, args);
	}

	@Bean
	InitializingBean start(){
		return ()->{

		};
	}

}
