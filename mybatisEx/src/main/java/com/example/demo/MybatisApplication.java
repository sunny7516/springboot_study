package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.PushMessageDAO;
import com.example.demo.domain.PushMessage;

@SpringBootApplication
public class MybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisApplication.class, args);
	}

	@Bean
	ApplicationRunner runner(PushMessageDAO dao) {
		return args -> {
			System.out.println(dao.countAll());
			System.out.println(dao.selectById(1L));
		};
	}
}

