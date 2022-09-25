package com.project.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

@SpringBootApplication
public class FinalProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(FinalProject1Application.class, args);
		
		
	}
	@Bean
    public ModelMapper modelMapper() {
          ModelMapper modelMapper = new ModelMapper();
          return modelMapper;
       }


}
