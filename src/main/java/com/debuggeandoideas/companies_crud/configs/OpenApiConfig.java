package com.debuggeandoideas.companies_crud.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Companies API",
                version = "1.0",
                description = "Companies crud API Information"
        )
)
public class OpenApiConfig {
}
