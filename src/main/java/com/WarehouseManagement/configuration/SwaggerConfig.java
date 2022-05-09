//package com.WarehouseManagement.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//@EnableWebMvc
//public class SwaggerConfig {
//    @Bean
//    public Docket docket() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }
//
////    //create api metadata that goes at the top of the generated page
////    private ApiInfo getApiInfo() {
////        return new ApiInfoBuilder()
////                .title("Employee API")
////                .version("1.0")
////                .description("API for managing employees.")
////                .contact(new Contact("Craig Golightly", "http://globomantics.com", "craig@globomantics.com"))
////                .license("Apache License Version 2.0")
////                .build();
////    }
//}