package ao.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig  {

	@Bean
	public RouteLocator grouteConfig( RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p->p.path("/account/**").uri("lb://mm-account-service"))
				.build();
	}
}
