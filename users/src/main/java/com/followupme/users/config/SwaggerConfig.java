package com.followupme.users.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
 * <h1>Swagger Configuration class</h1>
 * SwaggerConfig class contains swagger configuration for the application
 * <p>
 * <h2>List of operations</h2>
 * <ul>
 *  <li>
 *      api : return a bean which will scan packages for swagger documentation anotations<br/>
 *  </li>
 *  <li>
 *      apiInfo : returns api information to be configured in swagger
 *  </li>
 * </ul>
 * -- add profile to seprate it from testing classes
 *
 * @author Badawy Abouads
 * @version 1.0
 * @since   2018-06-06
 */
@Configuration
@EnableSwagger2
@Profile("dev")
public class SwaggerConfig {
    /**
     *
     * @return Docket
     */
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
}
