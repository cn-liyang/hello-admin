package com.liyang.helloadmin.framework.crypto.util;

import com.liyang.helloadmin.framework.crypto.configuration.RsaConfiguration;
import com.liyang.helloadmin.framework.crypto.constant.AlgorithmType;
import com.liyang.helloadmin.framework.crypto.constant.BlockSize;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Objects;
import javax.crypto.Cipher;
import lombok.SneakyThrows;
import lombok.val;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.Hex;
import org.springframework.security.converter.RsaKeyConverters;
import org.springframework.security.crypto.codec.Utf8;
import org.springframework.stereotype.Component;

/**
 * @author cn-liyang
 */
@Component
public final class RsaUtil {

    private static final PrivateKey RSA_PKCS8_PRIVATE_KEY = RsaKeyConverters
        .pkcs8()
        .convert(
            Objects.requireNonNull(RsaConfiguration.class.getResourceAsStream("/crypto/rsa_pkcs8_2048_private.pem"))
        );
    private static final PublicKey RSA_PKCS8_PUBLIC_KEY = RsaKeyConverters
        .x509()
        .convert(
            Objects.requireNonNull(RsaConfiguration.class.getResourceAsStream("/crypto/rsa_pkcs8_2048_public.pem"))
        );

    private static KeyPair rsaKeyPair;

    private RsaUtil(KeyPair rsaKeyPair) {
        RsaUtil.rsaKeyPair = rsaKeyPair;
    }

    @SneakyThrows
    public static byte[] encrypt(byte[] inputBytes) {
        val cipher = Cipher.getInstance(AlgorithmType.RSA.name());
        cipher.init(Cipher.ENCRYPT_MODE, RSA_PKCS8_PUBLIC_KEY);
        // return cipher.doFinal(inputBytes);
        return CipherUtil.doBlock(cipher, inputBytes, BlockSize._2048.getValue().getLeft());
    }

    @SneakyThrows
    public static byte[] decrypt(byte[] encryptedBytes) {
        val cipher = Cipher.getInstance(AlgorithmType.RSA.name());
        cipher.init(Cipher.DECRYPT_MODE, RSA_PKCS8_PRIVATE_KEY);
        // return cipher.doFinal(encryptedBytes);
        return CipherUtil.doBlock(cipher, encryptedBytes, BlockSize._2048.getValue().getRight());
    }

    public static String encryptToBase64Text(String plainText) {
        val inputBytes = Utf8.encode(plainText);
        val encryptedBytes = encrypt(inputBytes);
        return Base64.toBase64String(encryptedBytes);
    }

    public static String encryptToHexText(String plainText) {
        val inputBytes = Utf8.encode(plainText);
        val encryptedBytes = encrypt(inputBytes);
        return Hex.toHexString(encryptedBytes);
    }

    public static String decryptFromBase64TextToText(String encryptedBase64Text) {
        val encryptedBytes = Base64.decode(encryptedBase64Text);
        val decryptedBytes = decrypt(encryptedBytes);
        return Utf8.decode(decryptedBytes);
    }

    public static byte[] decryptFromBase64TextToBytes(String encryptedBase64Text) {
        val encryptedBytes = Base64.decode(encryptedBase64Text);
        return decrypt(encryptedBytes);
    }

    public static String decryptFromHexTextToText(String encryptedHexText) {
        val encryptedBytes = Hex.decode(encryptedHexText);
        val decryptedBytes = decrypt(encryptedBytes);
        return Utf8.decode(decryptedBytes);
    }

    public static byte[] decryptFromHexTextToBytes(String encryptedHexText) {
        val encryptedBytes = Hex.decode(encryptedHexText);
        return decrypt(encryptedBytes);
    }

    public static byte[] decryptFromHexBytesToBytes(byte[] encryptedHexBytes) {
        val encryptedBytes = Hex.decode(encryptedHexBytes);
        return decrypt(encryptedBytes);
    }

    public static byte[] decryptFromBase64BytesToBytes(byte[] encryptedBase64Bytes) {
        val encryptedBytes = Base64.decode(encryptedBase64Bytes);
        return decrypt(encryptedBytes);
    }
}
