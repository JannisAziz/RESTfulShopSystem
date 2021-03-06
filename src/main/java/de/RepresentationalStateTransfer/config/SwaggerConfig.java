package de.RepresentationalStateTransfer.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("category")
                .pathsToMatch("/**")
                .build();
    }
}
