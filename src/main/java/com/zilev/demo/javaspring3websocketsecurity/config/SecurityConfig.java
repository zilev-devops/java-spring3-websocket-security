package com.zilev.demo.javaspring3websocketsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;
import org.springframework.security.config.annotation.web.socket.EnableWebSocketSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collections;

//@Configuration
//@EnableWebSocketSecurity
public class SecurityConfig {

//    @Bean
//    AuthorizationManager<Message<?>> messageAuthorizationManager(MessageMatcherDelegatingAuthorizationManager.Builder messages) {
//        messages
//                .simpDestMatchers("/user/**").hasRole("USER");
//
//        return messages.build();
//    }
}

//@Configuration
//@EnableWebFluxSecurity
//public class SecurityConfig extends AbstractSecurityWebSocketMessageBrokerConfigurer {
//    @Override
//    protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
//        messages
////                .simpTypeMatchers(SimpMessageType.CONNECT, SimpMessageType.UNSUBSCRIBE, SimpMessageType.DISCONNECT).permitAll()
//                .simpDestMatchers("/app/**").hasRole("ADMIN")
//                .simpSubscribeDestMatchers("/topic/**").authenticated()
//                .anyMessage().authenticated();
//    }
//
//
//    // Create an AuthenticationManager bean to Authenticate users in the ChannelInterceptor
//    @Bean
//    public SecurityWebFilterChain configure(ServerHttpSecurity http) {
//    // Set up simplified security settings requiring all requests to be authenticated
//        return http
//                .authorizeExchange().pathMatchers("/portfolio/**").permitAll()
//                .anyExchange()
//                .authenticated().and().build();
////        return http.authorizeExchange()
////                .anyExchange().authenticated()
////                .and().build();
//    }
//
//    //    @Bean
////    public MapReactiveUserDetailsService userDetailsService() {
////        UserDetails user = User
////                .withUsername("user")
////                .password(passwordEncoder().encode("password"))
////                .roles("USER")
////                .build();
////        return new MapReactiveUserDetailsService(user);
////    }
////
////    @Bean
////    CorsConfigurationSource corsConfigurationSource() {
////        CorsConfiguration configuration = new CorsConfiguration();
////        configuration.setAllowCredentials(true);
////        configuration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
////        configuration.setAllowedMethods(Collections.singletonList("GET"));
////        configuration.setAllowedHeaders(Collections.singletonList("*"));
////        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
////        source.registerCorsConfiguration("/**", configuration);
////        return source;
////    }
////
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(10);
//    }
//}
