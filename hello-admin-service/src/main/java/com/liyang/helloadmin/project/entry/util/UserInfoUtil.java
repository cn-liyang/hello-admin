package com.liyang.helloadmin.project.entry.util;

import com.liyang.helloadmin.project.entry.controller.model.UserInfo;
import com.liyang.helloadmin.project.system.entity.UserInfoEntity;
import java.util.Objects;
import lombok.val;

/**
 * @author cn-liyang
 */
public final class UserInfoUtil {

    public static UserInfo reduceEntity(UserInfoEntity userInfoEntity) {
        if (Objects.isNull(userInfoEntity)) {
            return null;
        }
        val nickname = userInfoEntity.getNickname();
        val avatar = userInfoEntity.getAvatar();
        return new UserInfo(nickname, avatar);
    }
}
