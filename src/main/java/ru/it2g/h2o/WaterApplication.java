package ru.it2g.h2o;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class WaterApplication {
    public static void main(String[] args) {
        SpringApplication.run(WaterApplication.class,args);
    }
}
