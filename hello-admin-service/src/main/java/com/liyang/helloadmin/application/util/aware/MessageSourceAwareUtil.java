package com.liyang.helloadmin.application.util.aware;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * @author cn-liyang
 */
@Component
public final class MessageSourceAwareUtil implements MessageSourceAware {

    private static MessageSource messageSource;

    @Override
    public void setMessageSource(@NonNull MessageSource messageSource) {
        MessageSourceAwareUtil.messageSource = messageSource;
    }
}
