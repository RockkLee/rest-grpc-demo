package idv.sheng.infra.rest;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI baseOpenAPI() {
        return new OpenAPI().info(
                new Info()
                .title("Rest & Grpc demo")
                .description("SpringBoot 3.x application")
                .version("v0.0.1")
                .license(new License().name("Your License").url("http://springdoc.org"))
                .contact(new Contact().name("Sheng Lee").email("aaa@aaa.com").url("https://github.com/RockkLee"))
        );
    }
}