package com.demo.restservice;

import com.demo.restservice.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class RestServiceApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(RestServiceApplication.class, args);
	}

}
