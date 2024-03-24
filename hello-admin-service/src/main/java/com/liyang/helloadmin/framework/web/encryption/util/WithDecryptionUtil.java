package com.liyang.helloadmin.framework.web.encryption.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.liyang.helloadmin.framework.crypto.util.AesUtil;
import com.liyang.helloadmin.framework.json.util.JsonUtil;
import com.liyang.helloadmin.framework.web.encryption.model.WithDecryption;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.val;

/**
 * @author cn-liyang
 */
public final class WithDecryptionUtil {

    public static String decryptRequestBody(WithDecryption<Map<String, Object>> request) {
        val decryptedMap0 = request.getDecrypted();
        val encryptedStr = request.getEncrypted();
        val decryptedStr = AesUtil.decryptFromBase64TextToText(encryptedStr);
        val decryptedMap1 = JsonUtil.readValue(decryptedStr, new TypeReference<Map<String, Object>>() {});
        val decryptedMap2 = Stream
            .of(decryptedMap0, decryptedMap1)
            .flatMap(i -> i.entrySet().stream())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return JsonUtil.writeValueAsString(decryptedMap2);
    }
}
