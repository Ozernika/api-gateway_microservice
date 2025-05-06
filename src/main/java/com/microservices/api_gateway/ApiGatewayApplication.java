package com.microservices.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@SpringBootApplication
public class ApiGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("user-service", r -> r.path("/api/user/**")
						.uri("http://localhost:8081"))

				.route("task-service", r -> r.path("/api/tasks/**")
						.uri("http://localhost:8082"))

				.route("time-tracking-service", r -> r.path("/api/time/**")
						.uri("http://localhost:8083"))

				.route("frontend-service", r -> r.path("/**")
						.uri("http://localhost:8084"))

				.build();
	}
}

