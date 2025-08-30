package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// SOMENTE o pacote "turmas"
@SpringBootApplication(scanBasePackages = "com.example.demo.turmas")
@EntityScan(basePackages = "com.example.demo.turmas.data")
@EnableJpaRepositories(basePackages = "com.example.demo.turmas.data")
public class DemoApplication {
  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
}
