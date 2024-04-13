package com.emi.sprint1java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class Sprint1JavaApplication {

    public static void main(String[] args) {

        SpringApplication.run(Sprint1JavaApplication.class, args);
    }

}
