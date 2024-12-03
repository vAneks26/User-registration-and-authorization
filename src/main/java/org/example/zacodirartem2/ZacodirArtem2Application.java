package org.example.zacodirartem2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("org.example.zacodirartem2.repository")
@EntityScan(basePackages = "org.example.zacodirartem2.entity")
public class ZacodirArtem2Application {

    public static void main(String[] args) {
        SpringApplication.run(ZacodirArtem2Application.class, args);
    }

}
