package com.example.demo2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

// spring 동원해서 
@RunWith(SpringRunner.class)
@SpringBootTest
public class jdbcExApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Test
	public void contextLoads() {
		assertThat(context.containsBeanDefinition("postController")).isTrue();
	}

}