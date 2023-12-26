package com.liyang.helloadmin.application.util;

import com.github.yitter.idgen.YitIdHelper;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.util.IdGenerator;

/**
 * @author cn-liyang
 */
public final class IdUtil {

    private static final IdGenerator ID_GENERATOR = new AlternativeJdkIdGenerator();

    public static String uuid() {
        return ID_GENERATOR.generateId().toString();
    }

    /**
     * 雪花漂移算法
     */
    public static long driftId() {
        return YitIdHelper.nextId();
    }
}
