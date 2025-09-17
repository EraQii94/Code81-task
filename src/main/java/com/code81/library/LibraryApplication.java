package com.code81.library;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Library Management System API",
                version = "1.0",
                description = "This is a Spring Boot RESTful API for Library Management System",
                license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0.html")
        ),
        externalDocs = @ExternalDocumentation(description = "Library Management System Documentation", url = "")
)
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
        System.out.println(" Application is running on http://localhost:8081");
        System.out.println(" Swagger UI is available at http://localhost:8081/swagger-ui.html");
    }


}
