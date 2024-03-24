package com.liyang.helloadmin.framework.crypto.util;

import java.io.ByteArrayOutputStream;
import javax.crypto.Cipher;
import lombok.SneakyThrows;
import lombok.val;

/**
 * @author cn-liyang
 */
public final class CipherUtil {

    @SneakyThrows
    public static byte[] doBlock(Cipher cipher, byte[] inputBytes, int maxLength) {
        try (val byteArrayOutputStream = new ByteArrayOutputStream()) {
            for (int i = 0; i < inputBytes.length; i += maxLength) {
                val min = Math.min(inputBytes.length - i, maxLength);
                byteArrayOutputStream.write(cipher.doFinal(inputBytes, i, min));
            }
            return byteArrayOutputStream.toByteArray();
        }
    }
}
