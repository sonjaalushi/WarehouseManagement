package com.WarehouseManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.WarehouseManagement.repository")
@ComponentScan("com.WarehouseManagement.service")
@ComponentScan("com.WarehouseManagement.controller")
@EntityScan("com.WarehouseManagement.entity")
//@ComponentScan(basePackages = "com.WarehouseManagement.service")
public class WarehouseManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarehouseManagementApplication.class, args);
    }


}
