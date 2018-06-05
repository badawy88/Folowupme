package com.followupme.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * Created on June 05, 2018
 * Created by: Abouads, Badawy
 * <p>
 * Users Application Class, Spring boot start point
 * <p>
 * Swagger Enabled
 */
@SpringBootApplication
@EnableSwagger2
public class UsersApplication {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.followupme.users"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    /**
     *
     * @return ApiInfo for Swagger 2
     */
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "USERS API",
                "Users API, for creating/updating/Reading Users",
                "1.0.0-SNAPSHOT",
                "Terms of service",
                new Contact("Badawy Abouads", "www.followupme.com",
                        "BadawyMahmod@gmail.com"),
                "GNU General Public License v3.0",
                "https://github.com/badawy88/Folowupme/blob/master/LICENSE",
                 Collections.emptyList());
    }

    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class, args);
    }
}
