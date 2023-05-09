package com.hello;

import java.security.SecureRandom;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
@EnableAsync
public class HelloWorldApplication {
	
	@Autowired
	private AsyncService asyncService;

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
		
		SecureRandom secureRandom = null;
		try {
		     secureRandom = SecureRandom.getInstance("SHA1PRNG");
		     
		}catch(Exception ex){
		    System.err.println(ex.getMessage());
		}
		
		System.err.println("Secure Random "+secureRandom.nextInt());
	}
	
	
	@Bean
	public Executor taskExecutor() {
	    return Executors.newFixedThreadPool(100);
	  }
	
	@GetMapping("/")
	public String rootController() {
		asyncService.processSomethingForLong();
		return "OK_200";
	}

}
