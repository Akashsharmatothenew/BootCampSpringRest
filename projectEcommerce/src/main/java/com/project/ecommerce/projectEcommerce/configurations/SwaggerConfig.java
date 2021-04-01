package com.project.ecommerce.projectEcommerce.configurations;//package com.example.ecommerceProject.configurations;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import javax.print.Doc;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.ecommerceProject"))
//                .paths(PathSelectors.regex("/.*"))
//                .build().apiInfo(apiEndPointsInfo());
//    }
//
//    private ApiInfo apiEndPointsInfo() {
//
//        return new ApiInfoBuilder().title("E-commerce API design")
//                .description("E-commerce Detail Service with Spring Hibernate")
//                .build();
//
//    }
//
//    @Bean
//    public ModelMapper getModelMapper() {
//        ModelMapper modelMapper = new ModelMapper();
//        return modelMapper;
//    }
//
//}
