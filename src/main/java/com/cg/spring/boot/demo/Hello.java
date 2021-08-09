package com.cg.spring.boot.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

//	private static final 
	Logger LOG = LoggerFactory.getLogger(Hello.class);

	
	@CrossOrigin(origins = "/*")
//	@CrossOrigin(origins =  http://localhost:3000/)
	@RequestMapping("/")
	public String welcome() {
		LOG.info("welcome");
		return "Welcome to cg spring boot app.";
	}



	// URL - http://localhost:8082/hello

//	@RequestMapping("/hello") // end point, API
// we can use request mapping or get mapping also....it connect to the hello method 
	@GetMapping("/hello")
	public String hello() {
		LOG.info("Hello world! INFO");
		return "Hello world!";
	}
}
