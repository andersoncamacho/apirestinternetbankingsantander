package br.com.santander.internetbanking.config;

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
public class OpenAPIConfig {

    @Value("${santander.openapi.dev-url}")
    private String devUrl;

    @Value("${santander.openapi.prod-url}")
    private String prodUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL in Production environment");

        Contact contact = new Contact();
        contact.setEmail("support@santander.com");
        contact.setName("Santander");
        contact.setUrl("https://www.santander.com");

        License mitLicense = new License().name("MIT License").url("https://google.com/");

        Info info = new Info()
                .title("Santander Online Bank API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage Santander Online Bank.").termsOfService("https://www.santander.com.br/terms")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }
}