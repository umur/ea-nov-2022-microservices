package edu.miu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class ApiGatewayApplication {
    public static void main (String[] args) {
        SpringApplication.run(ApiGatewayApplication.class,args);
    }
    @Bean
    public DiscoveryClientRouteDefinitionLocator discoveryClientRouteDefinitionLocator(ReactiveDiscoveryClient dc,
                                                                                       DiscoveryLocatorProperties dlp){
        dlp.setLowerCaseServiceId(true);
        return  new DiscoveryClientRouteDefinitionLocator(dc,dlp);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate ();
    }

}
