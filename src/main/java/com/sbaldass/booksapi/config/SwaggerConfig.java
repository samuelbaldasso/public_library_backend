package com.sbaldass.booksapi.config;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

    @Configuration
    public class SwaggerConfig {
        private final String devUrl = "http://localhost:8080";

        @Bean
        public OpenAPI myOpenAPI() {
            Server devServer = new Server();
            devServer.setUrl(devUrl);
            devServer.setDescription("Server URL in Development environment");

            Contact contact = new Contact();
            contact.setEmail("samuelbaldasso93@gmail.com");
            contact.setName("Samuel Baldasso");

            License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

            Info info = new Info()
                    .title("Public Library Management API")
                    .version("1.0")
                    .contact(contact)
                    .description("This API exposes endpoints to manage a public library.")
                    .license(mitLicense);

            return new OpenAPI().info(info).servers(Collections.singletonList(devServer));
        }
    }