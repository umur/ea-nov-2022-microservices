package edu.miu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
                .authorizeExchange()
                //ALLOWING REGISTER API FOR DIRECT ACCESS
                .pathMatchers("product-service/users/**").permitAll()
                //ALL OTHER APIS ARE AUTHENTICATED
                .anyExchange()
                .authenticated()
                .and()
                .csrf().disable()
                .oauth2Login()
                .and()
                .oauth2ResourceServer()
                .jwt();
        return http.build();
    }
}

//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//class SecurityConfiguration {
//
//    @Bean
//    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests ()
//                .antMatchers (HttpMethod.GET,"/test/check")
//                .hasRole ("USER")
//                .anyRequest ()
//                .authenticated ()
//                .and ()
//                .oauth2ResourceServer ()
//                .jwt ();
//
//        return http.build ();
//    }
//}

