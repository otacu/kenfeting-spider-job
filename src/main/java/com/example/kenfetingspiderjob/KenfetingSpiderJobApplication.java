package com.example.kenfetingspiderjob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class KenfetingSpiderJobApplication {

    public static void main(String[] args) {
        final ApplicationContext applicationContext = SpringApplication.run(KenfetingSpiderJobApplication.class, args);
    }
}
