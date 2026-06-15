package com.finess.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                .title("Fitness Tracking Api")
                        .version("1,0")
                        .description("Production Grade API's")
                        .contact(new Contact()
                                .name("FIT_X")
                                .email("FIT005@gmail.com")
                                .url("https://FIT_X.com"))
                        .license(new License()
                                .name("EMBARK 2.0")
                                .url("https://FIT_X.com")
                        )
                );
    }
}
