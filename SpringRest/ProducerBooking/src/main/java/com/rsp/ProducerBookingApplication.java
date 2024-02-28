package com.rsp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(title = "Ticket booking API", version = "1.1",
                description = "Ticket booking application"),
        servers = @Server(
                url = "http://localhost:8080",
                description = "This API url will help in booking tickets."
        )
)
public class ProducerBookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerBookingApplication.class, args);
    }

}
