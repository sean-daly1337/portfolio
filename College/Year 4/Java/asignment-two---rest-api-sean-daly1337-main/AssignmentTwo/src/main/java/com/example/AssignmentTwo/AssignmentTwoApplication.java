package com.example.assignmenttwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EntityScan("entities")
@ComponentScan({"service", "controllers", "shared"})
@EnableJpaRepositories("repository")
@SpringBootApplication
public class AssignmentTwoApplication extends SpringBootServletInitializer implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(AssignmentTwoApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AssignmentTwoApplication.class);
    }


    @Bean
    public SpringApplicationContext springApplicationContext() {
        return new SpringApplicationContext();
    }

}
