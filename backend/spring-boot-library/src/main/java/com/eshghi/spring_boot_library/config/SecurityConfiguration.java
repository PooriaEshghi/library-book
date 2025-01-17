package com.eshghi.spring_boot_library.config;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @SuppressWarnings("removal")
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // Disable Cross Site Request Forgery
        http.csrf(csrf -> csrf.disable());

        // Protect endpoints at /api/<type>/secure
        http.authorizeHttpRequests(authorize -> 
                authorize
                        .requestMatchers(
                            "/api/books/secure/**",
                                "/api/reviews/secure/**",
                                "/api/messages/secure/**",
                                "/api/admin/secure/**"
                                )
                        .authenticated()
                        .anyRequest()
                        .permitAll());

        // Configure OAuth2 resource server
        http.oauth2ResourceServer(oauth2 -> oauth2.jwt());

        // Add CORS filters
        http.cors(cors -> {});

        // Add content negotiation strategy
        http.setSharedObject(ContentNegotiationStrategy.class,
                new HeaderContentNegotiationStrategy());

        // Force a non-empty response body for 401's to make the response friendly
        Okta.configureResourceServer401ResponseBody(http);

        return http.build();
    }

}
