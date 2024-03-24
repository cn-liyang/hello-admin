package com.liyang.helloadmin.framework.security.configuration;

import com.liyang.helloadmin.framework.security.constant.SecurityPaths;
import com.liyang.helloadmin.framework.security.handler.AccessDeniedHandlerImpl;
import com.liyang.helloadmin.framework.security.handler.AuthenticationEntryPointImpl;
import com.liyang.helloadmin.framework.security.handler.LogoutSuccessHandlerImpl;
import com.liyang.helloadmin.framework.security.manager.AuthorizationManagerImpl;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author cn-liyang
 */
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfiguration {

    private final AuthorizationManagerImpl authorizationManagerImpl;
    private final AuthenticationEntryPointImpl authenticationEntryPointImpl;
    private final AccessDeniedHandlerImpl accessDeniedHandlerImpl;
    private final LogoutSuccessHandlerImpl logoutSuccessHandlerImpl;

    @Bean
    @SneakyThrows
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        return httpSecurity
            .csrf(AbstractHttpConfigurer::disable)
            .httpBasic(AbstractHttpConfigurer::disable)
            .formLogin(AbstractHttpConfigurer::disable)
            .headers(c -> c.cacheControl(HeadersConfigurer.CacheControlConfig::disable))
            .headers(c -> c.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
            .sessionManagement(c -> c.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(c ->
                c.requestMatchers(SecurityPaths.WHITELIST).permitAll().anyRequest().access(authorizationManagerImpl)
            )
            .exceptionHandling(c ->
                c.authenticationEntryPoint(authenticationEntryPointImpl).accessDeniedHandler(accessDeniedHandlerImpl)
            )
            .logout(c -> c.logoutSuccessHandler(logoutSuccessHandlerImpl))
            .build();
    }
}
