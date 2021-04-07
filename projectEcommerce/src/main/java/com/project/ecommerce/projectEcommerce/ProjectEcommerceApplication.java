package com.project.ecommerce.projectEcommerce;


import com.project.ecommerce.projectEcommerce.auditinginfo.AuditingAwareImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;


@RestController
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@SpringBootApplication
public class ProjectEcommerceApplication {

	@Autowired
	TokenStore tokenStore;

	@Autowired
	MessageSource messageSource;

	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditingAwareImpl();
	}


	@Bean
	public LocaleResolver localeResolver(){
		AcceptHeaderLocaleResolver localeResolver=new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}




	public static void main(String[] args) {

		SpringApplication.run(ProjectEcommerceApplication.class, args);
	}



}
