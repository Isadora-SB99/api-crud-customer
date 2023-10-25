package com.isadorastrottmann.apicrudcustomer.infra.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .components(getComponents())
                .info(getInfo());
    }

    private Components getComponents(){
        return new Components()
                .addSecuritySchemes("bearer-key",
                        new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT"));
    }

    private Info getInfo() {
        return new Info()
                .title("Customer Crud Api")
                .version("1.0.0")
                .description("API with CRUD operations for a Customer entity");
    }
}
