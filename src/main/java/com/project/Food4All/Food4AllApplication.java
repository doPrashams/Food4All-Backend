package com.project.Food4All;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class Food4AllApplication {

	public static void main(String[] args) {
		SpringApplication.run(Food4AllApplication.class, args);
	}

}
