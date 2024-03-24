package com.liyang.helloadmin.framework.crypto.util;

import com.liyang.helloadmin.application.constant.Chars;
import com.liyang.helloadmin.framework.crypto.constant.AlgorithmType;
import com.liyang.helloadmin.framework.crypto.constant.CodePadding;
import com.liyang.helloadmin.framework.crypto.constant.GroupMode;
import com.liyang.helloadmin.framework.crypto.model.AesPair;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import lombok.SneakyThrows;
import lombok.val;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.Hex;
import org.springframework.security.crypto.codec.Utf8;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author cn-liyang
 */
@Component
public final class AesUtil {

    private static final String AES_CBC_PKCS5PADDING = StringUtils.arrayToDelimitedString(
        new String[] { AlgorithmType.AES.name(), GroupMode.CBC.name(), CodePadding.PKCS5Padding.name() },
        Chars.SLASH
    );

    private static SecretKey aesSecretKey;
    private static IvParameterSpec aesIvParameterSpec;

    private AesUtil(SecretKey aesSecretKey, IvParameterSpec aesIvParameterSpec) {
        AesUtil.aesSecretKey = aesSecretKey;
        AesUtil.aesIvParameterSpec = aesIvParameterSpec;
    }

    public static byte[] getKey() {
        return aesSecretKey.getEncoded();
    }

    public static String getKeyBase64Text() {
        return Base64.toBase64String(getKey());
    }

    public static byte[] getIv() {
        return aesIvParameterSpec.getIV();
    }

    public static String getIvBase64Text() {
        return Base64.toBase64String(getIv());
    }

    public static AesPair getAesPair() {
        val key = getKeyBase64Text();
        val iv = getIvBase64Text();
        return new AesPair(key, iv);
    }

    @SneakyThrows
    public static byte[] encrypt(byte[] inputBytes) {
        val cipher = Cipher.getInstance(AES_CBC_PKCS5PADDING);
        cipher.init(Cipher.ENCRYPT_MODE, aesSecretKey, aesIvParameterSpec);
        return cipher.doFinal(inputBytes);
    }

    @SneakyThrows
    public static byte[] decrypt(byte[] encryptedBytes) {
        val cipher = Cipher.getInstance(AES_CBC_PKCS5PADDING);
        cipher.init(Cipher.DECRYPT_MODE, aesSecretKey, aesIvParameterSpec);
        return cipher.doFinal(encryptedBytes);
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
