package com.quercusdata.awsspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EntityScan("com.quercusdata.awsspringboot.entity")
//@ComponentScan({"com.quercusdata.awsspringboot.model"})
public class AwsSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsSpringbootApplication.class, args);
	}

}
