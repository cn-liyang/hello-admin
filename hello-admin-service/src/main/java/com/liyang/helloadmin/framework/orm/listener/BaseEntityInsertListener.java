package com.liyang.helloadmin.framework.orm.listener;

import com.liyang.helloadmin.framework.orm.entity.BaseEntity;
import com.liyang.helloadmin.framework.security.util.UserDetailsUtil;
import com.mybatisflex.annotation.InsertListener;
import java.time.LocalDateTime;

/**
 * @author cn-liyang
 */
public class BaseEntityInsertListener implements InsertListener {

    @Override
    public void onInsert(Object entity) {
        if (entity instanceof BaseEntity baseEntity) {
            baseEntity.setCreateAt(LocalDateTime.now());
            baseEntity.setCreateBy(UserDetailsUtil.getUsername());
        }
    }
}
