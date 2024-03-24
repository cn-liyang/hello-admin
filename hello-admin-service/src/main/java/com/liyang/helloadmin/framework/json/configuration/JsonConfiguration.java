package com.liyang.helloadmin.framework.json.configuration;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.liyang.helloadmin.application.constant.Times;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cn-liyang
 */
@Configuration
public class JsonConfiguration {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> {
            builder.deserializers(new LocalDateDeserializer(Times.LOCAL_DATE_FORMATTER));
            builder.deserializers(new LocalDateTimeDeserializer(Times.LOCAL_DATE_TIME_FORMATTER));
            builder.serializers(new LocalDateSerializer(Times.LOCAL_DATE_FORMATTER));
            builder.serializers(new LocalDateTimeSerializer(Times.LOCAL_DATE_TIME_FORMATTER));
        };
    }
}
