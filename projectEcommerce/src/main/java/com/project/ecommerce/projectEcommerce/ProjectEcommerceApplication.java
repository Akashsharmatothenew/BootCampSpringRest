package com.project.ecommerce.projectEcommerce;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*@RestController
@EnableJpaAuditing(auditorAwareRef = "auditorAware")*/
@SpringBootApplication
public class ProjectEcommerceApplication {

	/*@Autowired
	TokenStore tokenStore;

	@Autowired
	MessageSource messageSource;*/

	/*@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditingAwareImpl();
	}*/


	/*@Bean
	public LocaleResolver localeResolver(){
		AcceptHeaderLocaleResolver localeResolver=new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}*/

	/*@Bean
	public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
		config.setAllowedMethods(Collections.singletonList("*"));
		config.setAllowedHeaders(Collections.singletonList("*"));
		source.registerCorsConfiguration("*//**//**", config);
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}*/


	public static void main(String[] args) {

		SpringApplication.run(ProjectEcommerceApplication.class, args);
	}



}
