package com.topup.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme( name = "api",
                 scheme = "basic",
                 type = SecuritySchemeType.HTTP,
                 in = SecuritySchemeIn.HEADER)
public class SwaggerConfig {

    private final String version;

    @Autowired
    public SwaggerConfig(@Value("${spring.application.version}") final String version) {
        this.version = version;
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                            .components(new Components())
                            .info(apiInfo());

    }
    @Bean
    public Info apiInfo() {
        return  new Info()
                          .title( "Auth-Manager-Service")
                          .description( "Auth manager service is used to Authenticate and Authorized an User")
                          .version(version);

    }
}
