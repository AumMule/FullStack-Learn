package com.aumm.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring02Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Spring02Application.class, args);

        Alien obj = context.getBean(Alien.class);
        obj.code();
    }

}
