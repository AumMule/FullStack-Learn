package com.aum.SpringJDBCDemo;

import com.aum.SpringJDBCDemo.model.Alien;
import com.aum.SpringJDBCDemo.repo.AlienRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(SpringJdbcDemoApplication.class, args);

		Alien alien1 =context.getBean(Alien.class);
		alien1.setId(108);
		alien1.setName("Aum");
		alien1.setTech("React");

		AlienRepo repo = context.getBean(AlienRepo.class);

		repo.save(alien1);

		System.out.println(repo.findAll());

	}

}
