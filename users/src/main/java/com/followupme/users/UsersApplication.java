package com.followupme.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * <h1>UsersApplication class</h1>
 * <p>
 * Start Point for starting this API and run this microservice
 *
 * @author Badawy Abouads
 * @version 1.0
 * @since 2018-06-05
 */
@SpringBootApplication
public class UsersApplication {
    /**
     * <p>
     * Main Method
     * </p>
     *
     * @param args startup arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class, args);
    }
}
