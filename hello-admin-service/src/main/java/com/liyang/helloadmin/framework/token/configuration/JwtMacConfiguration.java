package com.liyang.helloadmin.framework.token.configuration;

import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jwt.JWTClaimNames;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.proc.DefaultJWTClaimsVerifier;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cn-liyang
 */
@Configuration
public class JwtMacConfiguration {

    @Value("${jwt.mac.secret}")
    private String secret;

    @Value("${jwt.mac.issuer}")
    private String issuer;

    @Value("${jwt.mac.subject}")
    private String subject;

    @Bean
    @SneakyThrows
    public MACSigner macSigner() {
        return new MACSigner(secret);
    }

    @Bean
    @SneakyThrows
    public MACVerifier macVerifier() {
        return new MACVerifier(secret);
    }

    @Bean
    @SneakyThrows
    public DefaultJWTClaimsVerifier<SecurityContext> macJwtClaimsVerifier() {
        return new DefaultJWTClaimsVerifier<>(
            new JWTClaimsSet.Builder().issuer(issuer).subject(subject).build(),
            Stream
                .of(
                    JWTClaimNames.JWT_ID,
                    JWTClaimNames.ISSUED_AT,
                    JWTClaimNames.NOT_BEFORE,
                    JWTClaimNames.EXPIRATION_TIME
                )
                .collect(Collectors.toCollection(HashSet::new))
        );
    }
}
