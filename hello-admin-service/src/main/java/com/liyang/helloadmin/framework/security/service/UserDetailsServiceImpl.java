package com.liyang.helloadmin.framework.security.service;

import com.liyang.helloadmin.framework.security.service.model.UserDetailsImpl;
import com.liyang.helloadmin.project.system.context.UserEntityContext;
import com.liyang.helloadmin.project.system.util.UserEntityUtil;
import lombok.val;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author cn-liyang
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) {
        if (!StringUtils.hasText(username)) {
            throw new UsernameNotFoundException(username);
        }
        val optionalEntity = UserEntityUtil.getOptionalEntityWithRelations(username);
        val entity = optionalEntity.orElseThrow(() -> new UsernameNotFoundException(username));
        UserEntityContext.setUserEntity(entity);
        val authorities = UserEntityUtil.getAuthorities(entity);
        return new UserDetailsImpl(entity, authorities);
    }
}
