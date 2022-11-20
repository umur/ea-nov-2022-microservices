package miu.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;


@EnableDiscoveryClient
@SpringBootApplication
public class ApigatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApigatewayApplication.class,args);
    }
    @Bean
    public DiscoveryClientRouteDefinitionLocator discoveryClientRouteDefinitionLocator(ReactiveDiscoveryClient dc, DiscoveryLocatorProperties dlp)
    {
        dlp.setLowerCaseServiceId(true);
        return new DiscoveryClientRouteDefinitionLocator(dc,dlp);
    }
}
