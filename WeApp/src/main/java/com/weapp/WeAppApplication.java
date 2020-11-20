/*
 * Thanks to the Getting Start with Building an Application with Spring Boot documentation
 * https://spring.io/guides/gs/spring-boot/
 */
package com.weapp;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * The Class WeAppApplication.
 * The @SpringBootApplication annotation is used to add 
 * @Configuration is used to mark this class as a source of bean definitions 
 * @EnableAutoConfiguration have Spring Boot to add beans based on settings
 * @ComponentScan have Spring to look for other components 
 */
@SpringBootApplication
public class WeAppApplication {

	/**
	 * The main method is used to launch the application
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(WeAppApplication.class, args);
	}
	
	/**
	 *  This method retrieves all the beans associated with the application 
	 *  The bean are sorted and printed out 
	 *  
	 *  Thanks to Building an Application with Spring Boot guide on spring.io
	 *  https://spring.io/guides/gs/spring-boot/
	 *
	 * @param ctx the application context
	 * @return the command line runner
	 */
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}

}
