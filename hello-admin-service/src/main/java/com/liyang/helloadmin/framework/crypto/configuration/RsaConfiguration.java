package com.liyang.helloadmin.framework.crypto.configuration;

import com.liyang.helloadmin.framework.crypto.constant.AlgorithmType;
import com.liyang.helloadmin.framework.crypto.constant.KeySize;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import lombok.SneakyThrows;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cn-liyang
 */
@Configuration
public class RsaConfiguration {

    @Bean
    @SneakyThrows
    public KeyPair rsaKeyPair() {
        val keyPairGenerator = KeyPairGenerator.getInstance(AlgorithmType.RSA.name());
        keyPairGenerator.initialize(KeySize._2048.getValue());
        return keyPairGenerator.generateKeyPair();
    }
}
