package com.liyang.helloadmin.framework.crypto.configuration;

import com.liyang.helloadmin.framework.crypto.constant.AlgorithmType;
import com.liyang.helloadmin.framework.crypto.constant.KeySize;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import lombok.SneakyThrows;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cn-liyang
 */
@Configuration
public class AesConfiguration {

    @Bean
    @SneakyThrows
    public SecretKey aesSecretKey() {
        val keyGenerator = KeyGenerator.getInstance(AlgorithmType.AES.name());
        keyGenerator.init(KeySize._256.getValue());
        return keyGenerator.generateKey();
    }

    @Bean
    @SneakyThrows
    public IvParameterSpec aesIvParameterSpec() {
        val secureRandom = SecureRandom.getInstanceStrong();
        byte[] iv = secureRandom.generateSeed(16);
        return new IvParameterSpec(iv);
    }
}
