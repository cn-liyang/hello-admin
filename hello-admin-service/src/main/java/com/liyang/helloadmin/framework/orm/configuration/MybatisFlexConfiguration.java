package com.liyang.helloadmin.framework.orm.configuration;

import com.liyang.helloadmin.framework.orm.entity.BaseEntity;
import com.liyang.helloadmin.framework.orm.util.TableUtil;
import com.liyang.helloadmin.framework.security.util.UserDetailsUtil;
import com.mybatisflex.annotation.InsertListener;
import com.mybatisflex.annotation.UpdateListener;
import com.mybatisflex.core.FlexGlobalConfig;
import com.mybatisflex.core.logicdelete.LogicDeleteProcessor;
import com.mybatisflex.core.logicdelete.impl.TimeStampLogicDeleteProcessor;
import com.mybatisflex.core.mybatis.FlexConfiguration;
import com.mybatisflex.spring.boot.ConfigurationCustomizer;
import com.mybatisflex.spring.boot.MyBatisFlexCustomizer;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Optional;
import lombok.val;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.reflections.ReflectionUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cn-liyang
 */
@Configuration
public class MybatisFlexConfiguration implements MyBatisFlexCustomizer, ConfigurationCustomizer {

    private static Optional<Class<?>> getOptionalBaseEntityClass(Object entity) {
        return ReflectionUtils
            .get(ReflectionUtils.SuperTypes.of(entity.getClass()))
            .stream()
            .filter(i -> i == BaseEntity.class)
            .findAny();
    }

    @Override
    public void customize(FlexGlobalConfig flexGlobalConfig) {
        val entityInsertListeners = new HashMap<Class<?>, InsertListener>();
        val entityUpdateListeners = new HashMap<Class<?>, UpdateListener>();
        val annotatedTypes = TableUtil.getBaseEntitySubTypes();
        annotatedTypes.forEach(i -> {
            entityInsertListeners.put(i, baseEntityInsertListener());
            entityUpdateListeners.put(i, baseEntityUpdateListener());
        });
        flexGlobalConfig.setEntityInsertListeners(entityInsertListeners);
        flexGlobalConfig.setEntityUpdateListeners(entityUpdateListeners);
    }

    @Override
    public void customize(FlexConfiguration flexConfiguration) {
        flexConfiguration.setLogImpl(StdOutImpl.class);
    }

    @Bean
    public LogicDeleteProcessor logicDeleteProcessor() {
        return new TimeStampLogicDeleteProcessor();
    }

    @Bean
    public InsertListener baseEntityInsertListener() {
        return entity ->
            getOptionalBaseEntityClass(entity)
                .ifPresent(i -> {
                    try {
                        val now = LocalDateTime.now();
                        val username = UserDetailsUtil.getUsername();
                        i.getMethod("setCreateAt", LocalDateTime.class).invoke(entity, now);
                        i.getMethod("setCreateBy", String.class).invoke(entity, username);
                        i.getMethod("setUpdateAt", LocalDateTime.class).invoke(entity, now);
                        i.getMethod("setUpdateBy", String.class).invoke(entity, username);
                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    @Bean
    public UpdateListener baseEntityUpdateListener() {
        return entity ->
            getOptionalBaseEntityClass(entity)
                .ifPresent(i -> {
                    try {
                        val now = LocalDateTime.now();
                        val username = UserDetailsUtil.getUsername();
                        i.getMethod("setUpdateAt", LocalDateTime.class).invoke(entity, now);
                        i.getMethod("setUpdateBy", String.class).invoke(entity, username);
                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
