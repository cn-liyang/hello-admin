package com.liyang.helloadmin.framework.web.encryption.advice;

import com.liyang.helloadmin.framework.crypto.util.AesUtil;
import com.liyang.helloadmin.framework.json.util.JsonUtil;
import com.liyang.helloadmin.framework.web.encryption.annotation.AesEncryption;
import com.liyang.helloadmin.framework.web.encryption.model.BaseEncryption;
import com.liyang.helloadmin.framework.web.response.model.SuccessfulResponse;
import lombok.val;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author cn-liyang
 */
@RestControllerAdvice
public class ResponseBodyAesEncryptionAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(
        @NonNull MethodParameter returnType,
        @Nullable Class<? extends HttpMessageConverter<?>> converterType
    ) {
        return returnType.hasMethodAnnotation(AesEncryption.class);
    }

    @Override
    public Object beforeBodyWrite(
        Object body,
        @Nullable MethodParameter returnType,
        @Nullable MediaType selectedContentType,
        @Nullable Class<? extends HttpMessageConverter<?>> selectedConverterType,
        @Nullable ServerHttpRequest request,
        @Nullable ServerHttpResponse response
    ) {
        if (body instanceof SuccessfulResponse) {
            val content = JsonUtil.writeValueAsString(body);
            val encryptedText = AesUtil.encryptToBase64Text(content);
            return new BaseEncryption(encryptedText);
        }
        return body;
    }
}
