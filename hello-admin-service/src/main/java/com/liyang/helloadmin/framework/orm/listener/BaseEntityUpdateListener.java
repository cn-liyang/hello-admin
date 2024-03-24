package com.liyang.helloadmin.framework.orm.listener;

import com.liyang.helloadmin.framework.orm.entity.BaseEntity;
import com.liyang.helloadmin.framework.security.util.UserDetailsUtil;
import com.mybatisflex.annotation.UpdateListener;
import java.time.LocalDateTime;

/**
 * @author cn-liyang
 */
public class BaseEntityUpdateListener implements UpdateListener {

    @Override
    public void onUpdate(Object entity) {
        if (entity instanceof BaseEntity baseEntity) {
            baseEntity.setUpdateAt(LocalDateTime.now());
            baseEntity.setUpdateBy(UserDetailsUtil.getUsername());
        }
    }
}
