package com.liyang.helloadmin.project.system.service;

import com.liyang.helloadmin.project.system.entity.UserEntity;
import com.liyang.helloadmin.project.system.entity.table.UserEntityTableDef;
import com.liyang.helloadmin.project.system.mapper.UserMapper;
import com.mybatisflex.core.query.QueryCondition;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * @author cn-liyang
 */
@Service
public class UserService extends ServiceImpl<UserMapper, UserEntity> {

    public Optional<UserEntity> getOneOptWithRelationsByUsername(String username) {
        return Optional.ofNullable(
            this.mapper.selectOneWithRelationsByCondition(
                    QueryCondition.createEmpty().and(UserEntityTableDef.USER_ENTITY.USERNAME.eq(username))
                )
        );
    }
}
