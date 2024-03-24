package com.liyang.helloadmin.framework.token.configuration;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cn-liyang
 */
@Configuration
public class JwtConfiguration {

    @Bean
    public JWSHeader jwsHeader() {
        return new JWSHeader(JWSAlgorithm.HS256);
    }
}
