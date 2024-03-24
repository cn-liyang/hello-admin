package com.liyang.helloadmin.framework.web.configuration;

import com.liyang.helloadmin.application.util.TimeUtil;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cn-liyang
 */
@Configuration
public class WebConfiguration {

    @Bean
    public PropertyEditor localDateTimeEditor() {
        return new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(TimeUtil.parseLocalDateTime(text));
            }
        };
    }
}
