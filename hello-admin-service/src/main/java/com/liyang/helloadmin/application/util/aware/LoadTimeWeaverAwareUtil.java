package com.liyang.helloadmin.application.util.aware;

import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * @author cn-liyang
 */
@Component
public final class LoadTimeWeaverAwareUtil implements LoadTimeWeaverAware {

    private static LoadTimeWeaver loadTimeWeaver;

    @Override
    public void setLoadTimeWeaver(@NonNull LoadTimeWeaver loadTimeWeaver) {
        LoadTimeWeaverAwareUtil.loadTimeWeaver = loadTimeWeaver;
    }
}
