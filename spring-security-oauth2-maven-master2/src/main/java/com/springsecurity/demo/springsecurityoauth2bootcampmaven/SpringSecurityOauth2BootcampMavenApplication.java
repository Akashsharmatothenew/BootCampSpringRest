package com.springsecurity.demo.springsecurityoauth2bootcampmaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringSecurityOauth2BootcampMavenApplication {

	@GetMapping("/")
	public String index(){
		return "index";
	}

	@GetMapping("/admin/home")
	public String adminHome(){
		return "Admin home";
	}

	@GetMapping("/user/home")
	public String userHome(){
		return "User home";
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityOauth2BootcampMavenApplication.class, args);
	}

}
