package com.liyang.helloadmin.framework.web.encryption.advice;

import com.liyang.helloadmin.framework.crypto.util.AesUtil;
import com.liyang.helloadmin.framework.json.util.JsonUtil;
import com.liyang.helloadmin.framework.web.encryption.annotation.AesDecryption;
import com.liyang.helloadmin.framework.web.encryption.model.BaseEncryption;
import com.liyang.helloadmin.framework.web.request.model.HttpInputMessageImpl;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import lombok.SneakyThrows;
import lombok.val;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

/**
 * @author cn-liyang
 */
@RestControllerAdvice
public class RequestBodyAesDecryptionAdvice extends RequestBodyAdviceAdapter {

    @Override
    public boolean supports(
        @NonNull MethodParameter methodParameter,
        @Nullable Type targetType,
        @Nullable Class<? extends HttpMessageConverter<?>> converterType
    ) {
        return methodParameter.hasMethodAnnotation(AesDecryption.class);
    }

    @Override
    @NonNull
    @SneakyThrows
    public HttpInputMessage beforeBodyRead(
        @NonNull HttpInputMessage inputMessage,
        @NonNull MethodParameter parameter,
        @NonNull Type targetType,
        @NonNull Class<? extends HttpMessageConverter<?>> converterType
    ) {
        val body = inputMessage.getBody();
        val bodyBytes = new byte[body.available()];
        val read = body.read(bodyBytes);
        if (read > 0) {
            val bodyString = new String(bodyBytes, StandardCharsets.UTF_8);
            val encryptedRequest = JsonUtil.readValue(bodyString, BaseEncryption.class);
            val encryptedText = encryptedRequest.getEncrypted();
            val decryptedBytes = AesUtil.decryptFromBase64TextToBytes(encryptedText);
            return new HttpInputMessageImpl(new ByteArrayInputStream(decryptedBytes), inputMessage.getHeaders());
        } else {
            return super.beforeBodyRead(inputMessage, parameter, targetType, converterType);
        }
    }
}
