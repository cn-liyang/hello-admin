package com.liyang.helloadmin.project.system.context;

import com.liyang.helloadmin.project.system.entity.UserEntity;
import com.liyang.helloadmin.project.system.exception.UserEntityMissingException;
import java.util.Objects;
import lombok.val;

/**
 * @author cn-liyang
 */
public class UserEntityContext implements AutoCloseable {

    private static final ThreadLocal<UserEntity> context = new ThreadLocal<>();

    public static void setUserEntity(UserEntity userEntity) {
        context.set(userEntity);
    }

    public static UserEntity getUserEntity() {
        val userEntity = context.get();
        if (Objects.isNull(userEntity)) {
            throw new UserEntityMissingException();
        }
        return userEntity;
    }

    @Override
    public void close() {
        context.remove();
    }
}
