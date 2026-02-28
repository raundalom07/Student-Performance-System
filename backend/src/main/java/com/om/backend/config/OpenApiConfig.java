package com.om.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI studentAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Student Performance API")
                        .description("Student Management & Prediction System")
                        .version("1.0"));
    }
}
