package com.SpringSecurityOauth2.SpringSecurity;

import jdk.nashorn.internal.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringSecurityApplication {

//	@Autowired
//	Token token;
	@GetMapping("/")
    public String index(){
		return "index";
	}
	@GetMapping("/user/home")
	public String userHome(){
    	return "User home";
	}
	@GetMapping("/admin/home")
	public String adminHome(){
		return "Admin Home";
	}

	public static void main(String[] args) {


		SpringApplication.run(SpringSecurityApplication.class, args);
	}

}
