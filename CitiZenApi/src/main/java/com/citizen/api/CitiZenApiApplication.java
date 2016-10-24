package com.citizen.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class CitiZenApiApplication {

    @RequestMapping("/")
    @ResponseBody
    String home() {
      return "Citi Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(CitiZenApiApplication.class, args);
    }
}