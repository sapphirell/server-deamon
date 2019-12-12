package com.seeshion.control;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/***
 * @Author ran
 */

@MapperScan("com.seeshion.db.mapper")
@SpringBootApplication (scanBasePackages = "com.seeshion")
public class ControlServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControlServerApplication.class, args);
    }

}
