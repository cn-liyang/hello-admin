package com.liyang.helloadmin.framework.security.util;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author cn-liyang
 */
@SpringBootTest
class PasswordUtilTest {

    String STAFF_DECODED = "Staff123";
    String STAFF_ENCODED = "$2a$10$g52dskj8E2Kiu4ZOpWDIVOiaVXZ63k8VDgApL8764.DPnbJ7OTcuK";

    @Test
    void encode() {
        val encoded = PasswordUtil.encode(STAFF_DECODED);
        System.out.println("encoded=" + encoded);
    }

    @Test
    void verify() {
        val verified = PasswordUtil.verify(STAFF_DECODED, STAFF_ENCODED);
        System.out.println("verified=" + verified);
    }
}
