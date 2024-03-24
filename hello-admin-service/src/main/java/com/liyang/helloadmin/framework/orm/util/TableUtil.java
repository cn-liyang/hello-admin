package com.liyang.helloadmin.framework.orm.util;

import com.liyang.helloadmin.application.constant.Clazz;
import com.liyang.helloadmin.framework.orm.entity.BaseEntity;
import com.mybatisflex.annotation.Table;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.val;

/**
 * @author cn-liyang
 */
public final class TableUtil {

    public static Set<Class<?>> getBaseEntitySubTypes() {
        val annotatedTypes = Clazz.REFLECTIONS.getTypesAnnotatedWith(Table.class);
        return annotatedTypes.stream().filter(BaseEntity.class::isAssignableFrom).collect(Collectors.toSet());
    }
}
