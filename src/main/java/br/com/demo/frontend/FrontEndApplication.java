package br.com.demo.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import br.com.demo.frontend.resource.PersonResource;

@SpringBootApplication
public class FrontEndApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(FrontEndApplication.class, args);
	}
	
}
